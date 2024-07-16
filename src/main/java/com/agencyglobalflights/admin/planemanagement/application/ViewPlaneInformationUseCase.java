package com.agencyglobalflights.admin.planemanagement.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.admin.planemanagement.domain.service.PlaneService;

public class ViewPlaneInformationUseCase {
    private final PlaneService planeService;

    public ViewPlaneInformationUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public Plane viewPlaneByPlates(String id) throws SQLException {
        Plane plane = planeService.viewPlaneByPlates(id);
        return plane;
    }

}
