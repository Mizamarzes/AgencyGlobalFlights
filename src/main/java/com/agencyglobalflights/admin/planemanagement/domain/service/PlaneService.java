package com.agencyglobalflights.admin.planemanagement.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Model;
import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.admin.planemanagement.domain.entity.PlaneStatus;

public interface PlaneService {
    
    void planeRegister(Plane plane) throws SQLException;
    List<Model> findAllModels() throws SQLException;
    List<PlaneStatus> findAllStatuses() throws SQLException;

}
