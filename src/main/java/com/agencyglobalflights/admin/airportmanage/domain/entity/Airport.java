package com.agencyglobalflights.admin.airportmanage.domain.entity;

public class Airport {

    private int id;
    private String name;
    private int idcity;
   
    public Airport() {
    }

    public Airport(int id, String name, int idcity) {
        this.id = id;
        this.name = name;
        this.idcity = idcity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdcity() {
        return idcity;
    }

    public void setIdcity(int idcity) {
        this.idcity = idcity;
    }
    
}
