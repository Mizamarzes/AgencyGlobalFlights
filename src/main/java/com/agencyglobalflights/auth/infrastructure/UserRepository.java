package com.agencyglobalflights.auth.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencyglobalflights.DatabaseConfig;
import com.agencyglobalflights.auth.domain.User;
import com.agencyglobalflights.auth.domain.UserService;

public class UserRepository implements UserService {

    private Connection connection;

    public UserRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
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
}
