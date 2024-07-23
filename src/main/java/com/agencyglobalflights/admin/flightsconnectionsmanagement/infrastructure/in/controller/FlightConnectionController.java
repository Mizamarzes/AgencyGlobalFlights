package com.agencyglobalflights.admin.flightsconnectionsmanagement.infrastructure.in.controller;

import java.sql.SQLException;

import com.agencyglobalflights.admin.airportmanage.infrastructure.in.controller.AirportController;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.CreateFlightConnectionUseCase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightConnection;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller.FlightController;
import com.agencyglobalflights.admin.planemanagement.infrastructure.in.controller.PlaneController;
import com.agencyglobalflights.utils.ConsoleUtils;
import com.agencyglobalflights.utils.Validators;

public class FlightConnectionController {

    private final CreateFlightConnectionUseCase createFlightConnectionUseCase;
    private final FlightController flightController;
    private final PlaneController planeController;
    private final AirportController airportController;
    private final Validators validators;

    public FlightConnectionController(
            CreateFlightConnectionUseCase createFlightConnectionUseCase,
            FlightController flightController,
            PlaneController planeController,
            AirportController airportController,
            Validators validators) {
        this.createFlightConnectionUseCase = createFlightConnectionUseCase;
        this.flightController = flightController;
        this.planeController = planeController;
        this.airportController = airportController;
        this.validators = validators;
    }

    // -------------------------
    // CREATE FLIGHT CONNECTION 
    public void createFlightConnectionController() throws SQLException {
        ConsoleUtils.clear();
        flightController.getAllFlightsController();
        System.out.println("Enter the id of the flight");
        int id_flight = ConsoleUtils.verifyingIntNoRange();
        if (!validators.checkIdExistsINT("flight", "id", id_flight)) {
            return; 
        }

        if (createFlightConnectionUseCase.hasFlightConnections(id_flight)) {
            System.out.println("The flight with id " + id_flight + " already has flight connections.");
            ConsoleUtils.waitWindow();
        } else {
            System.out.println("The flight with id " + id_flight + " does not have any flight connections yet.");
            ConsoleUtils.waitWindow();

            ConsoleUtils.clear();
            System.out.println("Enter the connection_number of flight connection: ");
            String connection_number = ConsoleUtils.verifyingStringMaxStringREGEX(10);

            ConsoleUtils.clear();
            planeController.findAllPlanes();
            System.out.println("Enter the id of the plane to assign: ");
            String id_plane = ConsoleUtils.verifyingStringMaxStringREGEX(10);
            if (!validators.checkIdExistsSTRING("plane", "id", id_plane)) {
                return; 
            }
            
            ConsoleUtils.clear();
            airportController.findAllAirports();
            System.out.println("Enter the id of the airport to assign destiny airport: ");
            String id_airport_dest = ConsoleUtils.verifyingStringMaxStringREGEX(10);
            if (!validators.checkIdExistsSTRING("airport", "id", id_airport_dest)) {
                return; 
            }

            FlightConnection newFlightConnection = new FlightConnection(connection_number, id_flight, id_plane, id_airport_dest);
        
            try {
                createFlightConnectionUseCase.flightConnectionCreate(newFlightConnection);
                System.out.println("Flight connection created successfully!");
            } catch (SQLException e) {
                System.out.println("Error occurred while creating flight connection: " + e.getMessage());
            }
            ConsoleUtils.waitWindow();

        }
        
    }
    
}
