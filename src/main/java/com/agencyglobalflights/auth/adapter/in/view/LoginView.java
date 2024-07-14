package com.agencyglobalflights.auth.adapter.in.view;

import java.util.Scanner;

import com.agencyglobalflights.ConsoleUtils;
import com.agencyglobalflights.auth.adapter.in.controller.LoginController;
import com.agencyglobalflights.auth.adapter.out.UserRepository;
import com.agencyglobalflights.auth.service.UserService;

public class LoginView {
    
    private final LoginController controller;

    public LoginView() {
        UserService userRep = new UserRepository();  // Crea una instancia de UserService
        this.controller = new LoginController(userRep);  // Inicializa el controlador con los servicios
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        ConsoleUtils.clear();
        System.out.println("---------------------\n" +
        "       Sign in       \n" +
        "---------------------\n");

        System.out.print("\nEnter your username: ");
        String username = sc.nextLine().trim();
        System.out.print("\nEnter your password: ");
        String password = sc.nextLine().trim();
        System.out.println();

        try {
            boolean success = controller.login(username, password);
            if (success) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Incorrect username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred during login: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
