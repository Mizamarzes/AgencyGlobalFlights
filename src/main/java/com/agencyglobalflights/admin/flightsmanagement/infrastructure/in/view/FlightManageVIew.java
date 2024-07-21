package com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.view;

import java.sql.SQLException;

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

        FlightController fc = new FlightController(vfus, ufuc);

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "          Flights Management           \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. Assign flight plane  \n" +
            "2. Assign flight crew  \n" +
            "3. View crew assignment\n" +
            "4. View flight information\n" +
            "5. Update flight information\n" +
            "6. Delete flight \n" +
            "7. Go Back \n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 7);


            switch (op) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    fc.viewFlightByIdController();
                    break;
                case 5:
                    fc.updateFlightController();
                    break;
                case 6:
                
                    break;
                case 7:
                
                    return;
                default:
                    break;
            }

        } while (true);

    }
}
