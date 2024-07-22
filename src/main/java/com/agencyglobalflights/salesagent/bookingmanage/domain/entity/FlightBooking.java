package com.agencyglobalflights.salesagent.bookingmanage.domain.entity;

import java.sql.Date;

public class FlightBooking {

    private int id;
    private Date date;
    private int idFlight;
    private String idCostumer;
    private int idfares;

    public FlightBooking() {
    }

    //WITHOUT ID

    public FlightBooking(Date date, int idFlight, String idCostumer, int idfares) {
        this.date = date;
        this.idFlight = idFlight;
        this.idCostumer = idCostumer;
        this.idfares = idfares;
    }

    //WITH ID

    public FlightBooking(int id, Date date, int idFlight, String idCostumer, int idfares) {
        this.id = id;
        this.date = date;
        this.idFlight = idFlight;
        this.idCostumer = idCostumer;
        this.idfares = idfares;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public String getIdCostumer() {
        return idCostumer;
    }

    public void setIdCostumer(String idCostumer) {
        this.idCostumer = idCostumer;
    }

    public int getIdfares() {
        return idfares;
    }

    public void setIdfares(int idfares) {
        this.idfares = idfares;
    }   

}
