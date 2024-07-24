package com.agencyglobalflights.customer.customerbooking.infrastructure.in.view;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightfaresmanagement.application.ViewFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.in.controller.FlightFareController;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.out.FlightFareRepository;
import com.agencyglobalflights.admin.flightsmanagement.application.UpdateFlightUseCase;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller.FlightController;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.out.FlightRepository;
import com.agencyglobalflights.customer.customerbooking.application.UpdateCustomerFlightBookingUseCase;
import com.agencyglobalflights.customer.customerbooking.domain.service.CustomerBookingService;
import com.agencyglobalflights.customer.customerbooking.infrastructure.in.controller.CustomerBookingController;
import com.agencyglobalflights.customer.customerbooking.infrastructure.out.CustomerBookingRepository;
import com.agencyglobalflights.salesagent.bookingmanage.application.DeleteFlightBookingUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.application.ViewFlightBookingsUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.infrastructure.in.FlightBookingController;
import com.agencyglobalflights.salesagent.bookingmanage.infrastructure.out.FlightBookingRepository;
import com.agencyglobalflights.utils.ConsoleUtils;
import com.agencyglobalflights.utils.Validators;

public class CustomerBookingView {

    public void showmenu() throws SQLException {
        CustomerBookingService cbs = new CustomerBookingRepository();
 
        ViewFlightBookingsUseCase vfbuc = new ViewFlightBookingsUseCase(new FlightBookingRepository());
        DeleteFlightBookingUseCase dfbuc = new DeleteFlightBookingUseCase(new FlightBookingRepository());
        UpdateFlightUseCase ufuc = new UpdateFlightUseCase(new FlightRepository());
        ViewFlightFareUseCase vffuc = new ViewFlightFareUseCase(new FlightFareRepository());

        UpdateCustomerFlightBookingUseCase ucfbuc = new UpdateCustomerFlightBookingUseCase(cbs);

         // Validators
        Validators validators = new Validators();

        FlightBookingController fbc = new FlightBookingController(vfbuc, dfbuc);
        FlightController fc = new FlightController(ufuc);
        FlightFareController ffc = new FlightFareController(vffuc);

        CustomerBookingController cbc = new CustomerBookingController(ucfbuc, validators, fc, ffc);
    
        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "         Booking View:           \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. View flight booking \n" +
            "2. Cancel flight booking\n" +
            "3. Update flight booking \n" +
            "4. Go back\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 4);


            switch (op) {
                case 1:
                    fbc.viewFlightBookings();                              
                    break;
                case 2:
                    fbc.deleteFlightBooking();
                    break;
                case 3:
                    cbc.updateCustomerFlightBookingController();
                    break;
                case 4:
                    return;
                default:
                    break;
            }

        } while (true);

    }
}
