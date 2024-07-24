package com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity;

import java.sql.Date;

public class Employee {
    private String id;
    private String name;
    private int id_role;
    private String role_name;
    private Date entryDate;
    private int id_airline;
    private String airline_name;
    private String id_airport;
    private String airport_name;
    
    // Default constructor
    public Employee() {
    }

    // Constructor
    public Employee(String id, String name, int id_role, Date entryDate, int id_airline, String id_airport) {
        this.id = id;
        this.name = name;
        this.id_role = id_role;
        this.entryDate = entryDate;
        this.id_airline = id_airline;
        this.id_airport = id_airport;
    }

    // Constructor for show up information
    public Employee(String id, String name, String role_name, Date entryDate, String airline_name,
            String airport_name) {
        this.id = id;
        this.name = name;
        this.role_name = role_name;
        this.entryDate = entryDate;
        this.airline_name = airline_name;
        this.airport_name = airport_name;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public int getId_airline() {
        return id_airline;
    }

    public void setId_airline(int id_airline) {
        this.id_airline = id_airline;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public String getId_airport() {
        return id_airport;
    }

    public void setId_airport(String id_airport) {
        this.id_airport = id_airport;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }

    

}
