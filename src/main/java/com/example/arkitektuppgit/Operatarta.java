package com.example.arkitektuppgit;


public class Operatarta extends Tarta {
    String name;
    int id;

    public Operatarta(String tartaType, double pricePerOrder, String name, int id) {
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
        return "Operatårta{" +
                "name='" + name + '\'' +
                " ";
    }
}
