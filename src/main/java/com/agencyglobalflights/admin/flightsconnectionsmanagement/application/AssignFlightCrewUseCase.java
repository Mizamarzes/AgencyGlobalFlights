package com.agencyglobalflights.admin.flightsconnectionsmanagement.application;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.Employee;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightCrew;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.service.FlightConnectionService;

public class AssignFlightCrewUseCase {
    private final FlightConnectionService flightConnectionService;

    public AssignFlightCrewUseCase(FlightConnectionService flightConnectionService) {
        this.flightConnectionService = flightConnectionService;
    }

    public void flightCrewCreate(FlightCrew flightCrew) throws SQLException {
        flightConnectionService.flightCrewCreate(flightCrew);
    }

    public boolean hasFlightCrewAssigned(int flightConnection_id) throws SQLException {
        return flightConnectionService.hasFlightCrewAssigned(flightConnection_id);
    }

    public List<Employee> findAllEmployees() throws SQLException {
        List<Employee> employees = flightConnectionService.findAllEmployees();
        return employees;
    }
}
