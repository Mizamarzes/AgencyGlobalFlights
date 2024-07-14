package com.agencyglobalflights.admin.planemanagement.infrastructure.in.controller;

import java.sql.Date;
import java.sql.SQLException;

import com.agencyglobalflights.admin.planemanagement.application.RegisterPlaneUseCase;
import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.utils.ConsoleUtils;

public class PlaneController {
    private RegisterPlaneUseCase registerPlaneUseCase;

    public PlaneController(RegisterPlaneUseCase registerPlaneUseCase) {
        this.registerPlaneUseCase = registerPlaneUseCase;
    }
    
    public void registerPlaneController() throws SQLException {
        ConsoleUtils.clear();
        System.out.println("Enter plates: ");
        String plates = ConsoleUtils.verifyEntryString();

        System.out.println("Enter the plane capacity: ");
        int capacity = ConsoleUtils.verifyingIntNoRange();

        System.out.println("Enter the date of manufacture (yyyy-mm-dd): ");
        Date fabrication_date = ConsoleUtils.verifyDate();

        System.out.println("Enter the status of the plane");
        int id_status = ConsoleUtils.verifyingIntNoRange();

        System.out.println("Enter the model of the plane");
        int id_model = ConsoleUtils.verifyingIntNoRange();

        System.out.println("Enter the airline of the plane");
        int id_airline = ConsoleUtils.verifyingIntNoRange();

        Plane newPlane = new Plane(plates, capacity, fabrication_date, id_status, id_model, id_airline);
        registerPlaneUseCase.planeRegister(newPlane);
    }
}
