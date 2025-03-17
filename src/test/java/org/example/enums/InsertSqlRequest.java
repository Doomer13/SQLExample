package org.example.enums;

public enum InsertSqlRequest {

    INSERT_SQL_REQUEST_SMALL_TABLE("insert into world.smalllanguagetable (CountryCode, Language, IsOfficial, Percentage) values (?, ?, ?, ?);"),
    MY_TABLE_REQUEST("insert into world.mytable (city_name, country_name, language, population) values (?, ?, ?, ?);");

    private final String sql;

    InsertSqlRequest(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
