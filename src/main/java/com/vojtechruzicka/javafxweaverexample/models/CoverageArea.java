package com.vojtechruzicka.javafxweaverexample.models;

public class CoverageArea {
    int id;
    String name;
    float percent;

    public CoverageArea(int id, String name, int percent)
    {
        this.id = id;
        this.name = name;
        this.percent = percent;
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public float getPercent() {
        return percent;
    }


}
