package com.vojtechruzicka.javafxweaverexample.services;

import com.google.javascript.jscomp.jarjar.com.google.gson.JsonObject;
import com.google.javascript.jscomp.jarjar.com.google.gson.JsonParser;
import com.vojtechruzicka.javafxweaverexample.RealEstateClient;
import com.vojtechruzicka.javafxweaverexample.models.User;
import com.vojtechruzicka.javafxweaverexample.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class JwtUserService implements UserService {
    private static User user = null;
    private RequestService requestService;
    @Autowired
    public JwtUserService(RequestService requestService)
    {
        this.requestService = requestService;
    }
    @Override
    public CompletableFuture<User> getUser() {
        var request = requestService.sendRequest("user");
        request.thenAccept( response ->{
            System.out.println(response.body());
            JsonObject parser;
            try {
                parser = new JsonParser().parse(response.body()).getAsJsonObject();
            }
            catch (Exception e)
            {
                System.out.println("bad");
                return;
            }
            user = new User(
                    parser.get("id").getAsInt(),
                    parser.get("role").getAsString(),
                    parser.get("login").getAsString(),
                    parser.get("salary").getAsInt());
            System.out.println(user.getRole());

        }).join();
        return request.thenApply( response -> {
           return user;
        });
    }
}
