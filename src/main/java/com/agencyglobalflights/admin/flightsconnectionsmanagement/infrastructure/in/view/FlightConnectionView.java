package com.agencyglobalflights.admin.flightsconnectionsmanagement.infrastructure.in.view;

import java.sql.SQLException;

import com.agencyglobalflights.admin.airportmanage.application.ViewAirpInfoUseCase;
import com.agencyglobalflights.admin.airportmanage.infrastructure.in.controller.AirportController;
import com.agencyglobalflights.admin.airportmanage.infrastructure.out.AirportRepository;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.AssignFlightCrewUseCase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.CreateFlightConnectionUseCase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.DeleteflightConnectionUseCase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.UpdateFlightConnectionUsecase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.ViewFlightConnectionUseCase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.ViewFlightCrewUseCase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.service.FlightConnectionService;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.infrastructure.in.controller.FlightConnectionController;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.infrastructure.out.FlightConnectionRepository;
import com.agencyglobalflights.admin.flightsmanagement.application.UpdateFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller.FlightController;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.out.FlightRepository;
import com.agencyglobalflights.admin.planemanagement.application.UpdatePlaneUseCase;
import com.agencyglobalflights.admin.planemanagement.infrastructure.in.controller.PlaneController;
import com.agencyglobalflights.admin.planemanagement.infrastructure.out.PlaneRepository;
import com.agencyglobalflights.utils.ConsoleUtils;
import com.agencyglobalflights.utils.Validators;

public class FlightConnectionView {

    public void showmenu() throws SQLException {

    UpdateFlightUseCase ufuc = new UpdateFlightUseCase(new FlightRepository());
    UpdatePlaneUseCase upuc = new UpdatePlaneUseCase(new PlaneRepository());
    ViewAirpInfoUseCase vaiuc = new ViewAirpInfoUseCase(new AirportRepository());

    FlightController fc = new FlightController(ufuc);
    PlaneController pc = new PlaneController(upuc);
    AirportController ac = new AirportController(vaiuc);

    FlightConnectionService fcs = new FlightConnectionRepository();
    
    CreateFlightConnectionUseCase cfcuc = new CreateFlightConnectionUseCase(fcs);
    ViewFlightConnectionUseCase vfcuc = new ViewFlightConnectionUseCase(fcs);
    UpdateFlightConnectionUsecase ufcuc = new UpdateFlightConnectionUsecase(fcs);
    DeleteflightConnectionUseCase dfcuc = new DeleteflightConnectionUseCase(fcs);
    AssignFlightCrewUseCase afcuc = new AssignFlightCrewUseCase(fcs);
    ViewFlightCrewUseCase vfcucrew = new ViewFlightCrewUseCase(fcs);

    // Validators
    Validators validators = new Validators();

    // Start FlightConnectionController
    FlightConnectionController fcc = new FlightConnectionController(cfcuc, vfcuc, ufcuc, dfcuc, afcuc, vfcucrew, fc, pc, ac, validators);

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
                    fcc.AssignFlightCrewController();
                    break;
                case 3:
                    fcc.viewFlightControllerByIdFlightController();
                    break;
                case 4:
                    fcc.viewFlightCrewByIdFlightConnectionController();
                    break;
                case 5:
                    fcc.updateFlightConnectionsController();
                    break;
                case 6:
                    fcc.deleteFlightConnectionController();
                    break;
                case 7:

                    return;
                default:
                    break;
            }

        } while (true);

    }
}
