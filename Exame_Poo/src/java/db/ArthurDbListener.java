/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package db;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;

/**
 * Web application lifecycle listener.
 *
 * @author arthu
 */
public class ArthurDbListener implements ServletContextListener {
    public static final String CLASS_NAME = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:exame.db";
    
    public static Exception exception = null;
    
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL);
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName(CLASS_NAME);
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("create table if not exists ArthurAndrade_users ("
                    + "username text NOT NULL UNIQUE,"
                    + "password text NOT NULL,"
                    + "name text NOT NULL)");
            stmt.execute("create table if not exists ArthurAndrade_users ("
                    + "datetime string NOT NULL,"
                    + "username text NOT NULL,"
                    + "log text NOT NULL)");
            stmt.execute("insert into ArthurAndrade_users values ('adm','123', 'arthur')");
            stmt.execute("insert into ArthurAndrade_users values ('admin','1234', 'arthur2')");
            stmt.close();
            con.close();
        }
        catch(Exception ex) {
            exception = ex;
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
