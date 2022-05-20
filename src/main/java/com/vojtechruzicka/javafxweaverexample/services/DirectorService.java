package com.vojtechruzicka.javafxweaverexample.services;

import com.vojtechruzicka.javafxweaverexample.models.*;

import java.util.concurrent.CompletableFuture;

public interface DirectorService {
    void changeSalary(int id, int salary);
    CompletableFuture<User[]> getEmploys();
}
