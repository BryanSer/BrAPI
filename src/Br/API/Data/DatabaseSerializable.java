/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Data;

import com.mysql.jdbc.Driver;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan_lzh
 */
public interface DatabaseSerializable {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Config {

        public String Name() default "";

        public boolean Key() default false;

        public String DataType();

        public Class<?> ValueType();

        public boolean NotNull() default false;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Database {

        public String TableName();
    }

    static Map<Class<? extends DatabaseSerializable>, Statement> Statements = new HashMap<>();

    public static void Register(Class<? extends DatabaseSerializable> cls, String url)
            throws InstantiationException, ClassNotFoundException, IllegalAccessException,
            SQLException, NullDatabaseNameException, TooMuchKeyException, NullKeyException {
        if (cls.isAnonymousClass()) {
            if (!cls.isAnnotationPresent(Database.class)) {
                throw new NullDatabaseNameException(cls);
            }
            Database db = cls.getAnnotation(Database.class);
            if (db.TableName() == null || db.TableName().isEmpty()) {
                throw new NullDatabaseNameException(cls);
            }
        }
        Driver i = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection(url);
        Statement s = conn.createStatement();
        Statements.put(cls, s);
        CreateTables(cls);
    }

    public default void Save() throws IllegalArgumentException, IllegalAccessException, NullKeyException, SQLException {
        String sql = null;
        if (this.isExists()) {
            sql = "UPDATE " + this.getTableName() + " set ";
            boolean first = true;
            for (Field f : this.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(Config.class)) {
                    Config c = f.getAnnotation(Config.class);
                    if (!first) {
                        sql += ",";
                    }
                    first = false;
                    sql += (c.Name().isEmpty() ? f.getName() : c.Name()) + " = '" + c.ValueType().cast(f.get(this)).toString() + "'";
                }
            }
            Field f = this.getKey();
            Config c = f.getAnnotation(Config.class);
            sql += "where " + this.getKeyName() + " = '" + c.ValueType().cast(f.get(this).toString()) + "'";
        } else {
            sql = "INSERT INTO " + this.getTableName() + " ";
            String key = "(";
            String value = "(";
            boolean first = true;
            for (Field f : this.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(Config.class)) {
                    Config c = f.getAnnotation(Config.class);
                    if (!first) {
                        key += ",";
                        value += ",";
                    }
                    first = false;
                    key += c.Name().isEmpty() ? f.getName() : c.Name();
                    value += "'" + c.ValueType().cast(f.get(this)).toString() + "'";
                }
            }
            key += ")";
            value += ")";
            sql += key + " VALUES " + value;
        }
        System.out.println(sql);
        Statements.get(this.getClass()).execute(sql);
    }

    public default boolean isExists() throws IllegalArgumentException, IllegalAccessException {
        try {
            Field f = this.getKey();
            Config c = f.getAnnotation(Config.class);
            String sql;
            if (c.ValueType() == String.class) {
                sql = "select * from " + this.getTableName() + " where " + this.getKeyName() + " = '" + ((String) this.getKey().get(this)) + "'";
            } else if (Number.class == c.ValueType()) {
                sql = "select * from " + this.getTableName() + " where " + this.getKeyName() + " = " + ((Number) this.getKey().get(this));
            } else {
                sql = "select * from " + this.getTableName() + " where " + this.getKeyName() + " = '" + (this.getKey().get(this)) + "'";
            }
            ResultSet sr = Statements.get(this.getClass()).executeQuery(sql);
            return sr.next();
        } catch (NullKeyException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public default String getTableName() {
        String tablename = null;
        if (this.getClass().isAnnotationPresent(Database.class)) {
            Database db = this.getClass().getAnnotation(Database.class);
            if (db.TableName() != null && !db.TableName().isEmpty()) {
                tablename = db.TableName();
            }
        }
        if (tablename == null) {
            tablename = this.getClass().getSimpleName();
        }
        return tablename;
    }

    public default String getKeyName() throws NullKeyException {
        for (Field f : this.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Config.class)) {
                Config c = f.getAnnotation(Config.class);
                if (c.Key()) {

                    return c.Name().isEmpty() ? f.getName() : c.Name();
                }
            }
        }
        throw new NullKeyException(this.getClass());
    }

    public default Field getKey() throws NullKeyException {
        for (Field f : this.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Config.class)) {
                Config c = f.getAnnotation(Config.class);
                if (c.Key()) {
                    return f;
                }
            }
        }
        throw new NullKeyException(this.getClass());
    }

    public static <T extends DatabaseSerializable> Field getKey(Class<? extends DatabaseSerializable> cls) throws NullKeyException {
        for (Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Config.class)) {
                Config c = f.getAnnotation(Config.class);
                if (c.Key()) {
                    return f;
                }
            }
        }
        throw new NullKeyException(cls);
    }

    static void CreateTables(Class<? extends DatabaseSerializable> cls) throws TooMuchKeyException, SQLException, NullKeyException {
        Statement SQL = Statements.get(cls);
        String tablename = null;
        if (cls.isAnnotationPresent(Database.class)) {
            Database db = cls.getAnnotation(Database.class);
            if (db.TableName() != null && !db.TableName().isEmpty()) {
                tablename = db.TableName();
            }
        }
        if (tablename == null) {
            tablename = cls.getSimpleName();
        }
        String sql = "CREATE TABLE IF NOT EXISTS " + tablename + " (";
        boolean first = true;
        Field key = null;
        for (Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Config.class)) {
                Config c = f.getAnnotation(Config.class);
                String temp = c.Name().isEmpty() ? f.getName() : c.Name();
                temp = temp + " " + c.DataType();
                if (c.NotNull()) {
                    temp += " " + "NOT NULL ";
                }
                if (!first) {
                    temp = "," + temp;
                }
                first = false;
                sql += temp;
                if (c.Key()) {
                    if (key != null) {
                        throw new TooMuchKeyException(cls);
                    }
                    key = f;
                }
            }
        }
        if (key != null) {
            Config c = key.getAnnotation(Config.class);
            sql += ",PRIMARY KEY(`" + (c.Name().isEmpty() ? key.getName() : c.Name())
                    + "`)";
        } else {
            throw new NullKeyException(cls);
        }
        sql += ")";
        System.out.println(sql);
        SQL.execute(sql);
    }

    public static <T extends DatabaseSerializable> List<T> DeSerializeAll(Class<? extends T> cls) throws SQLException, InstantiationException, IllegalAccessException {
        String tn;
        if (cls.isAnnotationPresent(Database.class)) {
            Database db = cls.getAnnotation(Database.class);
            tn = db.TableName();
        } else {
            tn = cls.getSimpleName();
        }
        String sql = "select * from " + tn;
        ResultSet sr = DatabaseSerializable.Statements.get(cls).executeQuery(sql);
        List<T> list = new ArrayList<>();
        while (sr.next()) {
            T t = cls.newInstance();
            for (Field f : t.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(Config.class)) {
                    Config c = f.getAnnotation(Config.class);
                    String s = c.Name().isEmpty() ? f.getName() : c.Name();
                    Object obj = sr.getObject(s);
                    try {
                        f.set(t, obj);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            list.add(t);
        }
        return list;
    }

    public static <T extends DatabaseSerializable> Optional<T> DeSerialize(Object key, T t) {
        try {
            Field f0 = t.getKey();
            Config c0 = f0.getAnnotation(Config.class);
            String sql;
            if (c0.ValueType() == String.class) {
                sql = "select * from " + t.getTableName() + " where " + t.getKeyName() + " = '" + key + "'";
            } else if (Number.class == c0.ValueType()) {
                sql = "select * from " + t.getTableName() + " where " + t.getKeyName() + " = " + ((Number) key);
            } else {
                sql = "select * from " + t.getTableName() + " where " + t.getKeyName() + " = '" + (key) + "'";
            }
            ResultSet sr = Statements.get(t.getClass()).executeQuery(sql);
            if (!sr.next()) {
                return Optional.empty();
            }
            for (Field f : t.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(Config.class)) {
                    Config c = f.getAnnotation(Config.class);
                    String s = c.Name().isEmpty() ? f.getName() : c.Name();
                    Object obj = sr.getObject(s);
                    try {
                        f.set(t, obj);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } catch (NullKeyException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.of(t);
    }

    default void Delete() {
        try {
            String sql = "DELETE FROM " + this.getTableName() + " where " + this.getKeyName() + " = '" + this.getKey().get(this) + "'";
            DatabaseSerializable.Statements.get(this.getClass()).execute(sql);
        } catch (NullKeyException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    class Test implements DatabaseSerializable {
//
//        public Test() {
//        }
//
//        public Test(String s, int i) {
//            this.Name = s;
//            this.ID = i;
//        }
//
//        @Config(Key = true, DataType = "varchar(255)", ValueType = String.class, NotNull = true)
//        private String Name;
//        @Config(DataType = "int", ValueType = Integer.class, NotNull = true)
//        private int ID;
//
//        @Override
//        public String toString() {
//            return "Test{" + "Name=" + Name + ", ID=" + ID + '}';
//
//        }
//
//    }
//
//    public static void main(String args[]) {
//        try {
//            DatabaseSerializable.Register(Test.class, "jdbc:mysql://127.0.0.1:3306/Password?user=root&password=123456&useUnicode=true&characterEncoding=utf8&autoReconnect=true");
//        } catch (InstantiationException ex) {
//            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NullDatabaseNameException ex) {
//            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (TooMuchKeyException ex) {
//            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NullKeyException ex) {
//            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
//        }
////        Test t1 = new Test("Bryan_lzh", 1);
////        try {
////            t1.Save();
////        } catch (IllegalArgumentException ex) {
////            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
////        } catch (IllegalAccessException ex) {
////            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
////        } catch (NullKeyException ex) {
////            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
////        } catch (SQLException ex) {
////            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
////        }
//
//    }
}
