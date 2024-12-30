package com.infobasic.dao;

import com.infobasic.model.User;

import java.sql.SQLException;

public interface UserDAO {
    boolean createUser(User user) throws SQLException;
    User getUserByUsername(String username) throws SQLException;
    User getUserByEmail(String email) throws SQLException;
}