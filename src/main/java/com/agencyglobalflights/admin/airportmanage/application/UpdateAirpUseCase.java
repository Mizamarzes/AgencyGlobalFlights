package com.agencyglobalflights.admin.airportmanage.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.airportmanage.domain.service.AirportService;

public class UpdateAirpUseCase {

    private final AirportService airportService;

    public UpdateAirpUseCase(AirportService airportService) {
        this.airportService = airportService;
    }

    public void updateName(String id, String newName) throws SQLException {
        airportService.updateName(id, newName);
    }

    public void updateCity(String id, int newCity) throws SQLException {
        airportService.updateCity(id, newCity);
    }

    public void updateId(String id, String newId) throws SQLException {
        airportService.updateId(id, newId);
    }

}
