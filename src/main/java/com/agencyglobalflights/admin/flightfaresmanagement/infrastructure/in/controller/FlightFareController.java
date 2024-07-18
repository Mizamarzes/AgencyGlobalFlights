package com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.in.controller;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.flightfaresmanagement.application.ViewFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.domain.entity.FlightFare;
import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightFareController {
    private ViewFlightFareUseCase viewflightFareUseCase;

    public FlightFareController(ViewFlightFareUseCase viewflightFareUseCase) {
        this.viewflightFareUseCase = viewflightFareUseCase;
    }

    public List<FlightFare> getAllFlightFaresController() throws SQLException{
        ConsoleUtils.clear();
        String border = "+----+-------------------+";
        String header = "| id |       Fare        |";
        List<FlightFare> flightFares = viewflightFareUseCase.findAllFlightFares();

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (FlightFare flightFare : flightFares) {
            System.out.printf("| %-2d | %-17s |%n",
            flightFare.getId(), flightFare.getName());          
        }
        System.out.println(border);
        return flightFares;
    }

    public void getFlightFareByIdController(int id) throws SQLException {
        ConsoleUtils.clear();
    
        FlightFare flightFare = viewflightFareUseCase.viewFlightFareById(id);

        if (flightFare != null) {
            String border = "+----+-------------------+----------------+";
            String header = "| id |       Fare        |     Value      |";

            System.out.println(border);
            System.out.println(header);
            System.out.println(border);

            System.out.printf("| %-2d | %-17s | %-14.2f |%n",
                flightFare.getId(),
                flightFare.getName(),
                flightFare.getPrice()
            );
            
        System.out.println(border);
        } else {
            System.out.println("No fares found with the given id.");
        }
        ConsoleUtils.waitWindow();
    }

    public void viewflightFareByIdController() throws SQLException{
        ConsoleUtils.clear();
        getAllFlightFaresController();
        System.out.println("Enter the id of the fare: ");
        int op = ConsoleUtils.verifyingIntNoRange();
        getFlightFareByIdController(op);
        ConsoleUtils.waitWindow();
    }
}
