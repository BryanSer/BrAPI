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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan_lzh
 */
public abstract class DatabaseSerializable {

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

        public String DatabaseName();
    }

    private static Map<Class<? extends DatabaseSerializable>, Statement> Statements = new HashMap<>();

    public static void Register(Class<? extends DatabaseSerializable> cls, String url)
            throws InstantiationException, ClassNotFoundException, IllegalAccessException,
            SQLException, NullDatabaseNameException, TooMuchKeyException, NullKeyException {
        if (cls.isAnonymousClass()) {
            if (!cls.isAnnotationPresent(Database.class)) {
                throw new NullDatabaseNameException(cls);
            }
            Database db = cls.getAnnotation(Database.class);
            if (db.DatabaseName() == null || db.DatabaseName().isEmpty()) {
                throw new NullDatabaseNameException(cls);
            }
        }
        Driver i = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection(url);
        Statement s = conn.createStatement();
        Statements.put(cls, s);
        CreateTables(cls);
    }

    public void Save() throws IllegalArgumentException, IllegalAccessException, NullKeyException {
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
        }else {
            sql = "INSERT INTO "+this.getTableName()+" VALUES ";
        }
    }

    private boolean isExists() throws IllegalArgumentException, IllegalAccessException {
        try {
            Field f = this.getKey();
            Config c = f.getAnnotation(Config.class);
            String sql;
            if (c.ValueType() == String.class) {
                sql = "select * from " + this.getTableName() + " where " + this.getKeyName() + " = '" + ((String) this.getKey().get(this)) + "'";
            } else if (Number.class == c.ValueType()) {
                sql = "select * from " + this.getTableName() + " where " + this.getKeyName() + " = " + ((Number) this.getKey().get(this)).doubleValue();
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

    public String getTableName() {
        String tablename = null;
        if (this.getClass().isAnnotationPresent(Database.class)) {
            Database db = this.getClass().getAnnotation(Database.class);
            if (db.DatabaseName() != null && !db.DatabaseName().isEmpty()) {
                tablename = db.DatabaseName();
            }
        }
        if (tablename == null) {
            tablename = this.getClass().getSimpleName();
        }
        return tablename;
    }

    public String getKeyName() throws NullKeyException {
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

    public Field getKey() throws NullKeyException {
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

    private static void CreateTables(Class<? extends DatabaseSerializable> cls) throws TooMuchKeyException, SQLException, NullKeyException {
        Statement SQL = Statements.get(cls);
        String tablename = null;
        if (cls.isAnnotationPresent(Database.class)) {
            Database db = cls.getAnnotation(Database.class);
            if (db.DatabaseName() != null && !db.DatabaseName().isEmpty()) {
                tablename = db.DatabaseName();
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
                    temp += " " + "NOT NULL";
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
            sql += "PRIMARY KEY(`" + (c.Name().isEmpty() ? key.getName() : c.Name())
                    + "`)";
        } else {
            throw new NullKeyException(cls);
        }
        sql += ")";
        SQL.execute(sql);
    }

}
