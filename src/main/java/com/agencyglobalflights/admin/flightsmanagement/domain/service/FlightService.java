package com.agencyglobalflights.admin.flightsmanagement.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.airportmanage.domain.entity.City;
import com.agencyglobalflights.admin.flightsmanagement.domain.entity.Flight;

public interface FlightService {

    // View flight
    Flight viewFlightById(int id) throws SQLException;

    // Update flight
    void updateFlight(String tableName, String columnName, String newValue, String dataType , String id) throws SQLException;
    List<Flight> findAllFlights() throws SQLException; 
    List<City> findAllCities() throws SQLException;

    // Delete flight
    void deleteFlight(int id) throws SQLException;
}
