package com.agencyglobalflights.admin.flightsconnectionsmanagement.infrastructure.in.controller;

import java.sql.SQLException;

import com.agencyglobalflights.admin.airportmanage.infrastructure.in.controller.AirportController;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.CreateFlightConnectionUseCase;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller.FlightController;
import com.agencyglobalflights.admin.planemanagement.infrastructure.in.controller.PlaneController;
import com.agencyglobalflights.utils.ConsoleUtils;
import com.agencyglobalflights.utils.Validators;

public class FlightConnectionController {
    private final CreateFlightConnectionUseCase createFlightConnectionUseCase;

    private final FlightController flightController;

    private final PlaneController planeController;

    private final AirportController airportController;

    public FlightConnectionController(
            CreateFlightConnectionUseCase createFlightConnectionUseCase,
            FlightController flightController,
            PlaneController planeController,
            AirportController airportController) {
        this.createFlightConnectionUseCase = createFlightConnectionUseCase;
        this.flightController = flightController;
        this.planeController = planeController;
        this.airportController = airportController;
    }

    // -------------------------
    // CREATE FLIGHT CONNECTION 
    public void createFlightConnectionController() throws SQLException {
        ConsoleUtils.clear();
        flightController.getAllFlightsController();
        System.out.println("Enter the id of the flight");
        int id_flight = ConsoleUtils.verifyingIntNoRange();

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
            boolean exists = Validators.checkIdExists("plane", "id", id_plane);

            if (exists) {
                System.out.println("The plane ID exists.");
                // Proceder con la lógica de asignación
            } else {
                System.out.println("The plane ID does not exist.");
                // Manejar el caso en el que el ID no existe
            }

            ConsoleUtils.clear();
            airportController.findAllAirports();
            System.out.println("Enter the id of the airport to assign destiny airport: ");
            String id_airport_dest = ConsoleUtils.verifyingStringMaxStringREGEX(10);


        }
        
    }
    
}
