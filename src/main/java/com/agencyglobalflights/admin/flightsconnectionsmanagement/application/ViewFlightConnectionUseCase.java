package com.agencyglobalflights.admin.flightsconnectionsmanagement.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightConnection;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.service.FlightConnectionService;

public class ViewFlightConnectionUseCase {
    private final FlightConnectionService flightConnectionService;

    public ViewFlightConnectionUseCase(FlightConnectionService flightConnectionService) {
        this.flightConnectionService = flightConnectionService;
    }

    public FlightConnection FlightConnectionByIdFlight(int id) throws SQLException {
        FlightConnection flightConnection = flightConnectionService.FlightConnectionByIdFlight(id);
        return flightConnection;
    }
}
