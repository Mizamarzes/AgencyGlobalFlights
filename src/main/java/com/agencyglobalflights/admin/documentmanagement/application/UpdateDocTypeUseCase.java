package com.agencyglobalflights.admin.documentmanagement.application;

import com.agencyglobalflights.admin.documentmanagement.domain.service.DocTypeService;

public class UpdateDocTypeUseCase {

    private final DocTypeService docTypeService;

    public UpdateDocTypeUseCase(DocTypeService docTypeService) {
        this.docTypeService = docTypeService;
    }

}
