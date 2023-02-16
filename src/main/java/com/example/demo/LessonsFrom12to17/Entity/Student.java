package com.example.demo.LessonsFrom12to17.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.LinkedHashMap;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
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
