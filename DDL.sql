-- SQL file to create the airport database

-- Delete the database if exists
DROP DATABASE IF EXISTS airport;

-- Create the database if not exists
CREATE DATABASE airport;

-- Use the database
USE airport;

-- Create tables for users

CREATE TABLE IF NOT EXISTS rols (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    CONSTRAINT pk_rols_id PRIMARY KEY(id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS permmisions (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    CONSTRAINT pk_permmisions_id PRIMARY KEY(id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS rols_permissions (
    idrol INT NOT NULL,
    idpermission INT NOT NULL,
    CONSTRAINT pk_rolspermissions_id PRIMARY KEY(idrol, idpermission),
    CONSTRAINT fk_rolsperms_rol FOREIGN KEY(idrol) REFERENCES rols(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_rolsperms_permmisions FOREIGN KEY(idpermission) REFERENCES permmisions(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    idrols INT NOT NULL,
    CONSTRAINT pk_users_id PRIMARY KEY(id),
    CONSTRAINT fk_users_rolS FOREIGN KEY(idrols) REFERENCES rols(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

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


-- Create table for countries
CREATE TABLE IF NOT EXISTS countries (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    CONSTRAINT pk_countries_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for cities
CREATE TABLE IF NOT EXISTS cities (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    idcountry INT NOT NULL,
    CONSTRAINT pk_cities_id PRIMARY KEY(id),
    CONSTRAINT fk_cities_country_id FOREIGN KEY(idcountry) REFERENCES countries(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for flights
CREATE TABLE IF NOT EXISTS flights (
    id INT NOT NULL AUTO_INCREMENT,
    trip_date DATE NOT NULL,
    price_trip DOUBLE NOT NULL,
    orig_city INT NOT NULL,
    dest_city INT NOT NULL,
    CONSTRAINT pk_flights_id PRIMARY KEY(id),
    CONSTRAINT fk_flights_orig_city_id FOREIGN KEY(orig_city) REFERENCES cities(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_flights_dest_city_id FOREIGN KEY(dest_city) REFERENCES cities(id) ON DELETE CASCADE ON UPDATE CASCADE
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


-- Create table for customers
CREATE TABLE IF NOT EXISTS customers (
    id VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(30) NOT NULL,
    age INT NOT NULL,
    idnumber VARCHAR(20) NOT NULL UNIQUE,
    iddocument INT NOT NULL,
    iduser INT NOT NULL,
    CONSTRAINT pk_customers_id PRIMARY KEY(id),
    CONSTRAINT fk_customers_documenttypes_id FOREIGN KEY(iddocument) REFERENCES documenttypes(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_customers_user_id FOREIGN KEY(iduser) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;


-- Create table for trip booking details
CREATE TABLE IF NOT EXISTS flightbooking (
    id INT NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    idflights INT NOT NULL,
    idcustomers INT NOT NULL,
    idfares INT NOT NULL,
    CONSTRAINT pk_flightbooking_id PRIMARY KEY(id),
    CONSTRAINT fk_flightbooking_flights_id FOREIGN KEY(idflights) REFERENCES flights(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_flightbooking_customers_id FOREIGN KEY(idcustomers) REFERENCES customers(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_flightbooking_fares_id FOREIGN KEY(idfares) REFERENCES flightfares(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for airports
CREATE TABLE IF NOT EXISTS airports (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    idcity INT NOT NULL,
    CONSTRAINT pk_airports_id PRIMARY KEY(id),
    CONSTRAINT fk_airports_city_id FOREIGN KEY(idcity) REFERENCES cities(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for employees
CREATE TABLE IF NOT EXISTS employees (
    id VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(40) NOT NULL,
    idrole INT NOT NULL,
    ingresdate DATE NOT NULL,
    idairline INT NOT NULL,
    idairport INT NOT NULL,
    iduser INT NOT NULL,
    CONSTRAINT pk_employees_id PRIMARY KEY(id),
    CONSTRAINT fk_employees_roles_id FOREIGN KEY(idrole) REFERENCES tripulationroles(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_employees_airline_id FOREIGN KEY(idairline) REFERENCES airlines(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_employees_airport_id FOREIGN KEY(idairport) REFERENCES airports(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_employees_user_id FOREIGN KEY(iduser) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS employe_airlines (
    id_employee INT NOT NULL,
    id_airline INT NOT NULL,
    CONSTRAINT pk_employe_airlines_id PRIMARY KEY(id_employee, id_airline),
    CONSTRAINT fk_employe_airlines_emp_id FOREIGN KEY(id_employee) REFERENCES employees(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_employe_airlines_airl_id FOREIGN KEY(id_airline) REFERENCES airlines(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for revision details
CREATE TABLE IF NOT EXISTS revision_details (
    id INT NOT NULL AUTO_INCREMENT,
    description TEXT,
    date DATE NOT NULL,
    id_employee INT NOT NULL,
    CONSTRAINT pk_revision_details_id PRIMARY KEY(id),
    CONSTRAINT fk_revision_details_employee_id FOREIGN KEY(id_employee) REFERENCES employees(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for models
CREATE TABLE IF NOT EXISTS models (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    idmanufacturer INT NOT NULL,
    CONSTRAINT pk_models_id PRIMARY KEY(id),
    CONSTRAINT fk_models_manufacturer_id FOREIGN KEY(idmanufacturer) REFERENCES manufacturers(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for planes
CREATE TABLE IF NOT EXISTS planes (
    id INT NOT NULL AUTO_INCREMENT,
    plates VARCHAR(30) NOT NULL UNIQUE,
    capacity INT NOT NULL,
    fabrication_date DATE NOT NULL,
    id_status INT NOT NULL,
    id_model INT NOT NULL,
    id_airline INT NOT NULL,
    CONSTRAINT pk_planes_id PRIMARY KEY(id),
    CONSTRAINT fk_planes_status_id FOREIGN KEY(id_status) REFERENCES statuses(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_planes_model_id FOREIGN KEY(id_model) REFERENCES models(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_planes_airline_id FOREIGN KEY(id_airline) REFERENCES airlines(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for flight connections
CREATE TABLE IF NOT EXISTS flight_connections (
    id INT NOT NULL AUTO_INCREMENT,
    connection_number VARCHAR(20) NOT NULL,
    id_trip INT NOT NULL,
    id_plane INT NOT NULL,
    id_dest_airport INT NOT NULL,
    CONSTRAINT pk_flight_connections_id PRIMARY KEY(id),
    CONSTRAINT fk_flight_connections_trip_id FOREIGN KEY(id_trip) REFERENCES flights(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_flight_connections_plane_id FOREIGN KEY(id_plane) REFERENCES planes(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_flight_connections_airport_id FOREIGN KEY(id_dest_airport) REFERENCES airports(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for trip connections
CREATE TABLE IF NOT EXISTS tripcrews (
    id INT NOT NULL AUTO_INCREMENT,
    idemployees INT NOT NULL,
    idconnection INT NOT NULL,
    CONSTRAINT pk_tripcrews_id PRIMARY KEY(id),
    CONSTRAINT fk_tripcrews_employees_id FOREIGN KEY(idemployees) REFERENCES employees(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_tripcrews_connection_id FOREIGN KEY(idconnection) REFERENCES flight_connections(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for revisions
CREATE TABLE IF NOT EXISTS revisions (
    id INT NOT NULL AUTO_INCREMENT,
    revision_date DATE NOT NULL,
    id_plane INT NOT NULL,
    description TEXT NULL,
    CONSTRAINT pk_revisions_id PRIMARY KEY(id),
    CONSTRAINT fk_revisions_plane_id FOREIGN KEY(id_plane) REFERENCES planes(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for revision employees
CREATE TABLE IF NOT EXISTS revemployee (
    id INT NOT NULL AUTO_INCREMENT,
    idemployee INT NOT NULL,
    idrevision INT NOT NULL,
    CONSTRAINT pk_revemployees_id PRIMARY KEY(id),
    CONSTRAINT fk_revemployees_employee_id FOREIGN KEY(idemployee) REFERENCES employees(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_revemployees_revision_id FOREIGN KEY(idrevision) REFERENCES revisions(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for gates
CREATE TABLE IF NOT EXISTS gates (
    id INT NOT NULL AUTO_INCREMENT,
    gatenumber VARCHAR(10) NOT NULL,
    idairport INT NOT NULL,
    CONSTRAINT pk_gates_id PRIMARY KEY(id),
    CONSTRAINT fk_gates_airport_id FOREIGN KEY(idairport) REFERENCES airports(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;




-- Juan Diego Contreras - Santiago Laguado
