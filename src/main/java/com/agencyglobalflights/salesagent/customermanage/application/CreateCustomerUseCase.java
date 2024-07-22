package com.agencyglobalflights.salesagent.customermanage.application;

import java.sql.SQLException;

import com.agencyglobalflights.salesagent.customermanage.domain.entity.Customer;
import com.agencyglobalflights.salesagent.customermanage.domain.service.CustomerService;

public class CreateCustomerUseCase {

    private final CustomerService customerService;

    public CreateCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void createCustomer(Customer customer) throws SQLException {
        customerService.createCustomer(customer);
    }

}
