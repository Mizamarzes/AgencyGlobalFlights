package com.agencyglobalflights.admin.documentmanagement.application;

import java.sql.SQLException;

import com.agencyglobalflights.admin.documentmanagement.domain.entity.DocumentType;
import com.agencyglobalflights.admin.documentmanagement.domain.service.DocTypeService;

public class CreateDocTypeUseCase {

    private final DocTypeService docTypeService;

    public CreateDocTypeUseCase(DocTypeService docTypeService) {
        this.docTypeService = docTypeService;
    }

    public void CreateType(DocumentType documentType) throws SQLException {
        docTypeService.createType(documentType);
    }
}
