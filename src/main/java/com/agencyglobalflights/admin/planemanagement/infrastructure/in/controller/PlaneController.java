package com.agencyglobalflights.admin.planemanagement.infrastructure.in.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.application.DeletePlaneUseCase;
import com.agencyglobalflights.admin.planemanagement.application.RegisterPlaneUseCase;
import com.agencyglobalflights.admin.planemanagement.application.UpdatePlaneUseCase;
import com.agencyglobalflights.admin.planemanagement.application.ViewPlaneInformationUseCase;
import com.agencyglobalflights.admin.planemanagement.domain.entity.Airline;
import com.agencyglobalflights.admin.planemanagement.domain.entity.Model;
import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.admin.planemanagement.domain.entity.PlaneStatus;
import com.agencyglobalflights.utils.ConsoleUtils;

public class PlaneController {
    private RegisterPlaneUseCase registerPlaneUseCase;
    private ViewPlaneInformationUseCase viewPlaneInformationUseCase;
    private DeletePlaneUseCase deletePlaneUseCase;
    private UpdatePlaneUseCase updatePlaneUseCase;

    public PlaneController(RegisterPlaneUseCase registerPlaneUseCase,
            ViewPlaneInformationUseCase viewPlaneInformationUseCase,
            DeletePlaneUseCase deletePlaneUseCase,
            UpdatePlaneUseCase updatePlaneUseCase) {
        this.registerPlaneUseCase = registerPlaneUseCase;
        this.viewPlaneInformationUseCase = viewPlaneInformationUseCase;
        this.deletePlaneUseCase = deletePlaneUseCase;
        this.updatePlaneUseCase = updatePlaneUseCase;
    }    
    
    // -------------------------
    // REGISTER PLANE

    public List<PlaneStatus> getAllStatuses() throws SQLException {
        ConsoleUtils.clear();
        String border = "+----+-----------------+";
        String header = "| id |     Status      |";
        List<PlaneStatus> statuses = registerPlaneUseCase.getAllStatuses();

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (PlaneStatus status : statuses) {
            System.out.printf("|  %-2d| %-15s |%n",
            status.getId(), status.getName());          
        }
        System.out.println(border);
        return statuses;
    }

    public List<Model> getAllModels() throws SQLException {
        ConsoleUtils.clear();
        String border = "+----+--------------------+";
        String header = "| id |       Model        |";
        List<Model> models = registerPlaneUseCase.getAllModels();

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Model model : models) {
            System.out.printf("|  %-2d| %-18s |%n",
            model.getId(), model.getName());          
        }
        System.out.println(border);
        return models;
    }

    public List<Airline> getAllAirlines() throws SQLException {
        ConsoleUtils.clear();
        String border = "+----+-------------------------+";
        String header = "| id |         Airline         |";
        List<Airline> airlines = registerPlaneUseCase.getAllAirlines();

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Airline airline : airlines) {
            System.out.printf("|  %-2d| %-23s |%n",
            airline.getId(), airline.getName());          
        }
        System.out.println(border);
        return airlines;
    }

    public void registerPlaneController() throws SQLException {
        ConsoleUtils.clear();
        System.out.println("Enter the plane plate: ");
        String id = ConsoleUtils.verifyEntryString();

        System.out.println("Enter the plane capacity: ");
        int capacity = ConsoleUtils.verifyingIntNoRange();

        System.out.println("Enter the date of manufacture (yyyy-mm-dd): ");
        Date fabrication_date = ConsoleUtils.verifyDate();

        getAllStatuses();
        System.out.println("Select the plane Status: ");
        int id_status = ConsoleUtils.verifyingIntNoRange();

        getAllModels();
        System.out.println("Select the plane Model: ");
        int id_model = ConsoleUtils.verifyingIntNoRange();

        getAllAirlines();
        System.out.println("Select the airline for the plane: ");
        int id_airline = ConsoleUtils.verifyingIntNoRange();

        Plane newPlane = new Plane(id, capacity, fabrication_date, id_status, id_model, id_airline);
        registerPlaneUseCase.planeRegister(newPlane);
    }

    // -------------------------
    // VIEW PLANE INFORMATION

    public void getPLaneByPlateController() throws SQLException {
        ConsoleUtils.clear();
        System.out.print("Enter the plate of the plane: ");
        String plate = ConsoleUtils.verifyEntryString();

        Plane plane = viewPlaneInformationUseCase.viewPlaneByPlates(plate);

        if (plane != null) {
            String border = "+--------+---------+-------------------+------------+----------+------------+";
            String header = "|   ID   | Capacity | Fabrication Date  | Status | Model | Airline  |";

            System.out.println(border);
            System.out.println(header);
            System.out.println(border);

            System.out.printf("| %-2s | %-7d | %-17s | %-9s | %-7s | %-9s |%n",
                plane.getId(),
                plane.getCapacity(),
                plane.getFabrication_date(),
                plane.getStatus_name(),
                plane.getModel_name(),
                plane.getAirline_name()
            );
        System.out.println(border);
        } else {
            System.out.println("No plane found with the given plate.");
        }
        ConsoleUtils.waitWindow();
    }

    // -------------------------
    // UPDATE PLANE

    public List<Plane> findAllPlanes() throws SQLException {
        ConsoleUtils.clear();
        String border = "+--------+---------+-------------------+-----------+----------+------------+";
        String header = "|   ID   | Capacity | Fabrication Date  | Status ID | Model ID | Airline ID |";
        List<Plane> planes = updatePlaneUseCase.findAllPlanes();
    
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
    
        for (Plane plane : planes) {
            System.out.printf("| %-2s | %-7d | %-17s | %-9d | %-7d | %-9d |%n",
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
    
    public void updatePlaneController() throws SQLException {
        findAllPlanes();
        System.out.println("\n" + "Please enter the plate of the Plane to edit:");
        String id = ConsoleUtils.verifyEntryString();
        ConsoleUtils.clear();
        viewPlaneInformationUseCase.viewPlaneByPlates(id);
        ConsoleUtils.waitWindow();

        String data_int = "INT";
        String data_varchar = "VARCHAR";
        String data_date = "DATE";


        System.out.println("--------------------------------------\n" +
        "       Please select an option:       \n" +
        "--------------------------------------\n" +
        "\n" +
        "1. Update Capacity\n" +
        "2. Update Fabrication Date\n" +
        "3. Update Status\n" +
        "4. Update Model\n" +
        "5. Update Airline\n" +
        "6. Go back"
        );

        int op = ConsoleUtils.verifyEntryInt(1, 6);

        switch (op) {

            case 1:

                // ConsoleUtils.clear();     
                // System.out.println("Enter the new Capacity: ");
                // int new_capacity = ConsoleUtils.verifyingIntNoRange();
                // updatePlaneUseCase.updatePlaneColumnIntAndVarchar(id, "capacity", new_capacity, data_int);;
                // ConsoleUtils.waitWindow();
                break;

            case 2:

                // ConsoleUtils.clear();
                // vaUseCase.findAllCities();
                // System.out.println("Enter the new City: ");
                // int new_city = ConsoleUtils.verifyingIntNoRange();
                // updtUseCase.updateCity(id, new_city);
                // ConsoleUtils.waitWindow();
                break;

            case 3:

                // ConsoleUtils.clear();
                // System.out.println("Enter the new Code/Id: ");
                // String new_id = ConsoleUtils.verifyEntryString();
                // updtUseCase.updateId(id, new_id);
                // ConsoleUtils.waitWindow();
                break;

            case 4:

                // ConsoleUtils.clear();
                // System.out.println("Enter the new Code/Id: ");
                // String new_id = ConsoleUtils.verifyEntryString();
                // updtUseCase.updateId(id, new_id);
                // ConsoleUtils.waitWindow();
                break;

            case 5:

                // ConsoleUtils.clear();
                // System.out.println("Enter the new Code/Id: ");
                // String new_id = ConsoleUtils.verifyEntryString();
                // updtUseCase.updateId(id, new_id);
                // ConsoleUtils.waitWindow();
                break;

            case 6:

                return;
            default:

                break;
        }
    }


    // -------------------------
    // DELETE PLANE

    public void deletePlaneController() throws SQLException {
        ConsoleUtils.clear();
        System.out.println("Please, enter the plate of the plane to delete: ");
        String id = ConsoleUtils.verifyEntryString();
        System.out.println("Are you Sure?\n" +
            "1. NO\n" +
            "2. YES\n");
        int conf = ConsoleUtils.verifyEntryInt(1, 2);

        if (conf == 2) {
            deletePlaneUseCase.deletePlane(id);
            System.out.println("Plane succesfully eliminated.");
        } else {
            System.out.println("Elimination canceled.");
        }
        ConsoleUtils.waitWindow();
    }
}
