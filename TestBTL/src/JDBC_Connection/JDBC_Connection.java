/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC_Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mac
 */
public class JDBC_Connection {
    public static Connection get_connConnection() throws ClassNotFoundException{
        final String url = "jdbc:mysql://localhost:3306/BTL";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            return DriverManager.getConnection(url,"root","root");
        } catch (SQLException ex) {
            Logger.getLogger(JDBC_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
