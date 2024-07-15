package com.agencyglobalflights.admin.airportmanage.domain.entity;

public class Airport {

    private String id;
    private String name;
    private int idcity;
   
    public Airport() {
    }

    public Airport(String id, String name, int idcity) {
        this.id = id;
        this.name = name;
        this.idcity = idcity;
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

    public int getIdcity() {
        return idcity;
    }

    public void setIdcity(int idcity) {
        this.idcity = idcity;
    }
    
}
