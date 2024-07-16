package com.agencyglobalflights.admin.airportmanage.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.airportmanage.domain.service.AirportService;

public class DeleteAirpUseCase {

    private final AirportService airportService;

    public DeleteAirpUseCase(AirportService airportService) {
        this.airportService = airportService;
    }

    public void deleteAirport(String id) throws SQLException {
        airportService.deleteAirport(id);
    }
}
