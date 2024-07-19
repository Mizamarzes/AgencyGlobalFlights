package com.agencyglobalflights.technician.application;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.technician.domain.entity.Employee;
import com.agencyglobalflights.technician.domain.entity.Revision;
import com.agencyglobalflights.technician.domain.service.RevisionService;

public class RegisterRevisionUseCase {

    private final RevisionService revisionService;

    public RegisterRevisionUseCase(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    public void registerRevision(Revision revision) throws SQLException {
        revisionService.registerRevision(revision);
    }

    public List<Plane> viewAllPlanes() throws SQLException {
        List<Plane> allPlanes = revisionService.viewAllPlanes();
        return allPlanes;
    }

    public List<Employee> viewAllEmployees() throws SQLException {
        List<Employee> allEmployees = revisionService.viewAllEmployees();
        return allEmployees;
    }
}
