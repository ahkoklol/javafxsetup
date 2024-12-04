package com.example.javafxtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCconnector {

    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load database configuration", e);
        }

        String url = "jdbc:postgresql://localhost:5432/postgres"; // will be hidden in config.properties in the future
        String user = "postgres"; // will be hidden in config.properties in the future
        String password = properties.getProperty("dbpassword"); // hidden in config.properties

        return DriverManager.getConnection(url, user, password);
    }
}

