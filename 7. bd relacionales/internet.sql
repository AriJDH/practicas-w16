CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE Provincias(
ID INT auto_increment PRIMARY KEY,
Codigo varchar(100) NOT NULL,  
Nombre varchar(100) NOT NULL  
 );
 
CREATE TABLE Ciudades(
ID INT auto_increment PRIMARY KEY,
Codigo varchar(100) NOT NULL,  
Nombre varchar(100) NOT NULL,  
Provincia_id INT,
FOREIGN KEY (Provincia_id) REFERENCES Provincias(ID)
 );

CREATE TABLE Clientes(
ID INT auto_increment PRIMARY KEY,
DNI varchar(100) NOT NULL,  
Nombre varchar(100) NOT NULL,  
Apellido varchar(100) NOT NULL,
Telefono varchar(100) NOT NULL,
Direccion varchar(100) NOT NULL, 
Fecha_nacimiento DATE NOT NULL,
Provincia_id INT,
Ciudad_id INT,
FOREIGN KEY (Provincia_id) REFERENCES Provincias(ID),
FOREIGN KEY (Ciudad_id) REFERENCES Ciudades(ID)
);

 CREATE TABLE Planes_Internet(
ID INT auto_increment PRIMARY KEY,
Identificacion varchar(25) NOT NULL,  
Velocidad INT NOT NULL,  
Precio FLOAT,
Descuento FLOAT
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


INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Provincia_id, Ciudad_id)
VALUES('98732323','Erika','Altenburger', '9382983', 'Calle Falsa 123','2004-01-01',2,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Provincia_id, Ciudad_id)
VALUES('98732324','Matias','Lamela', '9382984', 'Calle Falsa 124','2004-01-04',1,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Provincia_id, Ciudad_id)
VALUES('98732325','Nicolas','De Maio', '9382985', 'Calle Falsa 125','2004-01-05',1,1);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Provincia_id, Ciudad_id)
VALUES('98732326','Tomas','Rodriguez', '9382986', 'Calle Falsa 126','2004-01-06',2,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Provincia_id, Ciudad_id)
VALUES('98732327','Sabrina','Silvero', '9382987', 'Calle Falsa 127','2004-01-07',1,1);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Provincia_id, Ciudad_id)
VALUES('98732328','Homero','Simpson', '9382988', 'Calle Falsa 129','2004-01-08',1,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Provincia_id, Ciudad_id)
VALUES('98732329','Marge','Simpson', '9382989', 'Calle Falsa 129','2004-01-09',1,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Provincia_id, Ciudad_id)
VALUES('98732330','Bart','Simpson', '9382989', 'Calle Falsa 129','2004-01-10',1,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Provincia_id, Ciudad_id)
VALUES('98732331','Lisa','Simpson', '9382989', 'Calle Falsa 129','2004-01-11',1,2);
INSERT Clientes (Dni, Nombre, Apellido, Telefono, Direccion, Fecha_nacimiento,Provincia_id, Ciudad_id)
VALUES('98732332','Maggie','Simpson', '9382989', 'Calle Falsa 129','2004-01-12',1,2);

#Falta agregar 10 queries



        