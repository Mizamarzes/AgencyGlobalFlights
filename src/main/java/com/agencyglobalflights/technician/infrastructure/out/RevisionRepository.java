package com.agencyglobalflights.technician.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Plane;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;
import com.agencyglobalflights.technician.domain.entity.Employee;
import com.agencyglobalflights.technician.domain.entity.Revision;
import com.agencyglobalflights.technician.domain.service.RevisionService;

public class RevisionRepository implements RevisionService{

    private Connection connection;

    public RevisionRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerRevision(Revision revision) throws SQLException {
        String query = "{CALL CreateRevision(?, ?, ?, ?)}";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setDate(1, revision.getRevision_date());
            cs.setString(2, revision.getId_plane());
            cs.setString(3, revision.getDescription());
            cs.setString(4, revision.getId_emp());
            cs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteRevision(int id) throws SQLException {
        String tableName = "revision";
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
    public List<Revision> viewRevHistory(String id) throws SQLException {
        String tableName = "revision";
        String column_name = "id_plane";
        String object_identifier = id;
        String query = "{CALL showObjectInformationVarchar(?, ?, ?)}";
        List<Revision> revisionHistory = new ArrayList<>();
        
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            cs.setString(2, column_name);
            cs.setString(3, object_identifier);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Revision revision = new Revision(0, null, id, query, id);
                    revision.setId(rs.getInt("id"));
                    revision.setRevision_date(rs.getDate("revision_date"));
                    revision.setId_plane(rs.getString("id_plane"));
                    revision.setDescription(rs.getString("description"));
                    revision.setId_emp(rs.getString("id_emp"));
                    revisionHistory.add(revision);
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return revisionHistory;
    }

    @Override
    public List<Revision> viewAllRevisions() throws SQLException {
        List<Revision> allRevisions = new ArrayList<>();
        String tableName = "revision";
        String query = "{CALL showInformationTable(?)}";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Revision revision = new Revision(0, null, query, tableName, query);
                    revision.setId(rs.getInt("id"));
                    revision.setRevision_date(rs.getDate("revision_date"));
                    revision.setId_plane(rs.getString("id_plane"));
                    revision.setDescription(rs.getString("description"));
                    revision.setId_emp(rs.getString("id_emp"));
                    allRevisions.add(revision);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return allRevisions;
    }

    @Override
    public List<Plane> viewAllPlanes() throws SQLException {
        List<Plane> planes = new ArrayList<>();
        String query = "CALL showAllPlanes()";
        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Plane plane = new Plane(query, 0, null, query, query, query);
                plane.setId(rs.getString("id"));
                plane.setCapacity(rs.getInt("capacity"));
                plane.setFabrication_date(rs.getDate("fabrication_date"));
                plane.setStatus_name(rs.getString("status_name"));
                plane.setModel_name(rs.getString("model_name"));
                plane.setAirline_name(rs.getString("airline_name"));
                planes.add(plane);
            }
        }
        return planes;
    }

    @Override
    public List<Employee> viewAllEmployees() throws SQLException {
        String tableName = "employee";
        String query = "{CALL showInformationTable(?)}";
        List<Employee> allEmployees = new ArrayList<>();
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);

            try (ResultSet rs = cs.executeQuery()){
                while (rs.next()) {
                    Employee employee = new Employee(query, tableName, 0, null, 0, query);
                    employee.setId(rs.getString("id"));
                    employee.setName(rs.getString("name"));
                    employee.setId_role(rs.getInt("idrole"));
                    employee.setEntryDate(rs.getDate("entrydate"));
                    employee.setId_airline(rs.getInt("idairline"));
                    employee.setId_airport(rs.getString("idairport"));
                    allEmployees.add(employee);
                }   
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allEmployees;
    }

}
