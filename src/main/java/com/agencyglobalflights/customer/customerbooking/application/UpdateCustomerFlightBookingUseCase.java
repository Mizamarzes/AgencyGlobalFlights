package com.agencyglobalflights.customer.customerbooking.application;

import java.sql.SQLException;

import com.agencyglobalflights.customer.customerbooking.domain.service.CustomerBookingService;

public class UpdateCustomerFlightBookingUseCase {
    private final CustomerBookingService customerBookingService;

    public UpdateCustomerFlightBookingUseCase(CustomerBookingService customerBookingService) {
        this.customerBookingService = customerBookingService;
    }

    public void updateFlightBookingCustomer(String id, String columnName, String newValue, String dataType) throws SQLException {
        customerBookingService.updateFlightBookingCustomer(id, columnName, newValue, dataType);
    }
} 
