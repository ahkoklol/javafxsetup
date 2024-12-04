package com.example.javafxtest.User.Login;
import java.sql.Connection;

public class LoginFacade {

    private final UserDAO userDAO;

    public LoginFacade(Connection connection) {
        AbstractUserFactory userFactory = new PostgreUserFactory();
        this.userDAO = userFactory.createUserDAO();
    }

    public User login(String email, String password) {
        return userDAO.login(email, password);
    }

}
