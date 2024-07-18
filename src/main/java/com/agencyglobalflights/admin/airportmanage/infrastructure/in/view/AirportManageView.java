package com.agencyglobalflights.admin.airportmanage.infrastructure.in.view;

import java.sql.SQLException;

import com.agencyglobalflights.admin.airportmanage.application.CreateAirpUseCase;
import com.agencyglobalflights.admin.airportmanage.application.DeleteAirpUseCase;
import com.agencyglobalflights.admin.airportmanage.application.UpdateAirpUseCase;
import com.agencyglobalflights.admin.airportmanage.application.ViewAirpInfoUseCase;
import com.agencyglobalflights.admin.airportmanage.domain.service.AirportService;
import com.agencyglobalflights.admin.airportmanage.infrastructure.in.controller.AirportController;
import com.agencyglobalflights.admin.airportmanage.infrastructure.out.AirportRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class AirportManageView {

    public void showmenu() throws SQLException {
        AirportService as = new AirportRepository();
        ViewAirpInfoUseCase vauc = new ViewAirpInfoUseCase(as);
        CreateAirpUseCase cauc = new CreateAirpUseCase(as);
        DeleteAirpUseCase deluc = new DeleteAirpUseCase(as);
        UpdateAirpUseCase updtuc = new UpdateAirpUseCase(as);
        AirportController ac = new AirportController(vauc, cauc, deluc, updtuc);


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
                    ac.viewAirportInfo();
                    break;
                case 2:
                    ac.UpdateAirport();
                    return;
                case 3:
                    ac.createAirport();
                    break;
                case 4:
                    ac.deleteAirport();
                    return;
                case 5:
                    return;
                default:
                    break;
            }

        } while (true);

    }
}
