package com.agencyglobalflights.admin.flightsmanagement.application;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.airportmanage.domain.entity.City;
import com.agencyglobalflights.admin.flightsmanagement.domain.entity.Flight;
import com.agencyglobalflights.admin.flightsmanagement.domain.service.FlightService;

public class UpdateFlightUseCase {
    private final FlightService flightService;

    public UpdateFlightUseCase(FlightService flightService) {
        this.flightService = flightService;
    }

    public void updateFlight(String tableName, String columnName, String newValue, String dataType , String id) throws SQLException {
        flightService.updateFlight(tableName, columnName, newValue, dataType, id);
    }

    public List<Flight> findAllFlights() throws SQLException {
        List<Flight> flights = flightService.findAllFlights();
        return flights;
    }

    public List<City> findAllCities() throws SQLException {
        List<City> cities = flightService.findAllCities();
        return cities;
    }
}
