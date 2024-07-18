package com.agencyglobalflights.admin.flightfaresmanagement.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.flightfaresmanagement.domain.entity.FlightFare;

public interface FlightFareService {

    // View flight fares 
    List<FlightFare> findAllFlightFares() throws SQLException;
    FlightFare viewFlightFareById(int id) throws SQLException;
}
