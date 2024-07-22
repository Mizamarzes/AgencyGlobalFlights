package com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.view;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightsmanagement.application.DeleteFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.application.UpdateFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.application.ViewFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.domain.service.FlightService;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller.FlightController;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.out.FlightRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightManageVIew {

    public void showmenu() throws SQLException {
        FlightService fs = new FlightRepository();

        ViewFlightUseCase vfus = new ViewFlightUseCase(fs);
        UpdateFlightUseCase ufuc = new UpdateFlightUseCase(fs);
        DeleteFlightUseCase dfuc = new DeleteFlightUseCase(fs);

        FlightController fc = new FlightController(vfus, ufuc, dfuc);

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "          Flights Management           \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. View flight information\n" +
            "2. Update flight information\n" +
            "3. Delete flight \n" +
            "4. Go Back \n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 7);


            switch (op) {
                case 1:
                    fc.viewFlightByIdController();
                    break;
                case 2:
                    fc.updateFlightController();
                    break;
                case 3:
                    fc.deleteFlightController();
                    break;
                case 4:
                    
                    return;
                default:
                    break;
            }

        } while (true);

    }
}
