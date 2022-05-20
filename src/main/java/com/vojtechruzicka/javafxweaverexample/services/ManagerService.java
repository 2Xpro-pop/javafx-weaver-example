package com.vojtechruzicka.javafxweaverexample.services;

import com.vojtechruzicka.javafxweaverexample.models.*;

import java.util.concurrent.CompletableFuture;

public interface ManagerService {
    CompletableFuture<Task[]> getTasks();
    CompletableFuture<User[]> getEmploys();
    CoverageArea[] getAreas();
}
