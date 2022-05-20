package com.vojtechruzicka.javafxweaverexample;

import com.vojtechruzicka.javafxweaverexample.controllers.SaleManagerController;
import com.vojtechruzicka.javafxweaverexample.services.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@FxmlView("views/Login.fxml")
public class LoginController {

    @FXML TextField login;
    @FXML TextField password;
    @FXML Button button;
    private RequestService requestService;
    private UserService userService;

    @Autowired
    public LoginController(RequestService requestService, UserService userService)
    {
        this.requestService = requestService;
        this.userService =userService;
    }

    public void login(ActionEvent actionEvent){
        var request = requestService.login(
                login.textProperty().get(),
                password.textProperty().get()
        );
        login.setDisable(false);
        password.setDisable(false);
        button.setDisable(false);
        request.thenAccept( response -> {

            if(response.statusCode()==200)
            {
                userService.getUser().thenAccept( user -> {
                    if(user != null)
                    {
                        try {
                            switch (user.getRole()) {
                                case SaleManager:
                                    JavaFxApplication.setRoot(SaleManagerController.class);
                                    break;
                                case Marketing:
                                    JavaFxApplication.setRoot(MarketingController.class);
                            }
                        }
                        catch (IOException e)
                        {

                        }
                    }
                }).join();
                return;
            }
            login.setDisable(true);
            password.setDisable(true);
            button.setDisable(true);
        }).join();
    }
}
