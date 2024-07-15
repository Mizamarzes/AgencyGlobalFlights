package com.agencyglobalflights.admin.planemanagement.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        String query = "SELECT * FROM planestatus";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                PlaneStatus status = new PlaneStatus(0, query);
                status.setId(rs.getInt("id"));
                status.setName(rs.getString("name"));
                statuses.add(status);
            }
        }
        return statuses;
    }

    @Override
    public List<Model> findAllModels() throws SQLException {
        List<Model> models = new ArrayList<>();
        String query = "SELECT * FROM model";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Model model = new Model(0, query, 0);
                model.setId(rs.getInt("id"));
                model.setName(rs.getString("name"));
                models.add(model);
            }
        }
        return models;
    }



    @Override
    public void planeRegister(Plane plane) throws SQLException {
        String query = "INSERT INTO plane (plates, capacity, fabrication_date, id_status, id_model, id_airline) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, plane.getPlates());
            ps.setInt(2, plane.getCapacity());
            ps.setDate(3, plane.getFabrication_date());
            ps.setInt(4, plane.getId_status());
            ps.setInt(5, plane.getId_model());
            ps.setInt(6, plane.getId_airline());
            ps.executeUpdate();
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
