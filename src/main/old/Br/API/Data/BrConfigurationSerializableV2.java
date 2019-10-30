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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

/**
 * 用于快捷实现ConfigurationSerializable
 *
 * @author Bryan_lzh
 */
public interface BrConfigurationSerializableV2 extends ConfigurationSerializable {

    /**
     * 带有该注释的局域变量将会自动被序列化<p>
     * 如果注释的是Map请确保key的泛型为String
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public static @interface Config {

        /**
         * 用于指定序列号后在TAML中的相对位置 默认为变量名
         *
         * @return
         */
        public String Path() default "";
    }

    public static <T extends BrConfigurationSerializableV2> Collection<Field> getAllDeclaredFields(Class<T> cls) {
        Class<?> t = cls;
        List<Field> f = new ArrayList<>();
        while (t != Object.class) {
            f.addAll(Arrays.asList(t.getDeclaredFields()));
            t = t.getSuperclass();
        }
        return f;
    }

    /**
     * 自动反序列号静态方法
     *
     * @param <T> 需要反序列话的类
     * @param args Bukkit传入的Map
     * @param t 需要反序列化的对象
     */
    public static <T extends BrConfigurationSerializableV2> void deserialize(Map<String, Object> args, T t) {
        Class<? extends BrConfigurationSerializableV2> c = t.getClass();
        for (Field f : getAllDeclaredFields(c)) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Config.class)) {
                Config co = f.getAnnotation(Config.class);
                String path;
                if (co.Path().isEmpty()) {
                    path = f.getName();
                } else {
                    path = co.Path();
                }
                try {
                    if (f.getType().isEnum()) {
                        Method m = f.getType().getMethod("valueOf", String.class);
                        Object re = m.invoke(null, args.get(path));
                        f.set(t, re);
                    } else {
                        Object get = args.get(path);
                        if (get instanceof Number) {
                            Number num = (Number) get;
                            Class<?> type = f.getType();
                            if (type == Integer.class || type == int.class) {
                                f.setInt(t, num.intValue());
                            } else if (type == Double.class || type == double.class) {
                                f.setDouble(t, num.doubleValue());
                            } else if (type == Float.class || type == float.class) {
                                f.setFloat(t, num.floatValue());
                            } else if (type == Long.class || type == long.class) {
                                f.setLong(t, num.longValue());
                            } else if (type == Short.class || type == short.class) {
                                f.setShort(t, num.shortValue());
                            } else if (type == Byte.class || type == byte.class) {
                                f.setByte(t, num.byteValue());
                            } else {
                                f.set(t, num);
                            }
                        } else {
                            f.set(t, get);
                        }
                    }
                } catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
                    Logger.getLogger(BrConfigurationSerializableV2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public default Map<String, Object> serialize() {
        Map<String, Object> map = new LinkedHashMap<>();
        for (Field f : getAllDeclaredFields(this.getClass())) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Config.class)) {
                Config c = f.getAnnotation(Config.class);
                String path;
                if (c.Path().isEmpty()) {
                    path = f.getName();
                } else {
                    path = c.Path();
                }
                try {
                    if (f.getType().isEnum()) {
                        Object obj = f.get(this);
                        Method m = obj.getClass().getMethod("name", (Class<?>[]) null);
                        String re = (String) m.invoke(obj, (Object[]) null);
                        map.put(path, re);
                    } else {
                        map.put(path, f.get(this));
                    }
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(BrConfigurationSerializableV2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(BrConfigurationSerializableV2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(BrConfigurationSerializableV2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(BrConfigurationSerializableV2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(BrConfigurationSerializableV2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return map;
    }
}
