package com.agencyglobalflights.technician.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.technician.domain.entity.Revision;

public interface RevisionService {

    void registerRevision(Revision revision) throws SQLException;
    void deleteRevision(int id) throws SQLException;
    List<Revision> viewRevHistory(String id) throws SQLException;
    List<Revision> viewAllRevisions() throws SQLException;
}
