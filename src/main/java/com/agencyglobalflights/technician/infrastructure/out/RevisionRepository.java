package com.agencyglobalflights.technician.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Model;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;
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
            cs.setString(1, column_name);
            cs.setString(1, object_identifier);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Revision revision = new Revision(0, null, id, query, id);
                    revision.setId(rs.getInt("id"));
                    revision.setRevision_date(rs.getDate("revision_date"));
                    revision.setId_plane(rs.getString("revision_date"));
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
                    revision.setId_plane(rs.getString("revision_date"));
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


}
