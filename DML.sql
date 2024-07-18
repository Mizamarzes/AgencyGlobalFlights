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

INSERT INTO manufacturer (id, name) VALUES (1, 'Boeing');
INSERT INTO manufacturer (id, name) VALUES (2, 'Airbus');
INSERT INTO manufacturer (id, name) VALUES (3, 'Embraer');
INSERT INTO manufacturer (id, name) VALUES (4, 'Bombardier');
INSERT INTO manufacturer (id, name) VALUES (5, 'Cessna');
INSERT INTO manufacturer (id, name) VALUES (6, 'Gulfstream');
INSERT INTO manufacturer (id, name) VALUES (7, 'Dassault');
INSERT INTO manufacturer (id, name) VALUES (8, 'Mitsubishi');
INSERT INTO manufacturer (id, name) VALUES (9, 'Antonov');

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
INSERT INTO model (name, idmanufacturer) VALUES ('747', 1);
INSERT INTO model (name, idmanufacturer) VALUES ('787 Dreamliner', 1);
INSERT INTO model (name, idmanufacturer) VALUES ('Airbus A380', 2);
INSERT INTO model (name, idmanufacturer) VALUES ('E190', 3);
INSERT INTO model (name, idmanufacturer) VALUES ('CRJ900', 4);
INSERT INTO model (name, idmanufacturer) VALUES ('Citation X', 5);
INSERT INTO model (name, idmanufacturer) VALUES ('G650', 6);
INSERT INTO model (name, idmanufacturer) VALUES ('Falcon 7X', 7);
INSERT INTO model (name, idmanufacturer) VALUES ('MRJ90', 8);
INSERT INTO model (name, idmanufacturer) VALUES ('An-225', 9);

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

INSERT INTO country (id, name) VALUES
('CO', 'Colombia'),
('MX', 'Mexico'),
('BR', 'Brazil'),
('AR', 'Argentina'),
('CL', 'Chile'),
('PE', 'Peru'),
('VE', 'Venezuela'),
('EC', 'Ecuador'),
('UY', 'Uruguay'),
('PY', 'Paraguay'),
('BZ', 'Belize'),
('JM', 'Jamaica'),
('DO', 'Dominican Republic'),
('US', 'United States'),
('CA', 'Canada'),
('FR', 'France'),
('DE', 'Germany'),
('IT', 'Italy'),
('ES', 'Spain'),
('GB', 'United Kingdom'),
('RU', 'Russia'),
('CN', 'China'),
('JP', 'Japan'),
('KR', 'South Korea'),
('IN', 'India'),
('AU', 'Australia'),
('NZ', 'New Zealand');

INSERT INTO city (id, name, idcountry) VALUES
(1, 'Bogotá', 'CO'),
(2, 'Mexico City', 'MX'),
(3, 'Brasília', 'BR'),
(4, 'Buenos Aires', 'AR'),
(5, 'Santiago', 'CL'),
(6, 'Lima', 'PE'),
(7, 'Caracas', 'VE'),
(8, 'Quito', 'EC'),
(9, 'Montevideo', 'UY'),
(10, 'Asunción', 'PY'),
(11, 'Belmopan', 'BZ'),
(12, 'Kingston', 'JM'),
(13, 'Santo Domingo', 'DO'),
(14, 'Washington, D.C.', 'US'),
(15, 'Ottawa', 'CA'),
(16, 'Paris', 'FR'),
(17, 'Berlin', 'DE'),
(18, 'Rome', 'IT'),
(19, 'Madrid', 'ES'),
(20, 'London', 'GB'),
(21, 'Moscow', 'RU'),
(22, 'Beijing', 'CN'),
(23, 'Tokyo', 'JP'),
(24, 'Seoul', 'KR'),
(25, 'New Delhi', 'IN'),
(26, 'Canberra', 'AU'),
(27, 'Wellington', 'NZ');


INSERT INTO flightfare (name, value) VALUES ('Basic', 100.00);
INSERT INTO flightfare (name, value) VALUES ('Economy', 100.00);
INSERT INTO flightfare (name, value) VALUES ('Business', 250.00);
INSERT INTO flightfare (name, value) VALUES ('First Class', 500.00);