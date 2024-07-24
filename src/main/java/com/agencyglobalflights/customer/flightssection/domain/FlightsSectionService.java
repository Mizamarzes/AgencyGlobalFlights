package com.agencyglobalflights.customer.flightssection.domain;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.airportmanage.domain.entity.Airport;
import com.agencyglobalflights.admin.flightsmanagement.domain.entity.Flight;
import com.agencyglobalflights.customer.flightssection.domain.entity.Passenger;
import com.agencyglobalflights.salesagent.customermanage.domain.entity.Customer;

public interface FlightsSectionService {

    List<Airport> ShowAvAirportsDate(Date insertedDate) throws SQLException;

    List<Flight> showFlightsByAirpDate(Date insertedDate, String selectedAirport) throws SQLException;

    void checkAndInsertPassenger(Passenger passenger) throws SQLException;

    void checkAndInsertCustomer(Customer customer) throws SQLException;
}
