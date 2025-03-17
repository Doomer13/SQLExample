package org.example.sqlexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    String url = "jdbc:mysql://localhost:3306/world";
    String username = "root";
    String password = "rootZiderman";

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, username, password);
    }

}
