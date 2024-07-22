package com.agencyglobalflights.salesagent.bookingmanage.infrastructure.out;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.salesagent.bookingmanage.domain.entity.FlightBooking;
import com.agencyglobalflights.salesagent.bookingmanage.domain.service.FlightBookingService;

public class FlightBookingRepository implements FlightBookingService{

    @Override
    public List<FlightBooking> viewFlightBookings() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewFlightBookings'");
    }

    @Override
    public void createFlightBooking(FlightBooking flightBooking) throws SQLException {
        
    }

    @Override
    public void deleteFlightBooking(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFlightBooking'");
    }

}
