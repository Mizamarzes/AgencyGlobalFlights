package com.agencyglobalflights.salesagent.bookingmanage.view;

import java.sql.SQLException;

import com.agencyglobalflights.utils.ConsoleUtils;

public class BookingManageVIew {

    public void showmenu() throws SQLException {

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
