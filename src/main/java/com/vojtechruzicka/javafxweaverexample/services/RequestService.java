package com.vojtechruzicka.javafxweaverexample.services;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;


public interface RequestService {
    /*
    * return empty string if bad request
    * */
    CompletableFuture<HttpResponse<String>> sendRequest(String url);
    CompletableFuture<HttpResponse<String>> sendRequestPut(String url);
    CompletableFuture<HttpResponse<String>>  login(String login, String password);
}
