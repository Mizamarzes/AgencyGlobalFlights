package com.agencyglobalflights.customer.customerbooking.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.agencyglobalflights.customer.customerbooking.domain.service.CustomerBookingService;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;

public class CustomerBookingRepository implements CustomerBookingService {

    private Connection connection;

    public CustomerBookingRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ---------------------
    // UPDATE FLIGHT BOOKING CUSTOMER

    @Override
    public void updateFlightBookingCustomer(String id, String columnName, String newValue, String dataType) throws SQLException {
        String tablename = "flightbooking";

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
            System.out.println("Column " + columnName + " of flight booking updated successfully.");
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }
}
