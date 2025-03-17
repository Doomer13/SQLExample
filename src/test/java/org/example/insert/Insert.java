package org.example.insert;

import org.example.dao.GreatArrayListMyTable;
import org.example.dao.GreatArrayListSmallTable;
import org.example.dto.CountryLanguageDTO;
import org.example.dto.MyTableDTO;
import org.example.sqlexample.DatabaseUtil;
import org.example.enums.InsertSqlRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

    DatabaseUtil dbUtil = new DatabaseUtil();

    public void insertingMethodSmallTable(GreatArrayListSmallTable arrayList) throws SQLException {

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

    public void insertingMyTable(GreatArrayListMyTable arrayList) throws SQLException {

        try (Connection connection = dbUtil.getConnection()) {
            try (PreparedStatement statement =
                         connection.prepareStatement(InsertSqlRequest.MY_TABLE_REQUEST.getSql())) {

                for (MyTableDTO dto : arrayList.GreatingMyTableList()) {
                    statement.setString(1, dto.getCityName());
                    statement.setString(2, dto.getCountryName());
                    statement.setString(3, dto.getLanguage());
                    statement.setString(4, dto.getPopulation());

                    statement.executeUpdate();
                }
            }
        }
    }


}
