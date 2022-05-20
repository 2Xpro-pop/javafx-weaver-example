package com.vojtechruzicka.javafxweaverexample.services;

import com.vojtechruzicka.javafxweaverexample.models.User;

import java.util.concurrent.CompletableFuture;

public interface UserService {
    CompletableFuture<User>  getUser();
}
