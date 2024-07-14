package com.agencyglobalflights.admin.view;

import java.sql.SQLException;

import com.agencyglobalflights.auth.adapter.out.UserRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class AdminMainView {

    @SuppressWarnings("unused")
    private String username;
    private String userRole;

    public AdminMainView(String username) throws SQLException {
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
            "      Global Flights Admin Panel      \n" +
            "       Please select an option:       \n" +
            "--------------------------------------\n" +
            "\n" +
            "1. Menu1\n" +
            "2. Menu2\n" +
            "3. Menu3\n" +
            "4. Sign Out\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 2);


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
