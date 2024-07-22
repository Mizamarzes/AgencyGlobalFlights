package com.agencyglobalflights.admin.flightsmanagement.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.airportmanage.domain.entity.City;
import com.agencyglobalflights.admin.flightsmanagement.domain.entity.Flight;
import com.agencyglobalflights.admin.flightsmanagement.domain.service.FlightService;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;

public class FlightRepository implements FlightService {
    private Connection connection;

    public FlightRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -------------------------
    // VIEW FLIGHT INFORMATION

    public Flight viewFlightById(int id) throws SQLException {
        String query = "{CALL showFlightById(?)}";
        Flight flight = new Flight();

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setInt(1, id);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    flight.setId(rs.getInt("id"));
                    flight.setTrip_date(rs.getDate("trip_date"));
                    flight.setPrice_trip(rs.getDouble("price_trip"));
                    flight.setOrig_city_name(rs.getString("orig_city"));
                    flight.setDest_city_name(rs.getString("dest_city"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return flight;
    }

    // -------------------------
    // UPDATE FLIGHT INFORMATION

    public List<City> findAllCities() throws SQLException{
        List<City> cities = new ArrayList<>();
        String tableName = "city";
        String query = "CALL showInformationTable(?)";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    City city = new City();
                    city.setId(rs.getInt("id"));
                    city.setName(rs.getString("name"));
                    city.setIdcountry(rs.getString("idcountry"));
                    cities.add(city);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return cities;
    }
    
    @Override
    public List<Flight> findAllFlights() throws SQLException {
        List<Flight> flights = new ArrayList<>();
        String query = "CALL showFlights()";
        try (CallableStatement cs = connection.prepareCall(query)) {
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Flight flight = new Flight(
                        rs.getInt("id"),
                        rs.getDate("trip_date"),
                        rs.getDouble("price_trip"),
                        rs.getString("orig_city"),
                        rs.getString("dest_city")
                    );
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
    public void updateFlight(String tableName, String columnName, String newValue, String dataType , String id) throws SQLException {
    
        try {
            CallableStatement cs = connection.prepareCall("{CALL EditColumnidVarAndInt(?, ?, ?, ?, ?)}");
            
            // Set the parameters for the stored procedure
            cs.setString(1, tableName);
            cs.setString(2, columnName);
            cs.setString(3, newValue);
            cs.setString(4, dataType);
            cs.setString(5, id);
            
            // Execute the stored procedure
            cs.execute();
            System.out.println("Column " + columnName + " of flight updated successfully.");
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    // -------------------------
    // DELETE FLIGHT 

    @Override
    public void deleteFlight(int id) throws SQLException {
        String tableName = "flight";
        String query = "{CALL DeleteByIdInt(?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            cs.setInt(2, id);
            cs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
