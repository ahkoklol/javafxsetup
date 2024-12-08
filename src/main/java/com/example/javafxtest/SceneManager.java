package com.example.javafxtest;

import com.example.javafxtest.User.Login.LoginFacade;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.SQLException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private final Stage stage;
    private final Map<String, Scene> scenes = new HashMap<>();
    private final Map<String, FXMLLoader> loaders = new HashMap<>();
    private final Connection connection;

    public SceneManager(Stage stage) {
        this.stage = stage;
        try {
            this.connection = JDBCconnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to establish database connection", e);
        }
    }

    public void loadScene(String name, String fxmlPath, double width, double height) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Scene scene = new Scene(loader.load(), width, height);
        scenes.put(name, scene);
        loaders.put(name, loader);

        // Pass connection to controllers that require it
        Object controller = loader.getController();

        // login
        if (controller instanceof LoginController) {
            LoginController loginController = (LoginController) controller;
            loginController.setLoginFacade(new LoginFacade(connection)); // Connection handled in UserDAO
        }

        if (controller instanceof RegisterController) {
            RegisterController registerController = (RegisterController) controller;
        }
    }

    public void showScene(String name) {
        Scene scene = scenes.get(name);
        if (scene != null) {
            stage.setScene(scene);
        } else {
            System.err.println("Scene " + name + " not found.");
        }
    }

    public Object getController(String name) {
        FXMLLoader loader = loaders.get(name);
        if (loader != null) {
            return loader.getController();
        } else {
            throw new IllegalStateException("Controller for scene " + name + " not found.");
        }
    }
}
