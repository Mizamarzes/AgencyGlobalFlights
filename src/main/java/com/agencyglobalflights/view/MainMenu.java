package com.agencyglobalflights.view;

import java.sql.SQLException;

import com.agencyglobalflights.auth.infrastructure.in.view.LoginView;
import com.agencyglobalflights.customer.view.CustomerMainView;
import com.agencyglobalflights.utils.ConsoleUtils;

public class MainMenu {

    public void Start() throws SQLException {

        ConsoleUtils.clear();
        System.out.println("--------------------------------------\n" +
        "         GlobalFlights Panel          \n" +
        "       Please select an option:       \n" +
        "--------------------------------------\n" +
        "\n" +
        "1. Continue As Customer\n" +
        "2. Sing in As Administrator\n" +
        "3. Exit\n"
        );

        int op = ConsoleUtils.verifyEntryInt(1, 3);
        System.out.println("Loading...");
        
        switch (op) {
            case 1:
                //inicia el customerMainView
                CustomerMainView customerMainView = new CustomerMainView();
                customerMainView.showmenu();
                break;
            case 2:
                //inicia el LoginView
                LoginView login = new LoginView();
                login.start();
                break;
            case 3:
                System.out.println("Thanks for using our Platform");
                break;
            default:
                break;
        }
    }
}
