package com.example.demo.Entity;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private LinkedHashMap<String ,String> optionsOfCountry;
    public Student() {
        optionsOfCountry = new LinkedHashMap<>();
        optionsOfCountry.put("LT","Lithuania");
        optionsOfCountry.put("EN","England");
        optionsOfCountry.put("LV","Latvia");
        optionsOfCountry.put("PL","Polands");
        optionsOfCountry.put("US","United States");
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
}
