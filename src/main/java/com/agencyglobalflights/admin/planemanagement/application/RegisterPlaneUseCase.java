package com.agencyglobalflights.admin.planemanagement.application;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Airline;
import com.agencyglobalflights.admin.planemanagement.domain.entity.Model;
import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.admin.planemanagement.domain.entity.PlaneStatus;
import com.agencyglobalflights.admin.planemanagement.domain.service.AirlineService;
import com.agencyglobalflights.admin.planemanagement.domain.service.PlaneService;

public class RegisterPlaneUseCase {
    private final PlaneService planeService;
    private final AirlineService airlineService;

    public RegisterPlaneUseCase(PlaneService planeService, AirlineService airlineService) {
        this.planeService = planeService;
        this.airlineService = airlineService;
    }
    

    public void planeRegister(Plane plane) throws SQLException{
        planeService.planeRegister(plane);
    }

    public List<Model> getAllModels() throws SQLException {
        List<Model> models = planeService.findAllModels();
        return models;
    }

    public List<PlaneStatus> getAllStatuses() throws SQLException {
        List<PlaneStatus> statuses = planeService.findAllStatuses();
        return statuses;
    }

    public List<Airline> getAllAirlines() throws SQLException {
        List<Airline> airlines = airlineService.findAllAirlines();
        return airlines;
    }
}
