package com.agencyglobalflights.technician.infrastructure.in;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.technician.application.DeleteRevisionUseCase;
import com.agencyglobalflights.technician.application.RegisterRevisionUseCase;
import com.agencyglobalflights.technician.application.UpdateRevisionUseCase;
import com.agencyglobalflights.technician.application.ViewRevHistoryUseCase;
import com.agencyglobalflights.technician.domain.entity.Employee;
import com.agencyglobalflights.technician.domain.entity.Revision;

import com.agencyglobalflights.utils.ConsoleUtils;

public class RevisionController {
    private DeleteRevisionUseCase delRevUc;
    private RegisterRevisionUseCase regRevUc;
    private ViewRevHistoryUseCase viewHisUc;
    private UpdateRevisionUseCase updtruc;


    public RevisionController(DeleteRevisionUseCase delRevUc, RegisterRevisionUseCase regRevUc, ViewRevHistoryUseCase viewHisUc, UpdateRevisionUseCase updtruc) {
        this.delRevUc = delRevUc;
        this.regRevUc = regRevUc;
        this.viewHisUc = viewHisUc;
        this.updtruc = updtruc;

    }
    
    public void createRevision() throws SQLException {

        viewAllPlanes();
        System.out.println("Please Select the plane: ");
        String plane_id = ConsoleUtils.verifyEntryString();

        System.out.println("Please enter the date: ");
        Date date = ConsoleUtils.verifyDate();

        System.out.println("Pleas enter a description of the Revision: ");
        String description = ConsoleUtils.verifyEntryString();

        viewAllEmployees();
        System.out.println("select the employee in charge: ");
        String employeeid = ConsoleUtils.verifyEntryString();

        Revision newRevision = new Revision(date, plane_id, description, employeeid);
        regRevUc.registerRevision(newRevision);
    }

    public List<Revision> viewAllRevisions() throws SQLException {
        List<Revision> revisionHistory = viewHisUc.viewAllRevisions();

        String border = "+------+------------+-----------+--------------+-------------------------------+";
        String header = "|  id  |    date    |   plane   |   employee   |          description          |";

        ConsoleUtils.clear();
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Revision revision : revisionHistory) {
            System.out.printf("| %-4d | %-6s | %-9s | %-12s | %-29s |\n",
            revision.getId(), revision.getRevision_date(), revision.getId_plane(), revision.getId_emp(), revision.getDescription());
        }

        System.out.println(border);

        return revisionHistory;        
    }

    public void deleteRevision() throws SQLException {

        viewAllRevisions();
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
        ConsoleUtils.clear();
        viewAllPlanes();
        System.out.println("Please select a plane by it plate: ");
        String id = ConsoleUtils.verifyEntryString();

        List<Revision> revisionHistory = viewHisUc.viewRevHistory(id);

        String border = "+------+------------+-----------+--------------+-------------------------------+";
        String header = "|  id  |    date    |   plane   |   employee   |          description          |";

        ConsoleUtils.clear();
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Revision revision : revisionHistory) {
            System.out.printf("| %-4d | %-6s | %-9s | %-12s | %-29s |\n",
            revision.getId(), revision.getRevision_date(), revision.getId_plane(), revision.getId_emp(), revision.getDescription());
        }

        System.out.println(border);
        ConsoleUtils.waitWindow();

        return revisionHistory;        
    }

    public List<Plane> viewAllPlanes() throws SQLException {
        ConsoleUtils.clear();
        String border = "+--------+----------+------------------+-----------+----------+------------+";
        String header = "|   ID   | Capacity | Fabrication Date | Status ID | Model ID | Airline ID |";
        List<Plane> planes = regRevUc.viewAllPlanes();
    
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
    
        for (Plane plane : planes) {
            System.out.printf("| %-2s | %-8d | %-16s | %-9d | %-8d | %-10d |%n",
            plane.getId(),
            plane.getCapacity(),
            plane.getFabrication_date(),
            plane.getId_status(),
            plane.getId_model(),
            plane.getId_airline());
        }
        System.out.println(border);
        return planes;
    }

    public List<Employee> viewAllEmployees() throws SQLException {
        ConsoleUtils.clear();
        String border = "+----------+----------------------------------+---------+------------+------------+------------+";
        String header = "|    ID    |               Name               | Role id | Entry Date | Airline id | Airport id |";
        List<Employee> employees = regRevUc.viewAllEmployees();

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Employee employee : employees) {
            System.out.printf("| %8s | %-32s | %7d | %10s | %10d | %10s |\n",
                employee.getId(),
                employee.getName(),
                employee.getId_role(),
                employee.getEntryDate().toString(),
                employee.getId_airline(),
                employee.getId_airport());
        }

        System.out.println(border);
        return employees;
    }

    public void UpdateRevision() throws SQLException {
        viewAllRevisions();
        System.out.println("\n" + "Please select a Revision to edit:");
        int id = ConsoleUtils.verifyingIntNoRange();
        ConsoleUtils.clear();

        System.out.println("--------------------------------------\n" +
        "       Please select an option:       \n" +
        "--------------------------------------\n" +
        "\n" +
        "1. Update Date\n" +
        "2. Update Plane\n" +
        "3. Update Description\n" +
        "4. Update Employee\n" +
        "5. Go back"
        );

        int op = ConsoleUtils.verifyEntryInt(1, 5);
            
        switch (op) {

            case 1:
                // aqui se usa el procedure EditVarcharColumnIdVar

                //mirar planecontroller para ver como se hace
            
                ConsoleUtils.clear();     
                System.out.println("Enter the new Date: ");
                Date new_name = ConsoleUtils.verifyDate();
                
                ConsoleUtils.waitWindow();
                break;
            case 2:

                // aqui se usa el procedure EditIntColumnidVar

                ConsoleUtils.clear();
                viewAllPlanes();
                System.out.println("Select the new Plane: ");
                String newPlane = ConsoleUtils.verifyEntryString();
            
                ConsoleUtils.waitWindow();
                break;
            case 3:

                // aqui se usa el procedure EditVarcharColumnIdVar

                ConsoleUtils.clear();
                System.out.println("Enter the new description: ");
                String newDesc = ConsoleUtils.verifyEntryString();
                
                ConsoleUtils.waitWindow();
                break;
            case 4:
                ConsoleUtils.clear();
                System.out.println("Select the new Employee: ");
                String newEmp = ConsoleUtils.verifyEntryString();

            case 5:
                return;
            default:
                break;
        }
    }

}
