package com.example.arkitektuppgit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VD implements BestallningManager {
    private List<Bestallning> bestallnings;
    private int nextBestallningId;
    private LocalDate bestallningsDatum;

    public VD () {
        bestallnings = new ArrayList<>();
        setNextBestallningId(1);

    }

    public VD(List<Bestallning> bestallnings, int nextBestallningId, LocalDate bestallningsDatum) {
        super();
        this.bestallnings = bestallnings;
        this.nextBestallningId = nextBestallningId;
        this.bestallningsDatum = bestallningsDatum;
    }

    public void addBestallning(String tartaType, String kundName, LocalDate betsallningsDatum, int antalBestallning) {
        Tarta tarta = createTarta(tartaType);
        Customer kund = new Customer("",0);
        Bestallning bestallning = new Bestallning ();
        nextBestallningId++;


    }
    private Tarta createTarta(String tartaType) {
        switch (tartaType) {
            case "Prinsesstårta":
                return new Prinsesstarta("Prinsesstårta", 1200, "", 0);
            case "Operatårta":
                return new Operatarta("Operatårta", 1200, "", 0);
            case "Chokladtårta":
                return new Chokladtarta("Chokladtårta", 2000, "", 0);
            default:
                throw new IllegalArgumentException("Ogiltig rumstyp: " + tartaType);
        }
    }



    @Override
    public String showAllBestallnings() {
        StringBuilder result = new StringBuilder();
        for (Bestallning bestallning : bestallnings) {
            result.append(bestallning).append("\n");
        }
        return result.toString();
    }


    @Override
    public String searchBestallningById(int id) {
        for (Bestallning bestallning : bestallnings) {
            if (bestallning.getOrderNummer() == 1) {
                return bestallning.toString();
            }
        }
        return "";
    }
    @Override
    public String searchBestallningById(String bookingIdStr) {
        for (Bestallning bestallning : bestallnings) {
            if (String.valueOf(bestallning.getOrderNummer()).equals(nextBestallningId)) {
                return bestallning.toString();
            }
        }
        return "Ingen bokning hittades med detta ID.";
    }


    @Override
    public String searchBestallningByName(String name) {
        for (Bestallning bestallning : bestallnings) {
            if (bestallning.getKund().getName().equalsIgnoreCase(name)) {
                return bestallning.toString();
            }
        }
        return "";
    }

    public List<Bestallning> getBestallnings() {
        return bestallnings;
    }

    public void setBestallnings(List<Bestallning> bestallnings) {
        this.bestallnings = bestallnings;
    }

    public int getNextBestallningId() {
        return nextBestallningId;
    }

    public void setNextBestallningId(int nextBestallningId) {
        this.nextBestallningId = nextBestallningId;
    }

    public LocalDate getBestallningsDatum() {
        return bestallningsDatum;
    }

    public void setBestallningsDatum(LocalDate bestallningsDatum) {
        this.bestallningsDatum = bestallningsDatum;
    }

    @Override
    public String toString() {
        return "VD{" +
                "bestallnings=" + bestallnings +
                ", nextBestallningId=" + nextBestallningId +
                ", bestallningsDatum=" + bestallningsDatum ;
    }
}

