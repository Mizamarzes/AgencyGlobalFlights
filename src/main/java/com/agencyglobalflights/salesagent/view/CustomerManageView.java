package com.agencyglobalflights.salesagent.view;

import java.sql.SQLException;

import com.agencyglobalflights.utils.ConsoleUtils;

public class CustomerManageView {

    public void showmenu() throws SQLException {

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "         Booking Management:           \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. View customer information\n" +
            "2. Update customer info\n" +
            "3. Create customer \n" +
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
