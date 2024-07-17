package com.agencyglobalflights.admin.airportmanage.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.airportmanage.domain.entity.Airport;
import com.agencyglobalflights.admin.airportmanage.domain.entity.City;
import com.agencyglobalflights.admin.airportmanage.domain.service.AirportService;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;

public class AirportRepository implements AirportService{

    private Connection connection;

    public AirportRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Airport viewAirportInfo(String id) throws SQLException {
        String tableName = "airport";
        String query = "{call showObjectInformationIDVARCHAR(?, ?)}";
        Airport airport = new Airport(); 

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            cs.setString(2, id);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    airport.setId(rs.getString("id"));
                    airport.setName(rs.getString("name"));
                    airport.setIdcity(rs.getInt("idcity"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return airport;
    }

    @Override
    public void createAirport(Airport airport) throws SQLException {
        String query = "{CALL CreateAirports(?, ?, ?)}";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, airport.getId());
            cs.setString(2, airport.getName());
            cs.setInt(3, airport.getIdcity());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Airport> findAll() throws SQLException {
        List<Airport> airports = new ArrayList<>();
        String query = "CALL showAllAirports()";
        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Airport airport = new Airport();
                airport.setId(rs.getString("id"));
                airport.setName(rs.getString("name"));
                airport.setCityname(rs.getString("city_name"));
                airports.add(airport);
            }
        }
        return airports;
    }


    @Override
    public void deleteAirport(String id) throws SQLException {
        String tableName = "airport";
        String query = "{CALL DeleteByIdVarchar(?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            cs.setString(2, id);

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<City> findAllCities() throws SQLException {
        String tableName = "city";
        String query = "{CALL showAllRegs(?)}";
        List<City> cities = new ArrayList<>();        
        
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
    public void updateName(String id, String newName) throws SQLException {
        String tablename = "airport";
        String columnname = "name";
    
        try {
            CallableStatement cs = connection.prepareCall("{CALL EditVarcharColumnIdVar(?, ?, ?, ?)}");
            
            // Set the parameters for the stored procedure
            cs.setString(1, tablename);
            cs.setString(2, columnname);
            cs.setString(3, newName);
            cs.setString(4, id);
            
            // Execute the stored procedure
            cs.execute();
            System.out.println("Airport name updated succesfully");
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }
    
    @Override
    public void updateCity(String id, int newCity) throws SQLException{
        String tablename = "airport";
        String columnname = "city";
    
        try {
            CallableStatement cs = connection.prepareCall("{CALL EditIntColumnidVar(?, ?, ?, ?)}");
            
            // Set the parameters for the stored procedure
            cs.setString(1, tablename);
            cs.setString(2, columnname);
            cs.setInt(3, newCity);
            cs.setString(4, id);
            
            // Execute the stored procedure
            cs.execute();
            System.out.println("Airport city updated succesfully");
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    @Override
    public void updateId(String id, String newId) throws SQLException{
        String tablename = "airport";
        String columnname = "id";
    
        try {
            CallableStatement cs = connection.prepareCall("{CALL EditVarcharColumnIdVar(?, ?, ?, ?)}");
            
            // Set the parameters for the stored procedure
            cs.setString(1, tablename);
            cs.setString(2, columnname);
            cs.setString(3, newId);
            cs.setString(4, id);
            
            // Execute the stored procedure
            cs.execute();
            System.out.println("Airport Id updated succesfully");
                        
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

}
