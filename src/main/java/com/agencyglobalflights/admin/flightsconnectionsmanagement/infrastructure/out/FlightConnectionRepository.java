package com.agencyglobalflights.admin.flightsconnectionsmanagement.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.Employee;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightConnection;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightCrew;
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
        String query = "{CALL flightConnectionCreator(?, ?, ?, ?)}";
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

    // -------------------------
    // ASSIGN FLIGHT CREW

    @Override
    public List<Employee> findAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "CALL GetAllEmployees()";
        try (CallableStatement cs = connection.prepareCall(query)) {
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getString("id"));
                    employee.setName(rs.getString("name"));
                    employee.setRole_name(rs.getString("role"));
                    employee.setEntryDate(rs.getDate("date"));
                    employee.setAirline_name(rs.getString("airline"));
                    employee.setAirport_name(rs.getString("airport"));
                    employees.add(employee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return employees;
    }

    public boolean hasFlightCrewAssigned(int flightConnection_id) throws SQLException {
        String query = "{CALL HasFlightCrewAssigns(?, ?)}";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setInt(1, flightConnection_id);
            cs.registerOutParameter(2, Types.BOOLEAN);
            cs.execute();
            return cs.getBoolean(2);
        }
    }

    @Override
    public void flightCrewCreate(FlightCrew flightCrew) throws SQLException {
        String query = "{CALL createFlightCrew(?, ?)}";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, flightCrew.getId_employee());
            cs.setInt(2, flightCrew.getId_flight_connection());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // -------------------------
    // VIEW FLIGHT CONNECTION

    public FlightConnection FlightConnectionByIdFlight(int id) throws SQLException {
        String query = "{CALL showObjectInformationVarchar(?, ?, ?)}";
        String tableName = "flight_connection";
        String column_name = "id_trip";
        FlightConnection flightConnection = new FlightConnection();

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            cs.setString(2, column_name);
            cs.setInt(3, id);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    flightConnection.setId(rs.getInt("id"));
                    flightConnection.setConnection_number(rs.getString("connection_number"));
                    flightConnection.setId_trip(rs.getInt("id_trip"));
                    flightConnection.setId_plane(rs.getString("id_plane"));
                    flightConnection.setDest_airport(rs.getString("dest_airport"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return flightConnection;
    }

    // -------------------------
    // VIEW FLIGHT CREW

    public List<FlightCrew> viewFlightsCrewsByIdFlight(int id) throws SQLException {
        String query = "{CALL showObjectInformationVarchar(?, ?, ?)}";
        String tableName = "tripcrew";
        String column_name = "idconnection";
        List<FlightCrew> flightCrews = new ArrayList<>();

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            cs.setString(2, column_name);
            cs.setInt(3, id);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    FlightCrew flightCrew = new FlightCrew(
                        rs.getString("idemployee"),
                        rs.getInt("idconnection")
                    );
                    flightCrews.add(flightCrew);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return flightCrews;
    }

    // -------------------------
    // UPDATE FLIGHT CONNECTION

    @Override
    public List<FlightConnection> findAllFlightConnections() throws SQLException {
        List<FlightConnection> flightConnections = new ArrayList<>();
        String tableName = "flight_connection";
        String query = "CALL showInformationTable(?)";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    FlightConnection flightConnection = new FlightConnection();
                    flightConnection.setId(rs.getInt("id"));
                    flightConnection.setConnection_number(rs.getString("connection_number"));
                    flightConnection.setId_trip(rs.getInt("id_trip"));
                    flightConnection.setId_plane(rs.getString("id_plane"));
                    flightConnection.setDest_airport(rs.getString("dest_airport"));
                    flightConnections.add(flightConnection);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return flightConnections;
    }

    @Override
    public void updateFlightConnection(String id, String columnName, String newValue, String dataType) throws SQLException {
        String tablename = "flight_connection";

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
            System.out.println("Column " + columnName + " of flight connection updated successfully.");
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    // -------------------------
    // DELETE FLIGHT CONNECTION

    @Override
    public void deleteFlightConnection(int id) throws SQLException {
        String tableName = "flight_connection";
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
