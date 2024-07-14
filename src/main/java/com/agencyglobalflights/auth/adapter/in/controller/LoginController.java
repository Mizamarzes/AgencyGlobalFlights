package com.agencyglobalflights.auth.adapter.in.controller;

import com.agencyglobalflights.auth.service.UserService;
import com.agencyglobalflights.view.admin.AdminMain;
import com.agencyglobalflights.view.salesagent.SalesAgentMain;
import com.agencyglobalflights.view.superadmin.SuperAdminMain;
import com.agencyglobalflights.view.technician.TechnicianMain;

import java.sql.SQLException;

import com.agencyglobalflights.auth.domain.User;

public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    public boolean login(String username, String password) throws SQLException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (userService.authUser(user)) {
            int role = user.getIdrole();
            switch (role) {
                case 0:
                    SuperAdminMain superAdminMenu = new SuperAdminMain(username);
                    superAdminMenu.showmenu();
                    break;
                case 1:
                    AdminMain adminMain = new AdminMain(username);
                    adminMain.showmenu();
                    break;
                case 2:
                    TechnicianMain techMain = new TechnicianMain(username);
                    techMain.showmenu();
                    break;
                case 3:
                    SalesAgentMain salesMain = new SalesAgentMain(username);
                    salesMain.showmenu();
                    break;
                default:
                    throw new IllegalStateException("Unexpected role: " + role);
            }
            return true;
        } else {
            return false;
        }
    }

}
