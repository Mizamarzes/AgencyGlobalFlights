package com.agencyglobalflights.admin.airportmanage.infrastructure.in.controller;

import java.io.Console;
import java.sql.SQLException;

import com.agencyglobalflights.admin.airportmanage.application.ViewAirpInfoUseCase;
import com.agencyglobalflights.admin.airportmanage.domain.entity.Airport;
import com.agencyglobalflights.utils.ConsoleUtils;

public class AirportController {
    private ViewAirpInfoUseCase vaUseCase;

    public AirportController(ViewAirpInfoUseCase vaUseCase) {
        this.vaUseCase = vaUseCase;
    }

    public Airport viewAirportInfo() throws SQLException {
    
        String border = "+----+------------------+---------+";
        String header = "| id |     Airport      | city id |";

        ConsoleUtils.clear();
        System.out.println("Enter the Airport id:  ");
        int id = ConsoleUtils.verifyingIntNoRange();
        Airport airport = vaUseCase.viewAirportInfo(id);
        ConsoleUtils.clear();
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
        System.out.printf("|  %-2d| %-15s | %-5d |%n",
                           airport.getId(), airport.getName(), airport.getIdcity());
        System.out.println(border);
        ConsoleUtils.waitWindow();
        return airport;
    }

    public void createAirport() throws SQLException {
        ConsoleUtils.clear();
        

    }

}
