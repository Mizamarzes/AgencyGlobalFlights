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

    // -------------------------
    // VIEW PLANE INFORMATION

    public Plane viewPlaneByPlates(String plates) throws SQLException {
        String tableName = "plane";
        String columnName = "plates";
        String query = "{CALL showObjectInformationVarchar(?, ?, ?)}";
    
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            cs.setString(2, columnName);
            cs.setString(3, plates);  // Corrected variable name
    
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    // Assuming the Plane class has a constructor that accepts these parameters
                    Plane plane = new Plane(
                        rs.getInt("id"),  // Assuming the Plane class has id as an integer
                        rs.getString("plates"),
                        rs.getInt("capacity"),
                        rs.getDate("fabrication_date"),
                        rs.getInt("id_status"),
                        rs.getInt("id_model"),
                        rs.getInt("id_airline")
                    );
                    return plane;
                } else {
                    return null;  // No plane found for the given plates
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
}
