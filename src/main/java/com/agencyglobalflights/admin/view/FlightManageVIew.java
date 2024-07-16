package com.agencyglobalflights.admin.view;

import java.sql.SQLException;

import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightManageVIew {

    public void showmenu() throws SQLException {

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "          Flights Management           \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. Assign flight plane  \n" +
            "2. Assign flight crew  \n" +
            "3. View crew assignment\n" +
            "4. View flight information\n" +
            "5. Update flight information\n" +
            "6. Delete flight \n" +
            "7. Go Back \n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 7);


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
                
                    break;
                case 7:
                
                    return;
                default:
                    break;
            }

        } while (true);

    }
}
