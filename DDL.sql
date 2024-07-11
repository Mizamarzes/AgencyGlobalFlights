-- SQL file to create the airport database

-- Delete the database if exists
DROP DATABASE IF EXISTS airport;

-- Create the database if not exists
CREATE DATABASE airport;

-- Use the database
USE airport;

-- Create table for document types
CREATE TABLE IF NOT EXISTS documenttypes (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    CONSTRAINT pk_documenttypes_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for flight fares
CREATE TABLE IF NOT EXISTS flightfares (
    id INT NOT NULL AUTO_INCREMENT,
    description VARCHAR(20),
    details TEXT,
    value DOUBLE(7,2),
    CONSTRAINT pk_flightfares_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for airlines
CREATE TABLE IF NOT EXISTS airlines (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    CONSTRAINT pk_airlines_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for tripulation roles
CREATE TABLE IF NOT EXISTS tripulationroles (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    CONSTRAINT pk_tripulationroles_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for trips
CREATE TABLE IF NOT EXISTS trips (
    id INT NOT NULL AUTO_INCREMENT,
    trip_date DATE NOT NULL,
    price_trip DOUBLE NOT NULL,
    CONSTRAINT pk_trips_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for statuses
CREATE TABLE IF NOT EXISTS statuses (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    CONSTRAINT pk_statuses_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for manufacturers
CREATE TABLE IF NOT EXISTS manufacturers (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    CONSTRAINT pk_manufacturers_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for countries
CREATE TABLE IF NOT EXISTS countries (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    CONSTRAINT pk_countries_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for customers
CREATE TABLE IF NOT EXISTS customers (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    age INT NOT NULL,
    iddocument INT NOT NULL,
    CONSTRAINT pk_customers_id PRIMARY KEY(id),
    CONSTRAINT fk_customers_documenttypes_id FOREIGN KEY(iddocument) REFERENCES documenttypes(id)
) ENGINE = InnoDB;

-- Create table for trip bookings
CREATE TABLE IF NOT EXISTS tripbooking (
    id INT NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    idtrips INT NOT NULL,
    CONSTRAINT pk_tripbooking_id PRIMARY KEY(id),
    CONSTRAINT fk_tripbooking_trips_id FOREIGN KEY(idtrips) REFERENCES trips(id)
) ENGINE = InnoDB;

-- Create table for trip booking details
CREATE TABLE IF NOT EXISTS tripbookingdetails (
    id INT NOT NULL AUTO_INCREMENT,
    idtripbooking INT NOT NULL,
    idcustomers INT NOT NULL,
    idfares INT NOT NULL,
    CONSTRAINT pk_tripbookingdetails_id PRIMARY KEY(id),
    CONSTRAINT fk_tripbookingdetails_tripbooking_id FOREIGN KEY(idtripbooking) REFERENCES tripbooking(id),
    CONSTRAINT fk_tripbookingdetails_customers_id FOREIGN KEY(idcustomers) REFERENCES customers(id),
    CONSTRAINT fk_tripbookingdetails_fares_id FOREIGN KEY(idfares) REFERENCES flightfares(id)
) ENGINE = InnoDB;

-- Create table for cities
CREATE TABLE IF NOT EXISTS cities (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    idcountry INT NOT NULL,
    CONSTRAINT pk_cities_id PRIMARY KEY(id),
    CONSTRAINT fk_cities_country_id FOREIGN KEY(idcountry) REFERENCES countries(id)
) ENGINE = InnoDB;

-- Create table for airports
CREATE TABLE IF NOT EXISTS airports (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    idcity INT NOT NULL,
    CONSTRAINT pk_airports_id PRIMARY KEY(id),
    CONSTRAINT fk_airports_city_id FOREIGN KEY(idcity) REFERENCES cities(id)
) ENGINE = InnoDB;

-- Create table for employees
CREATE TABLE IF NOT EXISTS employees (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    idrole INT NOT NULL,
    ingresdate DATE NOT NULL,
    idairline INT NOT NULL,
    idairport INT NOT NULL,
    CONSTRAINT pk_employees_id PRIMARY KEY(id),
    CONSTRAINT fk_employees_roles_id FOREIGN KEY(idrole) REFERENCES tripulationroles(id),
    CONSTRAINT fk_employees_airline_id FOREIGN KEY(idairline) REFERENCES airlines(id),
    CONSTRAINT fk_employees_airport_id FOREIGN KEY(idairport) REFERENCES airports(id)
) ENGINE = InnoDB;

-- Create table for revision details
CREATE TABLE IF NOT EXISTS revision_details (
    id INT NOT NULL AUTO_INCREMENT,
    description TEXT,
    date DATE NOT NULL,
    id_employee INT NOT NULL,
    CONSTRAINT pk_revision_details_id PRIMARY KEY(id),
    CONSTRAINT fk_revision_details_employee_id FOREIGN KEY(id_employee) REFERENCES employees(id)
) ENGINE = InnoDB;

-- Create table for models
CREATE TABLE IF NOT EXISTS models (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    idmanufacturer INT NOT NULL,
    CONSTRAINT pk_models_id PRIMARY KEY(id),
    CONSTRAINT fk_models_manufacturer_id FOREIGN KEY(idmanufacturer) REFERENCES manufacturers(id)
) ENGINE = InnoDB;

-- Create table for planes
CREATE TABLE IF NOT EXISTS planes (
    id INT NOT NULL AUTO_INCREMENT,
    plates VARCHAR(30) NOT NULL,
    capacity INT NOT NULL,
    fabrication_date DATE NOT NULL,
    id_status INT NOT NULL,
    id_model INT NOT NULL,
    CONSTRAINT pk_planes_id PRIMARY KEY(id),
    CONSTRAINT fk_planes_status_id FOREIGN KEY(id_status) REFERENCES statuses(id),
    CONSTRAINT fk_planes_model_id FOREIGN KEY(id_model) REFERENCES models(id)
) ENGINE = InnoDB;

-- Create table for flight connections
CREATE TABLE IF NOT EXISTS flight_connections (
    id INT NOT NULL AUTO_INCREMENT,
    connection_number VARCHAR(20) NOT NULL,
    id_trip INT NOT NULL,
    id_plane INT NOT NULL,
    id_airport INT NOT NULL,
    CONSTRAINT pk_flight_connections_id PRIMARY KEY(id),
    CONSTRAINT fk_flight_connections_trip_id FOREIGN KEY(id_trip) REFERENCES trips(id),
    CONSTRAINT fk_flight_connections_plane_id FOREIGN KEY(id_plane) REFERENCES planes(id),
    CONSTRAINT fk_flight_connections_airport_id FOREIGN KEY(id_airport) REFERENCES airports(id)
) ENGINE = InnoDB;

-- Create table for trip connections
CREATE TABLE IF NOT EXISTS triprecs (
    id INT NOT NULL AUTO_INCREMENT,
    idemployees INT NOT NULL,
    idconnection INT NOT NULL,
    CONSTRAINT pk_triprecs_id PRIMARY KEY(id),
    CONSTRAINT fk_triprecs_employees_id FOREIGN KEY(idemployees) REFERENCES employees(id),
    CONSTRAINT fk_triprecs_connection_id FOREIGN KEY(idconnection) REFERENCES flight_connections(id)
) ENGINE = InnoDB;

-- Create table for revisions
CREATE TABLE IF NOT EXISTS revisions (
    id INT NOT NULL AUTO_INCREMENT,
    revision_date DATE NOT NULL,
    id_plane INT NOT NULL,
    CONSTRAINT pk_revisions_id PRIMARY KEY(id),
    CONSTRAINT fk_revisions_plane_id FOREIGN KEY(id_plane) REFERENCES planes(id)
) ENGINE = InnoDB;

-- Create table for revision employees
CREATE TABLE IF NOT EXISTS revemployee (
    id INT NOT NULL AUTO_INCREMENT,
    idemployee INT NOT NULL,
    idrevision INT NOT NULL,
    CONSTRAINT pk_revemployees_id PRIMARY KEY(id),
    CONSTRAINT fk_revemployees_employee_id FOREIGN KEY(idemployee) REFERENCES employees(id),
    CONSTRAINT fk_revemployees_revision_id FOREIGN KEY(idrevision) REFERENCES revisions(id)
) ENGINE = InnoDB;

-- Create table for gates
CREATE TABLE IF NOT EXISTS gates (
    id INT NOT NULL AUTO_INCREMENT,
    gatenumber VARCHAR(10) NOT NULL,
    idairport INT NOT NULL,
    CONSTRAINT pk_gates_id PRIMARY KEY(id),
    CONSTRAINT fk_gates_airport_id FOREIGN KEY(idairport) REFERENCES airports(id)
) ENGINE = InnoDB;

-- Juan Diego Contreras - Santiago Laguado
