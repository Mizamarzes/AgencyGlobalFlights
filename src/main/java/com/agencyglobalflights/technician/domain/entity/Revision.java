package com.agencyglobalflights.technician.domain.entity;

import java.sql.Date;

public class Revision {

    private int id;
    private Date revision_date;
    private String id_plane;
    private String description;
    private String id_emp;

    public Revision() {
    }

    //constructor without id
    public Revision(Date revision_date, String id_plane, String description, String id_emp) {
        this.revision_date = revision_date;
        this.id_plane = id_plane;
        this.description = description;
        this.id_emp = id_emp;
    }

    //constructor with id
    public Revision(int id, Date revision_date, String id_plane, String description, String id_emp) {
        this.id = id;
        this.revision_date = revision_date;
        this.id_plane = id_plane;
        this.description = description;
        this.id_emp = id_emp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRevision_date() {
        return revision_date;
    }

    public void setRevision_date(Date revision_date) {
        this.revision_date = revision_date;
    }

    public String getId_plane() {
        return id_plane;
    }

    public void setId_plane(String id_plane) {
        this.id_plane = id_plane;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId_emp() {
        return id_emp;
    }

    public void setId_emp(String id_emp) {
        this.id_emp = id_emp;
    }

    

    

}
