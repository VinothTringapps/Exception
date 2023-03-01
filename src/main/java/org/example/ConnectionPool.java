package org.example;


import java.sql.*;
import java.util.logging.*;

public class ConnectionPool {
    private static ConnectionPool t2 = null;
    Logger l = Logger.getLogger("ConnectionPool");
    String databaseName;
    String userName;
    String userPassword;
    Connection con;

    private ConnectionPool() {

    }


    public static ConnectionPool getInstance() {
        if (t2 == null) {
            t2 = new ConnectionPool();
        }
        return t2;
    }

    public void create(String name, String user, String password) {
        databaseName = name;
        userName = user;
        userPassword = password;
        try {
            con = DriverManager.getConnection(databaseName, userName, userPassword);
            l.info("Connected Successfully !");
        } catch (SQLException e) {
            l.info("Sql Connection Interrupted");
        }


    }

    public void closeConnection() {
        try {
            con.close();
            l.info("Connection Closed !");
        } catch (SQLException e) {
            l.info("Sql Close Interrupted");
        }

    }
}