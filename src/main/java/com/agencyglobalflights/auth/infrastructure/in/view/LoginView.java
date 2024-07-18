package com.agencyglobalflights.auth.infrastructure.in.view;

import java.util.Scanner;

import com.agencyglobalflights.auth.infrastructure.in.controller.LoginController;
import com.agencyglobalflights.auth.infrastructure.out.UserRepository;
import com.agencyglobalflights.auth.service.UserService;
import com.agencyglobalflights.utils.ConsoleUtils;

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
