package com.vojtechruzicka.javafxweaverexample.models;

public class MarketingPlace {
    int id;
    String name;
    int budget;

    public MarketingPlace(int id, String name, int budget) {
        this.id = id;
        this.name = name;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBudget() {
        return budget;
    }
}
