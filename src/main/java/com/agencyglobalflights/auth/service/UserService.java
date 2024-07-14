package com.agencyglobalflights.auth.service;

import java.sql.SQLException;

import com.agencyglobalflights.auth.domain.User;

public interface UserService {

    boolean authUser(User user) throws SQLException;
    void createUser(User user) throws SQLException;
    String getUserRole(String username) throws SQLException;
}
