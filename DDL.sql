-- SQL file to create the airport database

-- Delete the database if exists
-- DROP DATABASE IF EXISTS airport;

-- Create the database if not exists
-- CREATE DATABASE airport;

-- Use the database
USE railway;

-- Create tables for user

CREATE TABLE IF NOT EXISTS role (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    CONSTRAINT pk_role_id PRIMARY KEY(id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS permmision (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    CONSTRAINT pk_permmision_id PRIMARY KEY(id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS role_permission (
    idrol INT NOT NULL,
    idpermission INT NOT NULL,
    CONSTRAINT pk_rolepermissions_id PRIMARY KEY(idrol, idpermission),
    CONSTRAINT fk_roleperms_rol FOREIGN KEY(idrol) REFERENCES role(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_roleperms_permmision FOREIGN KEY(idpermission) REFERENCES permmision(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS user (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    idrole INT NOT NULL,
    CONSTRAINT pk_user_id PRIMARY KEY(id),
    CONSTRAINT fk_user_role FOREIGN KEY(idrole) REFERENCES role(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for document types
CREATE TABLE IF NOT EXISTS documenttype (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    CONSTRAINT pk_documenttype_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for flight fares
CREATE TABLE IF NOT EXISTS flightfare (
    id INT NOT NULL AUTO_INCREMENT,
    description VARCHAR(20),
    details TEXT,
    value DOUBLE(7,2),
    CONSTRAINT pk_flightfare_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for airline
CREATE TABLE IF NOT EXISTS airline (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    CONSTRAINT pk_airline_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for tripulation roles
CREATE TABLE IF NOT EXISTS tripulationrole (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    CONSTRAINT pk_tripulationrole_id PRIMARY KEY(id)
) ENGINE = InnoDB;


-- Create table for country
CREATE TABLE IF NOT EXISTS country (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    CONSTRAINT pk_country_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for city
CREATE TABLE IF NOT EXISTS city (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    idcountry INT NOT NULL,
    CONSTRAINT pk_city_id PRIMARY KEY(id),
    CONSTRAINT fk_city_country_id FOREIGN KEY(idcountry) REFERENCES country(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for flight
CREATE TABLE IF NOT EXISTS flight (
    id INT NOT NULL AUTO_INCREMENT,
    trip_date DATE NOT NULL,
    price_trip DOUBLE NOT NULL,
    orig_city INT NOT NULL,
    dest_city INT NOT NULL,
    CONSTRAINT pk_flight_id PRIMARY KEY(id),
    CONSTRAINT fk_flight_orig_city_id FOREIGN KEY(orig_city) REFERENCES city(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_flight_dest_city_id FOREIGN KEY(dest_city) REFERENCES city(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for planestatus
CREATE TABLE IF NOT EXISTS planestatus (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    CONSTRAINT pk_planestatus_id PRIMARY KEY(id)
) ENGINE = InnoDB;

-- Create table for manufacturer
CREATE TABLE IF NOT EXISTS manufacturer (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    CONSTRAINT pk_manufacturer_id PRIMARY KEY(id)
) ENGINE = InnoDB;


-- Create table for customer
CREATE TABLE IF NOT EXISTS customer (
    id VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(30) NOT NULL,
    age INT NOT NULL,
    idnumber VARCHAR(20) NOT NULL UNIQUE,
    iddocument INT NOT NULL,
    iduser INT NOT NULL,
    CONSTRAINT pk_customer_id PRIMARY KEY(id),
    CONSTRAINT fk_customer_documenttype_id FOREIGN KEY(iddocument) REFERENCES documenttype(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_customer_user_id FOREIGN KEY(iduser) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;


-- Create table for trip booking details
CREATE TABLE IF NOT EXISTS flightbooking (
    id INT NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    idflight INT NOT NULL,
    idcustomer VARCHAR(10) NOT NULL,
    idfares INT NOT NULL,
    CONSTRAINT pk_flightbooking_id PRIMARY KEY(id),
    CONSTRAINT fk_flightbooking_flight_id FOREIGN KEY(idflight) REFERENCES flight(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_flightbooking_customer_id FOREIGN KEY(idcustomer) REFERENCES customer(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_flightbooking_fares_id FOREIGN KEY(idfares) REFERENCES flightfare(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for airport
CREATE TABLE IF NOT EXISTS airport (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    idcity INT NOT NULL,
    CONSTRAINT pk_airport_id PRIMARY KEY(id),
    CONSTRAINT fk_airport_city_id FOREIGN KEY(idcity) REFERENCES city(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for employee
CREATE TABLE IF NOT EXISTS employee (
    id VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(40) NOT NULL,
    idrole INT NOT NULL,
    ingresdate DATE NOT NULL,
    idairline INT NOT NULL,
    idairport INT NOT NULL,
    iduser INT NOT NULL,
    CONSTRAINT pk_employee_id PRIMARY KEY(id),
    CONSTRAINT fk_employee_roles_id FOREIGN KEY(idrole) REFERENCES tripulationrole(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_employee_airline_id FOREIGN KEY(idairline) REFERENCES airline(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_employee_airport_id FOREIGN KEY(idairport) REFERENCES airport(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_employee_user_id FOREIGN KEY(iduser) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS employe_airline (
    id_employee VARCHAR(10) NOT NULL,
    id_airline INT NOT NULL,
    CONSTRAINT pk_employe_airline_id PRIMARY KEY(id_employee, id_airline),
    CONSTRAINT fk_employe_airline_emp_id FOREIGN KEY(id_employee) REFERENCES employee(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_employe_airline_airl_id FOREIGN KEY(id_airline) REFERENCES airline(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for revision details
CREATE TABLE IF NOT EXISTS revision_detail (
    id INT NOT NULL AUTO_INCREMENT,
    description TEXT,
    date DATE NOT NULL,
    id_employee VARCHAR(10) NOT NULL,
    CONSTRAINT pk_revision_detail_id PRIMARY KEY(id),
    CONSTRAINT fk_revision_detail_employee_id FOREIGN KEY(id_employee) REFERENCES employee(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for model
CREATE TABLE IF NOT EXISTS model (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    idmanufacturer INT NOT NULL,
    CONSTRAINT pk_model_id PRIMARY KEY(id),
    CONSTRAINT fk_model_manufacturer_id FOREIGN KEY(idmanufacturer) REFERENCES manufacturer(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for plane
CREATE TABLE IF NOT EXISTS plane (
    id INT NOT NULL AUTO_INCREMENT,
    plates VARCHAR(30) NOT NULL UNIQUE,
    capacity INT NOT NULL,
    fabrication_date DATE NOT NULL,
    id_status INT NOT NULL,
    id_model INT NOT NULL,
    id_airline INT NOT NULL,
    CONSTRAINT pk_plane_id PRIMARY KEY(id),
    CONSTRAINT fk_plane_status_id FOREIGN KEY(id_status) REFERENCES planestatus(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_plane_model_id FOREIGN KEY(id_model) REFERENCES model(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_plane_airline_id FOREIGN KEY(id_airline) REFERENCES airline(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for flight connections
CREATE TABLE IF NOT EXISTS flight_connection (
    id INT NOT NULL AUTO_INCREMENT,
    connection_number VARCHAR(20) NOT NULL,
    id_trip INT NOT NULL,
    id_plane INT NOT NULL,
    id_dest_airport INT NOT NULL,
    CONSTRAINT pk_flight_connection_id PRIMARY KEY(id),
    CONSTRAINT fk_flight_connection_trip_id FOREIGN KEY(id_trip) REFERENCES flight(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_flight_connection_plane_id FOREIGN KEY(id_plane) REFERENCES plane(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_flight_connection_airport_id FOREIGN KEY(id_dest_airport) REFERENCES airport(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for trip connections
CREATE TABLE IF NOT EXISTS tripcrew (
    id INT NOT NULL AUTO_INCREMENT,
    idemployee VARCHAR(10) NOT NULL,
    idconnection INT NOT NULL,
    CONSTRAINT pk_tripcrew_id PRIMARY KEY(id),
    CONSTRAINT fk_tripcrew_employee_id FOREIGN KEY(idemployee) REFERENCES employee(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_tripcrew_connection_id FOREIGN KEY(idconnection) REFERENCES flight_connection(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for revision
CREATE TABLE IF NOT EXISTS revision (
    id INT NOT NULL AUTO_INCREMENT,
    revision_date DATE NOT NULL,
    id_plane INT NOT NULL,
    description TEXT NULL,
    CONSTRAINT pk_revision_id PRIMARY KEY(id),
    CONSTRAINT fk_revision_plane_id FOREIGN KEY(id_plane) REFERENCES plane(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for revision employee
CREATE TABLE IF NOT EXISTS revemployee (
    id INT NOT NULL AUTO_INCREMENT,
    idemployee VARCHAR(10) NOT NULL,
    idrevision INT NOT NULL,
    CONSTRAINT pk_revemployee_id PRIMARY KEY(id),
    CONSTRAINT fk_revemployee_employee_id FOREIGN KEY(idemployee) REFERENCES employee(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_revemployee_revision_id FOREIGN KEY(idrevision) REFERENCES revision(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;

-- Create table for gate
CREATE TABLE IF NOT EXISTS gate (
    id INT NOT NULL AUTO_INCREMENT,
    gatenumber VARCHAR(10) NOT NULL,
    idairport INT NOT NULL,
    CONSTRAINT pk_gate_id PRIMARY KEY(id),
    CONSTRAINT fk_gate_airport_id FOREIGN KEY(idairport) REFERENCES airport(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;





-- Juan Diego Contreras - Santiago Laguado
