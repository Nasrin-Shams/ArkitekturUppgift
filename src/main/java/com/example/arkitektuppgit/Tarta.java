package com.example.arkitektuppgit;

import java.time.LocalDate;

public class Tarta implements BestallningManager{
    private String tartaType;
    private double pricePerOrder;
    String name;
    int id;

    public Tarta() {
        super();

    }
    public Tarta(String tartaType, double pricePerOrder) {
        super();
        this.tartaType = tartaType;
        this.pricePerOrder = pricePerOrder;
    }

    public String getTartaType() {
        return tartaType;
    }

    public void setTartaType(String tartaType) {
        this.tartaType = tartaType;
    }

    public double getPricePerOrder() {
        return pricePerOrder;
    }

    public void setPricePerOrder(double pricePerOrder) {
        this.pricePerOrder = pricePerOrder;
    }

    @Override
    public void addBestallning(String tartaType, String kundName, LocalDate betsallningsDate, int antalBellning) {

    }

    @Override
    public String showAllBestallnings() {
        return "";
    }

    @Override
    public String searchBestallningById(int id) {
        return "";
    }

    @Override
    public String searchBestallningById(String bookingIdStr) {
        return "";
    }

    @Override
    public String searchBestallningByName(String name) {
        return "";
    }

    @Override
    public String toString() {
        return "Tarta{" +
                "tartaType='" + tartaType + '\'' +
                ", pricePerOrder=" + pricePerOrder ;
    }
}


