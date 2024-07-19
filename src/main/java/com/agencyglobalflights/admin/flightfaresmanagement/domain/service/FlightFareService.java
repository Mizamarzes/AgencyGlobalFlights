package com.agencyglobalflights.admin.flightfaresmanagement.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.flightfaresmanagement.domain.entity.FlightFare;

public interface FlightFareService {

    // View flight fares 
    List<FlightFare> findAllFlightFares() throws SQLException;
    FlightFare viewFlightFareById(int id) throws SQLException;

    // Register flight fare
    void flightFareRegister(FlightFare flightFare) throws SQLException;

    // Update flight fare
    void updateFlightFare(String id, String columnName, String newValue, String dataType) throws SQLException;

    // Delete flight fare
    void deleteFlightFare(int id) throws SQLException;
}
