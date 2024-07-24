package com.agencyglobalflights.admin.flightsconnectionsmanagement.infrastructure.in.controller;

import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.airportmanage.infrastructure.in.controller.AirportController;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.AssignFlightCrewUseCase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.CreateFlightConnectionUseCase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.DeleteflightConnectionUseCase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.UpdateFlightConnectionUsecase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.ViewFlightConnectionUseCase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.application.ViewFlightCrewUseCase;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.Employee;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightConnection;
import com.agencyglobalflights.admin.flightsconnectionsmanagement.domain.entity.FlightCrew;
import com.agencyglobalflights.admin.flightsmanagement.infrastructure.in.controller.FlightController;
import com.agencyglobalflights.admin.planemanagement.infrastructure.in.controller.PlaneController;
import com.agencyglobalflights.utils.ConsoleUtils;
import com.agencyglobalflights.utils.Validators;

public class FlightConnectionController {

    private final CreateFlightConnectionUseCase createFlightConnectionUseCase;
    private final ViewFlightConnectionUseCase viewFlightConnectionUseCase;
    private final UpdateFlightConnectionUsecase updateFlightConnectionUsecase;
    private final DeleteflightConnectionUseCase deleteflightConnectionUseCase;
    private final AssignFlightCrewUseCase assignFlightCrewUseCase;
    private final ViewFlightCrewUseCase viewFlightCrewUseCase;

    private final FlightController flightController;
    private final PlaneController planeController;
    private final AirportController airportController;
    private final Validators validators;

    public FlightConnectionController(
            CreateFlightConnectionUseCase createFlightConnectionUseCase,
            ViewFlightConnectionUseCase viewFlightConnectionUseCase,
            UpdateFlightConnectionUsecase updateFlightConnectionUsecase,
            DeleteflightConnectionUseCase deleteflightConnectionUseCase,
            AssignFlightCrewUseCase assignFlightCrewUseCase,
            ViewFlightCrewUseCase viewFlightCrewUseCase,
            FlightController flightController,
            PlaneController planeController,
            AirportController airportController,
            Validators validators) {
        this.createFlightConnectionUseCase = createFlightConnectionUseCase;
        this.viewFlightConnectionUseCase = viewFlightConnectionUseCase;
        this.updateFlightConnectionUsecase = updateFlightConnectionUsecase;
        this.deleteflightConnectionUseCase = deleteflightConnectionUseCase;
        this.assignFlightCrewUseCase = assignFlightCrewUseCase;
        this.viewFlightCrewUseCase = viewFlightCrewUseCase;
        this.flightController = flightController;
        this.planeController = planeController;
        this.airportController = airportController;
        this.validators = validators;
    }

    // -------------------------
    // CREATE FLIGHT CONNECTION 


    public void createFlightConnectionController() throws SQLException {
        ConsoleUtils.clear();
        flightController.getAllFlightsController();
        System.out.println("Enter the id of the flight");
        int id_flight = ConsoleUtils.verifyingIntNoRange();
        if (!validators.checkIdExistsINT("flight", "id", id_flight)) {
            return; 
        }

        if (createFlightConnectionUseCase.hasFlightConnections(id_flight)) {
            System.out.println("The flight with id " + id_flight + " already has flight connections.");
            ConsoleUtils.waitWindow();
        } else {
            System.out.println("The flight with id " + id_flight + " does not have any flight connections yet.");
            ConsoleUtils.waitWindow();

            ConsoleUtils.clear();
            System.out.println("Enter the connection_number of flight connection: ");
            String connection_number = ConsoleUtils.verifyingStringMaxStringREGEX(10);

            ConsoleUtils.clear();
            planeController.findAllPlanes();
            System.out.println("Enter the id of the plane to assign: ");
            String id_plane = ConsoleUtils.verifyingStringMaxStringREGEX(10);
            if (!validators.checkIdExistsSTRING("plane", "id", id_plane)) {
                return; 
            }
            
            ConsoleUtils.clear();
            airportController.findAllAirports();
            System.out.println("Enter the id of the airport to assign destiny airport: ");
            String id_airport_dest = ConsoleUtils.verifyingStringMaxStringREGEX(10);
            if (!validators.checkIdExistsSTRING("airport", "id", id_airport_dest)) {
                return; 
            }

            FlightConnection newFlightConnection = new FlightConnection(connection_number, id_flight, id_plane, id_airport_dest);
        
            try {
                createFlightConnectionUseCase.flightConnectionCreate(newFlightConnection);
                System.out.println("Flight connection created successfully!");
            } catch (SQLException e) {
                System.out.println("Error occurred while creating flight connection: " + e.getMessage());
            }
            ConsoleUtils.waitWindow();

        }
        
    }

    // -------------------------
    // ASSIGN FLIGHT CREW

    public List<Employee> getAllEmployeesController() throws SQLException {
        ConsoleUtils.clear();
        String border = "+-------------+-------------------+--------------------+--------------+--------------------------+-----------------------------------------+";
        String header = "|     id      |       name        |        role        |     date     |         airline          |                 airport                 |";
        List<Employee> employees = assignFlightCrewUseCase.findAllEmployees();

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Employee employee : employees){
            System.out.printf("| %-11s | %-17s | %-18s | %-12s | %-24s | %-39s |%n",
                employee.getId(),
                employee.getName(),
                employee.getRole_name(),
                employee.getEntryDate(),
                employee.getAirline_name(),
                employee.getAirport_name()
            );
        }
        System.out.println(border);
        return employees;
    }
    
    public void AssignFlightCrewController() throws SQLException {
        ConsoleUtils.clear();
        getAllFlightsConnections();
        System.out.println("Enter the id of the flight connection: ");
        int id_flight_connection = ConsoleUtils.verifyingIntNoRange();

        if (!validators.checkIdExistsINT("flight_connection", "id", id_flight_connection)) {
            return; 
        }

        if (assignFlightCrewUseCase.hasFlightCrewAssigned(id_flight_connection)) {
            System.out.println("The Connection flight with id " + id_flight_connection + " already has flight crew.");
            ConsoleUtils.waitWindow();
        } else {
            System.out.println("The Connection flight with id " + id_flight_connection + " does not have any flight crew yet.");
            ConsoleUtils.waitWindow();
        }

        ConsoleUtils.clear();
        System.out.println("Would you like to add another crew member?\n" +
            "1. YES\n"+
            "2. NO\n");
            
        int conf = ConsoleUtils.verifyEntryInt(1, 2);

        if (conf == 1) {
            ConsoleUtils.clear();
            getAllEmployeesController();
            System.out.println("Enter the id of the employee to assign to flight: ");
            String id_employee = ConsoleUtils.verifyingStringMaxStringREGEX(10);
            if (!validators.checkIdExistsSTRING("employee", "id", id_employee)) {
                return; 
            }

            FlightCrew flightCrew = new FlightCrew(id_employee, id_flight_connection);

            try {
                assignFlightCrewUseCase.flightCrewCreate(flightCrew);
                System.out.println("Flight crew created successfully!");
            } catch (SQLException e) {
                System.out.println("Error occurred while creating flight crew: " + e.getMessage());
            }
            ConsoleUtils.waitWindow();  
        } else {
            return;
        }
    }

    // -------------------------
    // VIEW FLIGHT CONNECTION 
    
    public void getFlightConnectionByIdFlightController(int id) throws SQLException {
        ConsoleUtils.clear();

        FlightConnection flightConnection = viewFlightConnectionUseCase.FlightConnectionByIdFlight(id);

        if (flightConnection != null){
            String border = "+----+----------+----------+---------+------------------+";
            String header = "| id |  number  |   trip   |  plane  |  airport destiny |";

            System.out.println(border);
            System.out.println(header);
            System.out.println(border);
            
            System.out.printf("| %-2d | %-8s | %-8d | %-7s | %-16s |%n",
                flightConnection.getId(),
                flightConnection.getConnection_number(),
                flightConnection.getId_trip(),
                flightConnection.getId_plane(),
                flightConnection.getDest_airport()
            );

        System.out.println(border);
        } else {
            System.out.println("No flights connections found with the given id.");
        }
    }

    public void viewFlightControllerByIdFlightController() throws SQLException{
        ConsoleUtils.clear();
        flightController.getAllFlightsController();
        System.out.println("Enter the trip id to search for flight connections: ");
        int op = ConsoleUtils.verifyingIntNoRange();
        if (!validators.checkIdExistsINT("flight", "id", op)) {
            return; 
        }

        if (!validators.checkIdExistsINT("flight_connection", "id_trip", op)) {
            return; 
        }

        getFlightConnectionByIdFlightController(op);
        ConsoleUtils.waitWindow();
    }

    // -------------------------
    // VIEW FLIGHT CREW 

    public List<FlightCrew> getTripCrewByFlightConnectionIdController(int id) throws SQLException {
        ConsoleUtils.clear();
        String border = "+--------------+------------+";
        String header = "|   Employee   |   Flight   |";
        List<FlightCrew> flightCrews = viewFlightCrewUseCase.viewFlightCrewByIdFlight(id);

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (FlightCrew flightCrew : flightCrews) {
            System.out.printf("| %-12s | %-10d |%n",
            flightCrew.getId_employee(), flightCrew.getId_flight_connection());
        }
        
    
        System.out.println(border);
        return flightCrews;
    }

    public void viewFlightCrewByIdFlightConnectionController() throws SQLException{
        ConsoleUtils.clear();
        getAllFlightsConnections();
        System.out.println("Enter the flight to search for flights crews: ");
        int op = ConsoleUtils.verifyingIntNoRange();
        if (!validators.checkIdExistsINT("flight_connection", "id", op)) {
            return; 
        }

        if (!validators.checkIdExistsINT("tripcrew", "idconnection", op)) {
            return; 
        }

        getTripCrewByFlightConnectionIdController(op);
        ConsoleUtils.waitWindow();
    }

    // -------------------------
    // UPDATE FLIGHT CONNECTION 

    public List<FlightConnection> getAllFlightsConnections() throws SQLException {
        ConsoleUtils.clear();
        String border = "+----+----------+----------+---------+------------------+";
        String header = "| id |  number  |   trip   |  plane  |  airport destiny |";
        List<FlightConnection> flightConnections = updateFlightConnectionUsecase.findAllFlightConnections();

        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (FlightConnection flightConnection : flightConnections){
            System.out.printf("| %-2d | %-8s | %-8d | %-7s | %-16s |%n",
                flightConnection.getId(),
                flightConnection.getConnection_number(),
                flightConnection.getId_trip(),
                flightConnection.getId_plane(),
                flightConnection.getDest_airport()
            );

        }
        System.out.println(border);
        return flightConnections;
    }

    public void updateFlightConnectionsController() throws SQLException{
        getAllFlightsConnections();

        System.out.println("Please, enter the id of the flight connection to edit: ");
        String id = ConsoleUtils.verifyingIntREGEXString();

        if (!validators.checkIdExistsSTRING("flight_connection", "id", id)) {
            return; 
        }

        ConsoleUtils.clear();
        System.out.println("--------------------------------------\n" +
        "       Please select an option:       \n" +
        "--------------------------------------\n" +
        "\n" +
        "1. Update Connection number\n" +
        "2. Update flight\n" +
        "3. Update plane\n" +
        "4. Update destiny aiport\n" +
        "5. Go back"
        );

        int op = ConsoleUtils.verifyEntryInt(1, 5);

        switch (op) {
            case 1:
                ConsoleUtils.clear();
                System.out.println("Enter the new connection number: ");
                String new_connection_number = ConsoleUtils.verifyingStringMaxStringREGEX(10);
                updateFlightConnectionUsecase.updateFlightConnection(id, "connection_number", new_connection_number, "VARCHAR");
                ConsoleUtils.waitWindow();
                break;
            case 2:
                ConsoleUtils.clear();
                flightController.getAllFlightsController();
                System.out.println("Enter the new flight: ");
                String new_flight = ConsoleUtils.verifyingIntREGEXString();
                if (!validators.checkIdExistsSTRING("flight", "id", new_flight)) {
                    return; 
                }
                updateFlightConnectionUsecase.updateFlightConnection(id, "id_trip", new_flight, "INT");
                ConsoleUtils.waitWindow();
                break;
            case 3:
                ConsoleUtils.clear();
                planeController.findAllPlanes();
                System.out.println("Enter the new plane: ");
                String new_plane = ConsoleUtils.verifyingIntREGEXString();
                if (!validators.checkIdExistsSTRING("plane", "id", new_plane)) {
                    return; 
                }
                updateFlightConnectionUsecase.updateFlightConnection(id, "id_plane", new_plane, "INT");
                ConsoleUtils.waitWindow();
                break;
            case 4:
                ConsoleUtils.clear();
                airportController.findAllAirports();
                System.out.println("Enter the new airport destiny: ");
                String new_dest_airport = ConsoleUtils.verifyingIntREGEXString();
                if (!validators.checkIdExistsSTRING("airport", "id", new_dest_airport)) {
                    return; 
                }
                updateFlightConnectionUsecase.updateFlightConnection(id, "id_plane", new_dest_airport, "INT");
                ConsoleUtils.waitWindow();
                break;
            case 5:
                return;
            default:
                break;
        }
    }

    // -------------------------
    // DELETE FLIGHT CONNECTION 

    public void deleteFlightConnectionController() throws SQLException {
        ConsoleUtils.clear();
        getAllFlightsConnections();
        System.out.println("Please, enter the id of the flight connection to delete:");
        int id = ConsoleUtils.verifyingIntNoRange();
        if (!validators.checkIdExistsINT("flight_connection", "id", id)) {
            return; 
        }
        System.out.println("Are you Sure?\n" +
            "1. NO\n" +
            "2. YES\n");
        int conf = ConsoleUtils.verifyEntryInt(1, 2);

        if (conf == 2) {
            deleteflightConnectionUseCase.deleteFlightConnection(id);
            System.out.println("Flight connection succesfully eliminated.");
        } else {
            System.out.println("Elimination canceled.");
        }
        ConsoleUtils.waitWindow();
    }
}
