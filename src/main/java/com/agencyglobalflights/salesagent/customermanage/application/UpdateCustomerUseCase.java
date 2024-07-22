package com.agencyglobalflights.salesagent.customermanage.application;

import java.sql.SQLException;

import com.agencyglobalflights.salesagent.customermanage.domain.service.CustomerService;

public class UpdateCustomerUseCase {

    private final CustomerService customerService;

    public UpdateCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void updateId(String id, String newId) throws SQLException {
        customerService.updateCustomerId(id, newId);
    }

    public void updateDocType(String id, int newType) throws SQLException {
        customerService.updateCustomerDocType(id, newType);
    }

    public void updateCustomerName(String id, String newName) throws SQLException {
        customerService.updateCustomerName(id, newName);
    }

    public void updateCustomerAge(String id, int newAge) throws SQLException {
        customerService.updateCustomerAge(id, newAge);
    }

    
}
