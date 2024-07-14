package com.agencyglobalflights.superadmin.view;

import java.sql.SQLException;

import com.agencyglobalflights.admin.view.AdminMainView;
import com.agencyglobalflights.auth.infrastructure.out.UserRepository;
import com.agencyglobalflights.salesagent.view.SalesAgentMainView;
import com.agencyglobalflights.technician.view.TechnicianMainView;
import com.agencyglobalflights.utils.ConsoleUtils;

public class SuperAdminMainView {


    @SuppressWarnings("unused")
    private String username;
    private String userRole;

    public SuperAdminMainView(String username) throws SQLException {
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
            "   Global Flights Super Admin Panel   \n" +
            "       Please select an option:       \n" +
            "--------------------------------------\n" +
            "\n" +
            "1. Administrator Menu\n" +
            "2. Maintenance Technician Menu\n" +
            "3. Sales Agent Menu\n" +
            "4. Sign Out\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 2);


            switch (op) {
                case 1:
                    AdminMainView adminMain = new AdminMainView(username);
                    adminMain.showmenu();
                    break;
                case 2:
                    TechnicianMainView techMain = new TechnicianMainView(username);
                    techMain.showmenu();
                    break;
                case 3:
                    SalesAgentMainView salesMain = new SalesAgentMainView(username);
                    salesMain.showmenu();
                    break;
                case 4:
                break;
                default:
                    break;
            }

        } while (true);

    }


}
