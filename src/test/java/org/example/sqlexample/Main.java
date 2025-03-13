package org.example.sqlexample;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "rootZiderman");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * FROM sakila.actor");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " +
                    resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " +
                    resultSet.getString(4) + " ");
        }
    }
}