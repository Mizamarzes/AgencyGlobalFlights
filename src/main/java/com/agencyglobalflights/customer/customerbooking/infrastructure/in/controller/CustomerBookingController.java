package com.agencyglobalflights.customer.customerbooking.infrastructure.in.controller;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.in.controller.FlightFareController;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller.FlightController;
import com.agencyglobalflights.customer.customerbooking.application.UpdateCustomerFlightBookingUseCase;
import com.agencyglobalflights.utils.ConsoleUtils;
import com.agencyglobalflights.utils.Validators;

public class CustomerBookingController {

    private final UpdateCustomerFlightBookingUseCase updateCustomerFlightBookingUseCase;

    private final FlightController flightController;
    private final FlightFareController flightFareController;

    private final Validators validators;

    public CustomerBookingController(
        UpdateCustomerFlightBookingUseCase updateCustomerFlightBookingUseCase,
        Validators validators,
        FlightController flightController,
        FlightFareController flightFareController) {
        this.updateCustomerFlightBookingUseCase = updateCustomerFlightBookingUseCase;
        this.validators = validators;
        this.flightController = flightController;
        this.flightFareController = flightFareController;
    }

    // -------------------------
    // UPDATE FLIGHT BOOKING CUSTOMER
    public void updateCustomerFlightBookingController() throws SQLException {
        System.out.println("Please, enter the id of the flight booking: ");
        String id = ConsoleUtils.verifyingIntREGEXString();

        if (!validators.checkIdExistsSTRING("flightbooking", "id", id)) {
            return; 
        }

        ConsoleUtils.clear();
        System.out.println("--------------------------------------\n" +
        "       Please select an option:       \n" +
        "--------------------------------------\n" +
        "\n" +
        "1. Update flight selected\n" +
        "2. Update fare selected\n" +
        "3. Go back"
        );

        int op = ConsoleUtils.verifyEntryInt(1, 3);

        switch (op) {
            case 1:
                ConsoleUtils.clear();
                flightController.getAllFlightsController();
                System.out.println("Enter the new flight: ");
                String new_flight = ConsoleUtils.verifyingIntREGEXString();
                if (!validators.checkIdExistsSTRING("flight", "id", new_flight)) {
                    return; 
                }
                updateCustomerFlightBookingUseCase.updateFlightBookingCustomer(id, "idflight", new_flight, "INT");
                ConsoleUtils.waitWindow();
                break;
            case 2:
                ConsoleUtils.clear();
                flightFareController.getAllFlightFaresController();
                System.out.println("Enter the new fare: ");
                String new_fare = ConsoleUtils.verifyingIntREGEXString();
                if (!validators.checkIdExistsSTRING("flightfare", "id", new_fare)) {
                    return; 
                }
                break;
            case 3:
                
                return;
            default:
                break;
        }
    }
}
