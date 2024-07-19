package com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.flightfaresmanagement.domain.entity.FlightFare;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;
import com.agencyglobalflights.admin.flightfaresmanagement.domain.service.FlightFareService;

public class FlightFareRepository implements FlightFareService {
    
    private Connection connection;

    public FlightFareRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -------------------------
    // VIEW FLIGHTS FARES

    @Override
    public List<FlightFare> findAllFlightFares() throws SQLException {
        List<FlightFare> flightFares = new ArrayList<>();
        String tableName = "flightfare";
        String query = "CALL showInformationTable(?)";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    FlightFare flightFare = new FlightFare(0, "", 0);
                    flightFare.setId(rs.getInt("id"));
                    flightFare.setName(rs.getString("name"));
                    flightFare.setPrice(rs.getDouble("value"));
                    flightFares.add(flightFare);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return flightFares;
    }

    public FlightFare viewFlightFareById(int id) throws SQLException {
        String query = "{call showObjectInformation(?, ?)}";
        String table_name = "flightfare";
        FlightFare flightFare = new FlightFare(); 

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, table_name);
            cs.setInt(2, id);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    flightFare.setId(rs.getInt("id"));
                    flightFare.setName(rs.getString("name"));
                    flightFare.setPrice(rs.getDouble("value"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return flightFare;
    }

    // -------------------------
    // REGISTER FLIGHT FARE

    @Override
    public void flightFareRegister(FlightFare flightFare) throws SQLException {
        String query = "{CALL flightFareRegister(?, ?)}";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, flightFare.getName());
            cs.setDouble(2, flightFare.getPrice());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // -------------------------
    // UPDATE FLIGHT FARE

    @Override
    public void updateFlightFare(String id, String columnName, String newValue, String dataType) throws SQLException {
        String tablename = "flightfare";

        try {
            CallableStatement cs = connection.prepareCall("{CALL EditColumnidVarAndInt(?, ?, ?, ?, ?)}");
            
            // Set the parameters for the stored procedure
            cs.setString(1, tablename);
            cs.setString(2, columnName);
            cs.setString(3, newValue);
            cs.setString(4, dataType);
            cs.setString(5, id);
            
            // Execute the stored procedure
            cs.execute();
            System.out.println("Column " + columnName + " of flight fare updated successfully.");
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    // -------------------------
    // DELETE FLIGHT FARE

    @Override
    public void deleteFlightFare(int id) throws SQLException {
        String tableName = "flightfare";
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
