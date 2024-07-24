package com.agencyglobalflights.customer.flightssection.infrastructure.in;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.airportmanage.domain.entity.Airport;
import com.agencyglobalflights.admin.documentmanagement.infrastructure.in.controller.DocTypeController;
import com.agencyglobalflights.admin.flightfaresmanagement.infrastructure.in.controller.FlightFareController;
import com.agencyglobalflights.admin.flightsmanagement.domain.entity.Flight;
import com.agencyglobalflights.customer.flightssection.application.CheckAndInsertCustomerUseCase;
import com.agencyglobalflights.customer.flightssection.application.CheckAndInsertPassengerUseCase;
import com.agencyglobalflights.customer.flightssection.application.ShowAvAirportsDateUseCase;
import com.agencyglobalflights.customer.flightssection.application.ShowFlightsByAirpDateUseCase;
import com.agencyglobalflights.customer.flightssection.domain.entity.Passenger;
import com.agencyglobalflights.salesagent.bookingmanage.application.CreateFlightBookingUseCase;
import com.agencyglobalflights.salesagent.bookingmanage.domain.entity.FlightBooking;
import com.agencyglobalflights.salesagent.customermanage.domain.entity.Customer;
import com.agencyglobalflights.utils.ConsoleUtils;

public class FlightsSectionController {

    private ShowAvAirportsDateUseCase showAvAirportsDateUseCase;
    private ShowFlightsByAirpDateUseCase showFlightsByAirpDateUseCase;
    private CheckAndInsertPassengerUseCase checkAndInsertPassengerUseCase;
    private CheckAndInsertCustomerUseCase checkAndInsertCustomerUseCase;
    private CreateFlightBookingUseCase createFlightBookingUseCase;
    private FlightFareController flightFareController;
    private DocTypeController docTypeController;




    public FlightsSectionController(ShowAvAirportsDateUseCase showAvAirportsDateUseCase,
            ShowFlightsByAirpDateUseCase showFlightsByAirpDateUseCase,
            CheckAndInsertPassengerUseCase checkAndInsertPassengerUseCase,
            CheckAndInsertCustomerUseCase checkAndInsertCustomerUseCase,
            CreateFlightBookingUseCase createFlightBookingUseCase, FlightFareController flightFareController,
            DocTypeController docTypeController) {
        this.showAvAirportsDateUseCase = showAvAirportsDateUseCase;
        this.showFlightsByAirpDateUseCase = showFlightsByAirpDateUseCase;
        this.checkAndInsertPassengerUseCase = checkAndInsertPassengerUseCase;
        this.checkAndInsertCustomerUseCase = checkAndInsertCustomerUseCase;
        this.createFlightBookingUseCase = createFlightBookingUseCase;
        this.flightFareController = flightFareController;
        this.docTypeController = docTypeController;
    }

    public void showAvAirportsDateController(Date inserDate) throws SQLException {
        //AQUI IMPRIMIR LO DEL REPOSITORY
        String border = "+------+-------------------------------------+--------------+";
        String header = "|  id  |                name                 |     city     |";

        List<Airport> airports = showAvAirportsDateUseCase.ShowAvAirportsDate(inserDate);
    
        ConsoleUtils.clear();
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
    
        for (Airport airport : airports) {
            System.out.printf("| %-4s | %-35s | %-12s |%n",
            airport.getId(), airport.getName(), airport.getCityname());
        }

        System.out.println(border);
    }

    public void showFlightsByAirpDateController(Date insertedDate, String insertedAiport) throws SQLException{
        String pborder = "+----------------------------------------------------------------+";
        String header = "|       Available flights on " + insertedDate + " departing from " + insertedAiport + "       |";
        String border = "+----+------------+----------------+-----------------+-----------+";
        String tableHeader = "| id |    date    |     origin     |     destiny     |   price   |";
        List<Flight> flights = showFlightsByAirpDateUseCase.ShowFlightsByAirpDate(insertedDate, insertedAiport);
        ConsoleUtils.clear();
        System.out.println(pborder);
        System.out.println(header);
        System.out.println(border);
        System.out.println(tableHeader);
        System.out.println(border);

        for (Flight flight : flights) {
            System.out.printf("| %-2d | %-10s | %-14s | %-15s | %-9.2f |%n",
                flight.getId(),
                flight.getTrip_date(),
                flight.getOrig_city_name(),
                flight.getDest_city_name(),
                flight.getPrice_trip()
            );       
        }

        System.out.println(border);
    }

    public void enterPassenger(int idBooking) throws SQLException {
        System.out.println("--------------------------------------\n" +
        "     Enter passenger information:     \n" +
        "--------------------------------------\n" +
        "\n"
        );
        System.out.print("Enter the Name: ");
        String firstName = ConsoleUtils.verifyEntryString();
        System.out.print("Enter the Identification Number: ");
        String idNumber = ConsoleUtils.verifyEntryString();
        System.out.print("Enter the Birth Date: ");
        Date birthDate = ConsoleUtils.verifyDate();
        Passenger passenger = new Passenger(idNumber, firstName, birthDate, idBooking);
        checkAndInsertPassengerUseCase.checkAndInsertPassenger(passenger);
    }

    public String enterCustomer() throws SQLException {
        String REGEX_ONLY_DIGITS = "^\\d+$";
        ConsoleUtils.clear();
        System.out.println("--------------------------------------\n" +
        "     Enter the Buyer information:     \n" +
        "--------------------------------------\n" +
        "\n"
        );  
        
        System.out.println("Enter the Name: ");
        String name = ConsoleUtils.verifyEntryString();   

        System.out.println("Enter the Age ");
        int age = ConsoleUtils.verifyEntryInt(1, 100);

        System.out.println("Please select the Type of Document: ");
        int doc_type = ConsoleUtils.verifyEntryInt(1, 3);

        docTypeController.viewAllTypes();

        System.out.println("Please enter the ID Number: ");
        String idNumber = ConsoleUtils.verifyingStringFormat(REGEX_ONLY_DIGITS, "numbers only");

        Customer customer = new Customer(idNumber, name, age, doc_type);
        checkAndInsertCustomerUseCase.checkAndInsertCustomer(customer);    
        
        return idNumber;
    }



    public int buyFlights() throws SQLException {

        ConsoleUtils.clear();
        System.out.println("--------------------------------------\n" +
        "            Global Flights            \n" +
        "       Please select an option:       \n" +
        "--------------------------------------\n" +
        "\n"
        );
    
        System.out.println("Please enter a date to search: ");
        Date insertedDate = ConsoleUtils.verifyDate();
    

    // HACER UNA CONSULTA DE LOS VUELOS QUE ESTAN DISPONIBLES ESA FECHA Y
    // SELECCIONAR LOS AEROPUERTOS DE DONDE SALEN ESOS VUELOS
    //MOSTRAR LOS AEROPUERTOS 
    showAvAirportsDateController(insertedDate);

    
    System.out.println("Please enter the Origin Airport: ");
    String selectedAirport = ConsoleUtils.verifyEntryString();
    

    // SELECCIONAR UNO DE LOS AEROPUERTO

    // HACER UNA CONSULTA DE LOS VUELOS QUE SALEN DE ESE AEROPUERTO, 

    // Y MOSTRAR LOS VUELOS QUE ESTAN DISPONIBLES PARA SALIR DE ESE AEROPUERTO EN LA FECHA INTRODUCIDA AL PRINCIPIO
    showFlightsByAirpDateController(insertedDate, selectedAirport);

    // SELECCIONAR UNA ID DE VUELO
    System.out.println("Please select a flight: ");
    int selectedFlight = ConsoleUtils.verifyingIntNoRange();

    //MOSTRAR TARIFAS
    flightFareController.getAllFlightFaresController();
    
    //seleccionar tarifa
    System.out.println("Please select a flight: ");
    int selectedFare = ConsoleUtils.verifyingIntNoRange();

    // CALCULAR TOTAL Y REALIZAR PAGO

    String customerid = enterCustomer();

    // AGREGAR la info de PASAJERO

    FlightBooking newBooking = new FlightBooking(insertedDate, selectedFlight, selectedAirport, selectedFare);
    int idBooking = createFlightBookingUseCase.createFlightBooking(newBooking);
    
    enterPassenger(idBooking);
    System.out.println("Your Booking ID is: " + idBooking);




    //SE CREA LA RESERVA

    
    

    // AQUI EL SISTEMA RETORNA UN NUMERO DE RESERVA
        int bookingID = 0;
        return bookingID;
    }   

}
