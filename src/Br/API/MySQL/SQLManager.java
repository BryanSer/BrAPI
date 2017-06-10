/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.MySQL;

import Br.API.PluginData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;

/**
 *
 * @author Bryan_lzh
 */
public class SQLManager {

    public static void main(String args[]) {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:mysql://localhost:3306/user=root&password=''&useUnicode=true&characterEncoding=gb2312";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            Scanner in = new Scanner(System.in);

            Statement ss = conn.createStatement();
                System.out.println("input sql");
            while (true) {
                String s = in.nextLine();
                if (s.equalsIgnoreCase("exit")) {
                    break;
                }
                if (s.startsWith("sqlb:")) {
                    String sql = s.substring(s.indexOf(":")+1);
                    System.out.println("SQL: "+sql);
                    boolean b = false;
                    try {
                       b = ss.execute(sql);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(b);
                }
                if (s.startsWith("sqls:")) {
                    String sql = s.substring(s.indexOf(":")+1);
                    ResultSet r = ss.executeQuery(sql);
                    System.out.println(r.toString());
                }
                System.out.println("input sql");
            }
            ss.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private SQLManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static SQLManager SQL = null;

    public static SQLManager getSQLManager() {
        if (SQL == null) {
            SQL = new SQLManager();
        }
        return SQL;
    }

    /**
     * <变量名,变量类型>
     * 变量类型: http://www.w3school.com.cn/sql/sql_datatypes.asp
     *
     * @param tablename
     * @param map
     * @return
     */
    public static String SQL_CreateTable(String tablename, Map<String, String> map) {
        String s = "CREATE TABLE " + tablename + "(";
        for (Map.Entry<String, String> e : map.entrySet()) {
            s += e.getKey() + " " + e.getValue() + ",";
        }
        s = s.substring(0, s.length() - 1);
        s += ")";
        return s;
    }

    public static String getURL(String database) {
        if (!PluginData.plugin.getDataFolder().exists()) {
            PluginData.plugin.saveDefaultConfig();
        }
        FileConfiguration config = PluginData.plugin.getConfig();
        String s = "jdbc:mysql://" + config.getString("MYSQL.Host.URL")
                + ":" + config.getString("MYSQL.Host.Port") + "/"
                + database + "user=" + config.getString("MYSQL.User.UserName");
        if (config.contains("MYSQL.User.Password")) {
            s += "&password=" + config.getString("MYSQL.User.Password");
        }
        s += "&useUnicode=true&characterEncoding=UTF8";
        return s;
    }
}
