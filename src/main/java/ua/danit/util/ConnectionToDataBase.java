package ua.danit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDataBase {
    private static final String DB_URL = "jdbc:mysql://danit.cukm9c6zpjo8.us-west-2.rds.amazonaws.com:3306/fs5";
    private static final String USERNAME = "fs5_user";
    private static final String USER_PASS = "bArceloNa";

    public static Connection getConnection() {
        Connection conection = null;

        try {
            conection = DriverManager.getConnection(DB_URL, USERNAME, USER_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conection;
    }
}
