package com.agencyglobalflights.admin.planemanagement.application;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.admin.planemanagement.domain.service.PlaneService;

public class UpdatePlaneUseCase {
    private final PlaneService planeService;

    public UpdatePlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void updatePlaneColumnIntAndVarchar(String id, String columnName, String newValue, String dataType) throws SQLException{
        planeService.updatePlaneColumnIntAndVarchar(id, columnName, newValue, dataType);
    }

    public void updateFabricationDatePlane(String id, Date newDate) throws SQLException{
        planeService.updateFabricationDatePlane(id, newDate);
    }

    public List<Plane> findAllPlanes() throws SQLException {
        List<Plane> planes = planeService.findAllPlanes();
        return planes;
    }

    public Plane viewPlaneInfo(String id) throws SQLException {
        Plane plane = planeService.viewPlaneInfo(id);
        return plane;
    }
}
