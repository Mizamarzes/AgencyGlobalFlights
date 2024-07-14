package com.agencyglobalflights.admin.view;

import java.sql.SQLException;

import com.agencyglobalflights.utils.ConsoleUtils;

public class PlaneManageView {

    public void showmenu() throws SQLException {

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "           Plane Management           \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. Register plane \n" +
            "2. View plane information\n" +
            "3. Update plane information\n" +
            "4. Delete Plane\n" +
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
