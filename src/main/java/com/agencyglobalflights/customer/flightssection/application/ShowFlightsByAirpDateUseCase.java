package com.agencyglobalflights.customer.flightssection.application;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.flightsmanagement.domain.entity.Flight;
import com.agencyglobalflights.customer.flightssection.domain.FlightsSectionService;

public class ShowFlightsByAirpDateUseCase {

    private final FlightsSectionService flightsSectionService;

    public ShowFlightsByAirpDateUseCase(FlightsSectionService flightsSectionService) {
        this.flightsSectionService = flightsSectionService;
    }

    public List<Flight> ShowFlightsByAirpDate(Date insertedDate, String selectedAirport) throws SQLException {
        List<Flight> flights = new ArrayList<>();
        flights = flightsSectionService.showFlightsByAirpDate(insertedDate, selectedAirport);
        
        return flights;
    }

}
