package com.agencyglobalflights.admin.planemanagement.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Model;
import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.admin.planemanagement.domain.entity.PlaneStatus;
import com.agencyglobalflights.admin.planemanagement.domain.service.PlaneService;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;

public class PlaneRepository implements PlaneService {
        
    private Connection connection;

    public PlaneRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -------------------------
    // REGISTER PLANE

    @Override
    public List<PlaneStatus> findAllStatuses() throws SQLException {
        List<PlaneStatus> statuses = new ArrayList<>();
        String tableName = "planestatus"; // The table name you want to query

        // Call the stored procedure
        String query = "{CALL showInformationTable(?)}";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            
            // Execute the stored procedure and get the result set
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    // Assuming PlaneStatus has a constructor that takes id and name
                    PlaneStatus status = new PlaneStatus(0, ""); 
                    status.setId(rs.getInt("id"));
                    status.setName(rs.getString("name"));
                    statuses.add(status);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return statuses;
    }

    @Override
    public List<Model> findAllModels() throws SQLException {
        List<Model> models = new ArrayList<>();
        String tableName = "model";
        String query = "{CALL showInformationTable(?)}";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    // Assuming Model has a constructor that takes id, name, and some integer value
                    Model model = new Model(0, "", 0);
                    model.setId(rs.getInt("id"));
                    model.setName(rs.getString("name"));
                    // Set other fields as necessary
                    models.add(model);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return models;
    }
    
    @Override
    public void planeRegister(Plane plane) throws SQLException {
        String query = "{CALL planeRegister(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, plane.getId());
            cs.setInt(2, plane.getCapacity());
            cs.setDate(3, plane.getFabrication_date());
            cs.setInt(4, plane.getId_status());
            cs.setInt(5, plane.getId_model());
            cs.setInt(6, plane.getId_airline());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // -------------------------
    // VIEW PLANE INFORMATION

    public Plane viewPlaneByPlates(String id) throws SQLException {
        String query = "{call showObjectInformationIDVARCHARPlane(?)}";
        Plane plane = new Plane(); 

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, id);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    plane.setId(rs.getString("id"));
                    plane.setCapacity(rs.getInt("capacity"));
                    plane.setFabrication_date(rs.getDate("fabrication_date"));
                    plane.setStatus_name(rs.getString("status_name"));
                    plane.setModel_name(rs.getString("model_name"));
                    plane.setAirline_name(rs.getString("airline_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return plane;
    }
    
    // -------------------------
    // UPDATE PLANE 

    @Override
    public List<Plane> findAllPlanes() throws SQLException {
        List<Plane> planes = new ArrayList<>();
        String query = "CALL showAllPlanes()";
        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Plane plane = new Plane(query, 0, null, query, query, query);
                plane.setId(rs.getString("id"));
                plane.setCapacity(rs.getInt("capacity"));
                plane.setFabrication_date(rs.getDate("fabrication_date"));
                plane.setStatus_name(rs.getString("status_name"));
                plane.setModel_name(rs.getString("model_name"));
                plane.setAirline_name(rs.getString("airline_name"));
                planes.add(plane);
            }
        }
        return planes;
    }

    @Override
    public void updatePlaneColumnIntAndVarchar(String id, String columnName, String newValue, String dataType) throws SQLException {
        String tablename = "plane";

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
            System.out.println("Column " + columnName + " of plane updated successfully.");
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    // -------------------------
    // DELETE PLANE 

    @Override
    public void deletePlane(String id) throws SQLException {
        String tableName = "plane";
        String query = "{CALL DeleteByIdVarchar(?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            cs.setString(2, id);
            cs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
