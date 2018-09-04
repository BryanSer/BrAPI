/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Data;

import Br.API.Scripts.ScriptLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;
import jdk.nashorn.api.scripting.NashornScriptEngine;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 * @since 2018-9-3
 */
public interface ProxyUtil {

    /**
     * 被代理对象的标识
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Proxy {

        /**
         * 若修改 标识使用修改后的值作为被代理对象的新键值
         *
         * @return
         */
        String vaule() default "";
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ProxyScript {

        String file();

        String function();

        String fromJarFile();

    }

    @FunctionalInterface
    public interface ProxyedScript<T> {

        T proxy(Object... args);
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ProxyInfo {

        /**
         * 说明需要代理的类的路径
         *
         * @return
         */
        String vaule();
    }

    public static Map<String, List<Class<? extends ProxyUtil>>> Proxyed = new HashMap<>();

    public static void addProxy(Plugin plugin, Class<? extends ProxyUtil> cls) {
        List<Class<? extends ProxyUtil>> list = Proxyed.get(plugin.getName());
        if (list == null) {
            list = new ArrayList<>();
            Proxyed.put(plugin.getName(), list);
        }
        list.add(cls);
    }

    public static void proxy(Plugin plugin) {
        List<Class<? extends ProxyUtil>> list = Proxyed.get(plugin.getName());
        if (list == null) {
            return;
        }
        File folder = new File(plugin.getDataFolder(), File.separator + "Proxy" + File.separator);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        for (Class<? extends ProxyUtil> cls : list) {
            if (!cls.isAnnotationPresent(ProxyInfo.class)) {
                continue;
            }
            ProxyInfo pi = cls.getAnnotation(ProxyInfo.class);
            File file = Util.getFile(folder, pi.vaule());
            YamlConfiguration config;
            if (!file.exists()) {
                config = new YamlConfiguration();
            } else {
                config = YamlConfiguration.loadConfiguration(file);
            }
            String[] patharr = pi.vaule().split("\\.");
            String root = patharr[patharr.length - 1];
            boolean edit = false;
            for (Field f : Util.getAllDeclaredFields(cls)) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    continue;
                }
                f.setAccessible(true);
                if (f.isAnnotationPresent(ProxyScript.class)) {
                    if (!ProxyedScript.class.isAssignableFrom(f.getType())) {
                        continue;
                    }
                    ProxyScript ps = f.getAnnotation(ProxyScript.class);
                    File jsFile = Util.getJsFile(folder, ps.file());
                    if (!jsFile.exists()) {
                        try {
                            Util.OutputFile(plugin, ps.fromJarFile(), jsFile);
                        } catch (IOException ex) {
                            Logger.getLogger(ProxyUtil.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    ProxyedScript pds = new ProxyedScript() {
                        private String Function = ps.function();
                        private NashornScriptEngine Engine = ScriptLoader.evalAsUTF8(plugin, jsFile);

                        @Override
                        public Object proxy(Object... args) {
                            try {
                                return Engine.invokeFunction(Function, args);
                            } catch (ScriptException | NoSuchMethodException ex) {
                                Logger.getLogger(ProxyUtil.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            return null;
                        }
                    };
                    try {
                        f.set(pds, null);
                    } catch (IllegalArgumentException | IllegalAccessException ex) {
                        Logger.getLogger(ProxyUtil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    continue;
                }
                if (!f.isAnnotationPresent(Proxy.class)) {
                    continue;
                }
                Proxy p = f.getAnnotation(Proxy.class);
                String path = root + '.' + (p.vaule().isEmpty() ? f.getName() : p.vaule());
                try {
                    if (config.contains(path)) {
                        f.set(config.get(path), null);
                    } else {
                        config.set(path, f.get(null));
                        edit = true;
                    }
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(ProxyUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (edit) {
                try {
                    config.save(file);
                } catch (IOException ex) {
                    Logger.getLogger(ProxyUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    static class Util {

        private static <T extends ProxyUtil> Collection<Field> getAllDeclaredFields(Class<T> cls) {
            Class<?> t = cls;
            List<Field> f = new ArrayList<>();
            while (t != Object.class) {
                f.addAll(Arrays.asList(t.getDeclaredFields()));
                t = t.getSuperclass();
            }
            return f;
        }

        private static File getFile(File folder, String path) {
            String[] s = path.split("\\.");
            if (s.length <= 1) {
                return new File(folder, "Proxyed.yml");
            }
            for (int i = 0; i < s.length - 2; i++) {
                folder = new File(folder, File.separator + s[i] + File.separator);
            }
            return new File(folder, s[s.length - 2] + ".yml");
        }

        private static File getJsFile(File folder, String path) {
            String[] s = path.split("\\.");
            if (s.length <= 1) {
                return new File(folder, s[0] + ".js");
            }
            for (int i = 0; i < s.length - 1; i++) {
                folder = new File(folder, File.separator + s[i] + File.separator);
            }
            return new File(folder, s[s.length - 1] + ".js");
        }

        private static void OutputFile(Plugin p, String res, File target) throws IOException {
            InputStream is = p.getResource(res);
            if (is == null) {
                return;
            }

            if (!target.exists()) {
                target.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(target);
            while (true) {
                int i = is.read();
                if (i == -1) {
                    break;
                }
                fos.write(i);
            }
            fos.close();
            is.close();
        }
    }
}
