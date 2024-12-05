package com.example.javafxtest;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class RegisterController {

    @FXML
    private Text registerText;

    @FXML
    public void initialize() {
        // Initialization logic if needed
        registerText.setText("Welcome to Registration!");
    }
}
