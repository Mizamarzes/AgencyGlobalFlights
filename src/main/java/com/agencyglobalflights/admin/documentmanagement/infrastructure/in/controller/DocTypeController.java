package com.agencyglobalflights.admin.documentmanagement.infrastructure.in.controller;

import com.agencyglobalflights.admin.documentmanagement.application.CreateDocTypeUseCase;
import com.agencyglobalflights.admin.documentmanagement.application.DeleteDocTypeUseCase;
import com.agencyglobalflights.admin.documentmanagement.application.UpdateDocTypeUseCase;
import com.agencyglobalflights.admin.documentmanagement.application.ViewDocTypesUseCase;

public class DocTypeController {

    private ViewDocTypesUseCase viewDocsUc;
    private UpdateDocTypeUseCase updateDocsUc;
    private CreateDocTypeUseCase createDocsUc;
    private DeleteDocTypeUseCase deleteDocsUc;
    
    public DocTypeController(ViewDocTypesUseCase viewDocsUc, UpdateDocTypeUseCase updateDocsUc,
            CreateDocTypeUseCase createDocsUc, DeleteDocTypeUseCase deleteDocsUc) {
        this.viewDocsUc = viewDocsUc;
        this.updateDocsUc = updateDocsUc;
        this.createDocsUc = createDocsUc;
        this.deleteDocsUc = deleteDocsUc;
    }

    
}
