package com.example.javafxtest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {

    @FXML
    private Label welcomeText;

    private Connection databaseConnection;

    // Setter method for the database connection
    public void setDatabaseConnection(Connection connection) {
        this.databaseConnection = connection;
    }

    @FXML
    protected void onHelloButtonClick() {
        if (databaseConnection == null) {
            welcomeText.setText("Database not connected!");
            return;
        }

        try (Statement statement = databaseConnection.createStatement()) {
            // Example query
            ResultSet resultSet = statement.executeQuery("SELECT message FROM greetings LIMIT 1");
            if (resultSet.next()) {
                String message = resultSet.getString("message");
                welcomeText.setText(message);
            } else {
                welcomeText.setText("No data found!");
            }
        } catch (Exception e) {
            welcomeText.setText("Error: " + e.getMessage());
        }
    }
}
