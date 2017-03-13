/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bryan_lzh
 */
public class SQLConnection {

    SQLConnection(String name) throws SQLException {
        Connection con = DriverManager.getConnection(SQLManager.getURL(name));
        Statement sta = con.createStatement();
        this.Sta = sta;
    }

    private Statement Sta;
    
    public Statement getStatement(){
        return this.Sta;
    }
}
