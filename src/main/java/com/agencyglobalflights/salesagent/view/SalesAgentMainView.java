package com.agencyglobalflights.salesagent.view;

import java.sql.SQLException;

import com.agencyglobalflights.auth.infrastructure.out.UserRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class SalesAgentMainView {


    @SuppressWarnings("unused")
    private String username;
    private String userRole;

    public SalesAgentMainView(String username) throws SQLException {
        this.username = username;
        UserRepository userRep = new UserRepository();
        userRole = userRep.getUserRole(username);
    }

    public void showmenu() throws SQLException {

        do {

            ConsoleUtils.clear();
            System.out.println("--------------------------------------\n" +
            "     Signed in as " + userRole +     "\n" +
            "--------------------------------------\n" +
            "      Global Flights Sales Panel      \n" +
            "       Please select an option:       \n" +
            "--------------------------------------\n" +
            "\n" +
            "1. Booking Management\n" +
            "2. Customer Management\n" +
            "3. Flight Management\n" +
            "4. Sign Out\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 4);


            switch (op) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    break;
            }

        } while (true);

    }

}
