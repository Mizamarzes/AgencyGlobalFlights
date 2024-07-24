package com.agencyglobalflights.customer.customerbooking.domain.service;

import java.sql.SQLException;

public interface CustomerBookingService {
    
    // Update flight booking 
    void updateFlightBookingCustomer(String id, String columnName, String newValue, String dataType) throws SQLException;


}
