package com.agencyglobalflights.customer.view;

import java.sql.SQLException;

import com.agencyglobalflights.utils.ConsoleUtils;

public class CustomerMainView {

    public void showmenu() throws SQLException {

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "   Welcome to Global Flights Agency    \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. Flights Section\n" +
            "2. Bookings Management\n" +
            "3. Sign Out\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 3);


            switch (op) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    break;
            }

        } while (true);

    }
}
