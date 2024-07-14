package com.agencyglobalflights.admin.planemanagement.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.admin.planemanagement.domain.service.PlaneService;

public class RegisterPlaneUseCase {
    private final PlaneService planeService;

    public RegisterPlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void planeRegister(Plane plane) throws SQLException{
        planeService.planeRegister(plane);
    }
}
