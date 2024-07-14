package com.agencyglobalflights.admin.planemanagement.domain.service;

import java.sql.SQLException;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;

public interface PlaneService {
    
    void planeRegister(Plane plane) throws SQLException;
}
