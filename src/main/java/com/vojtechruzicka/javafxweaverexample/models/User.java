package com.vojtechruzicka.javafxweaverexample.models;

public class User {
    int id;
    UserRole role;
    String login;
    int salary;

    public User(int id, String role, String login, int salary) {
        this.id = id;
        this.role = UserRole.valueOf(role);
        this.login = login;
        this.salary = salary;
    }

    public UserRole getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public int getSalary() {
        return salary;
    }


}
