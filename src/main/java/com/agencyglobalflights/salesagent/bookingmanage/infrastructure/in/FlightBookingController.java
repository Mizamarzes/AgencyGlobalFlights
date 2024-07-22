package com.agencyglobalflights.salesagent.bookingmanage.infrastructure.in;

import java.io.Console;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.flightfaresmanagement.application.ViewFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.domain.service.FlightFareService;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.in.controller.FlightFareController;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.out.FlightFareRepository;
import com.agencyglobalflights.admin.flightsmanagement.application.ViewFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.domain.service.FlightService;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller.FlightController;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.out.FlightRepository;
import com.agencyglobalflights.salesagent.bookingmanage.application.CreateFlightBookingUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.application.DeleteFlightBookingUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.application.ViewFlightBookingsUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.domain.entity.FlightBooking;
import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightBookingController {

    private CreateFlightBookingUseCase createBookingUC;
    private DeleteFlightBookingUseCase deleteBookingUC;
    private ViewFlightBookingsUseCase viewBookingsUC;

    public FlightBookingController(CreateFlightBookingUseCase createBookingUC, DeleteFlightBookingUseCase deleteBookingUC, ViewFlightBookingsUseCase viewBookingsUC) {
        this.createBookingUC = createBookingUC;
        this.deleteBookingUC = deleteBookingUC;
        this.viewBookingsUC = viewBookingsUC;
    }
    
    //services
    FlightService fs = new FlightRepository();
    FlightFareService ffs = new FlightFareRepository();
    
    //use cases
    ViewFlightUseCase vfuc = new ViewFlightUseCase(fs);
    ViewFlightFareUseCase vffuc = new ViewFlightFareUseCase(ffs);
    
    //controllers
    FlightController fc = new FlightController(vfuc);
    FlightFareController ffc = new FlightFareController(vffuc);


    public void CreateBooking() throws SQLException {
        String REGEX_ONLY_DIGITS = "^\\d+$";
        ConsoleUtils.clear();

        System.out.println("Please enter the Client ID: ");
        String idCustomer = ConsoleUtils.verifyingStringFormat(REGEX_ONLY_DIGITS, "numbers only");
        
        System.out.println("Enter the new trip date: ");
        Date bookingDate = ConsoleUtils.verifyDate();

        //MOSTRAR TODOS LOS VUELOS DE LA FECHA "bookingDate"
        fc.getFlightsByDateController(bookingDate);

        System.out.println("Please select a Flight ");
        int idFlight = ConsoleUtils.verifyingIntNoRange();

        //MOSTRAR TODAS LAS TARIFAS
        ffc.getAllFlightFaresController();

        System.out.println("Please select a Flight Fare ");
        int idFare = ConsoleUtils.verifyingIntNoRange();


    }

    public List<FlightBooking> viewFlightBookings() throws SQLException {
        List<FlightBooking> bookings = new ArrayList<>();
        
        // PREGUNTAR BUSCAR POR CLIENTE O POR VUELO

        // SI ES CLIENTE SE CAMBIA EL TIPO DE DATO DEL ID

        // SE PREGUNTA EL ID DE EL OBJETO QUE EL USUARIO SELECCIONO

        //SE EJECUTA EL PRODEDURE

        //SE IMPRIME LA TABLA

        //SE RETORNA LA LISTA DE BOOKINGS ENCONTRADOS
        return bookings;
    }

    public void deleteFlightBooking() throws SQLException {

        // EJECUTAR viewFlightBookings

        // SOLICITAR SELECCIONAR UNA DE LOS BOOKINGS RETORNADOS

        // PROCESO DE ELIMINAR
    }  

}
