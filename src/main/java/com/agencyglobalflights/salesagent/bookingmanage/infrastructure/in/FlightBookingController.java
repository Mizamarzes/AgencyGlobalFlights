package com.agencyglobalflights.salesagent.bookingmanage.infrastructure.in;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.salesagent.bookingmanage.application.CreateFlightBookingUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.application.DeleteFlightBookingUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.application.ViewFlightBookingsUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.domain.entity.FlightBooking;

public class FlightBookingController {

    private CreateFlightBookingUseCase createBookingUC;
    private DeleteFlightBookingUseCase deleteBookingUC;
    private ViewFlightBookingsUseCase viewBookingsUC;

    public FlightBookingController(CreateFlightBookingUseCase createBookingUC, DeleteFlightBookingUseCase deleteBookingUC, ViewFlightBookingsUseCase viewBookingsUC) {
        this.createBookingUC = createBookingUC;
        this.deleteBookingUC = deleteBookingUC;
        this.viewBookingsUC = viewBookingsUC;
    }

    public void CreateBooking() throws SQLException {

        // MOSTRAR TODOS LOS CLIENTES

        //SOLICITAR ID CLIENTE

        //SOLICITAR FECHA

        //MOSTRAR TODOS LOS VUELOS
        //SOLICITAR VUELO

        //MOSTRAR TODAS LAS TARIFAS
        //SOLICITARTARIFA

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
