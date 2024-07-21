package com.agencyglobalflights.admin.flightsmanagement.application;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.flightsmanagement.domain.entity.Flight;
import com.agencyglobalflights.admin.flightsmanagement.domain.service.FlightService;

public class UpdateFlightUseCase {
    private final FlightService flightService;

    public UpdateFlightUseCase(FlightService flightService) {
        this.flightService = flightService;
    }

    public void updateFlight(int id, String columnName, String newValue, String dataType) throws SQLException{
        flightService.updateFlight(id, columnName, newValue, dataType);
    }

    public List<Flight> findAllFlights() throws SQLException {
        List<Flight> flights = flightService.findAllFlights();
        return flights;
    }
}
