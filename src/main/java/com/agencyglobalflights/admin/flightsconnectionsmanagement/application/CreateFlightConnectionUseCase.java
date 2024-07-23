package com.agencyglobalflights.admin.flightsconnectionsmanagement.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightConnection;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.service.FlightConnectionService;

public class CreateFlightConnectionUseCase {
    private final FlightConnectionService flightConnectionService;

    public CreateFlightConnectionUseCase(FlightConnectionService flightConnectionService) {
        this.flightConnectionService = flightConnectionService;
    }

    public void flightConnectionCreate(FlightConnection flightConnection) throws SQLException {
        flightConnectionService.flightConnectionCreate(flightConnection);
    }

    public boolean hasFlightConnections(int flightId) throws SQLException {
        return flightConnectionService.hasFlightConnections(flightId);
    }
}
