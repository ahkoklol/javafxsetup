package com.example.javafxtest.User.Login;

public class PostgreUserFactory extends AbstractUserFactory {
    @Override
    public UserDAO createUserDAO() {
        return new UserPostgre();
    }
}