package com.agencyglobalflights.salesagent.flightmanage;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightfaresmanagement.application.ViewFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.domain.service.FlightFareService;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.in.controller.FlightFareController;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.out.FlightFareRepository;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.viewFlightConnectionUseCase;
import com.agencyglobalflights.admin.flightsmanagement.application.ViewFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.domain.service.FlightService;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller.FlightController;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.out.FlightRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightManageView {

    public void showmenu() throws SQLException {
        //services
        FlightService fs = new FlightRepository();
        FlightFareService ffs = new FlightFareRepository();

        //use cases
        ViewFlightUseCase vfuc = new ViewFlightUseCase(fs);
        ViewFlightFareUseCase vffuc = new ViewFlightFareUseCase(ffs);

        //controllers
        FlightController fc = new FlightController(vfuc);
        FlightFareController ffc = new FlightFareController(vffuc);

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "          Flight Management:           \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. View flight information\n" +
            "2. View flight connections\n" +
            "3. View flight fare \n" +
            "4. Go back\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 4);


            switch (op) {
                case 1:
                    fc.viewFlightByIdController();
                    break;
                case 2:
                    // en desarrollo
                    break;
                case 3:
                    ffc.viewflightFareByIdController();
                    break;
                case 4:
                    return;
                default:
                    break;
            }

        } while (true);

    }
}
