package org.example.sqlexample;

import org.example.dao.GreatArrayList;
import org.example.dto.CountryLanguageDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertForSmallLanguageTable {

    DatabaseUtil dbUtil = new DatabaseUtil();

    public  void insertingMethod(GreatArrayList arrayList) throws SQLException {

        try (Connection connection = dbUtil.getConnection()) {
            try (PreparedStatement statement =
                         connection.prepareStatement(InsertSqlRequest.INSERT_SQL_REQUEST_SMALL_TABLE.getSql())) {

                for (CountryLanguageDTO dto : arrayList.GreatingCountryLanguageList()) {
                    statement.setString(1, dto.getCountryCode());
                    statement.setString(2, dto.getLanguage());
                    statement.setString(3, dto.getIsOfficial());
                    statement.setDouble(4, dto.getPercentage());

                    statement.executeUpdate();
                }
            }
        }
    }
}
