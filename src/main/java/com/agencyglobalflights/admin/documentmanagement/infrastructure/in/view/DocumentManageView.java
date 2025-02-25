package com.agencyglobalflights.admin.documentmanagement.infrastructure.in.view;

import java.sql.SQLException;

import com.agencyglobalflights.admin.documentmanagement.application.CreateDocTypeUseCase;
import com.agencyglobalflights.admin.documentmanagement.application.DeleteDocTypeUseCase;
import com.agencyglobalflights.admin.documentmanagement.application.UpdateDocTypeUseCase;
import com.agencyglobalflights.admin.documentmanagement.application.ViewDocTypesUseCase;
import com.agencyglobalflights.admin.documentmanagement.domain.service.DocTypeService;
import com.agencyglobalflights.admin.documentmanagement.infrastructure.in.controller.DocTypeController;
import com.agencyglobalflights.admin.documentmanagement.infrastructure.out.DocTypeRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class DocumentManageView {

    public void showmenu() throws SQLException {
        DocTypeService ds = new DocTypeRepository();
        ViewDocTypesUseCase vduc = new ViewDocTypesUseCase(ds);
        UpdateDocTypeUseCase uduc = new UpdateDocTypeUseCase(ds);
        CreateDocTypeUseCase cduc = new CreateDocTypeUseCase(ds);
        DeleteDocTypeUseCase dduc = new DeleteDocTypeUseCase(ds);
        DocTypeController dtc = new DocTypeController(vduc, uduc, cduc, dduc);

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "         Documents Management          \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. View types of document \n" +
            "2. Update type of document\n" +
            "3. Register type of document\n" +
            "4. Delete type of document\n" +
            "5. Go back\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 5);

            switch (op) {
                case 1:
                    dtc.viewAllTypes();
                    ConsoleUtils.waitWindow();
                    break;
                case 2:
                dtc.updateType();
                    break;
                case 3:
                    dtc.CreateType();
                    break;
                case 4:
                    dtc.deleteType();
                    break;
                case 5:
                    return;
                default:
                    break;
            }

        } while (true);

    }
}
