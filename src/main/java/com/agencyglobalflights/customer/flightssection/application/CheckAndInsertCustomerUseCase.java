package com.agencyglobalflights.customer.flightssection.application;

import java.sql.SQLException;

import com.agencyglobalflights.customer.flightssection.domain.FlightsSectionService;
import com.agencyglobalflights.salesagent.customermanage.domain.entity.Customer;

public class CheckAndInsertCustomerUseCase {

    private final FlightsSectionService flightsSectionService;

    public CheckAndInsertCustomerUseCase(FlightsSectionService flightsSectionService) {
        this.flightsSectionService = flightsSectionService;
    }

    public void checkAndInsertCustomer(Customer customer) throws SQLException {
        flightsSectionService.checkAndInsertCustomer(customer);
    }
}
