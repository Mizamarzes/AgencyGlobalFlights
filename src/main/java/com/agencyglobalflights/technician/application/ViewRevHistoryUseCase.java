package com.agencyglobalflights.technician.application;

import java.security.PublicKey;
import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.technician.domain.entity.Revision;
import com.agencyglobalflights.technician.domain.service.RevisionService;

public class ViewRevHistoryUseCase {

    private final RevisionService revisionService;

    public ViewRevHistoryUseCase(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    public List<Revision> viewRevHistory(String id) throws SQLException {
        List<Revision> revisionHistory = revisionService.viewRevHistory(id);
        return revisionHistory;
    }

    public List<Revision> viewAllRevisions() throws SQLException {
        List<Revision> allRevisions = revisionService.viewAllRevisions();
        return allRevisions;
    }
}
