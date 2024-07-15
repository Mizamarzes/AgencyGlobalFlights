package com.agencyglobalflights.admin.airportmanage.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencyglobalflights.admin.airportmanage.domain.entity.Airport;
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
    public Airport viewAirportInfo(int id) throws SQLException {
        String tableName = "airport";
        String query = "{call showObjectInformation(?, ?)}";
        Airport airport = new Airport(id, tableName, id); 

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            cs.setInt(2, id);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    airport.setId(rs.getInt("id"));
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

}
