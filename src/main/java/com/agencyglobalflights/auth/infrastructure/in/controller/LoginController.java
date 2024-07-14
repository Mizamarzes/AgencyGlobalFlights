package com.agencyglobalflights.auth.infrastructure.in.controller;

import com.agencyglobalflights.auth.service.UserService;
import com.agencyglobalflights.salesagent.view.SalesAgentMainView;
import com.agencyglobalflights.superadmin.view.SuperAdminMainView;
import com.agencyglobalflights.technician.view.TechnicianMainView;

import java.sql.SQLException;

import com.agencyglobalflights.admin.view.AdminMainView;
import com.agencyglobalflights.auth.domain.User;
import com.agencyglobalflights.auth.infrastructure.out.UserRepository;

public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    public boolean login(String username, String password) throws SQLException {
        final String userRole;
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        

        if (userService.authUser(user)) {
            UserRepository userRep = new UserRepository();
            userRole = userRep.getUserRole(username);
            switch (userRole) {
                case "Super Admin":
                    SuperAdminMainView superAdminMenu = new SuperAdminMainView(username);
                    superAdminMenu.showmenu();
                    break;
                case "Administrator":
                    AdminMainView adminMain = new AdminMainView(username);
                    adminMain.showmenu();
                    break;
                case "Maintenance Technician":
                    TechnicianMainView techMain = new TechnicianMainView(username);
                    techMain.showmenu();
                    break;
                case "Sales Agent":
                    SalesAgentMainView salesMain = new SalesAgentMainView(username);
                    salesMain.showmenu();
                    break;
                default:
                    throw new IllegalStateException("Unexpected role: " + userRole);
            }
            return true;
        } else {
            return false;
        }
    }

}
