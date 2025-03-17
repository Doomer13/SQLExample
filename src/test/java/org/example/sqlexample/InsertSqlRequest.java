package org.example.sqlexample;

public enum InsertSqlRequest {

    INSERT_SQL_REQUEST_SMALL_TABLE("insert into world.smalllanguagetable (CountryCode, Language, IsOfficial, Percentage) values (?, ?, ?, ?);");

    private final String sql;

    InsertSqlRequest(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
