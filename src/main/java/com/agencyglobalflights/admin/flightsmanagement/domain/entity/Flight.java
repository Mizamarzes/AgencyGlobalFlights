package com.agencyglobalflights.admin.flightsmanagement.domain.entity;

import java.sql.Date;

public class Flight {
    private int id;
    private Date trip_date;
    private Double price_trip;
    private int orig_city;
    private String orig_city_name;
    private int dest_city;
    private String dest_city_name;

    // Default Constructor
    public Flight() {
    }

    // Constructor withoud id
    public Flight(Date trip_date, Double price_trip, int orig_city, int dest_city) {
        this.trip_date = trip_date;
        this.price_trip = price_trip;
        this.orig_city = orig_city;
        this.dest_city = dest_city;
    }

    // Constructor with id
    public Flight(int id, Date trip_date, Double price_trip, int orig_city, int dest_city) {
        this.id = id;
        this.trip_date = trip_date;
        this.price_trip = price_trip;
        this.orig_city = orig_city;
        this.dest_city = dest_city;
    }

    // Constructor with string names
    public Flight(int id, Date trip_date, Double price_trip, String orig_city_name, String dest_city_name) {
        this.id = id;
        this.trip_date = trip_date;
        this.price_trip = price_trip;
        this.orig_city_name = orig_city_name;
        this.dest_city_name = dest_city_name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTrip_date() {
        return trip_date;
    }

    public void setTrip_date(Date trip_date) {
        this.trip_date = trip_date;
    }

    public Double getPrice_trip() {
        return price_trip;
    }

    public void setPrice_trip(Double price_trip) {
        this.price_trip = price_trip;
    }

    public int getOrig_city() {
        return orig_city;
    }

    public void setOrig_city(int orig_city) {
        this.orig_city = orig_city;
    }

    public String getOrig_city_name() {
        return orig_city_name;
    }

    public void setOrig_city_name(String orig_city_name) {
        this.orig_city_name = orig_city_name;
    }

    public int getDest_city() {
        return dest_city;
    }

    public void setDest_city(int dest_city) {
        this.dest_city = dest_city;
    }

    public String getDest_city_name() {
        return dest_city_name;
    }

    public void setDest_city_name(String dest_city_name) {
        this.dest_city_name = dest_city_name;
    }
}
