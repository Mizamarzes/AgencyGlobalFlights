package com.agencyglobalflights.customer.flightssection.application;

import java.sql.SQLException;

import com.agencyglobalflights.customer.flightssection.domain.FlightsSectionService;

public class CalculateTotalUseCase {

    private final FlightsSectionService flightsSectionService;

    public CalculateTotalUseCase(FlightsSectionService flightsSectionService) {
        this.flightsSectionService = flightsSectionService;
    }

    public double calculateTotal(int idFlight, int idFare) throws SQLException {
        double totalPrice = flightsSectionService.calculateTotal(idFlight, idFare);
        
        return totalPrice;
    }

}
