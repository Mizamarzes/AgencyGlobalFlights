package com.agencyglobalflights.admin.airportmanage.domain.service;

import java.sql.SQLException;

import com.agencyglobalflights.admin.airportmanage.domain.entity.Airport;

public interface AirportService {

    Airport viewAirportInfo(String id) throws SQLException;
    void createAirport(Airport airport) throws SQLException;
}
