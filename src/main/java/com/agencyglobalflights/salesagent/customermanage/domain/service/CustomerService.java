package com.agencyglobalflights.salesagent.customermanage.domain.service;

import java.sql.SQLException;

import com.agencyglobalflights.salesagent.customermanage.domain.entity.Customer;

public interface CustomerService {

    Customer viewCustomer(String id) throws SQLException;
    void createCustomer(Customer customer) throws SQLException;

    void updateCustomerId(String id, String newId) throws SQLException;
    void updateCustomerDocType(String id, int newType) throws SQLException;
    void updateCustomerName(String id, String newName) throws SQLException;
    void updateCustomerAge(String id, int newAge) throws SQLException;

}
