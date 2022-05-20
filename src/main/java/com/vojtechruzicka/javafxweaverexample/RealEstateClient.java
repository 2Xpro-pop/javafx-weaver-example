package com.vojtechruzicka.javafxweaverexample;

import com.google.javascript.jscomp.jarjar.com.google.gson.Gson;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealEstateClient {
    public static final Gson gson = new Gson();
    public static void main(String[] args) {
        // This is how normal Spring Boot app would be launched
        //SpringApplication.run(JavafxWeaverExampleApplication.class, args);

        Application.launch(JavaFxApplication.class, args);
    }
}
