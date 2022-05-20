package com.vojtechruzicka.javafxweaverexample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class JavaFxApplication extends Application {

    private ConfigurableApplicationContext applicationContext;
    private static Scene scene;
    private static FxWeaver fxWeaver;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
                .sources(RealEstateClient.class)
                .run(args);
    }

    @Override
    public void start(Stage stage) {
        fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(LoginController.class);
        scene = new Scene(root);
        scene.getStylesheets().addAll(
                RealEstateClient.class.getResource("dark.css").toExternalForm()
        );
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }

    static void setRoot(Class<?> c) throws IOException {
        scene.setRoot(
                fxWeaver.loadView(c)
        );
    }


}
