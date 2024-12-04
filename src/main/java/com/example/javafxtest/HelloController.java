package com.example.javafxtest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {

    @FXML
    private TitledPane titledPane1;

    @FXML
    private Label testValLabel;

    private Connection databaseConnection;

    // Setter method for the database connection
    public void setDatabaseConnection(Connection connection) {
        this.databaseConnection = connection;
        loadDatabaseValue();
    }

    // Load data from the database into the label
    private void loadDatabaseValue() {
        if (databaseConnection == null) {
            testValLabel.setText("Database not connected!");
            return;
        }

        try (Statement statement = databaseConnection.createStatement()) {
            // Query to fetch testval
            ResultSet resultSet = statement.executeQuery("SELECT testval FROM pgtest LIMIT 1");
            if (resultSet.next()) {
                String testval = resultSet.getString("testval");
                testValLabel.setText(testval); // Set the value in the label
            } else {
                testValLabel.setText("No data found!");
            }
        } catch (Exception e) {
            testValLabel.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        // This method can be used for additional interactions if required
    }
}
