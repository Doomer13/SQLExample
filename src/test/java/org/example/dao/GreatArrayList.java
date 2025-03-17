package org.example.dao;

import org.example.dto.CountryLanguageDTO;
import org.example.sqlexample.DatabaseUtil;
import org.example.sqlexample.TakeSqlCmdWorld;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GreatArrayList {

    private final TakeSqlCmdWorld sql;

    List<CountryLanguageDTO> countryLanguageList = new ArrayList<>();

    DatabaseUtil data = new DatabaseUtil();

    // Конструктор принимает нужный enum
    public GreatArrayList(TakeSqlCmdWorld sql) {
        this.sql = sql;
    }

    public List<CountryLanguageDTO> GreatingCountryLanguageList() {
        try (Connection connection = data.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql.getSql())) {

            while (resultSet.next()) {
                countryLanguageList.add(new CountryLanguageDTO(
                        resultSet.getString("CountryCode"),
                        resultSet.getString("Language"),
                        resultSet.getString("IsOfficial"),
                        resultSet.getInt("Percentage")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return countryLanguageList;
    }
}
