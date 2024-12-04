package com.example.javafxtest.User.Login;

public class User {
    private String email;
    private String password;
    private String username;

    // Constructor
    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserame() {
        return this.username;
    }
}
