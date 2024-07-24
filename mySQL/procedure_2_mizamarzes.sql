-- This procedure show up information about planes

DELIMITER $$
DROP PROCEDURE IF EXISTS showObjectInformationIDVARCHARPlane $$
CREATE PROCEDURE showObjectInformationIDVARCHARPlane(
    IN object_id VARCHAR(30)
)
BEGIN
    SET @query = CONCAT('
		SELECT
			p.id,
			p.capacity,
			p.fabrication_date,
			pst.name AS status_name,
			m.name AS model_name,
			air.name AS airline_name
		FROM plane AS p
		JOIN planestatus AS pst ON pst.id = p.id_status
		JOIN model AS m ON m.id = p.id_model
		JOIN airline AS air ON air.id = p.id_airline
        WHERE p.id = ''', object_id, ''''
    );
    
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS showFlightById;
CREATE PROCEDURE showFlightById(
    IN object_id INT
)
BEGIN
    SET @query = CONCAT('
		SELECT
			f.id,
			f.trip_date,
            f.price_trip,
            c1.name AS orig_city,
            c2.name AS dest_city
		FROM flight AS f
		JOIN city AS c1 ON c1.id = f.orig_city
        JOIN city AS c2 ON c2.id = f.dest_city
        WHERE f.id = ''', object_id, ''''
    );
    
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;



DELIMITER $$
DROP PROCEDURE IF EXISTS showFlights;
CREATE PROCEDURE showFlights()
BEGIN
    SET @query = CONCAT('
		SELECT
			f.id,
			f.trip_date,
            f.price_trip,
            c1.name AS orig_city,
            c2.name AS dest_city
		FROM flight AS f
		JOIN city AS c1 ON c1.id = f.orig_city
        JOIN city AS c2 ON c2.id = f.dest_city;
    ');
    
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;




-- This procedure edits column int or varchar, but you have to enter the data type
DELIMITER $$
DROP PROCEDURE IF EXISTS EditColumnidVarAndInt;
CREATE PROCEDURE EditColumnidVarAndInt(
    IN p_table_name VARCHAR(64),
    IN p_column_name VARCHAR(64),
    IN p_new_value VARCHAR(255),
    IN p_data_type VARCHAR(20),
    IN p_object_id VARCHAR(30)
)
BEGIN
    DECLARE sql_query VARCHAR(1000);

    SET @table_name = p_table_name;
    SET @column_name = p_column_name;
    SET @new_value = p_new_value;
    SET @object_id = p_object_id;
    
    SET @query = CONCAT('UPDATE ', @table_name, ' SET ', @column_name, ' = ');
    
    IF p_data_type = 'INT' THEN
        SET @query = CONCAT(@query, 'CAST(? AS SIGNED)');
    ELSE
        SET @query = CONCAT(@query, '?');
    END IF;
    
    SET @query = CONCAT(@query, ' WHERE id = ?');new_capacity
    
    PREPARE stmt FROM @query;
    EXECUTE stmt USING @new_value, @object_id;
    DEALLOCATE PREPARE stmt;
    
    SELECT 1;
END $$
DELIMITER ;



DELIMITER $$
DROP PROCEDURE IF EXISTS FlightFareRegister;
CREATE PROCEDURE FlightFareRegister(
    IN flightFare_name VARCHAR(30),
    IN flightFare_value DOUBLE(7,2)
)
BEGIN
    INSERT INTO flightFare (id, name, value) 
    VALUES (NULL, flightFare_name, flightFare_value);
END $$
DELIMITER ;


-- Procedure to delete a register when the id is INT

DELIMITER $$
DROP PROCEDURE IF EXISTS DeleteByIdInt;
CREATE PROCEDURE DeleteByIdInt(
    IN table_name VARCHAR(64),
    IN object_id INT
)
BEGIN
    SET @query = CONCAT('DELETE FROM ', table_name, ' WHERE id = ''', object_id, '''');
    
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;








-- Structured procedure for check values on the table as VARCHAR




DELIMITER $$
DROP PROCEDURE IF EXISTS flightConnectionCreator;
CREATE PROCEDURE flightConnectionCreator(
    IN new_connection_number VARCHAR(20),
    IN new_id_trip INT,
    IN new_id_plane VARCHAR(30),
    IN new_dest_airport VARCHAR(5)
)
BEGIN
    INSERT INTO flight_connection (connection_number, id_trip, id_plane, dest_airport)
    VALUES (new_connection_number, new_id_trip, new_id_plane, new_dest_airport);
END $$
DELIMITER ;


-- verify if exists flight connections 

DELIMITER $$
DROP PROCEDURE IF EXISTS HasFlightConnections;
CREATE PROCEDURE HasFlightConnections(
    IN flightId INT, 
    OUT hasConnections BOOLEAN
)
BEGIN
    DECLARE connectionCount INT;

    SELECT COUNT(*) INTO connectionCount
    FROM flight_connection
    WHERE id_trip = flightId;

    IF connectionCount > 0 THEN
        SET hasConnections = TRUE;
    ELSE
        SET hasConnections = FALSE;
    END IF;
END $$
DELIMITER ;

-- Structured procedure for check values on the table as VARCHAR

DELIMITER $$
DROP PROCEDURE IF EXISTS CheckIdExistsString;
CREATE PROCEDURE CheckIdExistsString(
	IN tableName VARCHAR(64), 
    IN columnName VARCHAR(64), 
    IN idValue VARCHAR(64)
)
BEGIN
    SET @query = CONCAT('SELECT EXISTS(SELECT 1 FROM ', tableName, ' WHERE ', columnName, ' = ?) AS id_exists');
    PREPARE stmt FROM @query;
    SET @idValue = idValue;
    EXECUTE stmt USING @idValue;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;


-- Structured procedure for check values on the table as INT

DELIMITER $$
DROP PROCEDURE IF EXISTS CheckIdExistsINT;
CREATE PROCEDURE CheckIdExistsINT(
	IN tableName VARCHAR(64), 
    IN columnName VARCHAR(64), 
    IN idValue INT
)
BEGIN
    SET @query = CONCAT('SELECT EXISTS(SELECT 1 FROM ', tableName, ' WHERE ', columnName, ' = ?) AS id_exists');
    PREPARE stmt FROM @query;
    SET @idValue = idValue;
    EXECUTE stmt USING @idValue;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;

-- verify in tripcrew, if there are trip crews assigned

DELIMITER $$
CREATE PROCEDURE HasFlightCrewAssigns(
    IN flight_connection_id INT, 
    OUT hasFlightCrew BOOLEAN
)
BEGIN
    DECLARE connectionCount INT;

    SELECT COUNT(*) INTO connectionCount
    FROM tripcrew
    WHERE idconnection = flight_connection_id;

    IF connectionCount > 0 THEN
        SET hasFlightCrew = TRUE;
    ELSE
        SET hasFlightCrew = FALSE;
    END IF;
END $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE GetAllEmployees()
BEGIN
    SELECT
        e.id,
        e.name,
        tr.name AS role,
        e.entrydate AS date,
        air.name AS airline,
        aport.name AS airport
    FROM employee AS e
    JOIN tripulationrole AS tr ON tr.id = e.idrole
    JOIN airline AS air ON air.id = e.idairline
    JOIN airport AS aport ON aport.id = e.idairport;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE createFlightCrew(
    IN employee_id VARCHAR(10),
    IN flight_connection_id INT
)
BEGIN
    INSERT INTO tripcrew (idemployee, idconnection) 
    VALUES (employee_id, flight_connection_id);
END $$
DELIMITER ;

