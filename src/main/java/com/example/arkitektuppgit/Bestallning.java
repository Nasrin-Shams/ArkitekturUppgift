package com.example.arkitektuppgit;

import java.time.LocalDate;

public class Bestallning {
    private int orderNummer;
    private Customer kund;
    private Tarta tarta;
    private LocalDate bestallningsDatum;
    private int antalBestallning;
    private double totalPrice;

    public Bestallning() {
        super();
    }
    public Bestallning(int orderNummer, Customer kund, Tarta tarta, LocalDate bestallningsDatum, int antalBestallning,
                       double totalPrice) {
        super();
        this.orderNummer = orderNummer;
        this.kund = kund;
        this.tarta = tarta;
        this.bestallningsDatum = bestallningsDatum;
        this.antalBestallning = antalBestallning;
        this.totalPrice = totalPrice;
    }

    public int getOrderNummer() {
        return orderNummer;
    }

    public void setOrderNummer(int orderNummer) {
        this.orderNummer = orderNummer;
    }

    public Customer getKund() {
        return kund;
    }

    public void setKund(Customer kund) {
        this.kund = kund;
    }

    public Tarta getTarta() {
        return tarta;
    }

    public void setTarta(Tarta tarta) {
        this.tarta = tarta;
    }

    public LocalDate getBestallningsDatum() {
        return bestallningsDatum;
    }

    public void setBestallningsDatum(LocalDate bestallningsDatum) {
        this.bestallningsDatum = bestallningsDatum;
    }

    public int getAntalBestallning() {
        return antalBestallning;
    }

    public void setAntalBestallning(int antalBestallning) {
        this.antalBestallning = antalBestallning;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Beställning ID: " + orderNummer +
                ", Kund: " + kund + // Kallar på Customer.toString()
                ", Tårta: " + tarta + // Kallar på Tarta.toString()
                ", Datum: " + bestallningsDatum +
                ", Antal: " + antalBestallning +
                ", Totalt Pris: " + totalPrice + " SEK";
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    }


