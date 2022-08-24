CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE Provincias(
Id_provincia INT auto_increment PRIMARY KEY,
Codigo varchar(100) NOT NULL,  
Nombre varchar(100) NOT NULL  
 );
 
 CREATE TABLE Ciudades(
Id_ciudad INT auto_increment PRIMARY KEY,
Codigo varchar(100) NOT NULL,  
Nombre varchar(100) NOT NULL,  
Provincia_id INT,
FOREIGN KEY (Provincia_id) REFERENCES Provincias(Id_provincia)
 );
 
  CREATE TABLE Planes_Internet(
Id_plan_internet INT auto_increment PRIMARY KEY,
Identificacion varchar(25) NOT NULL,  
Velocidad INT NOT NULL,  
Precio FLOAT,
Descuento FLOAT
 );

CREATE TABLE Clientes(
Id_cliente INT auto_increment PRIMARY KEY,
DNI varchar(100) NOT NULL,  
Nombre varchar(100) NOT NULL,  
Apellido varchar(100) NOT NULL,
Telefono varchar(100) NOT NULL,
Direccion varchar(100) NOT NULL, 
Fecha_nacimiento DATE NOT NULL,
Plan_internet_id INT,
Ciudad_id INT,
FOREIGN KEY (Plan_internet_id) REFERENCES Planes_Internet(Id_plan_internet),
FOREIGN KEY (Ciudad_id) REFERENCES Ciudades(Id_ciudad)
);


 
 
INSERT Provincias (Codigo, Nombre)
VALUES ('01', 'Buenos Aires');
INSERT Provincias (Codigo, Nombre)
VALUES ('02', 'Córdoba');

INSERT Ciudades (Codigo, Nombre, Provincia_id)
VALUES ('01', 'La Plata', 1);
INSERT Ciudades (Codigo, Nombre, Provincia_id)
VALUES ('02', 'Buenos Aires', 1);

INSERT Ciudades (Codigo, Nombre, Provincia_id)
VALUES ('01', 'Córdoba', 2);
INSERT Ciudades (Codigo, Nombre, Provincia_id)
VALUES ('02', 'Rio Tercero', 2);

INSERT Planes_Internet (Identificacion, Velocidad, Precio, Descuento)
VALUES('01',100,1500.0,10.0);
INSERT Planes_Internet (Identificacion, Velocidad, Precio, Descuento)
VALUES('02',200,2500.0,7.5);
INSERT Planes_Internet (Identificacion, Velocidad, Precio, Descuento)
VALUES('03',300,3000.0,5.0);
INSERT Planes_Internet (Identificacion, Velocidad, Precio, Descuento)
VALUES('04',400,3500.0,3.5);
INSERT Planes_Internet (Identificacion, Velocidad, Precio, Descuento)
VALUES('05',500,4000.0,2.0);


INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Plan_internet_id, Ciudad_id)
VALUES('98732323','Erika','Altenburger', '9382983', 'Calle Falsa 123','2004-01-01',1,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Plan_internet_id, Ciudad_id)
VALUES('98732324','Matias','Lamela', '9382984', 'Calle Falsa 124','2004-01-04',2,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Plan_internet_id, Ciudad_id)
VALUES('98732325','Nicolas','De Maio', '9382985', 'Calle Falsa 125','2004-01-05',3,1);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Plan_internet_id, Ciudad_id)
VALUES('98732326','Tomas','Rodriguez', '9382986', 'Calle Falsa 126','2004-01-06',4,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Plan_internet_id, Ciudad_id)
VALUES('98732327','Sabrina','Silvero', '9382987', 'Calle Falsa 127','2004-01-07',5,1);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Plan_internet_id, Ciudad_id)
VALUES('98732328','Homero','Simpson', '9382988', 'Calle Falsa 129','2004-01-08',1,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Plan_internet_id, Ciudad_id)
VALUES('98732329','Marge','Simpson', '9382989', 'Calle Falsa 129','2004-01-09',2,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Plan_internet_id, Ciudad_id)
VALUES('98732330','Bart','Simpson', '9382989', 'Calle Falsa 129','2004-01-10',3,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Plan_internet_id, Ciudad_id)
VALUES('98732331','Lisa','Simpson', '9382989', 'Calle Falsa 129','2004-01-11',4,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Plan_internet_id, Ciudad_id)
VALUES('98732332','Maggie','Simpson', '9382989', 'Calle Falsa 129','2004-01-12',5,2);

-- 1) Traer todos los registros de la tabla clientes.
SELECT * FROM Clientes;
-- 2) Traer el nombre, apellido, nombre de la provincia, nombre de la ciudad y la identificación del plan por cliente.
SELECT c.Nombre, c.Apellido, ciu.Nombre AS Ciudad, prov.Nombre AS Provincia, plan.Identificacion AS Plan FROM Clientes c 
INNER JOIN Ciudades ciu ON ciu.Id_ciudad = c.Ciudad_id
INNER JOIN Provincias prov ON prov.Id_provincia = ciu.Provincia_id
INNER JOIN Planes_Internet plan ON plan.Id_plan_internet = c.Plan_internet_id;
-- 3) Traer el nombre, apellido, nombre de la provincia, nombre de la ciudad y la identificación del plan por cliente que sean de Buenos Aires.
SELECT c.Nombre, c.Apellido, ciu.Nombre AS Ciudad, prov.Nombre AS Provincia, plan.Identificacion AS Plan FROM Clientes c 
INNER JOIN Ciudades ciu ON ciu.Id_ciudad = c.Ciudad_id
INNER JOIN Provincias prov ON prov.Id_provincia = ciu.Provincia_id
INNER JOIN Planes_Internet plan ON plan.Id_plan_internet = c.Plan_internet_id
WHERE prov.Id_provincia = 1;
-- 4) Traer el nombre, apellido, nombre de la provincia, nombre de la ciudad y la identificación del plan por cliente que sean de ciudad de la plata.
SELECT c.Nombre, c.Apellido, ciu.Nombre AS Ciudad, prov.Nombre AS Provincia, plan.Identificacion AS Plan FROM Clientes c 
INNER JOIN Ciudades ciu ON ciu.Id_ciudad = c.Ciudad_id
INNER JOIN Provincias prov ON prov.Id_provincia = ciu.Provincia_id
INNER JOIN Planes_Internet plan ON plan.Id_plan_internet = c.Plan_internet_id
WHERE ciu.Id_ciudad = 1;
-- 5) Traer el nombre, apellido, nombre de la provincia, nombre de la ciudad y la identificación del plan por cliente que tengan el plan con una velocidad superior o igual a 300.
SELECT c.Nombre, c.Apellido, ciu.Nombre AS Ciudad, prov.Nombre AS Provincia, plan.Identificacion AS Plan FROM Clientes c 
INNER JOIN Ciudades ciu ON ciu.Id_ciudad = c.Ciudad_id
INNER JOIN Provincias prov ON prov.Id_provincia = ciu.Provincia_id
INNER JOIN Planes_Internet plan ON plan.Id_plan_internet = c.Plan_internet_id
WHERE plan.Velocidad >=300;
-- 6) Traer el nombre, apellido, fecha nacimiento, nombre de la provincia, nombre de la ciudad y la identificación del plan por cliente que tengan el plan con una velocidad superior o igual a 300 y nacieron el dia 2004-01-12.
SELECT c.Nombre, c.Apellido,c.Fecha_nacimiento, ciu.Nombre AS Ciudad, prov.Nombre AS Provincia, plan.Identificacion AS Plan FROM Clientes c 
INNER JOIN Ciudades ciu ON ciu.Id_ciudad = c.Ciudad_id
INNER JOIN Provincias prov ON prov.Id_provincia = ciu.Provincia_id
INNER JOIN Planes_Internet plan ON plan.Id_plan_internet = c.Plan_internet_id
WHERE plan.Velocidad >=300 and c.Fecha_nacimiento = '2004-01-12';
-- 7) Traer todos los registros de la tabla planes
SELECT * FROM Planes_Internet;
-- 8) Traer los plaes con una velocidad inferior a 300
SELECT * FROM Planes_Internet WHERE Velocidad < 300;
-- 9) Traer los plaes con una velocidad inferior a 300 y precio superior o igual a 2000
SELECT * FROM Planes_Internet WHERE Velocidad < 300 AND Precio >= 2000;
-- 10) Cantidad de usuarios de la plata
SELECT ciu.Nombre, COUNT(*) Plan FROM Clientes c 
INNER JOIN Ciudades ciu ON ciu.Id_ciudad = c.Ciudad_id
WHERE ciu.Id_ciudad = 1
GROUP BY ciu.Id_ciudad






        