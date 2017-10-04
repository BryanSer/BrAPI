/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Data;

import com.mysql.jdbc.Driver;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * 使用该接口，可以超快捷实现对象在数据库中的序列化与反序列化
 *
 * @author Bryan_lzh
 */
public interface DatabaseSerializable {
//    private long last = 0;
//
//    @Override
//    public long getLastLoad() {
//        return last;
//    }
//
//    @Override
//    public void setLastLoad(long l) {
//        this.last = l;
//    } 请确保此处按这样编写方法

    long getLastLoad();

    void setLastLoad(long l);

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Config {

        public String Name() default "";

        public boolean Key() default false;

        public String DataType();

        public boolean NotNull() default false;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Database {

        public String TableName() default "";

        public boolean UpdateCheck() default false;
    }

    default void DeleteTable() {
        Statement s = Statements.get(this.getClass());
        try {
            s.execute("drop table " + this.getTableName());
            if (this.getClass().isAnnotationPresent(Database.class)) {
                Database db = this.getClass().getAnnotation(Database.class);
                if (db.UpdateCheck()) {
                    s.execute("drop table " + this.getTableName() + "_Update");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    default void RecrateTable() {
        this.DeleteTable();
        try {
            DatabaseSerializable.CreateTables(this.getClass());
        } catch (TooMuchKeyException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullKeyException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static Map<Class<? extends DatabaseSerializable>, Connection> Connections = new HashMap<>();

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
        Connections.put(cls, conn);
        Statement s = conn.createStatement();
        Statements.put(cls, s);
        CreateTables(cls);
    }

    static Map<Class<? extends DatabaseSerializable>, PreparedStatement> UpdateCheckPreparedStatements = new HashMap<>();

    public default void UpdateData() {
        if (this.getClass().isAnnotationPresent(Database.class)) {
            Database db = this.getClass().getAnnotation(Database.class);
            if (db.UpdateCheck()) {
                if (!UpdateCheckPreparedStatements.containsKey(this.getClass())) {
                    try {
                        PreparedStatement ps = Connections.get(this.getClass()).prepareStatement("select Time from " + this.getTableName() + "_Update where KeyValue = ?");
                        UpdateCheckPreparedStatements.put(this.getClass(), ps);
                    } catch (SQLException ex) {
                        Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                PreparedStatement ps = UpdateCheckPreparedStatements.get(this.getClass());
                try {
                    ps.setObject(1, this.getKey().get(this));
                    ResultSet sr = ps.executeQuery();
                    if (sr.next()) {
                        long time = sr.getLong(1);
                        if (this.getLastLoad() >= time) {
                            return;
                        }
                        this.setLastLoad(time);
                    }
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullKeyException ex) {
                    Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        DatabaseSerializable t = this;
        if (!DataPreparedStatements.containsKey(t.getClass())) {
            try {
                PreparedStatement ps = Connections.get(t.getClass()).prepareCall("select * from " + t.getTableName()
                        + " where " + t.getKeyName()
                        + " = ?");
                DataPreparedStatements.put(t.getClass(), ps);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullKeyException ex) {
                Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        PreparedStatement ps = DataPreparedStatements.get(t.getClass());
        try {
            ps.setObject(1, t.getKey().get(t));
            ResultSet sr = ps.executeQuery();
            if (!sr.next()) {
                return;
            }
            for (Field f : t.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(Config.class)) {
                    Config c = f.getAnnotation(Config.class);
                    if (c.DataType().toUpperCase().contains("BLOB")) {
                        String s = c.Name().isEmpty() ? f.getName() : c.Name();
                        f.set(t, Bytes2Object(sr.getBytes(s), f.getType()));
                        continue;
                    }
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
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static Map<Class<? extends DatabaseSerializable>, PreparedStatement> UpdatePreparedStatements = new HashMap<>();
    static Map<Class<? extends DatabaseSerializable>, PreparedStatement> InsertPreparedStatements = new HashMap<>();
    static Map<Class<? extends DatabaseSerializable>, PreparedStatement> UpdateTimePreparedStatements = new HashMap<>();
    static Map<Class<? extends DatabaseSerializable>, PreparedStatement> InsertTimePreparedStatements = new HashMap<>();

    /**
     * 储存对象 现已使用PreparedStatement
     *
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws NullKeyException
     * @throws SQLException
     */
    public default void Save() throws IllegalArgumentException, IllegalAccessException, NullKeyException, SQLException {
        String sql = null;
        if (this.isExists()) {
            if (!UpdatePreparedStatements.containsKey(this.getClass())) {
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
                        sql += (c.Name().isEmpty() ? f.getName() : c.Name()) + " = ?";
                    }
                }
                sql += "where " + this.getKeyName() + " = ?";
                PreparedStatement ps = Connections.get(this.getClass()).prepareStatement(sql);
                UpdatePreparedStatements.put(this.getClass(), ps);
            }
            PreparedStatement ps = UpdatePreparedStatements.get(this.getClass());
            int i = 1;
            for (Field f : this.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (!f.isAnnotationPresent(Config.class)) {
                    continue;
                }
                Config c = f.getAnnotation(Config.class);
                if (c.DataType().toUpperCase().contains("BLOB")) {
                    try {
                        ps.setBytes(i++, DatabaseSerializable.Object2Bytes(f.get(this)));
                        continue;
                    } catch (IOException ex) {
                        Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ps.setObject(i++, f.get(this));
            }
            ps.setObject(i, this.getKey().get(this));
            ps.execute();

            if (this.getClass().isAnnotationPresent(Database.class)) {
                Database db = this.getClass().getAnnotation(Database.class);
                if (db.UpdateCheck()) {
                    if (!UpdateTimePreparedStatements.containsKey(this.getClass())) {
                        Connection conn = Connections.get(this.getClass());
                        PreparedStatement ps2 = conn.prepareStatement("UPDATE " + this.getTableName() + "_Update set Time = ? where KeyValue = ?");
                        UpdateTimePreparedStatements.put(this.getClass(), ps2);
                    }
                    PreparedStatement ps2 = UpdateTimePreparedStatements.get(this.getClass());
                    ps2.setLong(1, System.currentTimeMillis());
                    ps2.setObject(2, this.getKey().get(this));
                    ps2.execute();
                }
            }

        } else {
            if (!InsertPreparedStatements.containsKey(this.getClass())) {
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
                        value += "?";
                    }
                }
                key += ")";
                value += ")";
                sql += key + " VALUES " + value;
                PreparedStatement ps = Connections.get(this.getClass()).prepareStatement(sql);
                InsertPreparedStatements.put(this.getClass(), ps);
            }
            PreparedStatement ps = InsertPreparedStatements.get(this.getClass());

            int i = 1;

            for (Field f : this.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (!f.isAnnotationPresent(Config.class)) {
                    continue;
                }
                Config c = f.getAnnotation(Config.class);
                if (c.DataType().toUpperCase().contains("BLOB")) {
                    try {
                        ps.setBytes(i++, DatabaseSerializable.Object2Bytes(f.get(this)));
                        continue;
                    } catch (IOException ex) {
                        Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ps.setObject(i++, f.get(this));
            }
            ps.execute();
            if (this.getClass().isAnnotationPresent(Database.class)) {
                Database db = this.getClass().getAnnotation(Database.class);
                if (db.UpdateCheck()) {
                    if (!InsertTimePreparedStatements.containsKey(this.getClass())) {
                        PreparedStatement ps2 = Connections.get(this.getClass()).prepareStatement("INSERT INTO " + this.getTableName() + "_Update VALUES (?,?)");
                        InsertTimePreparedStatements.put(this.getClass(), ps2);
                    }
                    PreparedStatement ps2 = InsertTimePreparedStatements.get(this.getClass());
                    ps2.setObject(1, this.getKey().get(this));
                    ps2.setLong(2, System.currentTimeMillis());
                    ps2.execute();
                }
            }
        }
    }

    static Map<Class<? extends DatabaseSerializable>, PreparedStatement> DataPreparedStatements = new HashMap<>();

    public default boolean isExists() throws IllegalArgumentException, IllegalAccessException {
        if (!DataPreparedStatements.containsKey(this.getClass())) {
            try {
                PreparedStatement ps = Connections.get(this.getClass()).prepareCall("select * from " + this.getTableName()
                        + " where " + this.getKeyName()
                        + " = ?");
                DataPreparedStatements.put(this.getClass(), ps);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullKeyException ex) {
                Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        PreparedStatement ps = DataPreparedStatements.get(this.getClass());
        try {
            ps.setObject(1, this.getKey().get(this));
            ResultSet sr = ps.executeQuery();
            return sr.next();
        } catch (NullKeyException ex) {
        } catch (SQLException ex) {
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

    static Map<Class<? extends DatabaseSerializable>, Field> Keys = new HashMap<>();

    public default Field getKey() throws NullKeyException {
        if (!Keys.containsKey(this.getClass())) {
            boolean b = true;
            for (Field f : this.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(Config.class)) {
                    Config c = f.getAnnotation(Config.class);
                    if (c.Key()) {
                        Keys.put(this.getClass(), f);
                        b = false;
                        break;
                    }
                }
            }
            if (b) {
                throw new NullKeyException(this.getClass());
            }
        }
        return Keys.get(this.getClass());
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
        boolean UpdateCheck = false;
        if (cls.isAnnotationPresent(Database.class)) {
            Database db = cls.getAnnotation(Database.class);
            if (db.TableName() != null && !db.TableName().isEmpty()) {
                tablename = db.TableName();
            }
            UpdateCheck = db.UpdateCheck();
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
                    temp += " NOT NULL ";
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
        SQL.execute(sql);
        if (UpdateCheck) {
            Config c = key.getAnnotation(Config.class);
            sql = "CREATE TABLE IF NOT EXISTS " + tablename + "_Update (KeyValue "
                    + c.DataType() + " NOT NULL ,Time BIGINT ,PRIMARY KEY(`KeyValue`))";
            SQL.execute(sql);
        }
    }

    static Map<Class< ? extends DatabaseSerializable>, PreparedStatement> PreparedStatementPreparedStatement = new HashMap<>();
    static Map<Class< ? extends DatabaseSerializable>, PreparedStatement> PreparedTimeStatementPreparedStatement = new HashMap<>();

    public static <T extends DatabaseSerializable> List<T> DeserializeAll(Class<? extends T> cls) throws SQLException, InstantiationException, IllegalAccessException {
        String tn;
        if (cls.isAnnotationPresent(Database.class)) {
            Database db = cls.getAnnotation(Database.class);
            tn = db.TableName().isEmpty() ? cls.getSimpleName() : db.TableName();
        } else {
            tn = cls.getSimpleName();
        }
        if (!PreparedStatementPreparedStatement.containsKey(cls)) {
            PreparedStatementPreparedStatement.put(cls, Connections.get(cls).prepareStatement("select * from " + tn));
        }
        if (!PreparedTimeStatementPreparedStatement.containsKey(cls)) {
            PreparedTimeStatementPreparedStatement.put(cls, Connections.get(cls).prepareStatement("select Time from " + tn + "_Update where KeyValue = ?"));
        }
        PreparedStatement ps = PreparedStatementPreparedStatement.get(cls);
        ResultSet sr = ps.executeQuery();
        PreparedStatement ps2 = PreparedTimeStatementPreparedStatement.get(cls);

        List<T> list = new ArrayList<>();
        boolean up = false;
        if (cls.isAnnotationPresent(Database.class)) {
            Database db = cls.getAnnotation(Database.class);
            up = db.UpdateCheck();
        }
        while (sr.next()) {
            T t = cls.newInstance();
            for (Field f : t.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(Config.class)) {
                    Config c = f.getAnnotation(Config.class);
                    if (c.DataType().toUpperCase().contains("BLOB")) {
                        String s = c.Name().isEmpty() ? f.getName() : c.Name();
                        try {
                            f.set(t, Bytes2Object(sr.getBytes(s), f.getType()));
                        } catch (IOException ex) {
                            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        continue;
                    }
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
            if (up) {
                try {
                    ps2.setObject(1, t.getKey().get(t));
                    ResultSet sr2 = ps2.executeQuery();
                    if (sr2.next()) {
                        t.setLastLoad(sr2.getLong(1));
                    }
                } catch (NullKeyException ex) {
                    Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            list.add(t);
        }
        return list;
    }

    public static <T extends DatabaseSerializable> Optional<T> Deserialize(Object key, Class<T> cls) {
        T t;
        try {
            t = cls.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
            return Optional.empty();
        }
        if (!DataPreparedStatements.containsKey(t.getClass())) {
            try {
                PreparedStatement ps = Connections.get(t.getClass()).prepareCall("select * from " + t.getTableName()
                        + " where " + t.getKeyName()
                        + " = ?");
                DataPreparedStatements.put(t.getClass(), ps);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullKeyException ex) {
                Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!PreparedTimeStatementPreparedStatement.containsKey(cls)) {
            try {
                PreparedTimeStatementPreparedStatement.put(cls, Connections.get(cls).prepareStatement("select Time from " + t.getTableName() + "_Update where KeyValue = ?"));
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        PreparedStatement ps = DataPreparedStatements.get(t.getClass());
        PreparedStatement ps2 = DataPreparedStatements.get(cls);
        try {
            ps.setObject(1, t.getKey().get(t));
            ResultSet sr = ps.executeQuery();
            if (!sr.next()) {
                return Optional.empty();
            }
            for (Field f : t.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(Config.class)) {
                    Config c = f.getAnnotation(Config.class);
                    if (c.DataType().toUpperCase().contains("BLOB")) {
                        String s = c.Name().isEmpty() ? f.getName() : c.Name();
                        f.set(t, Bytes2Object(sr.getBytes(s), f.getType()));
                        continue;
                    }
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
            ps2.setObject(1, t.getKey().get(t));
            ResultSet sr2 = ps2.executeQuery();
            if (sr2.next()) {
                t.setLastLoad(sr2.getLong(1));
            }
        } catch (NullKeyException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.of(t);
    }

    @Deprecated
    public static <T extends DatabaseSerializable> Optional<T> Deserialize(Object key, T t) {
        if (!DataPreparedStatements.containsKey(t.getClass())) {
            try {
                PreparedStatement ps = Connections.get(t.getClass()).prepareCall("select * from " + t.getTableName()
                        + " where " + t.getKeyName()
                        + " = ?");
                DataPreparedStatements.put(t.getClass(), ps);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullKeyException ex) {
                Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!PreparedTimeStatementPreparedStatement.containsKey(t.getClass())) {
            try {
                PreparedTimeStatementPreparedStatement.put(t.getClass(), Connections.get(t.getClass()).prepareStatement("select Time from " + t.getTableName() + "_Update where KeyValue = ?"));
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        PreparedStatement ps = DataPreparedStatements.get(t.getClass());
        PreparedStatement ps2 = DataPreparedStatements.get(t.getClass());
        try {
            ps.setObject(1, t.getKey().get(t));
            ResultSet sr = ps.executeQuery();
            if (!sr.next()) {
                return Optional.empty();
            }
            for (Field f : t.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(Config.class)) {
                    Config c = f.getAnnotation(Config.class);
                    if (c.DataType().toUpperCase().contains("BLOB")) {
                        String s = c.Name().isEmpty() ? f.getName() : c.Name();
                        f.set(t, Bytes2Object(sr.getBytes(s), f.getType()));
                        continue;
                    }
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
            ps2.setObject(1, t.getKey().get(t));
            ResultSet sr2 = ps2.executeQuery();
            if (sr2.next()) {
                t.setLastLoad(sr2.getLong(1));
            }
        } catch (NullKeyException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
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

    public static byte[] Object2Bytes(Object obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        return baos.toByteArray();
    }
    // 将字节数组转换成为对象

    public static <T> T Bytes2Object(byte[] b, Class<? extends T> cls) throws IOException,
            ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object obj = ois.readObject();
        return cls.cast(obj);
    }
//
//    enum TA {
//        A;
//    }
//
//    @Database(UpdateCheck = true)
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
//        @Config(Key = true, DataType = "varchar(255)", NotNull = true)
//        private String Name;
//        @Config(DataType = "int", NotNull = true)
//        private int ID;
//        @Config(DataType = "LONGBLOB")
//        public List<String> test = new ArrayList<>();
//
//        @Config(DataType = "LONGBLOB")
//        public Map<TA, Integer> test2 = new HashMap<>();
//
//        @Override
//        public String toString() {
//            return "Test{" + "Name=" + Name + ", ID=" + ID + ", test=" + test + ", test2=" + test2 + ", l=" + l + '}';
//        }
//
//
//        private long l = 0;
//
//        @Override
//        public long getLastLoad() {
//            return l;
//        }
//
//        @Override
//        public void setLastLoad(long l) {
//            this.l = l;
//        }
//
//    }
//
//    public static void main(String args[]) {
//        try {
//            DatabaseSerializable.Register(Test.class, "jdbc:mysql://127.0.0.1:3306/Password?user=root&password=123456&useUnicode=true&characterEncoding=utf8&autoReconnect=true&autoDeserialize=true");
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
//        try {
//            List<Test> result = DatabaseSerializable.DeserializeAll(Test.class);
//            for (Test t : result) {
//                System.out.println(t.toString());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(DatabaseSerializable.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
}
