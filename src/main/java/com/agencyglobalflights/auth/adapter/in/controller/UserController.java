package com.agencyglobalflights.auth.adapter.in.controller;

import java.sql.SQLException;

import com.agencyglobalflights.ConsoleUtils;
import com.agencyglobalflights.auth.application.CreateUserUseCase;

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
