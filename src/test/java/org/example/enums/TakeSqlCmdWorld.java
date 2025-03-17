package org.example.enums;

public enum TakeSqlCmdWorld {
    SELECT_CITY_TABLE("SELECT * FROM world.city"),
    SELECT_COUNTRY_LANGUAGE_TABLE("SELECT * FROM world.countrylanguage"),
    SELECT_MY_TABLE(
            "SELECT " +
                    "   city.name AS city_name, " +
                    "   country.name AS country_name, " +
                    "   countrylanguage.language, " +
                    "   country.population " +
                    "FROM city " +
                    "JOIN country ON city.countryCode = country.Code " +
                    "JOIN countrylanguage ON country.Code = countrylanguage.countryCode"
    ),
    USE_LIKE_METHOD("SELECT * FROM world.countrylanguage WHERE Language LIKE '%an'"),

    UNION_TABLE("SELECT * FROM world.countrylanguage WHERE CountryCode = 'ABW' " +
            "UNION SELECT * FROM world.countrylanguage WHERE CountryCode = 'LUX' " +
            "UNION SELECT * FROM world.countrylanguage WHERE CountryCode = 'IDN' " +
            "UNION SELECT * FROM world.countrylanguage WHERE CountryCode = 'JAM' " +
            "UNION SELECT * FROM world.countrylanguage WHERE CountryCode = 'IRN'");

    private final String sql;

    TakeSqlCmdWorld(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}