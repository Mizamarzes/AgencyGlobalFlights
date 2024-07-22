package com.agencyglobalflights.admin.flightsconnectionsmanagement.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightConnection;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.service.FlightConnectionService;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;

public class FlightConnectionRepository implements FlightConnectionService {
    private Connection connection;

    public FlightConnectionRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -------------------------
    // CREATE FLIGHT CONNECTION 

    public boolean hasFlightConnections(int flightId) throws SQLException {
        String query = "{CALL HasFlightConnections(?, ?)}";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setInt(1, flightId);
            cs.registerOutParameter(2, Types.BOOLEAN);
            cs.execute();
            return cs.getBoolean(2);
        }
    }
    

    @Override
    public void flightConnectionCreate(FlightConnection flightConnection) throws SQLException {
        String query = "{CALL (?, ?, ?, ?, ?, ?)}";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, flightConnection.getConnection_number());
            cs.setInt(2, flightConnection.getId_trip());
            cs.setString(3, flightConnection.getId_plane());
            cs.setString(4, flightConnection.getDest_airport());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
