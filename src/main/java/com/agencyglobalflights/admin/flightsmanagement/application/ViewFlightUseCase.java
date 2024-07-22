package com.agencyglobalflights.admin.flightsmanagement.application;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.flightsmanagement.domain.entity.Flight;
import com.agencyglobalflights.admin.flightsmanagement.domain.service.FlightService;

public class ViewFlightUseCase {
    private final FlightService flightService;

    public ViewFlightUseCase(FlightService flightService) {
        this.flightService = flightService;
    }

    public Flight viewFlightById(int id) throws SQLException{
        Flight flight = flightService.viewFlightById(id);
        return flight;
    }

    public List<Flight> getFlightsByDate(Date insertedDate) throws SQLException {
        List <Flight> filteredFlights = flightService.getFlightsByDate(insertedDate);
        return filteredFlights;
    }
}
