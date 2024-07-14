package com.agencyglobalflights.admin.view;

import java.sql.SQLException;

import com.agencyglobalflights.utils.ConsoleUtils;

public class AirportsManageView {

        public void showmenu() throws SQLException {

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "         Airports Management           \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. View Airport information\n" +
            "2. Update airport information\n" +
            "3. Create Airport\n" +
            "4. Delete airport\n" +
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
