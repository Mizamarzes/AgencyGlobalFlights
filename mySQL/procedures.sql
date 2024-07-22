
-- Structured Procedure to insert a new plane

DELIMITER $$
DROP PROCEDURE IF EXISTS planeRegister;
CREATE PROCEDURE planeRegister(
    IN id_insert VARCHAR(30),
    IN capacity_insert INT,
    IN fabrication_date_insert DATE,
    IN id_status_insert INT,
    IN id_model_insert INT,
    IN id_airline_insert INT
)
BEGIN
    INSERT INTO plane (id, capacity, fabrication_date, id_status, id_model, id_airline) 
    VALUES (id_insert, capacity_insert, fabrication_date_insert, id_status_insert, id_model_insert, id_airline_insert);
END $$
DELIMITER ;

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

DELIMITER $$

-- Structure procedure to insert a new Document Type

DROP PROCEDURE IF EXISTS createDocType;
CREATE PROCEDURE createDocType(
    IN name_insert VARCHAR(40)
)
BEGIN
    INSERT INTO documenttype (name) 
    VALUES (name_insert);
END $$
DELIMITER ;

-- Structure procedure to insert a new Document Type

DELIMITER $$

DROP PROCEDURE IF EXISTS createRevision $$
CREATE PROCEDURE createRevision(
    IN date_insert VARCHAR(40),
    IN id_plane_insert VARCHAR(30),
    IN desc_insert TEXT,
    IN id_emp_insert VARCHAR(10)
)
BEGIN
    INSERT INTO revision (revision_date, id_plane, description, id_emp) 
    VALUES (date_insert, id_plane_insert, desc_insert, id_emp_insert);
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
    IN object_id VARCHAR(10)
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


-- Structure procedure for editing n varchar column of n object ** WITH ID VARCHAR **

DELIMITER $$

DROP PROCEDURE IF EXISTS EditVarcharColumnIdVar;
CREATE PROCEDURE EditVarcharColumnIdVar(
    IN p_table_name VARCHAR(64),
    IN p_column_name VARCHAR(64),
    IN p_new_value VARCHAR(64),
    IN p_object_id VARCHAR(10)
)
BEGIN
    DECLARE sql_query VARCHAR(1000);
    
    SET @table_name = p_table_name;
    SET @column_name = p_column_name;
    SET @new_value = p_new_value;
    SET @object_id = p_object_id;
    
    SET @query = CONCAT('UPDATE ', @table_name, ' SET ', @column_name, ' = ? WHERE id = ?');
    
    PREPARE stmt FROM @query;
    
    EXECUTE stmt USING @new_value, @object_id;
    DEALLOCATE PREPARE stmt;
    SELECT 1;
    
END $$
DELIMITER ;

--Example: CALL EditVarcharColumn('airport', 'name', 'El Dorado', 'BOG');

-- Structure procedure for editing n varchar column of n object ** WITH ID INT **

DELIMITER $$

DROP PROCEDURE IF EXISTS EditVarcharColumnidInt;
CREATE PROCEDURE EditVarcharColumnidInt(
    IN p_table_name VARCHAR(64),
    IN p_column_name VARCHAR(64),
    IN p_new_value VARCHAR(64),
    IN p_object_id INT
)
BEGIN
    DECLARE sql_query VARCHAR(1000);
    
    SET @table_name = p_table_name;
    SET @column_name = p_column_name;
    SET @new_value = p_new_value;
    SET @object_id = p_object_id;
    
    SET @query = CONCAT('UPDATE ', @table_name, ' SET ', @column_name, ' = ? WHERE id = ?');
    
    PREPARE stmt FROM @query;
    
    EXECUTE stmt USING @new_value, @object_id;
    DEALLOCATE PREPARE stmt;
    SELECT 1;
    
END $$
DELIMITER ;

--Example: CALL EditVarcharColumnidInt('city', 'name', 'Bogotáaa', '1');


-- Structure procedure for editing n int column of n object **WITH ID VARCHAR**

DELIMITER $$

DROP PROCEDURE IF EXISTS EditIntColumnidVar;
CREATE PROCEDURE EditIntColumnidVar(
    IN p_table_name VARCHAR(64),
    IN p_column_name VARCHAR(64),
    IN p_new_value INT,
    IN p_object_id VARCHAR(10)
)
BEGIN
    DECLARE sql_query VARCHAR(1000);
    
    SET @table_name = p_table_name;
    SET @column_name = p_column_name;
    SET @new_value = p_new_value;
    SET @object_id = p_object_id;
    
    SET @query = CONCAT('UPDATE ', @table_name, ' SET ', @column_name, ' = ? WHERE id = ?');
    
    PREPARE stmt FROM @query;
    
    EXECUTE stmt USING @new_value, @object_id;
    DEALLOCATE PREPARE stmt;
    SELECT 1;
    
END $$
DELIMITER ;

--Example: CALL EditIntColumnidVar('airport', 'idcity', '1', 'BOG');


-- Structure procedure for editing n int column of n object **WITH ID INT**

DELIMITER $$

DROP PROCEDURE IF EXISTS EditIntColumnidInt;
CREATE PROCEDURE EditIntColumnidInt(
    IN p_table_name VARCHAR(64),
    IN p_column_name VARCHAR(64),
    IN p_new_value INT,
    IN p_object_id INT
)
BEGIN
    DECLARE sql_query VARCHAR(1000);
    
    SET @table_name = p_table_name;
    SET @column_name = p_column_name;
    SET @new_value = p_new_value;
    SET @object_id = p_object_id;
    
    SET @query = CONCAT('UPDATE ', @table_name, ' SET ', @column_name, ' = ? WHERE id = ?');
    
    PREPARE stmt FROM @query;
    
    EXECUTE stmt USING @new_value, @object_id;
    DEALLOCATE PREPARE stmt;
    SELECT 1;
    
END $$
DELIMITER ;

--Example: CALL EditIntColumnidVar('tablename', 'columname', 'newintvalue', 'objectid');


-- Procedure to delete a register when the id is VARCHAR

DELIMITER $$
DROP PROCEDURE IF EXISTS DeleteByIdVarchar;
CREATE PROCEDURE DeleteByIdVarchar(
    IN table_name VARCHAR(64),
    IN object_id VARCHAR(5)
)
BEGIN
    SET @query = CONCAT('DELETE FROM ', table_name, ' WHERE id = ''', object_id, '''');
    
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
    
    SET @query = CONCAT(@query, ' WHERE id = ?');
    
    PREPARE stmt FROM @query;
    EXECUTE stmt USING @new_value, @object_id;
    DEALLOCATE PREPARE stmt;
    
    SELECT 1;
END $$
DELIMITER ;

-- This procedure show up all of the planes

DELIMITER $$
DROP PROCEDURE IF EXISTS showAllPlanes;
CREATE PROCEDURE showAllPlanes()
BEGIN
    SELECT
        p.id,
        p.capacity,
        p.fabrication_date,
        pst.name,
        m.name,
        air.name
    FROM plane AS p
    JOIN planestatus AS pst ON pst.id = p.id_status
    JOIN model AS m ON m.id = p.id_model
    JOIN airline AS air ON air.id = p.id_airline;
END $$
DELIMITER ;




DELIMITER $$


CREATE PROCEDURE EditColumnWithDynamicDataType(
    IN p_table_name VARCHAR(64),
    IN p_column_name VARCHAR(64),
    IN p_new_value VARCHAR(255),
    IN p_new_value_type VARCHAR(20), -- Nuevo parámetro para el tipo de dato del nuevo valor
    IN p_data_type VARCHAR(20),
    IN p_object_id VARCHAR(30)
)
BEGIN
    DECLARE sql_query VARCHAR(1000);
    DECLARE query_suffix VARCHAR(100);

    SET @table_name = p_table_name;
    SET @column_name = p_column_name;
    SET @new_value = p_new_value;
    SET @new_value_type = p_new_value_type; -- Nuevo parámetro para el tipo de dato del nuevo valor
    SET @object_id = p_object_id;

    -- Construir la parte inicial de la sentencia SQL
    SET @query = CONCAT('UPDATE ', @table_name, ' SET ', @column_name, ' = ');

    -- Determinar cómo agregar el nuevo valor basado en su tipo de dato
    IF p_new_value_type = 'INT' THEN
        SET @query = CONCAT(@query, 'CAST(? AS SIGNED)');
    ELSEIF p_new_value_type = 'DATE' THEN
        SET @query = CONCAT(@query, 'STR_TO_DATE(?, ''%Y-%m-%d'')');
    ELSE
        SET @query = CONCAT(@query, '?');
    END IF;

    -- Agregar la parte final de la sentencia SQL
    SET @query = CONCAT(@query, ' WHERE id = ?');

    -- Preparar y ejecutar la sentencia SQL
    PREPARE stmt FROM @query;
    IF p_new_value_type = 'DATE' THEN
        SET @query_suffix = DATE_FORMAT(@new_value, '%Y-%m-%d');
    ELSE
        SET @query_suffix = @new_value;
    END IF;
    
    EXECUTE stmt USING @query_suffix, @object_id;
    DEALLOCATE PREPARE stmt;

    SELECT 1; -- Opcional: devolver algo si es necesario
END $$

DELIMITER ;

-- Ejemplooo

CALL EditColumnWithDynamicDataType('revision', 'id_plane', 'abc123', 'VARCHAR', 'INT', '2');

-- PROCEDURE FOR SHOW FLIGHTS BY THE INSERTED DATE

DELIMITER $$

DROP PROCEDURE IF EXISTS showFlightsByDate $$
CREATE PROCEDURE showFlightsByDate(
	IN insertedDate DATE
)
BEGIN
    SELECT 
		f.id,
        f.trip_date,
        f.price_trip,
        f.orig_city,
        f.dest_city
    FROM
		flight f
	WHERE
		f.trip_date = insertedDate;
END $$

DELIMITER ;