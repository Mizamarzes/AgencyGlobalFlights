package com.agencyglobalflights.admin.flightsconnectionsmanagement.application;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightConnection;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.service.FlightConnectionService;

public class UpdateFlightConnectionUsecase {
    private final FlightConnectionService flightConnectionService;

    public UpdateFlightConnectionUsecase(FlightConnectionService flightConnectionService) {
        this.flightConnectionService = flightConnectionService;
    }

    public void updateFlightConnection(String id, String columnName, String newValue, String dataType) throws SQLException {
        flightConnectionService.updateFlightConnection(id, columnName, newValue, dataType);
    }

    public List<FlightConnection> findAllFlightConnections() throws SQLException {
        List<FlightConnection> flightConnections = flightConnectionService.findAllFlightConnections();
        return flightConnections;
    }
}
