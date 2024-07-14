package com.agencyglobalflights.admin.view;

import java.sql.SQLException;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.admin.planemanagement.infrastructure.in.view.PlaneManageView;
import com.agencyglobalflights.auth.infrastructure.out.UserRepository;
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
            "1. Plane management\n" +
            "2. Flight management\n" +
            "3. Flight Connections\n" +
            "4. Flight Fares\n" +
            "5. Airports Management\n" +
            "6. Documents Management\n" +
            "7. Sign Out\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 7);


            switch (op) {
                case 1:
                    PlaneManageView planeManageView = new PlaneManageView();
                    planeManageView.showmenu();
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
                
                    break;
                default:
                    break;
            }

        } while (true);

    }
}
