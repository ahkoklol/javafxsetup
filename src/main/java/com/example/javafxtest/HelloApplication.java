package com.example.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load FXML
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Get controller and set the database connection
        HelloController controller = fxmlLoader.getController();
        try {
            Connection connection = JDBCconnector.getConnection();
            controller.setDatabaseConnection(connection);
        } catch (Exception e) {
            System.err.println("Failed to connect to database: " + e.getMessage());
        }

        // Configure and show the stage
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
