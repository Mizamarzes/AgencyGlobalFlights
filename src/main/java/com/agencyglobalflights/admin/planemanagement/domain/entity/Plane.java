package com.agencyglobalflights.admin.planemanagement.domain.entity;

import java.sql.Date;

public class Plane {
    private String id;
    private int capacity;
    private Date fabrication_date;
    private int id_status;
    private String status_name;
    private int id_model;
    private String model_name;
    private int id_airline;
    private String airline_name;

    // Default Constructor
    public Plane() {
    }

    // Constructor without id
    public Plane(int capacity, Date fabrication_date, int id_status, int id_model, int id_airline) {
        this.capacity = capacity;
        this.fabrication_date = fabrication_date;
        this.id_status = id_status;
        this.id_model = id_model;
        this.id_airline = id_airline;
    } 

    // Constructor with id
    public Plane(String id, int capacity, Date fabrication_date, int id_status, int id_model, int id_airline) {
        this.id = id;
        this.capacity = capacity;
        this.fabrication_date = fabrication_date;
        this.id_status = id_status;
        this.id_model = id_model;
        this.id_airline = id_airline;
    }

    // Constructor with names of variables
    public Plane(String id, int capacity, Date fabrication_date, String status_name, String model_name,
            String airline_name) {
        this.id = id;
        this.capacity = capacity;
        this.fabrication_date = fabrication_date;
        this.status_name = status_name;
        this.model_name = model_name;
        this.airline_name = airline_name;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getFabrication_date() {
        return fabrication_date;
    }

    public void setFabrication_date(Date fabrication_date) {
        this.fabrication_date = fabrication_date;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public int getId_model() {
        return id_model;
    }

    public void setId_model(int id_model) {
        this.id_model = id_model;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
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
    
}
