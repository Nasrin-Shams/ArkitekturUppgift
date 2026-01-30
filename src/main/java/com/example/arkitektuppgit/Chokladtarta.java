package com.example.arkitektuppgit;


public class Chokladtarta extends Tarta {
    String name;
    int id;

    public Chokladtarta(String tartaType, double pricePerOrder, String name, int id) {
        super(tartaType, pricePerOrder);
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;

    }
    public int getId() {
        return id;

    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Chokladtarta{" +
                "name='" + name + '\'' +
                " " ;
    }
}
