package org.example.dao;

import org.example.dto.MyTableDTO;
import org.example.sqlexample.DatabaseUtil;
import org.example.enums.TakeSqlCmdWorld;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GreatArrayListMyTable {

    private final TakeSqlCmdWorld sql;
    List<MyTableDTO> myTableList = new ArrayList<>();
    DatabaseUtil data = new DatabaseUtil();

    public GreatArrayListMyTable(TakeSqlCmdWorld sql) {
        this.sql = sql;
    }

    public List<MyTableDTO> GreatingMyTableList() {
        try (Connection connection = data.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql.getSql())) {

            while (resultSet.next()) {
                myTableList.add(new MyTableDTO(
                        resultSet.getString("city_name"),
                        resultSet.getString("country_name"),
                        resultSet.getString("language"),
                        resultSet.getString("population")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return myTableList;
    }

}
