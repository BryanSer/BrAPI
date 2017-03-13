/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.MySQL;

import Br.API.PluginData;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;

/**
 *
 * @author Bryan_lzh
 */
public class SQLManager {

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
