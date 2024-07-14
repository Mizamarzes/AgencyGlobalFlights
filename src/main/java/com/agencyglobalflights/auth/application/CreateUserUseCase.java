package com.agencyglobalflights.auth.application;

import java.sql.SQLException;

import com.agencyglobalflights.auth.domain.User;
import com.agencyglobalflights.auth.service.UserService;

public class CreateUserUseCase {
    private UserService userService;

    public CreateUserUseCase(UserService userService) {
        this.userService = userService;
    }

    public void createUserCase(User user) throws SQLException{
        userService.createUser(user);
    }

}
