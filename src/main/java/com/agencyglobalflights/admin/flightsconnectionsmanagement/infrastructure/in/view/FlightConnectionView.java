package com.agencyglobalflights.admin.flightsconnectionsmanagement.infrastructure.in.view;

import java.sql.SQLException;

import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightConnectionView {

    public void showmenu() throws SQLException {

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "          Flight Connections           \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. Create Flight Connection\n" +
            "2. View flight connections\n" +
            "3. View crew connections\n" +
            "4. Update flight connection information\n" +
            "5. Delete flight connection\n" +
            "6. Go back\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 6);


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
                case 6:

                    return;
                default:
                    break;
            }

        } while (true);

    }
}
