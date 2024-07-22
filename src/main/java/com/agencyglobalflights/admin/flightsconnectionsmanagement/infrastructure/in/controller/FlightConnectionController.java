package com.agencyglobalflights.admin.flightsconnectionsmanagement.infrastructure.in.controller;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.CreateFlightConnectionUseCase;
import com.agencyglobalflights.admin.flightsmanagement.application.UpdateFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller.FlightController;
import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightConnectionController {
    private final CreateFlightConnectionUseCase createFlightConnectionUseCase;
    private final UpdateFlightUseCase updateFlightUseCase;
    private final FlightController flightController;

    public FlightConnectionController(CreateFlightConnectionUseCase createFlightConnectionUseCase,
            UpdateFlightUseCase updateFlightUseCase, FlightController flightController) {
        this.createFlightConnectionUseCase = createFlightConnectionUseCase;
        this.updateFlightUseCase = updateFlightUseCase;
        this.flightController = flightController;
    }

    // -------------------------
    // CREATE FLIGHT CONNECTION 
    public void createFlightConnectionController() throws SQLException {
        ConsoleUtils.clear();
        flightController.getAllFlightsController();
        System.out.println("Enter the id of the flight");
        int id_flight = ConsoleUtils.verifyingIntNoRange();

        // Verificar si el vuelo tiene conexiones de vuelo
        if (createFlightConnectionUseCase.hasFlightConnections(id_flight)) {
            System.out.println("The flight with id " + id_flight + " already has flight connections.");
            ConsoleUtils.waitWindow();
        } else {
            System.out.println("The flight with id " + id_flight + " does not have any flight connections yet.");
            ConsoleUtils.waitWindow();

            System.out.println("Enter the connection_number: ");
            String connection_number = ConsoleUtils.verifyEntryString();

            
            System.out.println("");
            // Aquí puedes continuar con la lógica para crear una nueva conexión de vuelo
        }
        
    }
    
}
