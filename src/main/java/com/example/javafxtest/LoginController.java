package com.example.javafxtest;

import com.example.javafxtest.User.Login.LoginFacade;
import com.example.javafxtest.User.Login.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.sql.Connection;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    private LoginFacade loginFacade;

    public void setLoginFacade(LoginFacade loginFacade) {
        this.loginFacade = loginFacade;
    }

    @FXML
    protected void onLoginButtonClick() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty()) {
            showAlert("Login Error", "Email cannot be empty!");
            return;
        }

        if(password.isEmpty()) {
            showAlert("Login Error", "Password cannot be empty!");
            return;
        }

        // Perform login via UserFacade
        User user = loginFacade.login(email, password);
        if (user != null) {
            showAlert("Login Successful", "Welcome back " + user.getUserame() + "!");
        } else {
            showAlert("Login Failed", "Invalid email or password.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
