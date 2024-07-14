package com.agencyglobalflights.auth.adapter.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencyglobalflights.auth.domain.User;
import com.agencyglobalflights.auth.service.UserService;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;

public class UserRepository implements UserService {

    private Connection connection;

    public UserRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
            System.out.println("Base de datos Conectada");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Base de datos CRASH");
        }
    }

    @Override
    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO user(username, email, password, idrole) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getIdrole());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean authUser(User user) throws SQLException {
        String query = "SELECT * FROM user WHERE username = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, user.getUsername());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    String providedPassword = user.getPassword();

                    if (storedPassword.equals(providedPassword)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al autenticar el usuario", e);
        }
    }

    @Override
    public String getUserRole(String username) throws SQLException {
        String roleName = null;
        String query = "SELECT r.name " +
                       "FROM user u " +
                       "JOIN role r ON u.idrole = r.id " +
                       "WHERE u.username = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
    
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    roleName = rs.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    
        return roleName;
    }
}
