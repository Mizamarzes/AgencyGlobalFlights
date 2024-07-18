package com.agencyglobalflights.admin.documentmanagement.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.documentmanagement.domain.service.DocTypeService;

public class UpdateDocTypeUseCase {

    private final DocTypeService docTypeService;

    public UpdateDocTypeUseCase(DocTypeService docTypeService) {
        this.docTypeService = docTypeService;
    }

    public void UpdateDocType(String newName, int id) throws SQLException {
        docTypeService.UpdateDocType(newName, id);
    }
}
