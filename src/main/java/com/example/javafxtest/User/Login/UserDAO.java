package com.example.javafxtest.User.Login;

import java.sql.Connection;
import com.example.javafxtest.JDBCconnector;

public abstract class UserDAO {
    protected Connection connection;

    public UserDAO() {
        // Use JDBCconnector to initialize the connection
        try {
            // Handle the exception locally
            this.connection = JDBCconnector.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to establish database connection", e);
        }
    }

    public abstract User login(String email, String password);
}