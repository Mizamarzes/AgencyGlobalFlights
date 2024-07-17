package com.agencyglobalflights.admin.documentmanagement.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.documentmanagement.domain.service.DocTypeService;

public class DeleteDocTypeUseCase {

    private final DocTypeService docTypeService;

    public DeleteDocTypeUseCase(DocTypeService docTypeService) {
        this.docTypeService = docTypeService;
    }

    public void deleteType(int id) throws SQLException {
        docTypeService.deleteType(id);
    }
}
