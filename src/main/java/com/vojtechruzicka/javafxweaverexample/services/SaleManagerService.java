package com.vojtechruzicka.javafxweaverexample.services;

import com.vojtechruzicka.javafxweaverexample.models.*;

import java.util.concurrent.CompletableFuture;

public interface SaleManagerService {
    CompletableFuture<House> getMax();
    CompletableFuture<House> getMin();
    void soldHouse(House house);
    void buyHouse(House house);
}
