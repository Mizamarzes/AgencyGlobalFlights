package com.agencyglobalflights.admin.airportmanage.infrastructure.in.controller;

import java.io.Console;
import java.sql.Date;
import java.sql.SQLException;

import com.agencyglobalflights.admin.airportmanage.application.CreateAirpUseCase;
import com.agencyglobalflights.admin.airportmanage.application.ViewAirpInfoUseCase;
import com.agencyglobalflights.admin.airportmanage.domain.entity.Airport;
import com.agencyglobalflights.utils.ConsoleUtils;

public class AirportController {
    private ViewAirpInfoUseCase vaUseCase;
    private CreateAirpUseCase caUseCase;

    public AirportController(ViewAirpInfoUseCase vaUseCase, CreateAirpUseCase caUseCase) {
        this.vaUseCase = vaUseCase;
        this.caUseCase = caUseCase;
    }

    public Airport viewAirportInfo() throws SQLException {

        // Definición del formato de la tabla
        String border = "+----+------------------+---------+";
        String header = "| id |     Airport      | city id |";

        // Limpia la consola
        ConsoleUtils.clear();
        
        // Solicita el ID del aeropuerto
        System.out.print("Enter the Airport id:  ");
        String id = ConsoleUtils.verifyEntryString();
        
        // Obtiene la información del aeropuerto
        Airport airport = vaUseCase.viewAirportInfo(id);
        
        // Limpia la consola nuevamente
        ConsoleUtils.clear();
        
        // Imprime la tabla con la información del aeropuerto
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
        System.out.printf("| %-3s| %-16s | %-7d |%n",
                           airport.getId(), airport.getName(), airport.getIdcity());
        System.out.println(border);
        
        // Espera a que el usuario presione una tecla para continuar
        ConsoleUtils.waitWindow();
        
        return airport;
    }

    public void createAirport() throws SQLException {
        ConsoleUtils.clear();

        System.out.println("Enter the Airport name: ");
        String name = ConsoleUtils.verifyEntryString();

        System.out.println("Enter the Airport IATA Code: ");
        String id = ConsoleUtils.verifyEntryString();

        System.out.println("Enter the date Airport city id: ");
        int idcity = ConsoleUtils.verifyingIntNoRange();

        Airport newAirport = new Airport(id, name, idcity);
        caUseCase.createAirport(newAirport);
        
    }

}
