package com.example.arkitektuppgit;

import java.time.LocalDate;

public interface BestallningManager {
    void addBestallning(String tartaType, String kundName, LocalDate betsallningsDate, int antalBellning);
    String showAllBestallnings();
    String searchBestallningById(int id);
    String searchBestallningById(String bookingIdStr);
    String searchBestallningByName(String name);
}
