package com.agencyglobalflights.salesagent.bookingmanage.infrastructure.in;

import java.io.Console;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.documentmanagement.domain.entity.DocumentType;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.in.controller.FlightFareController;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller.FlightController;
import com.agencyglobalflights.salesagent.bookingmanage.application.CreateFlightBookingUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.application.DeleteFlightBookingUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.application.ViewFlightBookingsUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.domain.entity.FlightBooking;
import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightBookingController {

    private CreateFlightBookingUseCase createBookingUC;
    private DeleteFlightBookingUseCase deleteBookingUC;
    private ViewFlightBookingsUseCase viewBookingsUC;
    private FlightController flightController;
    private FlightFareController flightFareController;

    
    
    public FlightBookingController(CreateFlightBookingUseCase createBookingUC,
            DeleteFlightBookingUseCase deleteBookingUC, ViewFlightBookingsUseCase viewBookingsUC,
            FlightController flightController, FlightFareController flightFareController) {
        this.createBookingUC = createBookingUC;
        this.deleteBookingUC = deleteBookingUC;
        this.viewBookingsUC = viewBookingsUC;
        this.flightController = flightController;
        this.flightFareController = flightFareController;
    }

    public void CreateBooking() throws SQLException {
        String REGEX_ONLY_DIGITS = "^\\d+$";
        ConsoleUtils.clear();

        System.out.println("Please enter the Client ID: ");
        String idCustomer = ConsoleUtils.verifyingStringFormat(REGEX_ONLY_DIGITS, "numbers only");
        
        System.out.println("Enter the new trip date: ");
        Date bookingDate = ConsoleUtils.verifyDate();

        //MOSTRAR TODOS LOS VUELOS DE LA FECHA "bookingDate"
        flightController.getFlightsByDateController(bookingDate);

        System.out.println("Please select a Flight ");
        int idFlight = ConsoleUtils.verifyingIntNoRange();

        //MOSTRAR TODAS LAS TARIFAS
        flightFareController.getAllFlightFaresController();

        System.out.println("Please select a Flight Fare ");
        int idFare = ConsoleUtils.verifyingIntNoRange();

        FlightBooking newBooking = new FlightBooking(bookingDate, idFlight, idCustomer, idFare);
        createBookingUC.createFlightBooking(newBooking);
    }

    public boolean viewFlightBookings() throws SQLException {
        boolean getOut = false;
        String border = "+------+------------+--------+-------------+------+";
        String header = "|  Id  |    Date    | Flight | Customer ID | Fare |";

        List<FlightBooking> bookings = new ArrayList<>();
        String REGEX_ONLY_DIGITS = "^\\d+$";
        String columnName;
        String idObject;

        // PREGUNTAR BUSCAR POR CLIENTE O POR VUELO
        
        ConsoleUtils.clear();
        System.out.println("--------------------------------------\n" +
        "       Please select an option:       \n" +
        "--------------------------------------\n" +
        "\n" +
        "1. Search by Customer ID\n" +
        "2. Search by Flight ID\n" +
        "3. Go back"
        );
        
        int op = ConsoleUtils.verifyEntryInt(1, 3);

        switch (op) {
            case 1:
                ConsoleUtils.clear();
                System.out.println("Enter the Customer ID: ");
                idObject = ConsoleUtils.verifyingStringFormat(REGEX_ONLY_DIGITS, "numbers only");
                columnName = "idcustomer";
                bookings = viewBookingsUC.viewFlightBookings(columnName, idObject);
                break;
            case 2:
                ConsoleUtils.clear();
                System.out.println("Enter the Flight ID: ");
                idObject = ConsoleUtils.verifyingStringFormat(REGEX_ONLY_DIGITS, "numbers only");
                columnName = "idflight";
                bookings = viewBookingsUC.viewFlightBookings(columnName, idObject);
                break;
            case 3:
                getOut = true;
                break;
            default:
                getOut = false;
                break;
        }

        ConsoleUtils.clear();
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (FlightBooking flightBooking : bookings) {
            System.out.printf("| %-4d | %-6s | %-6d | %-11s | %-4d |\n",
            flightBooking.getId(), flightBooking.getDate(), flightBooking.getIdFlight(),
            flightBooking.getIdCostumer(), flightBooking.getIdfares());
        }
        System.out.println(border);
        return getOut;
    }

    public void deleteFlightBooking() throws SQLException {

        boolean returnIsTrue = viewFlightBookings();

        if (returnIsTrue) {
            return;
        }

        System.out.println("Please select a Booking to Delete: ");
        int id = ConsoleUtils.verifyingIntNoRange();

        System.out.println("Are you Sure?\n" +
        "1. NO\n" +
        "2. YES\n");
        int conf = ConsoleUtils.verifyEntryInt(1, 2);
        if (conf == 2) {
            deleteBookingUC.deleteFlightBooking(id);
            System.out.println("Revision successfully eliminated.");
        } else {
            System.out.println("Elimination canceled.");
        }
        ConsoleUtils.waitWindow();
    }  

}
