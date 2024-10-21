package com.example.currencyconverter;

public class CurrencyItem {
    private String countryName;
    private String currencyCode;
    private double conversionRate;
    private int flagImageResId;

    public CurrencyItem(String countryName, String currencyCode, double conversionRate, int flagImageResId) {
        this.countryName = countryName;
        this.currencyCode = currencyCode;
        this.conversionRate = conversionRate;
        this.flagImageResId = flagImageResId;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public int getFlagImageResId() {
        return flagImageResId;
    }
}
