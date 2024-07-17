package com.agencyglobalflights.admin.planemanagement.infrastructure.in.view;

import java.sql.SQLException;

import com.agencyglobalflights.admin.planemanagement.application.DeletePlaneUseCase;
import com.agencyglobalflights.admin.planemanagement.application.RegisterPlaneUseCase;
import com.agencyglobalflights.admin.planemanagement.application.UpdatePlaneUseCase;
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
        DeletePlaneUseCase dpuc = new DeletePlaneUseCase(ps);
        UpdatePlaneUseCase upuc = new UpdatePlaneUseCase(ps);

        PlaneController pc = new PlaneController(rpuc, vpiuc, dpuc, upuc);

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
                    break;
                case 3:
                    pc.updatePlaneController();
                    break;
                case 4:
                    pc.deletePlaneController();
                    break;
                case 5:

                    return;
                default:
                    break;
            }

        } while (true);

    }
}
