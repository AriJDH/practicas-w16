USE empresa_internet;

-- Registro Pack 
INSERT INTO Pack (velocidad,precio,descuento) VALUES ('200',2100,0.15);
INSERT INTO Pack (velocidad,precio,descuento) VALUES ('100',1300,0.15);
INSERT INTO Pack (velocidad,precio,descuento) VALUES ('70',870,0.10);
INSERT INTO Pack (velocidad,precio,descuento) VALUES ('50',650,0.10);
INSERT INTO Pack (velocidad,precio,descuento) VALUES ('10',400,0.05);

-- Registros Cliente 
INSERT INTO Cliente (dni,nombre,apellido,fecha_nacimiento,provincia,ciudad,Pack_idPack)
VALUES ('1001A','Sandra','Lopez','1996-10-21','Xalostoc','Estado de México',2);

INSERT INTO Cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad,Pack_idPack)
VALUES('1002A','Lina','Najera','1997-09-21','Santiago de Chile','Santiago de Chile',5);

INSERT INTO Cliente (dni,nombre,apellido,fecha_nacimiento,provincia,ciudad,Pack_idPack)
VALUES ('1003A','Alexa','Galeano','1995-10-23','Buenos Aires','Buenos Aires',2);

INSERT INTO Cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad,Pack_idPack)
VALUES('1004A','Esteban','French','1998-03-18','Medellin','Bogota',1);

INSERT INTO Cliente (dni,nombre,apellido,fecha_nacimiento,provincia,ciudad,Pack_idPack)
VALUES ('1005A','Estefania','Garcia','1976-11-14','Xalostoc','Estado de México',5);

INSERT INTO Cliente (dni,nombre,apellido,fecha_nacimiento,provincia,ciudad,Pack_idPack)
VALUES ('1006A','Claudia','Alarcon','1975-09-01','Buenos Aires','Buenos Aires',4);

INSERT INTO Cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad,Pack_idPack)
VALUES('1007A','Angel','Rico','1986-10-21','Santiago de Chile','Santiago de Chile',3);

INSERT INTO Cliente (dni,nombre,apellido,fecha_nacimiento,provincia,ciudad,Pack_idPack)
VALUES ('1008A','Juan','Mendez','1998-02-12','Del Valle','Ciudad Mexico',3);

INSERT INTO Cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad,Pack_idPack)
VALUES('1009A','Eduardo','Hernandez','1990-05-28','Medellin','Bogota',2);

INSERT INTO Cliente (dni,nombre,apellido,fecha_nacimiento,provincia,ciudad,Pack_idPack)
VALUES ('1010A','Rogelio','Garza','1983-08-30','Del Valle','Ciudad Mexico',5);

-- Ejercicio 4
-- Mostrar el nombre,apellido,ciudad de todos los clientes
SELECT nombre,apellido,ciudad FROM Cliente;

-- Mostrar los paquetes de internet que tengan descuento del 0.10 
SELECT * FROM Pack WHERE descuento=0.10;

-- Mostrar el nombre de los cliente que tengan el paquete 5
SELECT nombre FROM Cliente WHERE Pack_idPack = 5;

-- Mostrar los nombres de los Clientes que empiezen con A
SELECT nombre FROM Cliente WHERE nombre LIKE 'A%';

-- Mostrar los paquetes de internet que tengan un precio menor a 1000
SELECT * FROM Pack WHERE precio<1000;

-- Mostrar los nombres y apellidos de los cliente donde su ciudad sea Buenos Aires y tengan el paquete 3 
SELECT nombre,apellido FROM Cliente WHERE ciudad = 'Buenos Aires' AND Pack_idPack = 4;  

-- Mostrar los nombres de los clientes que terminen con la letra o 
SELECT nombre FROM Cliente WHERE nombre LIKE '%o';

-- Mostrar los apellidos y nombre concatenados con el alias de 
-- nombre_completo de los clientes de forma ascendente por el nombre completo
SELECT CONCAT(apellido, " ", nombre) AS nombre_completo FROM Cliente ORDER BY nombre_completo ASC;   

-- Mostrar el paquete mas caro de internet
SELECT MAX(Precio) Precio FROM Pack;

-- Mostrar la velocidad, precio y descuento de los paquetes de internet de forma descendente 
SELECT velocidad, precio, descuento FROM Pack ORDER BY precio DESC;
