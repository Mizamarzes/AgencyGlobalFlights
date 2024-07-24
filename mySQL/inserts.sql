-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: viaduct.proxy.rlwy.net    Database: railway
-- ------------------------------------------------------
-- Server version	9.0.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `airline`
--

LOCK TABLES `airline` WRITE;
/*!40000 ALTER TABLE `airline` DISABLE KEYS */;
INSERT INTO `airline` VALUES (1,'American Airlines'),(2,'Delta Air Lines'),(3,'United Airlines'),(4,'Southwest Airlines'),(5,'JetBlue Airways'),(6,'Alaska Airlines'),(7,'Spirit Airlines'),(8,'Frontier Airlines'),(9,'Allegiant Air'),(10,'Hawaiian Airlines');
/*!40000 ALTER TABLE `airline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES ('1','wakanda por siempre',19),('AEP','Ministro Pistarini International Airport',4),('ASU','Silvio Pettirossi International Airport',10),('BCV','Philip S. W. Goldson International Airport',11),('BGA','Aeropuerto Internacional Palonegro',28),('BOG','Aeropuerto Internacional El Dorado',1),('BSB','Brasília International Airport',3),('CBR','Canberra Airport',26),('CCS','Simón Bolívar International Airport',7),('CDG','Charles de Gaulle Airport',16),('DCA','Ronald Reagan Washington National Airport',14),('DEL','Indira Gandhi International Airport',25),('FCO','Leonardo da Vinci International Airport',18),('ICN','Incheon International Airport',24),('KIN','Norman Manley International Airport',12),('LAX','Los Angeles International Airport',29),('LHR','Heathrow Airport',20),('LIM','Jorge Chávez International Airport',6),('MAD','Adolfo Suárez Madrid-Barajas Airport',19),('MEX','Benito Juárez International Airport',2),('MVD','Carrasco International Airport',9),('NRT','Narita International Airport',23),('PEK','Beijing Capital International Airport',22),('SCL','Comodoro Arturo Merino Benítez Intl Airport',5),('SDQ','Las Américas International Airport',13),('SVO','Sheremetyevo International Airport',21),('TXL','Berlin Tegel Airport',17),('UIO','Mariscal Sucre International Airport',8),('WLG','Wellington International Airport',27),('YOW','Ottawa Macdonald-Cartier International Airport',15);
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Bogotá','CO'),(2,'Mexico City','MX'),(3,'Brasília','BR'),(4,'Buenos Aires','AR'),(5,'Santiago','CL'),(6,'Lima','PE'),(7,'Caracas','VE'),(8,'Quito','EC'),(9,'Montevideo','UY'),(10,'Asunción','PY'),(11,'Belmopan','BZ'),(12,'Kingston','JM'),(13,'Santo Domingo','DO'),(14,'Washington, D.C.','US'),(15,'Ottawa','CA'),(16,'Paris','FR'),(17,'Berlin','DE'),(18,'Rome','IT'),(19,'Madrid','ES'),(20,'London','GB'),(21,'Moscow','RU'),(22,'Beijing','CN'),(23,'Tokyo','JP'),(24,'Seoul','KR'),(25,'New Delhi','IN'),(26,'Canberra','AU'),(27,'Wellington','NZ'),(28,'Bucaramanga','CO'),(29,'Los Angeles','US');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES ('AR','Argentina'),('AU','Australia'),('BR','Brazil'),('BZ','Belize'),('CA','Canada'),('CL','Chile'),('CN','China'),('CO','Colombia'),('DE','Germany'),('DO','Dominican Republic'),('EC','Ecuador'),('ES','Spain'),('FR','France'),('GB','United Kingdom'),('IN','India'),('IT','Italy'),('JM','Jamaica'),('JP','Japan'),('KR','South Korea'),('MX','Mexico'),('NZ','New Zealand'),('PE','Peru'),('PY','Paraguay'),('RU','Russia'),('US','United States'),('UY','Uruguay'),('VE','Venezuela');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('1097489826','Santiago Laguado Osorio',19,1),('1097782782','Juan Diego Contreras Melendez',18,1),('9876543211','Oscar Arismendi',28,1),('9876543212','Fabian mantilla',25,1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `documenttype`
--

LOCK TABLES `documenttype` WRITE;
/*!40000 ALTER TABLE `documenttype` DISABLE KEYS */;
INSERT INTO `documenttype` VALUES (1,'National Identification Card');
/*!40000 ALTER TABLE `documenttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employe_airline`
--

LOCK TABLES `employe_airline` WRITE;
/*!40000 ALTER TABLE `employe_airline` DISABLE KEYS */;
/*!40000 ALTER TABLE `employe_airline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('1234567891','Carla Pussy',2,'2020-01-01',1,'BGA'),('E001','John Doe',1,'2023-01-15',1,'BGA'),('E002','Jane Smith',2,'2022-05-23',2,'BGA'),('E003','Robert Johnson',3,'2021-11-30',3,'BOG'),('E004','Emily Davis',4,'2020-03-05',1,'LAX');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'2004-12-31',350.00,1,29),(2,'2024-01-11',450.50,3,4),(3,'2024-08-22',320.75,5,6),(4,'2024-08-23',280.00,20,1),(5,'2024-08-24',32.00,4,3),(6,'2024-08-25',410.00,6,7);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `flight_connection`
--

LOCK TABLES `flight_connection` WRITE;
/*!40000 ALTER TABLE `flight_connection` DISABLE KEYS */;
INSERT INTO `flight_connection` VALUES (2,'sldka',5,'eee_32','BGA'),(3,'lll_3214',2,'abc123','1');
/*!40000 ALTER TABLE `flight_connection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `flightbooking`
--

LOCK TABLES `flightbooking` WRITE;
/*!40000 ALTER TABLE `flightbooking` DISABLE KEYS */;
INSERT INTO `flightbooking` VALUES (1,'2004-12-31',4,'1097489826',1),(2,'2024-01-11',2,'1097782782',1),(4,'2004-12-31',1,'1097489826',4),(5,'2004-12-31',1,'1097489826',4),(6,'2004-12-31',1,'1097489826',4),(7,'2004-12-31',1,'1097489826',2),(8,'2004-12-31',1,'1097489826',1),(9,'2004-12-31',1,'1097489826',1),(10,'2004-12-31',1,'1097489826',1),(11,'2004-12-31',1,'1097489826',2),(12,'2004-12-31',1,'1097489826',1),(13,'2004-12-31',1,'1097489826',1),(14,'2004-12-31',1,'1097489826',1),(15,'2004-12-31',1,'1097489826',2),(16,'2004-12-31',1,'1097489826',1),(17,'2004-12-31',1,'1097489826',2),(18,'2004-12-31',1,'1097489826',1),(19,'2024-01-11',2,'1097489826',1),(20,'2024-01-11',2,'1097489826',4);
/*!40000 ALTER TABLE `flightbooking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `flightfare`
--

LOCK TABLES `flightfare` WRITE;
/*!40000 ALTER TABLE `flightfare` DISABLE KEYS */;
INSERT INTO `flightfare` VALUES (1,'Basic',100.00),(2,'Economy',100.00),(3,'hola',250.00),(4,'First Class',500.00),(5,'lol',25.00);
/*!40000 ALTER TABLE `flightfare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `gate`
--

LOCK TABLES `gate` WRITE;
/*!40000 ALTER TABLE `gate` DISABLE KEYS */;
/*!40000 ALTER TABLE `gate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` VALUES (1,'Boeing'),(2,'Airbus'),(3,'Embraer'),(4,'Bombardier'),(5,'Cessna'),(6,'Gulfstream'),(7,'Dassault'),(8,'Mitsubishi'),(9,'Antonov');
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (1,'737',1),(2,'A320',2),(3,'747',1),(4,'787 Dreamliner',1),(5,'Airbus A380',2),(6,'E190',3),(7,'CRJ900',4),(8,'Citation X',5),(9,'G650',6),(10,'Falcon 7X',7),(11,'MRJ90',8),(12,'An-225',9);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES ('1097489826','Santiago Laguado Osorio','2004-12-07','3157645002',17),('9876543212','Fabian Mantilla','1999-02-02','7897897854',14);
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `plane`
--

LOCK TABLES `plane` WRITE;
/*!40000 ALTER TABLE `plane` DISABLE KEYS */;
INSERT INTO `plane` VALUES ('abc123',22,'2002-04-12',5,3,2),('eee_32',34,'2004-04-12',1,1,1),('lll_321',43,'2004-03-11',1,1,1),('OWJ20G',600,'2005-02-01',2,2,2);
/*!40000 ALTER TABLE `plane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `planestatus`
--

LOCK TABLES `planestatus` WRITE;
/*!40000 ALTER TABLE `planestatus` DISABLE KEYS */;
INSERT INTO `planestatus` VALUES (1,'Active'),(2,'Inactive'),(3,'Maintenance'),(4,'Decommissioned'),(5,'In Construction'),(6,'Pending'),(7,'Operational'),(8,'Retired'),(9,'Stored'),(10,'Sold');
/*!40000 ALTER TABLE `planestatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `revision`
--

LOCK TABLES `revision` WRITE;
/*!40000 ALTER TABLE `revision` DISABLE KEYS */;
INSERT INTO `revision` VALUES (2,'2024-07-22','abc123','General Revision, Mas naa','1234567891'),(3,'2024-07-23','OWJ20G','Operability Check','1234567891');
/*!40000 ALTER TABLE `revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Super Admin'),(2,'Administrator'),(3,'Maintenance Technician'),(4,'Sales Agent');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tripcrew`
--

LOCK TABLES `tripcrew` WRITE;
/*!40000 ALTER TABLE `tripcrew` DISABLE KEYS */;
INSERT INTO `tripcrew` VALUES ('E001',3),('E002',3);
/*!40000 ALTER TABLE `tripcrew` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tripulationrole`
--

LOCK TABLES `tripulationrole` WRITE;
/*!40000 ALTER TABLE `tripulationrole` DISABLE KEYS */;
INSERT INTO `tripulationrole` VALUES (1,'Operations Manager'),(2,'Technician'),(3,'Sales Agent'),(4,'Pilot'),(5,'Co-pilot'),(6,'Cabin Crew'),(7,'Flight Dispatcher');
/*!40000 ALTER TABLE `tripulationrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'santilaguado','santi@gmail.com','santi123',1),(2,'mizamarzes','mizamarzes@gmail.com','miza123',1),(3,'administrator','admin1@gmail.com','admin123',2),(4,'technician','tech1@gmail.com','tech123',3),(5,'salesagent','sales1@gmail.com','sales123',4);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-24 15:13:20