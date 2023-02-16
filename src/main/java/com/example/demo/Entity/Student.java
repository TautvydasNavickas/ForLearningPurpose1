package com.example.demo.Entity;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private LinkedHashMap<String ,String> optionsOfCountry;
    private String favoriteLanguage;
    private String[] operatingSystem;
    public Student() {
        optionsOfCountry = new LinkedHashMap<>();
        optionsOfCountry.put("LT","Lithuania");
        optionsOfCountry.put("EN","England");
        optionsOfCountry.put("LV","Latvia");
        optionsOfCountry.put("PL","Polands");
        optionsOfCountry.put("US","United States");
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public String getCountry() {
        return country;
    }

    public LinkedHashMap<String, String> getOptionsOfCountry() {
        return optionsOfCountry;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String[] getOperatingSystem() {        return operatingSystem;
    }

    public void setOperatingSystem(String[] operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
