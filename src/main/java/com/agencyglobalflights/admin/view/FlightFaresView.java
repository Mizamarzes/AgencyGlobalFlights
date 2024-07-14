package com.agencyglobalflights.admin.view;

import java.sql.SQLException;

import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightFaresView {

    public void showmenu() throws SQLException {

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "            Flight Fares               \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. View flight fares \n" +
            "2. Register flight fare \n" +
            "3. Update flight fare information\n" +
            "4. Delete flight fare\n" +
            "5. Go back\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 5);


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
