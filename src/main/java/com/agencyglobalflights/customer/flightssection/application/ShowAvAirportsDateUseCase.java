package com.agencyglobalflights.customer.flightssection.application;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.airportmanage.domain.entity.Airport;
import com.agencyglobalflights.customer.flightssection.domain.FlightsSectionService;

// este caso de uso busca los aeropuertos en los que hay vuelos disponibles la fecha ingresada
public class ShowAvAirportsDateUseCase {
    
    private final FlightsSectionService flightsSectionService;

    public ShowAvAirportsDateUseCase(FlightsSectionService flightsSectionService) {
        this.flightsSectionService = flightsSectionService;
    }

    public List<Airport> ShowAvAirportsDate(Date insertedDate) throws SQLException{
        List<Airport> filteredAirports = new ArrayList<>();
        filteredAirports = flightsSectionService.ShowAvAirportsDate(insertedDate);
        return filteredAirports;
    } 
}
