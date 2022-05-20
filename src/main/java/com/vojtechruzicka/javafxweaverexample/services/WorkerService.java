package com.vojtechruzicka.javafxweaverexample.services;

import com.vojtechruzicka.javafxweaverexample.models.*;

import java.util.concurrent.CompletableFuture;

public interface WorkerService {
    CompletableFuture<Task[]> getWorkerTasks(int id);
    void DoTask(Task task);
}
