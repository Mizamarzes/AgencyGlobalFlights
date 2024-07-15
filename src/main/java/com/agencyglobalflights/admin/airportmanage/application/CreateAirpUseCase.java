package com.agencyglobalflights.admin.airportmanage.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.airportmanage.domain.entity.Airport;
import com.agencyglobalflights.admin.airportmanage.domain.service.AirportService;

public class CreateAirpUseCase {

    private final AirportService airportService;

    public CreateAirpUseCase(AirportService airportService) {
        this.airportService = airportService;
    }

    public void createAirport(Airport airport) throws SQLException {
        airportService.createAirport(airport);
    }
}
