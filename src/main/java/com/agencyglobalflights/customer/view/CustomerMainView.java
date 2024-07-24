package com.agencyglobalflights.customer.view;

import java.sql.SQLException;

import com.agencyglobalflights.admin.documentmanagement.application.ViewDocTypesUseCase;
import com.agencyglobalflights.admin.documentmanagement.domain.service.DocTypeService;
import com.agencyglobalflights.admin.documentmanagement.infrastructure.in.controller.DocTypeController;
import com.agencyglobalflights.admin.documentmanagement.infrastructure.out.DocTypeRepository;
import com.agencyglobalflights.admin.flightfaresmanagement.application.ViewFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.domain.service.FlightFareService;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.in.controller.FlightFareController;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.out.FlightFareRepository;
import com.agencyglobalflights.customer.customerbooking.infrastructure.in.view.CustomerBookingView;
import com.agencyglobalflights.customer.flightssection.application.CheckAndInsertCustomerUseCase;
import com.agencyglobalflights.customer.flightssection.application.CheckAndInsertPassengerUseCase;
import com.agencyglobalflights.customer.flightssection.application.ShowAvAirportsDateUseCase;
import com.agencyglobalflights.customer.flightssection.application.ShowFlightsByAirpDateUseCase;
import com.agencyglobalflights.customer.flightssection.domain.FlightsSectionService;
import com.agencyglobalflights.customer.flightssection.infrastructure.in.FlightsSectionController;
import com.agencyglobalflights.customer.flightssection.infrastructure.out.FlightsSectionRepository;
import com.agencyglobalflights.salesagent.bookingmanage.application.CreateFlightBookingUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.domain.service.FlightBookingService;
import com.agencyglobalflights.salesagent.bookingmanage.infrastructure.out.FlightBookingRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class CustomerMainView {

    public void showmenu() throws SQLException {

        //services
        FlightsSectionService fss = new FlightsSectionRepository();
        FlightFareService ffs = new FlightFareRepository();
        FlightBookingService fbs = new FlightBookingRepository();
        DocTypeService dts = new DocTypeRepository();
        //use cases
        CheckAndInsertPassengerUseCase checkAndInsertPassengerUseCase = new CheckAndInsertPassengerUseCase(fss);
        CheckAndInsertCustomerUseCase checkAndInsertCustomerUseCase = new CheckAndInsertCustomerUseCase(fss);
        ShowFlightsByAirpDateUseCase showFlightsByAirpDateUseCase = new ShowFlightsByAirpDateUseCase(fss);
        CreateFlightBookingUseCase createFlightBookingUseCase = new CreateFlightBookingUseCase(fbs);
        ShowAvAirportsDateUseCase showAvAirpUseCase = new ShowAvAirportsDateUseCase(fss);
        ViewDocTypesUseCase viewDocTypesUseCase = new ViewDocTypesUseCase(dts);


        ViewFlightFareUseCase vffuc = new ViewFlightFareUseCase(ffs);

        //controllers
        FlightFareController ffc = new FlightFareController(vffuc);
        DocTypeController dtc = new DocTypeController(viewDocTypesUseCase);
        FlightsSectionController fsc = new FlightsSectionController(showAvAirpUseCase, showFlightsByAirpDateUseCase, checkAndInsertPassengerUseCase, checkAndInsertCustomerUseCase, createFlightBookingUseCase, ffc, dtc);

        // menu
        CustomerBookingView cbv = new CustomerBookingView();

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "   Welcome to Global Flights Agency    \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. Flights Section\n" +
            "2. Bookings Management\n" +
            "3. Exit\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 3);


            switch (op) {
                case 1:
                    fsc.buyFlights();
                    break;
                case 2:
                    cbv.showmenu();
                    break;
                case 3:

                    return;
                default:
                    break;
            }

        } while (true);

    }
}
