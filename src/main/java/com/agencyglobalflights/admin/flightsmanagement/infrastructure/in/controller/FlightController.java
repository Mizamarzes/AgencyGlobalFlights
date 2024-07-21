package com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.flightsmanagement.application.UpdateFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.application.ViewFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.domain.entity.Flight;
import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightController {
    private ViewFlightUseCase viewFlightUseCase;
    private UpdateFlightUseCase updateFlightUseCase;
    
    public FlightController(ViewFlightUseCase viewFlightUseCase, UpdateFlightUseCase updateFlightUseCase) {
        this.viewFlightUseCase = viewFlightUseCase;
        this.updateFlightUseCase = updateFlightUseCase;
    }

    // -------------------------
    // VIEW FLIGHT

    public void getFlightByIdController(int id) throws SQLException {
        ConsoleUtils.clear();
    
        Flight flight = viewFlightUseCase.viewFlightById(id);

        if (flight != null) {
            String border = "+----+-------------+-----------+------------+-------------+";
            String header = "| id |    date     |   price   |   origin   |   destiny   |";

            System.out.println(border);
            System.out.println(header);
            System.out.println(border);

            System.out.printf("| %-2d | %-10s | %-14.2f | %-12s | %-12s |%n",
                flight.getId(),
                flight.getTrip_date(),
                flight.getPrice_trip(),
                flight.getOrig_city_name(),
                flight.getDest_city_name()
            );
            
        System.out.println(border);
        } else {
            System.out.println("No flights found with the given id.");
        }
        ConsoleUtils.waitWindow();
    }

    public void viewFlightByIdController() throws SQLException {
        ConsoleUtils.clear();
        System.out.println("Enter the id of the Flight: ");
        int op = ConsoleUtils.verifyingIntNoRange();
        getFlightByIdController(op);
    }

    // -------------------------
    // UPDATE FLIGHT INFORMATION

    public List<Flight> getAllFlightsController() throws SQLException{
        ConsoleUtils.clear();
        String border = "+----+-------------+-----------+------------+-------------+";
        String header = "| id |    date     |   price   |   origin   |   destiny   |";
        List<Flight> flights = updateFlightUseCase.findAllFlights();

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Flight flight : flights) {
            System.out.printf("| %-2d | %-10s | %-14.2f | %-12s | %-12s |%n",
                flight.getId(),
                flight.getTrip_date(),
                flight.getPrice_trip(),
                flight.getOrig_city_name(),
                flight.getDest_city_name()
            );       
        }
        System.out.println(border);
        return flights;
    }

    public void updateFlightController() throws SQLException {
        getAllFlightsController();

        String data_double = "DOUBLE(7, 2)";
        String data_varchar = "VARCHAR";

        String REGEX_ONLY_DIGITS = "^\\d+$";
        String REGEX_ONLY_LETTERS = "^[a-zA-Z]+$";
        String REGEX_DOUBLE_7_2 = "^\\d{1,5}(\\.\\d{1,2})?$";


        System.out.println("Please enter the id of the flight fare to edit");
        String id = ConsoleUtils.verifyingStringFormat(REGEX_ONLY_DIGITS, "numbers only");
        ConsoleUtils.clear();

        
        
        System.out.println("--------------------------------------\n" +
        "       Please select an option:       \n" +
        "--------------------------------------\n" +
        "\n" +
        "1. Update trip date\n" +
        "2. Update price trip\n" +
        "3. Update origin city\n" +
        "4. Update destiny city\n" +
        "5. Go back"
        );

        int op = ConsoleUtils.verifyEntryInt(1, 5);
    }

}
