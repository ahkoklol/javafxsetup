package com.example.javafxtest;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class HomeController {

    @FXML
    private Text homeText;

    @FXML
    private Button ToLoginPageButton;

    private SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    public void initialize() {
        // Initialization logic if needed
        homeText.setText("Welcome to Home!");
        ToLoginPageButton.setOnAction(event -> {
            if (sceneManager != null) {
                sceneManager.showScene("Login");
            }
        });
    }

    @FXML
    protected void onGoToLoginButtonClick() {
        ToLoginPageButton.setOnAction(event -> {
            if (sceneManager != null) {
                sceneManager.showScene("Login");
            }
        });
    }
}
