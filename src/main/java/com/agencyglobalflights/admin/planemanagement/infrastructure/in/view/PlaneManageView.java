package com.agencyglobalflights.admin.planemanagement.infrastructure.in.view;

import java.sql.SQLException;

import com.agencyglobalflights.admin.planemanagement.application.RegisterPlaneUseCase;
import com.agencyglobalflights.admin.planemanagement.application.ViewPlaneInformationUseCase;
import com.agencyglobalflights.admin.planemanagement.domain.service.PlaneService;
import com.agencyglobalflights.admin.planemanagement.domain.service.AirlineService;
import com.agencyglobalflights.admin.planemanagement.infrastructure.in.controller.PlaneController;
import com.agencyglobalflights.admin.planemanagement.infrastructure.out.AirlineRepository;
import com.agencyglobalflights.admin.planemanagement.infrastructure.out.PlaneRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class PlaneManageView {

    public void showmenu() throws SQLException {
        PlaneService ps = new PlaneRepository();
        AirlineService as = new AirlineRepository();

        RegisterPlaneUseCase rpuc = new RegisterPlaneUseCase(ps, as);
        ViewPlaneInformationUseCase vpiuc = new ViewPlaneInformationUseCase(ps);

        PlaneController pc = new PlaneController(rpuc, vpiuc);

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
                    pc.registerPlaneController();
                    break;
                case 2:
                    pc.getPLaneByPlateController();
                    ConsoleUtils.waitWindow();
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
