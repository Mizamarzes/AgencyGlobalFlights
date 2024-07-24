package com.agencyglobalflights.salesagent.bookingmanage.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.salesagent.bookingmanage.domain.entity.FlightBooking;

public interface FlightBookingService {

    List<FlightBooking> viewFlightBookings(String columnName, String idObject) throws SQLException;
    void createFlightBooking(FlightBooking flightBooking) throws SQLException;
    void deleteFlightBooking(int id) throws SQLException;

}
