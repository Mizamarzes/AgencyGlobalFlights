package com.agencyglobalflights.admin.flightfaresmanagement.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightfaresmanagement.domain.service.FlightFareService;

public class DeleteFlightFareUseCase {
    private final FlightFareService flightFareService;

    public DeleteFlightFareUseCase(FlightFareService flightFareService) {
        this.flightFareService = flightFareService;
    }

    public void deleteFlightFare(int id) throws SQLException{
        flightFareService.deleteFlightFare(id);
    }
}
