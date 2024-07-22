package com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity;

public class FlightConnection {
    private int id;
    private String connection_number;
    private int id_trip;
    private String date_trip;
    private String orig_city_name;
    private String dest_city_name;
    private String id_plane;
    private String dest_airport;
    public FlightConnection() {
    }

    // Constructor with id
    public FlightConnection(int id, String connection_number, int id_trip, String id_plane) {
        this.id = id;
        this.connection_number = connection_number;
        this.id_trip = id_trip;
        this.id_plane = id_plane;
    }

    // Constructor without id
    public FlightConnection(String connection_number, int id_trip, String id_plane, String dest_airport) {
        this.connection_number = connection_number;
        this.id_trip = id_trip;
        this.id_plane = id_plane;
        this.dest_airport = dest_airport;
    }

    // Constructor with names for show up
    public FlightConnection(int id, String connection_number, String date_trip, String orig_city_name,
            String dest_city_name, String id_plane, String dest_airport) {
        this.id = id;
        this.connection_number = connection_number;
        this.date_trip = date_trip;
        this.orig_city_name = orig_city_name;
        this.dest_city_name = dest_city_name;
        this.id_plane = id_plane;
        this.dest_airport = dest_airport;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConnection_number() {
        return connection_number;
    }

    public void setConnection_number(String connection_number) {
        this.connection_number = connection_number;
    }

    public int getId_trip() {
        return id_trip;
    }

    public void setId_trip(int id_trip) {
        this.id_trip = id_trip;
    }

    public String getDate_trip() {
        return date_trip;
    }

    public void setDate_trip(String date_trip) {
        this.date_trip = date_trip;
    }

    public String getOrig_city_name() {
        return orig_city_name;
    }

    public void setOrig_city_name(String orig_city_name) {
        this.orig_city_name = orig_city_name;
    }

    public String getDest_city_name() {
        return dest_city_name;
    }

    public void setDest_city_name(String dest_city_name) {
        this.dest_city_name = dest_city_name;
    }

    public String getId_plane() {
        return id_plane;
    }

    public void setId_plane(String id_plane) {
        this.id_plane = id_plane;
    }

    public String getDest_airport() {
        return dest_airport;
    }

    public void setDest_airport(String dest_airport) {
        this.dest_airport = dest_airport;
    }
}
