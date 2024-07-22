package com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.airportmanage.domain.entity.City;
import com.agencyglobalflights.admin.flightsmanagement.application.DeleteFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.application.UpdateFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.application.ViewFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.domain.entity.Flight;
import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightController {
    private ViewFlightUseCase viewFlightUseCase;
    private UpdateFlightUseCase updateFlightUseCase;
    private DeleteFlightUseCase deleteFlightUseCase;
    
    public FlightController(ViewFlightUseCase viewFlightUseCase, UpdateFlightUseCase updateFlightUseCase,
    DeleteFlightUseCase deleteFlightUseCase) {
        this.viewFlightUseCase = viewFlightUseCase;
        this.updateFlightUseCase = updateFlightUseCase;
        this.deleteFlightUseCase = deleteFlightUseCase;
    }

    // SPECIAL CONSTRUCTOR FOR ONLY VIEW FLIGHT INFORMATION

    public FlightController(ViewFlightUseCase viewFlightUseCase) {
        this.viewFlightUseCase = viewFlightUseCase;
    }


    public void getFlightByIdController(int id) throws SQLException {
        ConsoleUtils.clear();
    
        Flight flight = viewFlightUseCase.viewFlightById(id);

        if (flight != null) {
            String border = "+----+-------------+-----------+----------------+-----------------+";
            String header = "| id |    date     |   price   |     origin     |     destiny     |";

            System.out.println(border);
            System.out.println(header);
            System.out.println(border);

            System.out.printf("| %-2d | %-11s | %-9.2f | %-10s | %-9s |%n",
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

    public List<City> findAllCitiesController() throws SQLException {
        ConsoleUtils.clear();
        String border = "+------+--------------------------+-----------+";
        String header = "|  id  |           name           |  country  |";
        List<City> cities = updateFlightUseCase.findAllCities();
    
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
    
        for (City city : cities) {
            System.out.printf("| %-4d | %-24s | %-9s |%n",
            city.getId(), city.getName(), city.getIdcountry());
        }

        System.out.println(border);
        return cities;
    }

    public List<Flight> getAllFlightsController() throws SQLException{
        ConsoleUtils.clear();
        String border = "+----+-------------+-----------+----------------+-----------------+";
        String header = "| id |    date     |   price   |     origin     |     destiny     |";
        List<Flight> flights = updateFlightUseCase.findAllFlights();

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Flight flight : flights) {
            System.out.printf("| %-2d | %-11s | %-9.2f | %-14s | %-15s |%n",
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

    public List<Flight> getFlightsByDateController(Date insertedDate) throws SQLException {
        ConsoleUtils.clear();
        String border = "+----+-------------+-----------+----------------+-----------------+";
        String header = "| id |    date     |   price   |     origin     |     destiny     |";
        List<Flight> filteredFlights = viewFlightUseCase.getFlightsByDate(insertedDate);
        
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Flight flight : filteredFlights) {
            System.out.printf("| %-2d | %-11s | %-9.2f | %-14s | %-15s |%n",
                flight.getId(),
                flight.getTrip_date(),
                flight.getPrice_trip(),
                flight.getOrig_city_name(),
                flight.getDest_city_name()
            );       
        }
        System.out.println(border);
        return filteredFlights;
    }

    public void updateFlightController() throws SQLException {
        getAllFlightsController();

        String data_double = "DOUBLE(7, 2)";
        String data_date = "DATE";
        String data_int = "INT";

        System.out.println("Please enter the id of the flight fare to edit");
        String id = ConsoleUtils.verifyingIntREGEXString();
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


        switch (op) {
            case 1:
                ConsoleUtils.clear();
                System.out.println("Enter the new trip date: ");
                String new_tripDate = ConsoleUtils.verifyingDateREGEX();
                updateFlightUseCase.updateFlight("flight", "trip_date", new_tripDate, data_date, id);
                ConsoleUtils.waitWindow();
                break;

            case 2:
                ConsoleUtils.clear();
                System.out.println("Enter the new price trip: ");
                String new_priceTrip = ConsoleUtils.verifyingDoubleREGEX();
                updateFlightUseCase.updateFlight("flight", "price_trip", new_priceTrip, data_double, id);
                ConsoleUtils.waitWindow();
                break;
            case 3:
                ConsoleUtils.clear();
                findAllCitiesController();
                System.out.println("Enter the new origin city: ");
                String new_originCity = ConsoleUtils.verifyingIntREGEXString();
                updateFlightUseCase.updateFlight("flight", "orig_city", new_originCity, data_int, id);
                ConsoleUtils.waitWindow();
                break;
            
            case 4:
                ConsoleUtils.clear();
                findAllCitiesController();
                System.out.println("Enter the new destiny city: ");
                String new_destinyCity = ConsoleUtils.verifyingIntREGEXString();
                updateFlightUseCase.updateFlight("flight", "dest_city", new_destinyCity, data_int, id);
                ConsoleUtils.waitWindow();
                break;
            
            case 5:
                
                return;
        
            default:
                break;
        }
    }

    // -------------------------
    // DELETE FLIGHT 

    public void deleteFlightController() throws SQLException {
        ConsoleUtils.clear();
        getAllFlightsController();
        System.out.println("Please, enter the id of the flight to delete:");
        int id = ConsoleUtils.verifyingIntNoRange();
        System.out.println("Are you Sure?\n" +
            "1. NO\n" +
            "2. YES\n");
        int conf = ConsoleUtils.verifyEntryInt(1, 2);

        if (conf == 2) {
            deleteFlightUseCase.deleteFlight(id);
            System.out.println("Flight succesfully eliminated.");
        } else {
            System.out.println("Elimination canceled.");
        }
        ConsoleUtils.waitWindow();
    }
}
