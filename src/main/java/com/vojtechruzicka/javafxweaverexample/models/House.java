package com.vojtechruzicka.javafxweaverexample.models;

public class House {
    int id;
    String name;
    String address;
    int price;

    public House(int id, String name, String address, int price) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPrice() {
        return price;
    }
}
