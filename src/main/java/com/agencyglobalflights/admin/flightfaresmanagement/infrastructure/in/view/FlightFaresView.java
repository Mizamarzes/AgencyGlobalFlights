package com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.in.view;

import java.sql.SQLException;

import com.agencyglobalflights.admin.flightfaresmanagement.application.DeleteFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.application.RegisterFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.application.UpdateFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.application.ViewFlightFareUseCase;
import com.agencyglobalflights.admin.flightfaresmanagement.domain.service.FlightFareService;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.in.controller.FlightFareController;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.out.FlightFareRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightFaresView {

    public void showmenu() throws SQLException {
        FlightFareService ffs = new FlightFareRepository();

        ViewFlightFareUseCase vffuc = new ViewFlightFareUseCase(ffs);
        RegisterFlightFareUseCase rffuc = new RegisterFlightFareUseCase(ffs);
        UpdateFlightFareUseCase uffuc = new UpdateFlightFareUseCase(ffs);
        DeleteFlightFareUseCase dffuc = new DeleteFlightFareUseCase(ffs);

        FlightFareController ffc = new FlightFareController(vffuc, rffuc, uffuc, dffuc);

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "            Flight Fares               \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. View flight fares \n" +
            "2. Register flight fare \n" +
            "3. Update flight fare information\n" +
            "4. Delete flight fare\n" +
            "5. Go back\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 5);


            switch (op) {
                case 1:
                    ffc.viewflightFareByIdController();
                    break;
                case 2:
                    ffc.RegisterFlightFareController();
                    break;
                case 3:
                    ffc.updateFlightFareController();
                    break;
                case 4:
                    ffc.deleteFlightFareController();
                    break;
                case 5:
                
                    return;
                default:
                    break;
            }

        } while (true);

    }
}
