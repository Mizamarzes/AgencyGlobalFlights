package com.agencyglobalflights.salesagent.customermanage.application;

import java.sql.SQLException;

import com.agencyglobalflights.salesagent.customermanage.domain.entity.Customer;
import com.agencyglobalflights.salesagent.customermanage.domain.service.CustomerService;
import com.agencyglobalflights.utils.ConsoleUtils;

public class ViewCustomerUseCase {
    private final CustomerService customerService;

    public ViewCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer viewCustomer(String id) throws SQLException {
        Customer customer = customerService.viewCustomer(id);

        return customer;
    }
}
