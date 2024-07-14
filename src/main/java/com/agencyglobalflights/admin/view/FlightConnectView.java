package com.agencyglobalflights.admin.view;

import java.sql.SQLException;

import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightConnectView {

    public void showmenu() throws SQLException {

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "          Flight Connections           \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. View flight connections\n" +
            "2. Update flight connection information\n" +
            "3. Delete flight connection\n" +
            "4. Go back\n"
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
                case 5:
                
                    break;
                default:
                    break;
            }

        } while (true);

    }
}
