package com.agencyglobalflights.admin.flightsconnectionsmanagement.infrastructure.in.view;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.CreateFlightConnectionUseCase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.service.FlightConnectionService;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.infrastructure.in.controller.FlightConnectionController;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.infrastructure.out.FlightConnectionRepository;
import com.agencyglobalflights.admin.flightsmanagement.application.DeleteFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.application.UpdateFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.application.ViewFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller.FlightController;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.out.FlightRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightConnectionView {

    public void showmenu() throws SQLException {
    // Inicializa los servicios y repositorios necesarios
    ViewFlightUseCase viewFlightUseCase = new ViewFlightUseCase(new FlightRepository());
    UpdateFlightUseCase updateFlightUseCase = new UpdateFlightUseCase(new FlightRepository());
    DeleteFlightUseCase deleteFlightUseCase = new DeleteFlightUseCase(new FlightRepository());

    // Inicializa FlightController con todos los casos de uso
    FlightController flightController = new FlightController(viewFlightUseCase, updateFlightUseCase, deleteFlightUseCase);

    // Inicializa los casos de uso para FlightConnection
    FlightConnectionService fcs = new FlightConnectionRepository();
    
    CreateFlightConnectionUseCase cfcuc = new CreateFlightConnectionUseCase(fcs);
    UpdateFlightUseCase ufuc = new UpdateFlightUseCase(new FlightRepository());

    // Inicializa FlightConnectionController
    FlightConnectionController fcc = new FlightConnectionController(cfcuc, ufuc, flightController);

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "          Flight Connections           \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. Assign Flight Connection\n" +
            "2. Assign Flight Crew\n" +
            "3. View flight connections\n" +
            "4. View crew connections\n" +
            "5. Update flight connection information\n" +
            "6. Delete flight connection\n" +
            "7. Go back\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 7);


            switch (op) {
                case 1:
                    fcc.createFlightConnectionController();
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

                    return;
                default:
                    break;
            }

        } while (true);

    }
}
