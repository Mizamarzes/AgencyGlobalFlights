package com.agencyglobalflights.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencyglobalflights.infrastructure.config.DatabaseConfig;

public class Validators {

    private static Connection connection;

    // Bloque estático para inicializar la conexión
    static {
        try {
            connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo adicional si es necesario
        }
    }

    // Método para verificar si el ID existe
    public static boolean checkIdExists(String tableName, String columnName, String idValue) throws SQLException {
        boolean exists = false;
        String query = "{CALL CheckIdExists(?, ?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            cs.setString(2, columnName);
            cs.setString(3, idValue);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    exists = rs.getInt("id") > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-lanzar la excepción para el manejo externo
        }

        return exists;
    }
}
