package com.agencyglobalflights.salesagent.customermanage.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;
import com.agencyglobalflights.salesagent.customermanage.domain.entity.Customer;
import com.agencyglobalflights.salesagent.customermanage.domain.service.CustomerService;

public class CustomerRepository implements CustomerService{

    private Connection connection;

    public CustomerRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer viewCustomer(String id) throws SQLException {
        String tableName = "customer";
        String query = "{CALL showObjectInformationIDVARCHAR(?, ?)}";
        Customer customer = new Customer();

        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, tableName);
            cs.setString(2, id);

            try(ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {            
                    customer.setId(rs.getString("id"));
                    customer.setName(rs.getString("name"));
                    customer.setAge(rs.getInt("age"));
                    customer.setDoc_type(rs.getInt("doc_type"));
                }  
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return customer;
    }

    @Override
    public void createCustomer(Customer customer) throws SQLException {
        String query = "{CALL createCustomer(?, ?, ?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, customer.getId());
            cs.setString    (2, customer.getName());
            cs.setInt(3, customer.getAge());
            cs.setInt(4, customer.getDoc_type());
            cs.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateCustomerId(String id, String newId) throws SQLException {
        String tableName = "revision";
        String columnName = "id_emp";
        String newValue = newId;
        String dataType = "VARCHAR";
        String idObject = id;

        String query = "{CALL EditColumnidVarAndInt(?, ?, ?, ?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, tableName);
            cs.setString(2, columnName);
            cs.setString(3, newValue);
            cs.setString(4, dataType);
            cs.setString(5, idObject);
            cs.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateCustomerName(String id, String newName) throws SQLException {
        String tableName = "revision";
        String columnName = "id_emp";
        String newValue = newName;
        String dataType = "VARCHAR";
        String idObject = id;

        String query = "{CALL EditColumnidVarAndInt(?, ?, ?, ?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, tableName);
            cs.setString(2, columnName);
            cs.setString(3, newValue);
            cs.setString(4, dataType);
            cs.setString(5, idObject);
            cs.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateCustomerAge(String id, int newAge) throws SQLException {
        String tableName = "revision";
        String columnName = "id_emp";
        int newValue = newAge;
        String dataType = "VARCHAR";
        String idObject = id;

        String query = "{CALL EditColumnidVarAndInt(?, ?, ?, ?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, tableName);
            cs.setString(2, columnName);
            cs.setInt(3, newValue);
            cs.setString(4, dataType);
            cs.setString(5, idObject);
            cs.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateCustomerDocType(String id, int newType) throws SQLException {
        String tableName = "revision";
        String columnName = "id_emp";
        int newValue = newType;
        String dataType = "INT";
        String idObject = id;

        String query = "{CALL EditColumnidVarAndInt(?, ?, ?, ?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, tableName);
            cs.setString(2, columnName);
            cs.setInt(3, newValue);
            cs.setString(4, dataType);
            cs.setString(5, idObject);
            cs.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
