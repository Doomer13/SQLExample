package org.example.dto;

public class MyTableDTO {

    private String cityName;
    private String countryName;
    private String language;
    private String population;

    public MyTableDTO(String cityName, String countryName, String language, String population) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.language = language;
        this.population = population;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getLanguage() {
        return language;
    }

    public String getPopulation() {
        return population;
    }

    @Override
    public String toString() {

        return "Country Language{" +
                "city_name='" + cityName + '\'' +
                ", country_name='" + countryName + '\'' +
                ", language=" + language +
                ", population=" + population +
                '}';
    }
}
