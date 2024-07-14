-- sql file to insertions

USE railway;

INSERT INTO role (id, name) VALUES 
        (1, 'Super Admin');

INSERT INTO permmision (id, name) VALUES  
        (1, 'SuperAdminPerms'),  
        (2, 'Perm2'),
        (3, 'Perm3');
       
INSERT INTO role_permission (idrol, idpermission) VALUES
(1, 1);

INSERT INTO user (id, username, email, password, idrole) VALUES  
        (1, 'santilaguado', 'santi@gmail.com', 'santi123', 1),  
        (2, 'mizamarzes', 'mizamarzes@gmail.com', 'miza123', 1);