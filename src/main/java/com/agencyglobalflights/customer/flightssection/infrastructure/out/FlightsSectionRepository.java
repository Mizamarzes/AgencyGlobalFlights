package com.agencyglobalflights.customer.flightssection.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;

import com.agencyglobalflights.admin.airportmanage.domain.entity.Airport;
import com.agencyglobalflights.admin.flightsmanagement.domain.entity.Flight;
import com.agencyglobalflights.customer.flightssection.domain.FlightsSectionService;
import com.agencyglobalflights.customer.flightssection.domain.entity.Passenger;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;
import com.agencyglobalflights.salesagent.customermanage.domain.entity.Customer;

public class FlightsSectionRepository implements FlightsSectionService{

    private Connection connection;

    public FlightsSectionRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Airport> ShowAvAirportsDate(Date insertedDate) throws SQLException{
        List<Airport> filteredAirports = new ArrayList<>();
        String query = "{CALL showAirportByFlightDate(?)}";

        try (CallableStatement cs = connection.prepareCall(query)){
                cs.setDate(1, insertedDate);

                try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Airport airport = new Airport(query, query, query);
                    airport.setId(rs.getString("id"));
                    airport.setName(rs.getString("name"));
                    airport.setCityname(rs.getString("cityname"));
                    filteredAirports.add(airport);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return filteredAirports;
    }

    @Override
    public List <Flight> showFlightsByAirpDate(Date insertedDate, String selectedAirport) throws SQLException {
        List<Flight> flights = new ArrayList<>();
        String query = "{CALL showFlightsByAirpDate(?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)){
                cs.setDate(1, insertedDate);
                cs.setString(2, selectedAirport);

                try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Flight flight = new Flight();
                    flight.setId(rs.getInt("id"));
                    flight.setTrip_date(rs.getDate("trip_date"));
                    flight.setOrig_city_name(rs.getString("orig_city"));
                    flight.setDest_city_name(rs.getString("dest_city"));
                    flight.setPrice_trip(rs.getDouble("price_trip"));
                    flights.add(flight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return flights;
    }

    @Override
    public void checkAndInsertPassenger(Passenger passenger) throws SQLException {
        String query = "{CALL checkAndInsertPassenger(?, ?, ?)}";
        
        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, passenger.getId());
            cs.setString(2, passenger.getName());
            cs.setDate(3, passenger.getBirthDate());

            cs.execute();
            System.out.println("Passenger information processed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override 
    public void checkAndInsertCustomer(Customer customer) throws SQLException {
        String query = "{CALL checkAndInsertPassenger(?, ?, ?, ?)}";
        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, customer.getId());
            cs.setString(2, customer.getName());
            cs.setInt(3, customer.getAge());
            cs.setInt(4, customer.getDoc_type());
            cs.execute();
            
            System.out.println("Customer information processed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }
}    



