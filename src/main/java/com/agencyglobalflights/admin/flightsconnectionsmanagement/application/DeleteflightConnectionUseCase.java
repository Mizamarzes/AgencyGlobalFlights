package com.agencyglobalflights.admin.flightsconnectionsmanagement.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.service.FlightConnectionService;

public class DeleteflightConnectionUseCase {
    private final FlightConnectionService flightConnectionService;

    public DeleteflightConnectionUseCase(FlightConnectionService flightConnectionService) {
        this.flightConnectionService = flightConnectionService;
    }

    public void deleteFlightConnection(int id) throws SQLException {
        flightConnectionService.deleteFlightConnection(id);
    }
}
