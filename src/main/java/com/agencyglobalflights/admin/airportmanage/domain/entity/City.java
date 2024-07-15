package com.agencyglobalflights.admin.airportmanage.domain.entity;

public class City {
    private int id;
    private String name;
    private String idcountry;

    public City() {
    }

    public City(int id, String name, String idcountry) {
        this.id = id;
        this.name = name;
        this.idcountry = idcountry;
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

    public String getIdcountry() {
        return idcountry;
    }
    
    public void setIdcountry(String idcountry) {
        this.idcountry = idcountry;
    }


    
}
