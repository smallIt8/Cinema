package org.example.model;

import static org.example.util.constant.ColorsConstant.*;

public class Film {
    private Long id;
    private String filmName;
    private String year;
    private String country;
    private String description;

    public Film() {
    }

    public Film(String filmName, String year, String country, String description) {
        this.filmName = filmName;
        this.year = year;
        this.country = country;
        this.description = description;
    }

    public Film(Long id, String filmName, String year, String country, String description) {
        this.id = id;
        this.filmName = filmName;
        this.year = year;
        this.country = country;
        this.description = description;
    }

    @Override
    public String toString() {
        return  "Название фильма: " + INDIGO +  filmName + RESET + "\n" +
                "Год выпуска: " + INDIGO +  year + RESET + "\n" +
                "Страна: " + INDIGO +  country + RESET + "\n" +
                "Краткое описание: " + "\n" +
                INDIGO +  description + RESET + "\n"
                ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
