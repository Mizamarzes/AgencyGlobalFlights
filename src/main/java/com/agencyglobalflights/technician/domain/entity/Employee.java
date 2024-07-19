package com.agencyglobalflights.technician.domain.entity;

import java.sql.Date;

public class Employee {
    private String id;
    private String name;
    private int id_role;
    private Date entryDate;
    private int id_airline;
    private String id_airport;

    public Employee() {
    }

    public Employee(String id, String name, int id_role, Date entryDate, int id_airline,String id_airport) {
        this.id = id;
        this.name = name;
        this.id_role = id_role;
        this.entryDate = entryDate;
        this.id_airline = id_airline;
        this.id_airport = id_airport;
    }

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

    public String getId_airport() {
        return id_airport;
    }

    public void setId_airport(String id_airport) {
        this.id_airport = id_airport;
    }

    
    
}
