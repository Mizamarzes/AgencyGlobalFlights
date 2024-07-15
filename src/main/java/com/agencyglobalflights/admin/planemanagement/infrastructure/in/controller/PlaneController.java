package com.agencyglobalflights.admin.planemanagement.infrastructure.in.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.application.RegisterPlaneUseCase;
import com.agencyglobalflights.admin.planemanagement.application.ViewPlaneInformationUseCase;
import com.agencyglobalflights.admin.planemanagement.domain.entity.Airline;
import com.agencyglobalflights.admin.planemanagement.domain.entity.Model;
import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.admin.planemanagement.domain.entity.PlaneStatus;
import com.agencyglobalflights.utils.ConsoleUtils;

public class PlaneController {
    private RegisterPlaneUseCase registerPlaneUseCase;
    private ViewPlaneInformationUseCase viewPlaneInformationUseCase;

    public PlaneController(RegisterPlaneUseCase registerPlaneUseCase,
            ViewPlaneInformationUseCase viewPlaneInformationUseCase) {
        this.registerPlaneUseCase = registerPlaneUseCase;
        this.viewPlaneInformationUseCase = viewPlaneInformationUseCase;
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
        String plates = ConsoleUtils.verifyEntryString();

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

        Plane newPlane = new Plane(plates, capacity, fabrication_date, id_status, id_model, id_airline);
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
            String border = "+----+--------------------+---------+-------------------+-----------+----------+-----------+";
            String header = "| ID | Plates             | Capacity| Fabrication Date  | Status ID | Model ID | Airline ID |";

            System.out.println(border);
            System.out.println(header);
            System.out.println(border);

            System.out.printf("|  %-2d| %-18s | %-7d | %-17s | %-9d | %-7d | %-9d |%n",
                plane.getId(),
                plane.getPlates(),
                plane.getCapacity(),
                plane.getFabrication_date(),
                plane.getId_status(),
                plane.getId_model(),
                plane.getId_airline()
            );
        System.out.println(border);
        } else {
            System.out.println("No plane found with the given plate.");
        }
    }
}
