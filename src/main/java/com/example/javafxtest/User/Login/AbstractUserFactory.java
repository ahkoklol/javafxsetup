package com.example.javafxtest.User.Login;
import java.sql.Connection;

public abstract class AbstractUserFactory {
    public abstract UserDAO createUserDAO();
}
