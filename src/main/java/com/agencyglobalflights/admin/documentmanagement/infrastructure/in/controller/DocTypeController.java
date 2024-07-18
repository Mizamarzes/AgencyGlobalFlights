package com.agencyglobalflights.admin.documentmanagement.infrastructure.in.controller;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.documentmanagement.application.CreateDocTypeUseCase;
import com.agencyglobalflights.admin.documentmanagement.application.DeleteDocTypeUseCase;
import com.agencyglobalflights.admin.documentmanagement.application.UpdateDocTypeUseCase;
import com.agencyglobalflights.admin.documentmanagement.application.ViewDocTypesUseCase;
import com.agencyglobalflights.admin.documentmanagement.domain.entity.DocumentType;
import com.agencyglobalflights.utils.ConsoleUtils;

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

    public List<DocumentType> viewAllTypes() throws SQLException{
        List<DocumentType> alltypes = viewDocsUc.viewAllTypes();
        String border = "+------+----------------------------------+";
        String header = "|  id  |               name               |";

        ConsoleUtils.clear();
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (DocumentType documentType : alltypes) {
            System.out.printf("| %-4d | %-32s |\n",
            documentType.getId(), documentType.getName());
        }
        System.out.println(border);

        return alltypes; 
    }

    public void CreateType() throws SQLException {
        ConsoleUtils.clear();

        System.out.println("Enter the Document Type Name: ");
        String name = ConsoleUtils.verifyEntryString();

        DocumentType documentType = new DocumentType(name);
        createDocsUc.CreateType(documentType);
    }
 
    public void deleteType() throws SQLException {
        ConsoleUtils.clear();
        viewAllTypes();

        System.out.println("Please select a Document Type to Delete: ");
        int id = ConsoleUtils.verifyingIntNoRange();

        System.out.println("Are you Sure?\n" +
            "1. NO\n" +
            "2. YES\n");

        int conf = ConsoleUtils.verifyEntryInt(1, 2);

        if (conf == 2) {
            deleteDocsUc.deleteType(id);
            System.out.println("Document Type successfully eliminated.\n" +
                                " ");
        } else {
            System.out.println("Elimination canceled.\n" +
                                " ");
        }
        ConsoleUtils.waitWindow();  
    }

    public void updateType() throws SQLException {
        viewAllTypes();
        System.out.println("Please select a Document Type to Edit: ");
        int id = ConsoleUtils.verifyingIntNoRange();
        System.out.println("Please Enter the new Document type Name");
        String newName = ConsoleUtils.verifyEntryString();
        ConsoleUtils.clear();
        updateDocsUc.UpdateDocType(newName, id);
    }

}
