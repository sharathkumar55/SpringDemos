package com.springDemoMVC;

import java.util.HashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private HashMap<String,String> countryOptions;
    private String favoriteLanguage;
    private String[] operatingSystems;
    public Student()
    {
        countryOptions = new HashMap<>();
        countryOptions.put("BR","Brazil");
        countryOptions.put("IN","India");
        countryOptions.put("FR","France");
        countryOptions.put("US","America");

    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public HashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
