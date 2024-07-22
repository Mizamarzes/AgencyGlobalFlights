package com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.in.controller;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.flightfaresmanagement.application.DeleteFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.application.RegisterFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.application.UpdateFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.application.ViewFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.domain.entity.FlightFare;
import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightFareController {
    private ViewFlightFareUseCase viewflightFareUseCase;
    private RegisterFlightFareUseCase registerFlightFareUseCase;
    private UpdateFlightFareUseCase updateFlightFareUseCase;
    private DeleteFlightFareUseCase deleteFlightFareUseCase;

    public FlightFareController(ViewFlightFareUseCase viewflightFareUseCase,
        RegisterFlightFareUseCase registerFlightFareUseCase,
        UpdateFlightFareUseCase updateFlightFareUseCase,
        DeleteFlightFareUseCase deleteFlightFareUseCase) {
        this.viewflightFareUseCase = viewflightFareUseCase;
        this.registerFlightFareUseCase = registerFlightFareUseCase;
        this.updateFlightFareUseCase = updateFlightFareUseCase;
        this.deleteFlightFareUseCase = deleteFlightFareUseCase;
    }

    //SPECIAL CONSTRUCTOR FOR ONLY VIEW FLIGHT FARES
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
    }

    // -------------------------
    // REGISTER FLIGHT FARE

    public void RegisterFlightFareController() throws SQLException{
        ConsoleUtils.clear();
        System.out.println("Enter the name of the fare: ");
        String name_fare = ConsoleUtils.verifyEntryString();

        System.out.println("Enter the value of the fare: ");
        Double value_fare = ConsoleUtils.verifyingDouble();

        FlightFare newFlightFare = new FlightFare(name_fare, value_fare);
        registerFlightFareUseCase.flightFareRegister(newFlightFare);
    }

    // -------------------------
    // UPDATE FLIGHT FARE

    public void updateFlightFareController() throws SQLException {
        getAllFlightFaresController();

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
        "1. Update name\n" +
        "2. Update value\n" +
        "3. Go back"
        );

        int op = ConsoleUtils.verifyEntryInt(1, 3);

        switch (op) {
            case 1:
                ConsoleUtils.clear();
                System.out.println("Enter the new name: ");
                String new_name = ConsoleUtils.verifyingStringFormat(REGEX_ONLY_LETTERS, "letters only");
                updateFlightFareUseCase.updateFlightFare(id, "name", new_name, data_varchar);
                ConsoleUtils.waitWindow();
                break;

            case 2:
                ConsoleUtils.clear();
                System.out.println("Enter the new value: ");
                String new_value = ConsoleUtils.verifyingStringFormat(REGEX_DOUBLE_7_2, "XXXX.XX");
                updateFlightFareUseCase.updateFlightFare(id, "value", new_value, data_double);
                ConsoleUtils.waitWindow();
                break;
            case 3:
                
                return;
        
            default:
                break;
        }
    }

    // -------------------------
    // DELETE FLIGHT FARE

    public void deleteFlightFareController() throws SQLException {
        ConsoleUtils.clear();
        getAllFlightFaresController();
        System.out.println("Please, enter the id of the flight fare to delete:");
        int id = ConsoleUtils.verifyingIntNoRange();
        System.out.println("Are you Sure?\n" +
            "1. NO\n" +
            "2. YES\n");
        int conf = ConsoleUtils.verifyEntryInt(1, 2);

        if (conf == 2) {
            deleteFlightFareUseCase.deleteFlightFare(id);
            System.out.println("Flight fare succesfully eliminated.");
        } else {
            System.out.println("Elimination canceled.");
        }
        ConsoleUtils.waitWindow();
    }
}
