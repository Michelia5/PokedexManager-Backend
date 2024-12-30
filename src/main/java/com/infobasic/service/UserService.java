package com.infobasic.service;

import com.infobasic.dao.UserDAO;
import com.infobasic.dao.impl.UserDAOImpl;
import com.infobasic.model.User;

import java.sql.SQLException;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAOImpl();
    }

    public boolean createUser(User user) throws SQLException {
        if (user.getUsername() == null || user.getPassword() == null || user.getEmail() == null) {
            throw new IllegalArgumentException("I campi username, password ed email sono obbligatori");
        }

        return userDAO.createUser(user);
    }

    public boolean authenticateUser(String username, String password) throws SQLException {
        User user = userDAO.getUserByUsername(username);
        if (user != null) {
            // Verifica se la password corrisponde
            return user.getPassword().equals(password);
        }
        return false;
    }

    public User getUserByUsername(String username) throws SQLException {
        return userDAO.getUserByUsername(username);
    }

    public User getUserByEmail(String email) throws SQLException {
        return userDAO.getUserByEmail(email);
    }

}
