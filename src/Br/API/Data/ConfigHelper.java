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
    }
    private Plugin plugin;

    public ConfigHelper(Plugin p) {
        this.plugin = p;
    }

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

    public void Load() throws IOException {
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

}
