-- sql file to insertions

USE railway;

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