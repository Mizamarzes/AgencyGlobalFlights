package com.agencyglobalflights.admin.planemanagement.application;


import java.sql.SQLException;

import com.agencyglobalflights.admin.planemanagement.domain.service.PlaneService;

public class DeletePlaneUseCase {
    private final PlaneService planeService;

    public DeletePlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void deletePlane(String id) throws SQLException{
        planeService.deletePlane(id);
    }

    
}
