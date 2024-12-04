package com.example.javafxtest.User.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// This class is where the query to login a user is made

public class UserPostgre extends UserDAO {

    public UserPostgre() {
        super(); // the connection is made in the parent class
    }

    @Override
    public User login(String email, String password) {
        String query = "SELECT * FROM \"User\" WHERE email_address = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                // Instantiate and return a User object
                return new User(
                        resultSet.getString("email_address"),
                        resultSet.getString("password"),
                        resultSet.getString("user_name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if login fails
    }
}
