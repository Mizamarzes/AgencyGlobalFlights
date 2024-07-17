package com.agencyglobalflights.admin.planemanagement.domain.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Model;
import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.admin.planemanagement.domain.entity.PlaneStatus;

public interface PlaneService {
    
    // Register plane
    void planeRegister(Plane plane) throws SQLException;
    List<Model> findAllModels() throws SQLException;
    List<PlaneStatus> findAllStatuses() throws SQLException;

    // View plane information
    Plane viewPlaneByPlates(String id) throws SQLException;
    
    // Update plane information
    void updatePlaneColumnIntAndVarchar(String id, String columnName, String newValue, String dataType) throws SQLException;
    void updateFabricationDatePlane(String id, Date newDate) throws SQLException;
    List<Plane> findAllPlanes() throws SQLException;
    Plane viewPlaneInfo(String id) throws SQLException;

    // Delete plane
    void deletePlane(String id) throws SQLException;

    
}
