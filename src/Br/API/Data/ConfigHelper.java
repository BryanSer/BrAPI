/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Data;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Bryan_lzh
 */
public abstract class ConfigHelper {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Config {

        /**
         * 用于指定配置在TAML中的相对位置 默认为变量名
         *
         * @return
         */
        public String Path() default "";

        /**
         * 用来设定该字段的注释
         *
         * @return
         */
        public String Annotation() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Setting {

        /**
         * 用于指定配置在TAML中的根目录 默认为空
         *
         * @return
         */
        public String Root() default "";

        /**
         * 用于指定配置名 默认为config
         *
         * @return
         */
        public String File() default "config.yml";

        /**
         * 用于描述该配置文件
         *
         * @return
         */
        public String Description() default "";
    }
    private Plugin plugin;

    @Deprecated
    public ConfigHelper(Plugin p) {
        this.plugin = p;
    }

    @Deprecated
    public void Reload() throws IOException {
        Class<? extends ConfigHelper> cls = this.getClass();
        File cfg = null;
        String root = "";
        if (cls.isAnnotationPresent(Setting.class)) {
            Setting s = cls.getAnnotation(Setting.class);
            String filename = s.File();
            cfg = new File(this.plugin.getDataFolder(), filename);
            root = s.Root().isEmpty() ? "" : s.Root() + ".";

        } else {
            cfg = new File(this.plugin.getDataFolder(), "config.yml");
        }
        if (!cfg.exists()) {
            this.plugin.getDataFolder().mkdirs();
            cfg.createNewFile();
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(cfg);
        for (Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Config.class)) {
                Config c = f.getAnnotation(Config.class);
                String path = root + (c.Path().isEmpty() ? f.getName() : c.Path());
                if (config.contains(path)) {
                    try {
                        f.set(this, config.get(path));
                    } catch (Throwable ex) {
                        Logger.getLogger(ConfigHelper.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    @Deprecated
    public void Load() throws IOException {
        Class<? extends ConfigHelper> cls = this.getClass();
        File cfg = null;
        String root = "";
        String des = null;
        if (cls.isAnnotationPresent(Setting.class)) {
            Setting s = cls.getAnnotation(Setting.class);
            String filename = s.File();
            cfg = new File(this.plugin.getDataFolder(), filename);
            root = s.Root().isEmpty() ? "" : s.Root() + ".";
            if (!s.Description().isEmpty()) {
                des = s.Description();
            }
        } else {
            cfg = new File(this.plugin.getDataFolder(), "config.yml");
        }
        if (!cfg.exists()) {
            this.plugin.getDataFolder().mkdirs();
            cfg.createNewFile();
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(cfg);
        if (des != null) {
            config.options().header(des);
        }
        boolean save = false;
        for (Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Config.class)) {
                Config c = f.getAnnotation(Config.class);
                String path = root + (c.Path().isEmpty() ? f.getName() : c.Path());
                if (!config.contains(path)) {
                    try {
                        Object get = f.get(this);
                        if (get != null) {
                            config.set(path, get);
                            if (!c.Annotation().isEmpty()) {
                                String h = config.options().header();
                                if (h == null) {
                                    h = "";
                                }
                                h += path + " >> " + c.Annotation() + "\n";
                                config.options().header(h);
                            }
                            save = true;
                        }
                    } catch (Throwable ex) {
                        Logger.getLogger(ConfigHelper.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        f.set(this, config.get(path));
                    } catch (Throwable ex) {
                        Logger.getLogger(ConfigHelper.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        if (save) {
            config.save(cfg);
        }
    }

    public static void Reload(Class<?> cls, Plugin p) throws IOException {
        File cfg = null;
        String root = "";
        if (cls.isAnnotationPresent(Setting.class)) {
            Setting s = cls.getAnnotation(Setting.class);
            String filename = s.File();
            cfg = new File(p.getDataFolder(), filename);
            root = s.Root().isEmpty() ? "" : s.Root() + ".";
        } else {
            cfg = new File(p.getDataFolder(), "config.yml");
        }
        if (!cfg.exists()) {
            p.getDataFolder().mkdirs();
            cfg.createNewFile();
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(cfg);
        for (Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Config.class)) {
                Config c = f.getAnnotation(Config.class);
                String path = root + (c.Path().isEmpty() ? f.getName() : c.Path());
                if (!config.contains(path)) {
                    try {
                        Object get = f.get(null);
                        if (get != null) {
                            config.set(path, get);
                            if (!c.Annotation().isEmpty()) {
                                String h = config.options().header();
                                if (h == null) {
                                    h = "";
                                }
                                h += path + " >> " + c.Annotation() + "\n";
                                config.options().header(h);
                            }
                        }
                    } catch (Throwable ex) {
                    }
                } else {
                    try {
                        f.set(null, config.get(path));
                    } catch (Throwable ex) {
                    }
                }
            }
        }
    }

    public static void Load(Class<?> cls, Plugin p) throws IOException {
        File cfg = null;
        String root = "";
        if (cls.isAnnotationPresent(Setting.class)) {
            Setting s = cls.getAnnotation(Setting.class);
            String filename = s.File();
            cfg = new File(p.getDataFolder(), filename);
            root = s.Root().isEmpty() ? "" : s.Root() + ".";
        } else {
            cfg = new File(p.getDataFolder(), "config.yml");
        }
        if (!cfg.exists()) {
            p.getDataFolder().mkdirs();
            cfg.createNewFile();
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(cfg);
        boolean save = false;
        for (Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Config.class)) {
                Config c = f.getAnnotation(Config.class);
                String path = root + (c.Path().isEmpty() ? f.getName() : c.Path());
                if (!config.contains(path)) {
                    try {
                        Object get = f.get(null);
                        if (get != null) {
                            config.set(path, get);
                            save = true;
                        }
                    } catch (Throwable ex) {
                    }
                } else {
                    try {
                        f.set(null, config.get(path));
                    } catch (Throwable ex) {
                    }
                }
            }
        }
        if (save) {
            config.save(cfg);
        }
    }
}
