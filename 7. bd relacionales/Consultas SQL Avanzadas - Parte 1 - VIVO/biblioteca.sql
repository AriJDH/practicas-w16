CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE LIBRO (
IdLibro INT auto_increment PRIMARY KEY,
Titulo varchar(100) NOT NULL, 
Editorial varchar(100) NOT NULL, 
Area varchar(100) NOT NULL
);

CREATE TABLE ESTUDIANTE (
IdLector INT auto_increment PRIMARY KEY,
Nombre varchar(100) NOT NULL, 
Apellido varchar(100) NOT NULL, 
Direccion varchar(100) NOT NULL,
Carrera varchar(100) NOT NULL,
Edad INT NOT NULL
);

CREATE TABLE PRESTAMO (
IdLector INT,
IdLibro INT,
FechaPrestamo DATE,
FechaDevolucion DATE,
Devuelto BIT,
FOREIGN KEY (IdLector) REFERENCES ESTUDIANTE(IdLector),
FOREIGN KEY (IdLibro) REFERENCES LIBRO(IdLibro)
);

CREATE TABLE AUTOR (
IdAutor INT auto_increment PRIMARY KEY,
Nombre varchar(100) NOT NULL, 
Nacionalidad varchar(100) NOT NULL
);

CREATE TABLE LIBROAUTOR (
IdAutor INT,
IdLibro INT,
FOREIGN KEY (IdAutor) REFERENCES AUTOR(IdAutor),
FOREIGN KEY (IdLibro) REFERENCES LIBRO(IdLibro)
);

INSERT LIBRO (Titulo, Editorial, Area)
VALUES('EL UNIVERSO: GUIA DE VIAJE','COOP','CIENCIAS EXACTAS');
INSERT LIBRO (Titulo, Editorial, Area)
VALUES('FISICA','COOP','CIENCIAS EXACTAS');
INSERT LIBRO (Titulo, Editorial, Area)
VALUES('CONTABILIDAD','SALAMANDRA','CIENCIAS ECONOMICAS');
INSERT LIBRO (Titulo, Editorial, Area)
VALUES('INTERNET DE LAS COSAS','SALAMANDRA','INTERNET');
INSERT LIBRO (Titulo, Editorial, Area)
VALUES('MATEMATICAS','PERFIL','MATEMATICAS');
INSERT LIBRO (Titulo, Editorial, Area)
VALUES('BASE DE DATOS','PERFIL','BASE DE DATOS');

INSERT ESTUDIANTE (Nombre, Apellido, Direccion, Carrera, Edad)
VALUES('ERIKA','ALTENBURGER','CORDOBA', 'INFORMATICA', 20);
INSERT ESTUDIANTE (Nombre, Apellido, Direccion, Carrera, Edad)
VALUES('SABRINA','SILVERO','BUENOS AIRES', 'ING QUIMICA', 25);
INSERT ESTUDIANTE (Nombre, Apellido, Direccion, Carrera, Edad)
VALUES('FILIPO','GALLI','BUENOS AIRES', 'INFORMATICA', 30);
INSERT ESTUDIANTE (Nombre, Apellido, Direccion, Carrera, Edad)
VALUES('PAMELA','PEREYRA','CORDOBA', 'CONTADOR', 25);
INSERT ESTUDIANTE (Nombre, Apellido, Direccion, Carrera, Edad)
VALUES('MATEO','RIVERO','MISIONES', 'LIC MATEMATICAS', 20);
INSERT ESTUDIANTE (Nombre, Apellido, Direccion, Carrera, Edad)
VALUES('GEORGINA','RIVERA','RIO NEGRO', 'INFORMATICA', 23);


INSERT PRESTAMO (IdLector, IdLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES(1,1,'2021-05-15', '2022-05-20', 1);
INSERT PRESTAMO (IdLector, IdLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES(2,2,'2021-06-15', '2022-06-20', 1);
INSERT PRESTAMO (IdLector, IdLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES(3,3,'2021-07-15', '2022-07-20', 1);
INSERT PRESTAMO (IdLector, IdLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES(3,4,'2021-08-15', '2022-08-20', 0);
INSERT PRESTAMO (IdLector, IdLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES(5,5,'2021-09-15', '2022-09-20', 0);
INSERT PRESTAMO (IdLector, IdLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES(5,6,'2021-09-15', '2022-09-20', 1);
INSERT PRESTAMO (IdLector, IdLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES(5,6,'2021-07-11', '2021-07-16', 1);


INSERT AUTOR (Nombre, Nacionalidad)
VALUES('Jose Carlos', 'Argentino');
INSERT AUTOR (Nombre, Nacionalidad)
VALUES('Maria Antonieta', 'Argentino');
INSERT AUTOR (Nombre, Nacionalidad)
VALUES('Martín Sancanaro', 'Uruguayo');
INSERT AUTOR (Nombre, Nacionalidad)
VALUES('Milagros Belén', 'Italiano');
INSERT AUTOR (Nombre, Nacionalidad)
VALUES('J.K. Rowling', 'Francés');

INSERT LIBROAUTOR (IdAutor, IdLibro)
VALUES(1, 1);
INSERT LIBROAUTOR (IdAutor, IdLibro)
VALUES(2, 2);
INSERT LIBROAUTOR (IdAutor, IdLibro)
VALUES(3, 3);
INSERT LIBROAUTOR (IdAutor, IdLibro)
VALUES(4, 4);
INSERT LIBROAUTOR (IdAutor, IdLibro)
VALUES(5, 5);

-- Listar los datos de los autores.
SELECT * FROM AUTOR;
-- Listar nombre y edad de los estudiantes
SELECT Nombre, Edad FROM ESTUDIANTE;
-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT Nombre, Carrera FROM ESTUDIANTE WHERE Carrera = 'INFORMATICA';
-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT Nombre, Nacionalidad FROM AUTOR WHERE Nacionalidad = 'Francés' OR Nacionalidad = 'Italiano';
-- ¿Qué libros no son del área de internet?
SELECT Titulo, Area FROM LIBRO WHERE Area != 'INTERNET';
-- istar los libros de la editorial Salamandra.
SELECT Titulo, Editorial FROM LIBRO WHERE Editorial = 'SALAMANDRA';
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT Nombre, Edad FROM ESTUDIANTE WHERE Edad > (SELECT AVG(Edad) FROM ESTUDIANTE);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT Nombre FROM ESTUDIANTE WHERE Nombre LIKE 'G%';
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT Nombre FROM AUTOR WHERE IdAutor = (SELECT IdLibro FROM LIBRO WHERE Titulo = 'EL UNIVERSO: GUIA DE VIAJE');
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT Titulo FROM LIBRO l
INNER JOIN PRESTAMO p
ON l.IdLibro = p.IdLibro
WHERE p.IdLector = (SELECT IdLector FROM ESTUDIANTE WHERE Nombre = 'Filipo' AND Apellido = 'Galli');
-- Listar el nombre del estudiante de menor edad.
SELECT Nombre, Apellido FROM ESTUDIANTE ORDER BY Edad ASC LIMIT 1;
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT Nombre FROM ESTUDIANTE e
INNER JOIN PRESTAMO p
ON e.IdLector = p.IdLector
WHERE p.IdLibro = (SELECT IdLibro FROM LIBRO WHERE Area = 'BASE DE DATOS');
-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT Titulo FROM LIBRO l
INNER JOIN LIBROAUTOR la
ON l.IdLibro = la.IdLibro
WHERE la.IdAutor = (SELECT IdAutor FROM AUTOR WHERE Nombre = 'J.K. Rowling');
-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT Titulo FROM LIBRO l
INNER JOIN PRESTAMO p
ON l.IdLibro = p.IdLibro
WHERE p.FechaDevolucion = '2021-07-16';



