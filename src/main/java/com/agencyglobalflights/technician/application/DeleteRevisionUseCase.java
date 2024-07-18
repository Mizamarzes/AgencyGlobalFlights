package com.agencyglobalflights.technician.application;

import java.sql.SQLException;

import com.agencyglobalflights.technician.domain.service.RevisionService;

public class DeleteRevisionUseCase {

    private final RevisionService revisionService;

    public DeleteRevisionUseCase(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    public void deleteRevision(int id) throws SQLException {
        revisionService.deleteRevision(id);
    }
}
