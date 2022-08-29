
create database empresa_internet;
USE empresa_internet;

CREATE TABLE Planes (idPlan INT, velocidad INT, precio DECIMAL(12,2), descuento DECIMAL(3,2), PRIMARY KEY (idPlan));
CREATE TABLE Clientes (dni INT, nombre VARCHAR(45), apellido VARCHAR(45), fecha_nacimiento DATETIME, provincia VARCHAR(45), ciudad VARCHAR(45), Planes_idPlan INT, PRIMARY KEY (dni), FOREIGN KEY (Planes_idPlan) REFERENCES Planes(idPlan));
DROP table Clientes;
DROP TABLE Planes;

INSERT INTO Planes VALUE(1,50,1500.00,0.25);
INSERT INTO Planes VALUE(2,100,2000.00,null);
INSERT INTO Planes VALUE(3,200,4000.00,0.5);
INSERT INTO Planes VALUE(4,500,5500.00,0.2);
INSERT INTO Planes VALUE(5,1000,8499.99,0.10);

INSERT INTO Clientes VALUE(101,'Name1','Sur1','1995-10-01','Buenos Aires','Buenos Aires',3);
INSERT INTO Clientes VALUE(102,'Name2','Sur2','1995-10-30','Buenos Aires','Buenos Aires',2);
INSERT INTO Clientes VALUE(103,'Name3','Sur3','1997-10-01','Buenos Aires','Buenos Aires',1);
INSERT INTO Clientes VALUE(104,'Name4','Sur4','1998-02-18','Buenos Aires','Buenos Aires',1);
INSERT INTO Clientes VALUE(105,'Name5','Sur5','1999-10-01','Buenos Aires','Buenos Aires',4);
INSERT INTO Clientes VALUE(106,'Name6','Sur6','1991-10-01','Buenos Aires','Buenos Aires',4);
INSERT INTO Clientes VALUE(107,'Name7','Sur7','1990-10-01','Buenos Aires','Buenos Aires',5);
INSERT INTO Clientes VALUE(108,'Name8','Sur8','1993-10-10','Buenos Aires','Buenos Aires',5);
INSERT INTO Clientes VALUE(109,'Name9','Sur9','1993-12-01','Buenos Aires','Buenos Aires',1);
INSERT INTO Clientes VALUE(110,'Name10','Sur10','1992-10-01','Buenos Aires','Buenos Aires',1);

####### CONSULTAS
SELECT * FROM Planes;
SELECT * FROM Clientes;
SELECT * FROM Planes WHERE descuento <= 0.5;
SELECT * FROM Planes ORDER BY precio DESC;
SELECT * FROM Clientes WHERE Planes_idPlan = 5;
SELECT dni, nombre, apellido, fecha_nacimiento WHERE fecha_nacimiento = '1995-10-01';
SELECT * FROM Planes ORDER BY precio DESC LIMIT 3;
SELECT Planes_idPlan, COUNT(*) AS NumInscriptos FROM Clientes WHERE Planes_idPlan = 1;
SELECT * FROM Planes WHERE precio = (SELECT MAX(precio) FROM Planes);
SELECT nombre, apellido FROM Clientes WHERE apellido LIKE '%9%';
