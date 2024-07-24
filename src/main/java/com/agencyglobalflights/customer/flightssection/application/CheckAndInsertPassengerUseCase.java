package com.agencyglobalflights.customer.flightssection.application;

import java.sql.SQLException;

import com.agencyglobalflights.customer.flightssection.domain.FlightsSectionService;
import com.agencyglobalflights.customer.flightssection.domain.entity.Passenger;

public class CheckAndInsertPassengerUseCase {

    private final FlightsSectionService flightsSectionService;

    public CheckAndInsertPassengerUseCase(FlightsSectionService flightsSectionService) {
        this.flightsSectionService = flightsSectionService;
    }

    public void checkAndInsertPassenger(Passenger passenger) throws SQLException {
        flightsSectionService.checkAndInsertPassenger(passenger);
    }

}
