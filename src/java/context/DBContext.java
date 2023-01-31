/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HONG QUAN
 */
public class DBContext {

    ResourceBundle bundle = ResourceBundle.getBundle("resource.database");

    public Connection getConnection() {
        try {
            String url = bundle.getString("url");
            String username = bundle.getString("username");
            String password = bundle.getString("password");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        DBContext db = new DBContext();
        System.out.println(db.getConnection());
        System.out.println(db.getConnection().getCatalog());
    }
}
