-- sql file to insertions

-- USE railway;
USE airport;

INSERT INTO role (id, name) VALUES 
        (1, 'Super Admin'),
       	(2, 'Administrator'),
       	(3, 'Maintenance Technician'),
       	(4, 'Sales Agent');


INSERT INTO user (id, username, email, password, idrole) VALUES  
        (1, 'santilaguado', 'santi@gmail.com', 'santi123', 1),  
        (2, 'mizamarzes', 'mizamarzes@gmail.com', 'miza123', 1),
        (3, 'administrator', 'admin1@gmail.com', 'admin123', 2),
        (3, 'technician', 'tech1@gmail.com', 'tech123', 2),
        (3, 'salesagent', 'sales1@gmail.com', 'sales123', 2);

INSERT INTO manufacturer (name) VALUES ('Boeing');
INSERT INTO manufacturer (name) VALUES ('Airbus');
INSERT INTO manufacturer (name) VALUES ('Lockheed Martin');
INSERT INTO manufacturer (name) VALUES ('Embraer');
INSERT INTO manufacturer (name) VALUES ('Bombardier');
INSERT INTO manufacturer (name) VALUES ('Cessna');
INSERT INTO manufacturer (name) VALUES ('Gulfstream');
INSERT INTO manufacturer (name) VALUES ('Dassault');
INSERT INTO manufacturer (name) VALUES ('Mitsubishi');
INSERT INTO manufacturer (name) VALUES ('Antonov');

INSERT INTO planestatus (name) VALUES ('Active');
INSERT INTO planestatus (name) VALUES ('Inactive');
INSERT INTO planestatus (name) VALUES ('Maintenance');
INSERT INTO planestatus (name) VALUES ('Decommissioned');
INSERT INTO planestatus (name) VALUES ('Under Construction');
INSERT INTO planestatus (name) VALUES ('Pending');
INSERT INTO planestatus (name) VALUES ('Operational');
INSERT INTO planestatus (name) VALUES ('Retired');
INSERT INTO planestatus (name) VALUES ('Stored');
INSERT INTO planestatus (name) VALUES ('Sold');

INSERT INTO model (name, idmanufacturer) VALUES ('737', 1);
INSERT INTO model (name, idmanufacturer) VALUES ('A320', 2);
INSERT INTO model (name, idmanufacturer) VALUES ('F-22 Raptor', 3);
INSERT INTO model (name, idmanufacturer) VALUES ('E190', 4);
INSERT INTO model (name, idmanufacturer) VALUES ('CRJ900', 5);
INSERT INTO model (name, idmanufacturer) VALUES ('Citation X', 6);
INSERT INTO model (name, idmanufacturer) VALUES ('G650', 7);
INSERT INTO model (name, idmanufacturer) VALUES ('Falcon 7X', 8);
INSERT INTO model (name, idmanufacturer) VALUES ('MRJ90', 9);
INSERT INTO model (name, idmanufacturer) VALUES ('An-225', 10);

INSERT INTO airline (name) VALUES ('American Airlines');
INSERT INTO airline (name) VALUES ('Delta Air Lines');
INSERT INTO airline (name) VALUES ('United Airlines');
INSERT INTO airline (name) VALUES ('Southwest Airlines');
INSERT INTO airline (name) VALUES ('JetBlue Airways');
INSERT INTO airline (name) VALUES ('Alaska Airlines');
INSERT INTO airline (name) VALUES ('Spirit Airlines');
INSERT INTO airline (name) VALUES ('Frontier Airlines');
INSERT INTO airline (name) VALUES ('Allegiant Air');
INSERT INTO airline (name) VALUES ('Hawaiian Airlines');
