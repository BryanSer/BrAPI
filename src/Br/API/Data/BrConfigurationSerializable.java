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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

/**
 * 用于快捷实现ConfigurationSerializable
 *
 * @author Bryan_lzh
 */
public interface BrConfigurationSerializable extends ConfigurationSerializable {

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

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public static @interface MapTarget {

        public enum KeyTypes {
            String((s) -> s, (o) -> (String) o),
            Int(Integer::parseInt, (o) -> o + ""),
            Float(java.lang.Float::parseFloat, (o) -> o + ""),
            Double(java.lang.Double::parseDouble, (o) -> o + ""),
            Long(java.lang.Long::parseLong, (o) -> o + ""),
            Short(java.lang.Short::parseShort, (o) -> o + ""),
            Byte(java.lang.Byte::parseByte, (o) -> o + ""),
            Custom(null, null);
            Function<String, Object> O;
            Function<Object, String> S;

            private KeyTypes(Function<String, Object> toO, Function<Object, String> toS) {
                this.O = toO;
                this.S = toS;
            }

            public String toString(Object o) {
                return S.apply(o);
            }

            public Object toObject(String s) {
                return O.apply(s);
            }
        }

        public KeyTypes KeyType();

        /**
         * 若KeyType == Custom 将需要定义<p>
         * Key的类
         *
         * @return
         */
        public Class<?> KeyClass() default String.class;

        /**
         * 若KeyType == Custom 将需要定义<p>
         * 从字符串变为Key对象的<b>public</b>静态方法名<br>
         * 该静态方法必须存在于 @see KeyClass() 类中
         *
         * 如 public static Object toObject(String s)
         *
         * @return
         */
        public String toObject() default "";

        /**
         * 若KeyType == Custom 将需要定义<p>
         * 从对象变为字符串的<b>public</b>静态方法名<br>
         * 该静态方法必须存在于 @see KeyClass() 类中 如 public static String toString(Object
         * obj)
         *
         * @return
         */
        public String toStringMethod() default "toString";
    }

    static <T extends BrConfigurationSerializable> Collection<Field> getAllDeclaredFields(Class<T> cls) {
        Class<?> t = cls;
        List<Field> f = new ArrayList<>();
        while(t != Object.class){
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
    public static <T extends BrConfigurationSerializable> void deserialize(Map<String, Object> args, T t) {
        Class<? extends BrConfigurationSerializable> c = t.getClass();
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
                    if (f.getType().isAssignableFrom(Map.class)) {
                        List<String> keys = (List<String>) args.get(path + "Keys");
                        Map m = new HashMap<>();
                        if (f.isAnnotationPresent(MapTarget.class)) {
                            MapTarget mt = f.getAnnotation(MapTarget.class);
                            if (mt.KeyType() != MapTarget.KeyTypes.Custom) {
                                MapTarget.KeyTypes kt = mt.KeyType();
                                keys.forEach((s) -> {
                                    m.put(kt.toObject(s), args.get(path + "." + s));
                                });
                            } else {
                                Method method = mt.KeyClass().getMethod(mt.toObject(), (Class<?>[]) null);
                                keys.forEach((s) -> {
                                    try {
                                        m.put(method.invoke(null, s), args.get(path + "." + s));
                                    } catch (IllegalAccessException ex) {
                                        Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IllegalArgumentException ex) {
                                        Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (InvocationTargetException ex) {
                                        Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                });
                            }
                        } else {
                            for (String s : keys) {
                                m.put(s, args.get(path + "." + s));
                            }
                        }
                        f.set(t, m);
                    } else if (f.getType().isEnum()) {
                        Method m = f.getType().getMethod("valueOf", String.class);
                        Object re = m.invoke(null, args.get(path));
                        f.set(t, re);
                    } else {
                        f.set(t, args.get(path));
                    }
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
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
                    if (f.getType().isAssignableFrom(Map.class)) {
                        try {
                            List<String> keys = new ArrayList<>();
                            if (f.isAnnotationPresent(MapTarget.class)) {
                                Map m = (Map) f.get(this);
                                MapTarget mt = f.getAnnotation(MapTarget.class);
                                if (mt.KeyType() != MapTarget.KeyTypes.Custom) {
                                    MapTarget.KeyTypes kt = mt.KeyType();
                                    ((Set<Map.Entry>) m.entrySet()).forEach((e) -> {
                                        map.put(path + "." + kt.toString(e.getKey()), e.getValue());
                                        keys.add(kt.toString(e.getKey()));
                                    });
                                } else {
                                    Method method = mt.KeyClass().getMethod(mt.toStringMethod(), Object.class);
                                    for (Map.Entry e : (Set<Map.Entry>) m.entrySet()) {
                                        String key = (String) method.invoke(null, e.getKey());
                                        map.put(path + "." + key, e.getValue());
                                        keys.add(key);
                                    }
                                }
                            } else {
                                Map<String, Object> m = (Map<String, Object>) f.get(this);
                                m.entrySet().forEach((e) -> {
                                    map.put(path + "." + e.getKey(), e.getValue());
                                    keys.add(e.getKey());
                                });
                            }
                            map.put(path + "Keys", keys);
                        } catch (Exception ex) {
                            Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (f.getType().isEnum()) {
                        Object obj = f.get(this);
                        Method m = obj.getClass().getMethod("name", (Class<?>[]) null);
                        String re = (String) m.invoke(obj, (Object[]) null);
                        map.put(path, re);
                    } else {
                        map.put(path, f.get(this));
                    }
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(BrConfigurationSerializable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return map;
    }

}
