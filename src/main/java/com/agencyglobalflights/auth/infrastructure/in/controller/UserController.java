package com.agencyglobalflights.auth.infrastructure.in.controller;

import java.sql.SQLException;

import com.agencyglobalflights.auth.application.CreateUserUseCase;
import com.agencyglobalflights.utils.ConsoleUtils;

public class UserController {
    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    public void createUserController() throws SQLException {
        
        ConsoleUtils.clear();
        System.out.println("Enter the Username: ");
    }
}
