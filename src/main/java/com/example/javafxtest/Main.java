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
        // Load FXML
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // Get controller and set the database connection
        LoginController controller = fxmlLoader.getController();
        try {
            Connection connection = JDBCconnector.getConnection();
            LoginFacade loginFacade = new LoginFacade(connection);
            controller.setLoginFacade(loginFacade);
        } catch (Exception e) {
            System.err.println("Failed to connect to database: " + e.getMessage());
        }

        // Configure and show the stage
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
