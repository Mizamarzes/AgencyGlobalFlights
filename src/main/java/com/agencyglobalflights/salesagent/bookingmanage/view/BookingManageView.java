package com.agencyglobalflights.salesagent.bookingmanage.view;

import java.sql.SQLException;

import com.agencyglobalflights.salesagent.bookingmanage.application.CreateFlightBookingUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.application.DeleteFlightBookingUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.application.ViewFlightBookingsUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.domain.service.FlightBookingService;
import com.agencyglobalflights.salesagent.bookingmanage.infrastructure.in.FlightBookingController;
import com.agencyglobalflights.salesagent.bookingmanage.infrastructure.out.FlightBookingRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class BookingManageView {

    public void showmenu() throws SQLException {
        FlightBookingService fbs = new FlightBookingRepository();
        CreateFlightBookingUseCase cfbuc = new CreateFlightBookingUseCase(fbs);
        DeleteFlightBookingUseCase dfbuc = new DeleteFlightBookingUseCase(fbs);
        ViewFlightBookingsUseCase ffbuc = new ViewFlightBookingsUseCase(fbs);

        FlightBookingController fbc = new FlightBookingController(cfbuc, dfbuc, ffbuc);


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
                
                // El sistema solicita al agente ingresar el identificador del cliente o del VUELO.
                // 3. El agente ingresa el identificador solicitado.
                // 4. El sistema busca las reservas en la base de datos.
                
                    break;
                case 2:
                fbc.CreateBooking();
                // cliente, trayecto, fecha, tarifa.
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
