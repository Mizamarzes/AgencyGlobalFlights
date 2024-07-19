package com.agencyglobalflights.admin.flightfaresmanagement.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightfaresmanagement.domain.service.FlightFareService;

public class UpdateFlightFareUseCase {
    private final FlightFareService flightFareService;

    public UpdateFlightFareUseCase(FlightFareService flightFareService) {
        this.flightFareService = flightFareService;
    }

    public void updateFlightFare(String id, String columnName, String newValue, String dataType) throws SQLException{
        flightFareService.updateFlightFare(id, columnName, newValue, dataType);
    }
}
