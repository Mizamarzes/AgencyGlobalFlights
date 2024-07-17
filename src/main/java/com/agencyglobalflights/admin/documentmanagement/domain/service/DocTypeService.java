package com.agencyglobalflights.admin.documentmanagement.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.documentmanagement.domain.entity.DocumentType;

public interface DocTypeService {

    List<DocumentType> viewAllTypes() throws SQLException;
    void createType(DocumentType documentType) throws SQLException;
    void deleteType(int id) throws SQLException;

    //UPDATE
    // void updateType() throws SQLException;

}
