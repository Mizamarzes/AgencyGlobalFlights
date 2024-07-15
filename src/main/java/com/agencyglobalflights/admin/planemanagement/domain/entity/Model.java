package com.agencyglobalflights.admin.planemanagement.domain.entity;

public class Model {
    private int id;
    private String name;
    private int idmanufacturer;


    public Model() {
    }


    public Model(int id, String name, int idmanufacturer) {
        this.id = id;
        this.name = name;
        this.idmanufacturer = idmanufacturer;
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


    public int getIdmanufacturer() {
        return idmanufacturer;
    }


    public void setIdmanufacturer(int idmanufacturer) {
        this.idmanufacturer = idmanufacturer;
    }
 
}
