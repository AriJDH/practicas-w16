
# Creacion base de datos

CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE Provincia(
	id_provincia INT auto_increment PRIMARY KEY,
	codigo varchar(100) NOT NULL,  
	nombre varchar(100) NOT NULL  
 );
 
CREATE TABLE Ciudad(
	id_ciudad INT auto_increment PRIMARY KEY,
	codigo varchar(100) NOT NULL,  
	nombre varchar(100) NOT NULL,  
	provincia_id INT,
	FOREIGN KEY (provincia_id) REFERENCES Provincia(id_provincia)
 );

CREATE TABLE Plan_Internet(
	id_plan_internet INT auto_increment PRIMARY KEY,
	identificacion varchar(25) NOT NULL,  
	velocidad INT NOT NULL,  
	precio FLOAT,
	descuento FLOAT
 );

CREATE TABLE Cliente(
	id_cliente INT auto_increment PRIMARY KEY,
	dni varchar(100) NOT NULL,  
	nombre varchar(100) NOT NULL,  
	apellido varchar(100) NOT NULL,
	telefono varchar(100) NOT NULL,
	direccion varchar(100) NOT NULL, 
	fecha_nacimiento DATE NOT NULL,
	ciudad_id INT,
	plan_internet_id INT,
	FOREIGN KEY (ciudad_id) REFERENCES Ciudad(id_ciudad),
	FOREIGN KEY (plan_internet_id) REFERENCES Plan_Internet(id_plan_internet)
);

INSERT Provincia (codigo, nombre)
VALUES ('01', 'Buenos Aires');
INSERT Provincia (codigo, nombre)
VALUES ('02', 'Córdoba');

INSERT Ciudad (codigo, nombre, provincia_id)
VALUES ('01', 'La Plata', 1);
INSERT Ciudad (codigo, nombre, provincia_id)
VALUES ('02', 'Buenos Aires', 1);

INSERT Ciudad (codigo, nombre, provincia_id)
VALUES ('01', 'Córdoba', 2);
INSERT Ciudad (codigo, nombre, provincia_id)
VALUES ('02', 'Rio Tercero', 2);

# Inserción 5 planes de internet

INSERT Plan_Internet (identificacion, velocidad, precio, descuento)
VALUES('01',100,1500.0,10.0);
INSERT Plan_Internet (Identificacion, Velocidad, Precio, Descuento)
VALUES('02',200,2500.0,7.5);
INSERT Plan_Internet (Identificacion, Velocidad, Precio, Descuento)
VALUES('03',300,3000.0,5.0);
INSERT Plan_Internet (Identificacion, Velocidad, Precio, Descuento)
VALUES('04',400,3500.0,3.5);
INSERT Plan_Internet (Identificacion, Velocidad, Precio, Descuento)
VALUES('05',500,4000.0,2.0);

# Inserción 10 clientes

INSERT Cliente (dni, nombre, apellido, telefono, direccion, fecha_nacimiento, ciudad_id, plan_internet_id)
VALUES('98732323','Erika','Altenburger', '9382983', 'Calle Falsa 123','2004-01-01',2,2);
INSERT Cliente (dni, nombre, apellido, telefono, direccion, fecha_nacimiento, ciudad_id, plan_internet_id)
VALUES('98732324','Matias','Lamela', '9382984', 'Calle Falsa 124','2004-01-04',1,2);
INSERT Cliente (dni, nombre, apellido, telefono, direccion, fecha_nacimiento, ciudad_id, plan_internet_id)
VALUES('98732325','Nicolas','De Maio', '9382985', 'Calle Falsa 125','2004-01-05',1,1);
INSERT Cliente (dni, nombre, apellido, telefono, direccion, fecha_nacimiento, ciudad_id, plan_internet_id)
VALUES('98732326','Tomas','Rodriguez', '9382986', 'Calle Falsa 126','2004-01-06',2,2);
INSERT Cliente (dni, nombre, apellido, telefono, direccion, fecha_nacimiento, ciudad_id, plan_internet_id)
VALUES('98732327','Sabrina','Silvero', '9382987', 'Calle Falsa 127','2004-01-07',1,1);
INSERT Cliente (dni, nombre, apellido, telefono, direccion, fecha_nacimiento, ciudad_id, plan_internet_id)
VALUES('98732328','Homero','Simpson', '9382988', 'Calle Falsa 129','2004-01-08',1,2);
INSERT Cliente (dni, nombre, apellido, telefono, direccion, fecha_nacimiento, ciudad_id, plan_internet_id)
VALUES('98732329','Marge','Simpson', '9382989', 'Calle Falsa 129','2004-01-09',1,2);
INSERT Cliente (dni, nombre, apellido, telefono, direccion, fecha_nacimiento, ciudad_id, plan_internet_id)
VALUES('98732330','Bart','Simpson', '9382989', 'Calle Falsa 129','2004-01-10',1,2);
INSERT Cliente (dni, nombre, apellido, telefono, direccion, fecha_nacimiento, ciudad_id, plan_internet_id)
VALUES('98732331','Lisa','Simpson', '9382989', 'Calle Falsa 129','2004-01-11',1,2);
INSERT Cliente (dni, nombre, apellido, telefono, direccion, fecha_nacimiento, ciudad_id, plan_internet_id)
VALUES('98732332','Maggie','Simpson', '9382989', 'Calle Falsa 129','2004-01-12',1,2);


# 10 consultas a la base de datos

SELECT COUNT(dni) AS cantidad_suscriptores 
FROM Cliente;

SELECT nombre, apellido, telefono 
FROM Cliente 
WHERE plan_internet_id = 1;

SELECT id_plan_internet, identificacion, precio
FROM Plan_Internet
WHERE precio >= 3000;

SELECT nombre, apellido, telefono 
FROM Cliente 
WHERE ciudad_id = 2;

SELECT COUNT(id_plan_internet) AS cantidad_plane_vigente
FROM Plan_Internet;

SELECT MIN(precio) as precio_menor
FROM Plan_Internet;

SELECT MAX(precio) as precio_mayor
FROM Plan_Internet;

SELECT nombre, provincia_id 
FROM Ciudad
WHERE provincia_id = 1;

SELECT id_plan_internet, identificacion, precio
FROM Plan_Internet
WHERE precio BETWEEN 3000 AND 3500;

SELECT nombre, apellido, telefono 
FROM Cliente 
WHERE plan_internet_id = 1 AND ciudad_id = 1;


