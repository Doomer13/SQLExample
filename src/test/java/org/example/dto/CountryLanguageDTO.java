package org.example.dto;

public class CountryLanguageDTO {

    String countryCode;
    String language;
    String isOfficial;
    int percentage;

    public CountryLanguageDTO(String countryCode, String language, String isOfficial, int percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Country Language{" +
                "CountryCode='" + countryCode + '\'' +
                ", Language='" + language + '\'' +
                ", IsOfficial=" + isOfficial +
                ", Percentage=" + percentage +
                '}';
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public int getPercentage() {
        return percentage;
    }
}
