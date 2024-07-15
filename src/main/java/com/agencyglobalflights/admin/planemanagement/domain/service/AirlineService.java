package com.agencyglobalflights.admin.planemanagement.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Airline;

public interface AirlineService {

    List<Airline> findAllAirlines() throws SQLException;
}
