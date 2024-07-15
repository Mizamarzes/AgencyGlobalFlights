
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
