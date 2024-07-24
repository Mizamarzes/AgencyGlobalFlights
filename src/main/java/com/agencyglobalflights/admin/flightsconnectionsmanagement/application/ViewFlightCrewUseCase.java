package com.agencyglobalflights.admin.flightsconnectionsmanagement.application;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightCrew;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.service.FlightConnectionService;

public class ViewFlightCrewUseCase {
    private final FlightConnectionService flightConnectionService;

    public ViewFlightCrewUseCase(FlightConnectionService flightConnectionService) {
        this.flightConnectionService = flightConnectionService;
    }

    public List<FlightCrew> viewFlightCrewByIdFlight(int id) throws SQLException {
        List<FlightCrew> flightCrews = flightConnectionService.viewFlightsCrewsByIdFlight(id);
        return flightCrews;
    }
}
