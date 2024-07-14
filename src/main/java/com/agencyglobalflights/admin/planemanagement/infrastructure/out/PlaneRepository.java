package com.agencyglobalflights.admin.planemanagement.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
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
