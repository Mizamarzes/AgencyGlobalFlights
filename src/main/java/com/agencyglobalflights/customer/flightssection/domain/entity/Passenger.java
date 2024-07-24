package com.agencyglobalflights.customer.flightssection.domain.entity;

import java.sql.Date;

public class Passenger {
    private String id;
    private String name;
    private Date birthDate;
    private String cel;
    private int idFlightBooking;

    public Passenger() {
    }

    public Passenger(String id, String name, Date birthDate, String cel, int idFlightBooking) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.cel = cel;
        this.idFlightBooking = idFlightBooking;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public int getIdFlightBooking() {
        return idFlightBooking;
    }

    public void setIdFlightBooking(int idFlightBooking) {
        this.idFlightBooking = idFlightBooking;
    }  

}
