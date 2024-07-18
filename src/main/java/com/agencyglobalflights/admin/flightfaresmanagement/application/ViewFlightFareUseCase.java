package com.agencyglobalflights.admin.flightfaresmanagement.application;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.flightfaresmanagement.domain.entity.FlightFare;
import com.agencyglobalflights.admin.flightfaresmanagement.domain.service.FlightFareService;

public class ViewFlightFareUseCase {
    private final FlightFareService flightFareService;

    public ViewFlightFareUseCase(FlightFareService flightFareService) {
        this.flightFareService = flightFareService;
    }

    // View flight fares
    public List<FlightFare> findAllFlightFares() throws SQLException{
        List<FlightFare> flightFares = flightFareService.findAllFlightFares();
        return flightFares;
    }

    public FlightFare viewFlightFareById(int id) throws SQLException{
        FlightFare flightFare = flightFareService.viewFlightFareById(id);
        return flightFare;
    }

}
