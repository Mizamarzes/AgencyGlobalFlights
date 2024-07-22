package com.agencyglobalflights.admin.flightsmanagement.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightsmanagement.domain.service.FlightService;

public class DeleteFlightUseCase {
    private final FlightService flightService;

    public DeleteFlightUseCase(FlightService flightService) {
        this.flightService = flightService;
    }

    public void deleteFlight(int id) throws SQLException{
        flightService.deleteFlight(id);
    }
}
