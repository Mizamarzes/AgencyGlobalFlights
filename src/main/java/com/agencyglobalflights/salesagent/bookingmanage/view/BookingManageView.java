package com.agencyglobalflights.salesagent.bookingmanage.view;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightfaresmanagement.application.ViewFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.domain.service.FlightFareService;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.in.controller.FlightFareController;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.out.FlightFareRepository;
import com.agencyglobalflights.admin.flightsmanagement.application.ViewFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.domain.service.FlightService;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller.FlightController;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.out.FlightRepository;
import com.agencyglobalflights.salesagent.bookingmanage.application.CreateFlightBookingUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.application.DeleteFlightBookingUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.application.ViewFlightBookingsUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.domain.service.FlightBookingService;
import com.agencyglobalflights.salesagent.bookingmanage.infrastructure.in.FlightBookingController;
import com.agencyglobalflights.salesagent.bookingmanage.infrastructure.out.FlightBookingRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class BookingManageView {

    public void showmenu() throws SQLException {

        //services
        FlightBookingService fbs = new FlightBookingRepository();
        FlightService fs = new FlightRepository();
        FlightFareService ffs = new FlightFareRepository();
    
        //use cases
        CreateFlightBookingUseCase cfbuc = new CreateFlightBookingUseCase(fbs);
        DeleteFlightBookingUseCase dfbuc = new DeleteFlightBookingUseCase(fbs);
        ViewFlightBookingsUseCase ffbuc = new ViewFlightBookingsUseCase(fbs);
        ViewFlightUseCase vfuc = new ViewFlightUseCase(fs);
        ViewFlightFareUseCase vffuc = new ViewFlightFareUseCase(ffs);

        //controllers
        FlightController fc = new FlightController(vfuc);
        FlightFareController ffc = new FlightFareController(vffuc);
        FlightBookingController fbc = new FlightBookingController(cfbuc, dfbuc, ffbuc, fc, ffc);


        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "         Booking Management:           \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. View flight bookings \n" +
            "2. Create booking\n" +
            "3. Delete flight booking \n" +
            "4. Go back\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 4);


            switch (op) {
                case 1:
                fbc.viewFlightBookings();                
                    break;
                case 2:
                fbc.CreateBooking();
                    break;
                case 3:

                    break;
                case 4:
                    return;
                default:
                    break;
            }

        } while (true);

    }
}
