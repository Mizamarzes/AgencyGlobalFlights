package com.agencyglobalflights.admin.airportmanage.infrastructure.in.controller;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.airportmanage.application.CreateAirpUseCase;
import com.agencyglobalflights.admin.airportmanage.application.DeleteAirpUseCase;
import com.agencyglobalflights.admin.airportmanage.application.UpdateAirpUseCase;
import com.agencyglobalflights.admin.airportmanage.application.ViewAirpInfoUseCase;
import com.agencyglobalflights.admin.airportmanage.domain.entity.Airport;
import com.agencyglobalflights.admin.airportmanage.domain.entity.City;
import com.agencyglobalflights.utils.ConsoleUtils;

public class AirportController {
    private ViewAirpInfoUseCase vaUseCase;
    private CreateAirpUseCase caUseCase;
    private DeleteAirpUseCase delUseCase;
    private UpdateAirpUseCase updtUseCase;

    public AirportController(ViewAirpInfoUseCase vaUseCase, CreateAirpUseCase caUseCase, DeleteAirpUseCase delUseCase, UpdateAirpUseCase updtUseCase) {
        this.vaUseCase = vaUseCase;
        this.caUseCase = caUseCase;
        this.delUseCase = delUseCase;
        this.updtUseCase = updtUseCase;
    }

    public List<Airport> findAllAirports() throws SQLException {
        String border = "+------+-------------------------------------+--------------+";
        String header = "|  id  |                name                 |     city     |";
        List<Airport> airports = vaUseCase.findAllAirports();
    
        ConsoleUtils.clear();
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
    
        for (Airport airport : airports) {
            System.out.printf("| %-4s | %-35s | %-12s |%n",
            airport.getId(), airport.getName(), airport.getCityname());
        }

        System.out.println(border);
        return airports;
    }

    public List<City> findAllCities() throws SQLException {
        ConsoleUtils.clear();
        String border = "+------+--------------------------+-----------+";
        String header = "|  id  |           name           |  country  |";
        List<City> cities = vaUseCase.findAllCities();
    
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
    
        for (City city : cities) {
            System.out.printf("| %-4d | %-24s | %-9s |%n",
            city.getId(), city.getName(), city.getIdcountry());
        }

        System.out.println(border);
        return cities;
    }

    public Airport viewAirportInfo() throws SQLException {

        String border = "+------+-------------------------------------+--------------+";
        String header = "|  id  |                name                 |     city     |";
        
        ConsoleUtils.clear();
        
        System.out.print("Enter the Airport id:  ");
        String id = ConsoleUtils.verifyEntryString();
        Airport airport = vaUseCase.viewAirportInfo(id);
        ConsoleUtils.clear();
        
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
        System.out.printf("| %-4s | %-35s | %-12s |%n",
                           airport.getId(), airport.getName(), airport.getIdcity());
        System.out.println(border);
        
        ConsoleUtils.waitWindow();
        return airport;
    }

    public void UpdateAirport() throws SQLException {
        findAllAirports();
        System.out.println("\n" + "Please enter the CODE/ID of the Airport to edit:");
        String id = ConsoleUtils.verifyEntryString();
        ConsoleUtils.clear();
        vaUseCase.viewAirportInfo(id);

        System.out.println("--------------------------------------\n" +
        "       Please select an option:       \n" +
        "--------------------------------------\n" +
        "\n" +
        "1. Update Name\n" +
        "2. Update City\n" +
        "3. Update CODE/ID\n" +
        "4. Go back"
        );

        int op = ConsoleUtils.verifyEntryInt(1, 4);
            
        switch (op) {

            case 1:
                // aqui se usa el procedure EditVarcharColumnIdVar
            
                ConsoleUtils.clear();     
                System.out.println("Enter the new name: ");
                String new_name = ConsoleUtils.verifyEntryString();
                updtUseCase.updateName(id, new_name);
                ConsoleUtils.waitWindow();
                break;
            case 2:

                // aqui se usa el procedure EditIntColumnidVar

                ConsoleUtils.clear();
                vaUseCase.findAllCities();
                System.out.println("Enter the new City: ");
                int new_city = ConsoleUtils.verifyingIntNoRange();
                updtUseCase.updateCity(id, new_city);
                ConsoleUtils.waitWindow();
                break;
            case 3:

                // aqui se usa el procedure EditVarcharColumnIdVar

                ConsoleUtils.clear();
                System.out.println("Enter the new Code/Id: ");
                String new_id = ConsoleUtils.verifyEntryString();
                updtUseCase.updateId(id, new_id);
                ConsoleUtils.waitWindow();
                break;
            case 4:
                return;
            default:
                break;
        }
    }

    public void createAirport() throws SQLException {
        ConsoleUtils.clear();

        System.out.println("Enter the Airport name: ");
        String name = ConsoleUtils.verifyEntryString();

        System.out.println("Enter the Airport Code/Id: ");
        String id = ConsoleUtils.verifyEntryString();

        findAllCities();
        System.out.println("Enter the date Airport city id: ");
        int idcity = ConsoleUtils.verifyingIntNoRange();

        Airport newAirport = new Airport(id, name, idcity);
        caUseCase.createAirport(newAirport);
        
    }

    public void deleteAirport() throws SQLException {
        findAllAirports();
        System.out.println("\n" + "Please enter the CODE/ID of the Airport to delete:");
        String id = ConsoleUtils.verifyEntryString();
        System.out.println("Are you Sure?\n" +
            "1. NO\n" +
            "2. YES\n");
        int conf = ConsoleUtils.verifyEntryInt(1, 2);

        if (conf == 2) {
            delUseCase.deleteAirport(id);
            System.out.println("Airport successfully eliminated.");
        } else {
            System.out.println("Elimination canceled.");
        }
        ConsoleUtils.waitWindow();        
    }


}
