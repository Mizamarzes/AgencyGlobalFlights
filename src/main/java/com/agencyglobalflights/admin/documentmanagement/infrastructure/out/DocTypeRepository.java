package com.agencyglobalflights.admin.documentmanagement.infrastructure.out;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.documentmanagement.domain.entity.DocumentType;
import com.agencyglobalflights.admin.documentmanagement.domain.service.DocTypeService;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;

public class DocTypeRepository implements DocTypeService{

private Connection connection;

    public DocTypeRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DocumentType> viewAllTypes() throws SQLException {
        String tableName = "documenttype";
        String query = "{CALL showAllRegs(?)}";
        List<DocumentType> alltypes = new ArrayList<>();
        
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    DocumentType documentType = new DocumentType();
                    documentType.setId(rs.getInt("id"));
                    documentType.setName(rs.getString("name"));
                    alltypes.add(documentType);
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return alltypes;
    }

    @Override
    public void createType(DocumentType documentType) throws SQLException {
        String query = "{CALL createDocType(?)}";

        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, documentType.getName());
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void deleteType(int id) throws SQLException{
        System.out.println(id);
        String tableName = "documenttype";
        String query = "{CALL DeleteByIdInt(?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            cs.setInt(2, id);
            cs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void UpdateDocType(String newName, int id) throws SQLException {
        String tablename = "documenttype";
        String columnname = "name";
    
        try {
            CallableStatement cs = connection.prepareCall("{CALL EditVarcharColumnidInt(?, ?, ?, ?)}");
            
            // Set the parameters for the stored procedure
            cs.setString(1, tablename);
            cs.setString(2, columnname);
            cs.setString(3, newName);
            cs.setInt(4, id);
            
            // Execute the stored procedure
            cs.execute();
            System.out.println("Airport name updated succesfully");
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

}

