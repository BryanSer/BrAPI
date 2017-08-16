/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

/**
 * 用于快捷实现ConfigurationSerializable
 * @author Bryan_lzh
 */
public interface BrConfigurationSerializable extends ConfigurationSerializable {

    /**
     * 带有该注释的局域变量将会自动被序列化
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Config {

        /**
         * 用于指定序列号后在TAML中的相对位置 默认为变量名
         * @return
         */
        String Path() default "";
    }

    /**
     * 自动反序列号静态方法
     * @param <T> 需要反序列话的类
     * @param args Bukkit传入的Map
     * @param t 需要反序列化的对象
     */
    public static <T extends BrConfigurationSerializable> void deserialize(Map<String, Object> args, T t) {
        Class<? extends BrConfigurationSerializable> c = t.getClass();
        for (Field f : c.getFields()) {
            if (f.isAnnotationPresent(Config.class)) {
                Config co = f.getAnnotation(Config.class);
                String path;
                if (co.Path().isEmpty()) {
                    path = f.getName();
                } else {
                    path = co.Path();
                }
                try {
                    f.set(t, f.getType().cast(args.get(path)));
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public default Map<String, Object> serialize() {
        Map<String, Object> map = new LinkedHashMap<>();
        for (Field f : this.getClass().getFields()) {
            if (f.isAnnotationPresent(Config.class)) {
                Config c = f.getAnnotation(Config.class);
                String path;
                if (c.Path().isEmpty()) {
                    path = f.getName();
                } else {
                    path = c.Path();
                }
                try {
                    map.put(path, f.get(this));
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return map;
    }

}
