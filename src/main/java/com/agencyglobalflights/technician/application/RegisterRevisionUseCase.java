package com.agencyglobalflights.technician.application;

import java.sql.SQLException;

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
}
