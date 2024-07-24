package com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.Employee;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightConnection;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightCrew;

public interface FlightConnectionService {

    // Create flight connection
    void flightConnectionCreate(FlightConnection flightConnection) throws SQLException;
    boolean hasFlightConnections(int flightId) throws SQLException;

    // Assign crew flight
    void flightCrewCreate(FlightCrew flightCrew) throws SQLException;
    boolean hasFlightCrewAssigned(int flightConnection_id) throws SQLException;
    List<Employee> findAllEmployees() throws SQLException;

    // View flight connection
    FlightConnection FlightConnectionByIdFlight(int id) throws SQLException;

    // View flight crew
    List<FlightCrew> viewFlightsCrewsByIdFlight(int id) throws SQLException;

    // update flight connection
    void updateFlightConnection(String id, String columnName, String newValue, String dataType) throws SQLException;
    List<FlightConnection> findAllFlightConnections() throws SQLException;

    // delete flight connection
    void deleteFlightConnection(int id) throws SQLException;
    
}
