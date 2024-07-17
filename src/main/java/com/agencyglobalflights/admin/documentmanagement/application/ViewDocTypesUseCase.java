package com.agencyglobalflights.admin.documentmanagement.application;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.documentmanagement.domain.entity.DocumentType;
import com.agencyglobalflights.admin.documentmanagement.domain.service.DocTypeService;

public class ViewDocTypesUseCase {

    private final DocTypeService docTypeService;

    public ViewDocTypesUseCase(DocTypeService docTypeService) {
        this.docTypeService = docTypeService;
    }

    public List<DocumentType> viewAllTypes() throws SQLException {
        List<DocumentType> allTypes = docTypeService.viewAllTypes();
        return allTypes;
    }
}
