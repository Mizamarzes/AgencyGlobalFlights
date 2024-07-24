package com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity;

public class FlightCrew {
    private String id_employee;
    private int id_flight_connection;

    // Default Constructor
    public FlightCrew() {
    }

    // Constructor
    public FlightCrew(String id_employee, int id_flight_connection) {
        this.id_employee = id_employee;
        this.id_flight_connection = id_flight_connection;
    }

    // Getters and Setters
    public String getId_employee() {
        return id_employee;
    }

    public void setId_employee(String id_employee) {
        this.id_employee = id_employee;
    }

    public int getId_flight_connection() {
        return id_flight_connection;
    }

    public void setId_flight_connection(int id_flight_connection) {
        this.id_flight_connection = id_flight_connection;
    }

   
    

    
}
