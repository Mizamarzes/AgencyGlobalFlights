package com.agencyglobalflights.salesagent.bookingmanage.application;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.salesagent.bookingmanage.domain.entity.FlightBooking;
import com.agencyglobalflights.salesagent.bookingmanage.domain.service.FlightBookingService;

public class ViewFlightBookingsUseCase {

    private final FlightBookingService flightBookingService;

    public ViewFlightBookingsUseCase(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    public List<FlightBooking> viewFlightBookings() throws SQLException {
        List<FlightBooking> bookings = flightBookingService.viewFlightBookings();
        return bookings;
    }
}
