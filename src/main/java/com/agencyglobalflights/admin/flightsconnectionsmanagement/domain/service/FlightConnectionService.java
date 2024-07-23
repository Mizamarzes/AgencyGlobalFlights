package com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.service;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightConnection;

public interface FlightConnectionService {

    // Create flight connection
    void flightConnectionCreate(FlightConnection flightConnection) throws SQLException;
    boolean hasFlightConnections(int flightId) throws SQLException;
    
}
