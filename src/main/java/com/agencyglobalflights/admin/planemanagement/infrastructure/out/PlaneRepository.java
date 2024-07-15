package com.agencyglobalflights.admin.planemanagement.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Model;
import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.admin.planemanagement.domain.entity.PlaneStatus;
import com.agencyglobalflights.admin.planemanagement.domain.service.PlaneService;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;

public class PlaneRepository implements PlaneService {
    
// Register plane, view plane information, delete plane, update plane information
    
    private Connection connection;

    public PlaneRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PlaneStatus> findAllStatuses() throws SQLException {
        List<PlaneStatus> statuses = new ArrayList<>();
        String tableName = "planestatus"; // The table name you want to query

        // Call the stored procedure
        String query = "{call showInformationTable(?)}";
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
        String query = "{call showInformationTable(?)}";
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
        String query = "{call planeRegister(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, plane.getPlates());
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

    // @Override
    // public Plane viewPlaneById(String plates) throws SQLException{
    //     String query = "SELECT plates, capacity, fabrication_date, id_status, id_model, id_airline FROM plane WHERE id = ?";
    //     try (PreparedStatement ps = connection.prepareStatement(query)) {
    //         ps.setInt(1, plates);
    //         try (ResultSet rs = ps.executeQuery()) {
    //             if (rs.next()) {
    //                 Plane plane = new Plane(plates, 0, null, 0, 0, 0);
    //                 plane.getPlates(rs.getString("plates"));
    //                 plane.setName(rs.getString("name"));
    //                 plane.setAge(rs.getInt("age"));
    //                 plane.setNationality(rs.getString("nationality"));
    //                 plane.setPosition(rs.getString("position"));
    //                 plane.setShirt_number(rs.getInt("shirt_number"));
    //                 plane.setTeam(rs.getInt("team"));
    //                 return plane; 
    //             }
    //         }
    //     }
    //     return null;
    // }


}
