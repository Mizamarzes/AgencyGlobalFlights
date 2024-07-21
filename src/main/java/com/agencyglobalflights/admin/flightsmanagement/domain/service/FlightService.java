package com.agencyglobalflights.admin.flightsmanagement.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.flightsmanagement.domain.entity.Flight;

public interface FlightService {

    // View flight
    Flight viewFlightById(int id) throws SQLException;

    // Update flight
    void updateFlight(int id, String columnName, String newValue, String dataType) throws SQLException;
    List<Flight> findAllFlights() throws SQLException; 

    // Delete flight

}
