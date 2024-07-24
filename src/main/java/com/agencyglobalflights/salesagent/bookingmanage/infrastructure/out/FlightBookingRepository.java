package com.agencyglobalflights.salesagent.bookingmanage.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencyglobalflights.admin.planemanagement.domain.entity.Airline;
import com.agencyglobalflights.infrastructure.config.DatabaseConfig;
import com.agencyglobalflights.salesagent.bookingmanage.domain.entity.FlightBooking;
import com.agencyglobalflights.salesagent.bookingmanage.domain.service.FlightBookingService;

public class FlightBookingRepository implements FlightBookingService{

    private Connection connection;

    public FlightBookingRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<FlightBooking> viewFlightBookings(String columnName, String idObject) throws SQLException {
        List<FlightBooking> flightBookings = new ArrayList<>();
        String tableName = "flightbooking";
        String query = "{CALL showObjectInformationVarchar(?, ?, ?)}";
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);
            cs.setString(2, columnName);
            cs.setString(3, idObject);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    FlightBooking flightBooking = new FlightBooking(0, null, 0, query, 0);
                    flightBooking.setId(rs.getInt("id"));
                    flightBooking.setDate(rs.getDate("date"));
                    flightBooking.setIdFlight(rs.getInt("idflight"));
                    flightBooking.setIdCostumer(rs.getString("idcustomer"));
                    flightBooking.setIdfares(rs.getInt("idfares"));
                    flightBookings.add(flightBooking);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } return flightBookings;
    }

    @Override
    public void createFlightBooking(FlightBooking flightBooking) throws SQLException {
        String query = "{CALL createBooking(?, ?, ?, ?)}";
        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setDate(1, flightBooking.getDate());
            cs.setInt(2, flightBooking.getIdFlight());
            cs.setString(3, flightBooking.getIdCostumer());
            cs.setInt(4, flightBooking.getIdfares());
            cs.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteFlightBooking(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFlightBooking'");
    }

}
