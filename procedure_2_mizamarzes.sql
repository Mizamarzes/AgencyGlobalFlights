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