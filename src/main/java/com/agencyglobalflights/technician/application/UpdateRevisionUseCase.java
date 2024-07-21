package com.agencyglobalflights.technician.application;

import java.sql.Date;
import java.sql.SQLException;

import com.agencyglobalflights.technician.domain.service.RevisionService;

public class UpdateRevisionUseCase {

    private final RevisionService revisionService;

    public UpdateRevisionUseCase(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    public void updateRevDate(int id, Date newdate) throws SQLException {
        revisionService.updateRevDate(id, newdate);
    }

    public void updateRevPlane(int id, String newPlane) throws SQLException {
        revisionService.updateRevPlane(id, newPlane);
    }

    public void updateRevEmpl(int id, String newEmpl) throws SQLException {
        revisionService.updateRevEmpl(id, newEmpl);
    }

    public void updateRevDesc(int id, String newDesc) throws SQLException {
        revisionService.updateRevDesc(id, newDesc);
    }

    

}
