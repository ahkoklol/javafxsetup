package com.example.javafxtest;

import com.example.javafxtest.User.Login.LoginFacade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        SceneManager sceneManager = new SceneManager(stage);

        // Load all scenes
        sceneManager.loadScene("Login", "/com/example/javafxtest/LoginScene.fxml", 600, 400);
        sceneManager.loadScene("Home", "/com/example/javafxtest/HomeScene.fxml", 600, 400);
        sceneManager.loadScene("Register", "/com/example/javafxtest/RegisterScene.fxml", 600, 400);

        // Inject SceneManager into HomeController
        HomeController homeController = (HomeController) sceneManager.getController("Home");
        homeController.setSceneManager(sceneManager);

        // Show the initial scene
        sceneManager.showScene("Home");

        // Set stage title and show it
        stage.setTitle("Pick & Pic");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
