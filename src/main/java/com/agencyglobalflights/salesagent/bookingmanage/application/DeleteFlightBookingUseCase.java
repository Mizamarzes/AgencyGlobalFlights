package com.agencyglobalflights.salesagent.bookingmanage.application;

import java.sql.SQLException;

import com.agencyglobalflights.salesagent.bookingmanage.domain.service.FlightBookingService;

public class DeleteFlightBookingUseCase {

    private final FlightBookingService flightBookingService;

    public DeleteFlightBookingUseCase(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    public void deleteFlightBooking(int id) throws SQLException {
        flightBookingService.deleteFlightBooking(id);
    }
}
