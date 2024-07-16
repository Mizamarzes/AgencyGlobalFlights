package com.agencyglobalflights.admin.airportmanage.application;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.airportmanage.domain.entity.Airport;
import com.agencyglobalflights.admin.airportmanage.domain.entity.City;
import com.agencyglobalflights.admin.airportmanage.domain.service.AirportService;

public class ViewAirpInfoUseCase {

    private final AirportService airportService;

    public ViewAirpInfoUseCase(AirportService airportService) {
        this.airportService = airportService;
    }

    public Airport viewAirportInfo(String id) throws SQLException {
        Airport airport = airportService.viewAirportInfo(id);
        return airport;
    }

    public List<Airport> findAllAirports() throws SQLException {
        List<Airport> airports = airportService.findAll();
        return airports;
    }

    public List<City> findAllCities() throws SQLException {
        List<City> cities = airportService.findAllCities();
        return cities;
    }

}
