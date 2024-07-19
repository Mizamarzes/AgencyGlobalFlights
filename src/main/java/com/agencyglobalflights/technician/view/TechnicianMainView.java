package com.agencyglobalflights.technician.view;

import java.sql.SQLException;

import com.agencyglobalflights.auth.infrastructure.out.UserRepository;
import com.agencyglobalflights.technician.application.DeleteRevisionUseCase;
import com.agencyglobalflights.technician.application.RegisterRevisionUseCase;
import com.agencyglobalflights.technician.application.UpdateRevisionUseCase;
import com.agencyglobalflights.technician.application.ViewRevHistoryUseCase;
import com.agencyglobalflights.technician.domain.service.RevisionService;
import com.agencyglobalflights.technician.infrastructure.in.RevisionController;
import com.agencyglobalflights.technician.infrastructure.out.RevisionRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class TechnicianMainView {

    @SuppressWarnings("unused")
    private String username;
    private String userRole;

    public TechnicianMainView(String username) throws SQLException {
        this.username = username;
        UserRepository userRep = new UserRepository();
        userRole = userRep.getUserRole(username);
    }

    public void showmenu() throws SQLException {
        RevisionService rs = new RevisionRepository();
        
        RegisterRevisionUseCase rruc = new RegisterRevisionUseCase(rs);
        DeleteRevisionUseCase delruc = new DeleteRevisionUseCase(rs);
        UpdateRevisionUseCase updtruc = new UpdateRevisionUseCase(rs);
        ViewRevHistoryUseCase vrevhuc = new ViewRevHistoryUseCase(rs);

        RevisionController rc = new RevisionController(delruc, rruc, updtruc, vrevhuc);

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "     Signed in as " + userRole +      "\n" +
            "---------------------------------------\n" +
            "    Global Flights Technician Panel    \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. Register revision\n" +
            "2. View plane revision history\n" +
            "3. Update revision information\n" +
            "4. Delete maintenance revision\n" +
            "5. Sign Out\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 5);


            switch (op) {
                case 1:
                    rc.createRevision();
                    break;
                case 2:
                    rc.viewRevisionHistory();
                    break;
                case 3:
                    break;
                case 4:
                    rc.deleteRevision();
                    break;
                case 5:
                    return;
                default:
                    break;
            }

        } while (true);

    }
}
