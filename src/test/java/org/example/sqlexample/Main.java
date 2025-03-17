package org.example.sqlexample;

import org.example.dao.GreatArrayList;
import org.example.dto.CountryLanguageDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;


public class Main {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/world";
    private static final String USER = "root";
    private static final String PASS = "rootZiderman";

    DatabaseUtil dbUtil = new DatabaseUtil();
    InsertForSmallLanguageTable ins = new InsertForSmallLanguageTable();

    GreatArrayList arrayListUnionTable = new GreatArrayList(TakeSqlCmdWorld.UNION_TABLE);
    GreatArrayList arrayListLikeTable = new GreatArrayList(TakeSqlCmdWorld.USE_LIKE_METHOD);


    @Test
    public void opt() throws SQLException {
        ins.insertingMethod(arrayListLikeTable);

    }


    @Test
    @DisplayName("Берем часть данных из таблицы countrylanguage, создаем из них массив," +
            " потом делаем инсер их в тестовую таблицу в SQL")
    public void insertMethodUnion() throws SQLException {

        try (Connection connection = dbUtil.getConnection()) {
            try (PreparedStatement statement =
                         connection.prepareStatement(InsertSqlRequest.INSERT_SQL_REQUEST_SMALL_TABLE.getSql())) {

                for (CountryLanguageDTO dto : arrayListUnionTable.GreatingCountryLanguageList()) {
                    statement.setString(1, dto.getCountryCode());
                    statement.setString(2, dto.getLanguage());
                    statement.setString(3, dto.getIsOfficial());
                    statement.setDouble(4, dto.getPercentage());

                    statement.executeUpdate();
                }
            }
        }
    }

    @Test
    @DisplayName("Берем часть данных из таблицы countrylanguage, создаем из них массив," +
            " потом делаем инсер их в тестовую таблицу в SQL")
    public void insertMethodLK() throws SQLException {

        arrayListLikeTable.GreatingCountryLanguageList();

        try (Connection connection = dbUtil.getConnection()) {
            try (PreparedStatement statement =
                         connection.prepareStatement(InsertSqlRequest.INSERT_SQL_REQUEST_SMALL_TABLE.getSql())) {

                for (CountryLanguageDTO dto : arrayListLikeTable.GreatingCountryLanguageList()) {
                    statement.setString(1, dto.getCountryCode());
                    statement.setString(2, dto.getLanguage());
                    statement.setString(3, dto.getIsOfficial());
                    statement.setDouble(4, dto.getPercentage());

                    statement.executeUpdate();
                }
            }
        }
    }


    @Test
    public void printUnionTable() throws SQLException {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(TakeSqlCmdWorld.UNION_TABLE.getSql())) {
                    // Получаем метаданные
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    // Выводим названия столбцов
                    int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-20s", metaData.getColumnName(i) + "\t");
                    }
                    System.out.println(); // Переход на новую строку
                    // Выводим данные
                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.printf("%-20s", resultSet.getString(i) + "\t");
                        }
                        System.out.println(); // Переход на новую строку
                    }
                }
            }
        }
    }

    @Test
    public void printCityTable() throws SQLException {
        // Establish connection
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Create statement
            try (Statement statement = connection.createStatement()) {
                // Execute query
                try (ResultSet resultSet = statement.executeQuery(TakeSqlCmdWorld.SELECT_CITY_TABLE.getSql())) {
                    // Print results
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString(1) + " " +
                                resultSet.getString(2) + " " +
                                resultSet.getString(3) + " " +
                                resultSet.getString(4));
                    }
                }
            }
        }
    }

    @Test
    public void printCountryTable() throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(TakeSqlCmdWorld.SELECT_COUNTRY_LANGUAGE_TABLE.getSql())) {
                    // Получаем метаданные
                    ResultSetMetaData metaData = resultSet.getMetaData();

                    // Выводим названия столбцов
                    int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-20s", metaData.getColumnName(i) + "\t");
                    }
                    System.out.println(); // Переход на новую строку

                    // Выводим данные
                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.printf("%-20s", resultSet.getString(i) + "\t");
                        }
                        System.out.println(); // Переход на новую строку
                    }
                }
            }
        }
    }

    @Test
    public void printMyTable() throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(TakeSqlCmdWorld.SELECT_MY_TABLE.getSql())) {
                    // Получаем метаданные
                    ResultSetMetaData metaData = resultSet.getMetaData();

                    // Выводим названия столбцов
                    int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-20s", metaData.getColumnName(i) + "\t");
                    }
                    System.out.println(); // Переход на новую строку

                    // Выводим данные
                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.printf("%-20s", resultSet.getString(i) + "\t");
                        }
                        System.out.println(); // Переход на новую строку
                    }
                }
            }
        }
    }

    @Test
    public void printLikeMethodTable() throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(TakeSqlCmdWorld.USE_LIKE_METHOD.getSql())) {
                    // Получаем метаданные
                    ResultSetMetaData metaData = resultSet.getMetaData();

                    // Выводим названия столбцов
                    int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-20s", metaData.getColumnName(i) + "\t");
                    }
                    System.out.println(); // Переход на новую строку

                    // Выводим данные
                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.printf("%-20s", resultSet.getString(i) + "\t");
                        }
                        System.out.println(); // Переход на новую строку
                    }
                }
            }
        }
    }
}
