package com.vojtechruzicka.javafxweaverexample.models;

public class Task {
    int id;
    String name;
    int userId;

    public Task(int id, String name, int userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }
}
