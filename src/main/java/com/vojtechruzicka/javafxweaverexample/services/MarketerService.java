package com.vojtechruzicka.javafxweaverexample.services;

import com.google.javascript.jscomp.jarjar.com.google.gson.JsonObject;
import com.google.javascript.jscomp.jarjar.com.google.gson.JsonParser;
import com.vojtechruzicka.javafxweaverexample.RealEstateClient;
import com.vojtechruzicka.javafxweaverexample.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class MarketerService {
    private static  MarketingPlace[] places;
    private RequestService requestService;
    public  MarketerService(RequestService requestService)
    {
        this.requestService = requestService;
    }

    public CompletableFuture<MarketingPlace[]> getMarketingPlace()
    {
        var request = requestService.sendRequest("Marketer/marketing_place");
        request.thenAccept( response ->{
            System.out.println(response.body());
            JsonObject parser;
            try {
                parser = new JsonParser().parse(response.body()).getAsJsonObject();
                places = RealEstateClient.gson.fromJson(response.body(), MarketingPlace[].class);
                System.out.println("URA");
            }
            catch (Exception e)
            {
                System.out.println("bad update");
                return;
            }


        }).join();
        return request.thenApply( response -> {
            return places;
        });
    }

    public void updateBudget(String name, String budget)
    {
        requestService.sendRequestPut(String.format("Marketer/marketing_place/%s/%s", name, budget)).join();
    }
}
