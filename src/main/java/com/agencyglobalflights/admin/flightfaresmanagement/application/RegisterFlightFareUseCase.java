package com.agencyglobalflights.admin.flightfaresmanagement.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightfaresmanagement.domain.entity.FlightFare;
import com.agencyglobalflights.admin.flightfaresmanagement.domain.service.FlightFareService;

public class RegisterFlightFareUseCase {
    private final FlightFareService flightFareService;

    // Register flight fare
    public RegisterFlightFareUseCase(FlightFareService flightFareService) {
        this.flightFareService = flightFareService;
    }

    public void flightFareRegister(FlightFare flightFare) throws SQLException{
        flightFareService.flightFareRegister(flightFare);
    }
}
