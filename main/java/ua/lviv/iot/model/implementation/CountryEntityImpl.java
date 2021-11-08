package ua.lviv.iot.model.implementation;

import ua.lviv.iot.model.CountryEntity;

public class CountryEntityImpl implements CountryEntity {
    private int countryID;
    private String countryName;

    @Override
    public int getCountryID() {
        return countryID;
    }

    @Override
    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    @Override
    public String getCountryName() {
        return countryName;
    }

    @Override
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public CountryEntityImpl() { }

    public CountryEntityImpl(int countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return String.format("%3s %-12s", countryID, countryName);
    }
}
