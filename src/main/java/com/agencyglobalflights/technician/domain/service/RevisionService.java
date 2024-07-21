package com.agencyglobalflights.technician.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.technician.domain.entity.Employee;
import com.agencyglobalflights.technician.domain.entity.Revision;

public interface RevisionService {

    void registerRevision(Revision revision) throws SQLException;
    void deleteRevision(int id) throws SQLException;
    List<Revision> viewRevHistory(String id) throws SQLException;
    List<Revision> viewAllRevisions() throws SQLException;
    List<Plane> viewAllPlanes() throws SQLException;
    List<Employee> viewAllEmployees() throws SQLException;
    
    // void updateRevDate(int id) throws SQLException;
    // void updateRevPlane(int id) throws SQLException;
    // void updateRevDesc(int id) throws SQLException;
    // void updateRevEmpl(int id) throws SQLException;
}
