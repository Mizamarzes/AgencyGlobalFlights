package com.agencyglobalflights.admin.planemanagement.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Airline;
import com.agencyglobalflights.admin.planemanagement.domain.service.AirlineService;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;

public class AirlineRepository implements AirlineService{

    private Connection connection;

    public AirlineRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Airline> findAllAirlines() throws SQLException {
        List<Airline> airlines = new ArrayList<>();
        String tableName = "airline";  // The table name you want to query
        String query = "{call showInformationTable(?)}";
    
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    // Assuming Airline has a constructor that takes id and name
                    Airline airline = new Airline(0, "");  // Adjust constructor as per your Airline class
                    airline.setId(rs.getInt("id"));
                    airline.setName(rs.getString("name"));
                    // Set other fields as necessary
                    airlines.add(airline);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return airlines;
    }
    

}
