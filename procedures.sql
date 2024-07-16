
-- Structured Procedure to insert a new plane

DELIMITER $$
DROP PROCEDURE IF EXISTS planeRegister;
CREATE PROCEDURE planeRegister(
    IN plates_insert VARCHAR(30),
    IN capacity_insert INT,
    IN fabrication_date_insert DATE,
    IN id_status_insert INT,
    IN id_model_insert INT,
    IN id_airline_insert INT
)
BEGIN
    INSERT INTO plane (id, plates, capacity, fabrication_date, id_status, id_model, id_airline) VALUES 
    (NULL, plates_insert, capacity_insert, fabrication_date_insert, id_status_insert, id_model_insert, id_airline_insert)

END $$
DELIMITER;

-- Structured Procedure to insert a new Airport

DELIMITER $$
DROP PROCEDURE IF EXISTS CreateAirports;
CREATE PROCEDURE CreateAirports(
    IN id VARCHAR(5),
    IN name VARCHAR(50),
    IN idcity INT
)
BEGIN
    INSERT INTO airport (id, name, idcity) VALUES 
    (id, name, idcity);
END $$
DELIMITER ;


-- Structure procedure to show up information

DELIMITER $$
DROP PROCEDURE IF EXISTS showInformationTable;
CREATE PROCEDURE showInformationTable(
    IN table_name VARCHAR(30)
)
BEGIN
    SET @query = CONCAT('SELECT * FROM ', table_name);
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;

-- Structure procedure to show up information about a specific register with id

DELIMITER $$
DROP PROCEDURE IF EXISTS showObjectInformation $$
CREATE PROCEDURE showObjectInformation(
    IN table_name VARCHAR(64),
    IN object_id INT
)
BEGIN
    SET @query = CONCAT('SELECT * FROM ', table_name, ' WHERE id = ', object_id);

    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;

-- Structure procedure to show up information about a specific register with id VARCHAR

DELIMITER $$

DROP PROCEDURE IF EXISTS showObjectInformationIDVARCHAR $$
CREATE PROCEDURE showObjectInformationIDVARCHAR(
    IN table_name VARCHAR(64),
    IN object_id VARCHAR(3)
)
BEGIN
    SET @query = CONCAT('SELECT * FROM ', table_name, ' WHERE id = ''', object_id, '''');
    
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$

DELIMITER ;

-- Structure procedure for displaying information about a specific record with VARCHAR and a different column than id

DELIMITER $$
DROP PROCEDURE IF EXISTS showObjectInformationVarchar;
CREATE PROCEDURE showObjectInformationVarchar(
    IN table_name VARCHAR(64),
    IN column_name VARCHAR(64),
    IN object_identifier VARCHAR(64)
)
BEGIN
    SET @query = CONCAT('SELECT * FROM ', table_name, ' WHERE ', column_name, ' = \'', object_identifier, '\'');

    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;

-- Structure procedure for displaying all the airport list

DELIMITER $$

DROP PROCEDURE IF EXISTS showAllAirports $$
CREATE PROCEDURE showAllAirports()
BEGIN
    SELECT a.id,
           a.name,
           c.name as city_name
    FROM airport a
    JOIN city c ON a.idcity = c.id;
END $$

DELIMITER ;

-- Structure procedure for displaying all of N table

DELIMITER $$

DROP PROCEDURE IF EXISTS showAllRegs;
CREATE PROCEDURE showAllRegs(
    IN table_name VARCHAR(64)
)
BEGIN
    SET @query = CONCAT('SELECT * FROM ', table_name);
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$

DELIMITER ;