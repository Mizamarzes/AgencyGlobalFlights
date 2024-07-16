package com.agencyglobalflights.admin.airportmanage.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.airportmanage.domain.entity.Airport;
import com.agencyglobalflights.admin.airportmanage.domain.entity.City;

public interface AirportService {

    Airport viewAirportInfo(String id) throws SQLException;
    void createAirport(Airport airport) throws SQLException;
    List<Airport> findAll() throws SQLException;
    void deleteAirport(String id) throws SQLException;
    List<City> findAllCities() throws SQLException;

    void updateName(String id, String newName) throws SQLException;
    void updateCity(String id, int newCity) throws SQLException;
    void updateId(String id, String newId) throws SQLException;

}
