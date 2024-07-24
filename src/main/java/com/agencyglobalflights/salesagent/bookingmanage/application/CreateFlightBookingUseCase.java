package com.agencyglobalflights.salesagent.bookingmanage.application;

import java.sql.SQLException;

import com.agencyglobalflights.salesagent.bookingmanage.domain.entity.FlightBooking;
import com.agencyglobalflights.salesagent.bookingmanage.domain.service.FlightBookingService;

public class CreateFlightBookingUseCase {

    private final FlightBookingService flightBookingService;
    
    public CreateFlightBookingUseCase(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    public int createFlightBooking(FlightBooking flightBooking) throws SQLException {
        int newBookingid = flightBookingService.createFlightBooking(flightBooking);  

        return newBookingid;
    }
}
