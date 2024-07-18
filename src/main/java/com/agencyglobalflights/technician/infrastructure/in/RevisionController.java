package com.agencyglobalflights.technician.infrastructure.in;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.technician.application.DeleteRevisionUseCase;
import com.agencyglobalflights.technician.application.RegisterRevisionUseCase;
import com.agencyglobalflights.technician.application.ViewRevHistoryUseCase;
import com.agencyglobalflights.technician.domain.entity.Revision;
import com.agencyglobalflights.admin.planemanagement.infrastructure.in.controller.PlaneController;
import com.agencyglobalflights.utils.ConsoleUtils;

public class RevisionController {
    private DeleteRevisionUseCase delRevUc;
    private RegisterRevisionUseCase regRevUc;
    private ViewRevHistoryUseCase viewHisUc;
    private PlaneController planeController;

    public RevisionController(DeleteRevisionUseCase delRevUc, RegisterRevisionUseCase regRevUc, ViewRevHistoryUseCase viewHisUc) {
        this.delRevUc = delRevUc;
        this.regRevUc = regRevUc;
        this.viewHisUc = viewHisUc;
        this.planeController = planeController;
    }
    
    public void createRevision() throws SQLException {

        //mostrar todos los aviones
        planeController.findAllPlanes();
        System.out.println("Please Select the plane: ");
        String plane_id = ConsoleUtils.verifyEntryString();

        System.out.println("Please enter the date: ");
        Date date = ConsoleUtils.verifyDate();

        System.out.println("Pleas enter a description of the Revision: ");
        String description = ConsoleUtils.verifyEntryString();

        //mostrar todos los empleados
        System.out.println("select the employee in charge: ");

        Revision newRevision = new Revision(date, plane_id, description, description);
        regRevUc.registerRevision(newRevision);
    }

    public List<Revision> viewAllRevisions() throws SQLException {
        List<Revision> revisionHistory = viewHisUc.viewAllRevisions();

        String border = "+------+----------+-----------+--------------+-------------------------------+";
        String header = "|  id  |   date   |   plane   |   employee   |          description          |";

        ConsoleUtils.clear();
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Revision revision : revisionHistory) {
            System.out.printf("| %-4d | %-32s | %-9s | %-12s | %-29s |\n",
            revision.getId(), revision.getRevision_date(), revision.getId_plane(), revision.getId_emp(), revision.getDescription());
        }

        System.out.println(border);

        return revisionHistory;        
    }

    public void deleteRevision() throws SQLException {

        viewAllRevisions(); //mostrar todas las revisiones
        System.out.println("\n" + "Please select a Revision to delete:");
        int id = ConsoleUtils.verifyingIntNoRange();

        System.out.println("Are you Sure?\n" +
        "1. NO\n" +
        "2. YES\n");
        int conf = ConsoleUtils.verifyEntryInt(1, 2);
        if (conf == 2) {
            delRevUc.deleteRevision(id);
            System.out.println("Revision successfully eliminated.");
        } else {
            System.out.println("Elimination canceled.");
        }
        ConsoleUtils.waitWindow();   

    }

    public List<Revision> viewRevisionHistory() throws SQLException {
        
        // MOSTRAR TODOS LOS AVIONES
        System.out.println("Please select a plane by it plate: ");
        String id = ConsoleUtils.verifyEntryString();

        List<Revision> revisionHistory = viewHisUc.viewRevHistory(id);

        String border = "+------+----------+-----------+--------------+-------------------------------+";
        String header = "|  id  |   date   |   plane   |   employee   |          description          |";

        ConsoleUtils.clear();
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Revision revision : revisionHistory) {
            System.out.printf("| %-4d | %-32s | %-9s | %-12s | %-29s |\n",
            revision.getId(), revision.getRevision_date(), revision.getId_plane(), revision.getId_emp(), revision.getDescription());
        }

        System.out.println(border);

        return revisionHistory;        
    }






}
