DROP DATABASE IF EXISTS biblioteca_db;
CREATE DATABASE biblioteca_db;
USE biblioteca_db;

CREATE TABLE `libro` (
  `id_libro` int unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `editorial` varchar(50) NOT NULL,
  `area` varchar(50) NOT NULL,
  PRIMARY KEY (`id_libro`)
);

CREATE TABLE `autor` (
  `id_autor` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `nacionalidad` varchar(50) NOT NULL,
  PRIMARY KEY (`id_autor`)
);

CREATE TABLE `libro_autor` (
  `id_libro_autor` int unsigned NOT NULL AUTO_INCREMENT,
  `id_autor` int unsigned NOT NULL,
  `id_libro` int unsigned NOT NULL,
  PRIMARY KEY (`id_libro_autor`),
  KEY `libro_autor__autor` (`id_autor`),
  KEY `libro_autor__libro` (`id_libro`),
  CONSTRAINT `libro_autor__autor` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id_autor`),
  CONSTRAINT `libro_autor__libro` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`)
);

CREATE TABLE `estudiante` (
  `id_lector` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `carrera` varchar(50) NOT NULL,
  `edad` int NOT NULL,
  PRIMARY KEY (`id_lector`)
);

CREATE TABLE `prestamo` (
  `id_prestamo` int unsigned NOT NULL AUTO_INCREMENT,
  `id_lector` int unsigned NOT NULL,
  `id_libro` int unsigned NOT NULL,
  `fecha_prestamo` timestamp NOT NULL,
  `fecha_devolucion` timestamp NOT NULL,
  `devuelto` bool NOT NULL,
  PRIMARY KEY (`id_prestamo`),
  KEY `prestamo__libro` (`id_libro`),
  KEY `prestamo__estudiante` (`id_lector`),
  CONSTRAINT `prestamo__libro` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`),
  CONSTRAINT `prestamo__estudiante` FOREIGN KEY (`id_lector`) REFERENCES `estudiante` (`id_lector`)
);

INSERT INTO libro(titulo, editorial, area) VALUES 
('Libro 1', 'Editorial 1', 'Area 1'),
('Libro 2', 'Editorial 2', 'Area 2'),
('Libro 3', 'Editorial 3', 'Area 3'),
('Libro 4', 'Editorial 4', 'Area 4'),
('Libro 5', 'Editorial 5', 'Area 5');


INSERT INTO autor(nombre, nacionalidad) VALUES
('J.K. Rowling', 'Pais 1'),
('Autor 2', 'Pais 2'),
('Autor 3', 'Pais 3'),
('Autor 4', 'Pais 4'),
('Autor 5', 'Pais 5');

INSERT INTO libro_autor(id_autor, id_libro) VALUES
(1,1),
(1,2),
(1,3),
(2,4),
(3,5);

INSERT INTO estudiante(nombre, apellido, direccion, carrera, edad) VALUES
('Nombre 1', 'Apellido 1', 'Direccion 1', 'Carrera 1', 20),
('Gombre 2', 'Apellido 2', 'Direccion 2', 'Carrera 2', 21),
('Nombre 3', 'Apellido 3', 'Direccion 3', 'Informática', 22),
('Nombre 4', 'Apellido 4', 'Direccion 4', 'Carrera 4', 23),
('Gombre 5', 'Apellido 5', 'Direccion 5', 'Carrera 5', 24);

INSERT INTO prestamo(id_lector, id_libro,fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1,1,'2022-05-05', '2022-05-12', false),
(2,2,'2022-05-05', '2022-05-12', true),
(3,4,'2022-05-05', '2022-05-12', false),
(4,3,'2022-05-05', '2022-05-12', true),
(5,5,'2022-05-05', '2022-05-12', false);

-- Listar los datos de los autores
SELECT * FROM autor;

--¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor where nacionalidad = 'francesa' OR nacionalidad = 'italiana';

-- ¿Qué libros no son del área de internet?
SELECT * FROM libro where not area = 'internet';

-- Listar los libros de la editorial Salamandra.
SELECT * FROM libro where editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * from estudiante where edad > avg(edad);

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo FROM libro_autor la 
inner join libro l on l.id_libro=la.id_libro 
inner join autor a on a.id_autor=la.id_autor 
where a.nombre = 'J.K. Rowling';

-- Listar el nombre del estudiante de menor edad.
SELECT e.nombre, e.apellido FROM estudiante e 
where e.edad = (SELECT min(edad) FROM estudiante);

-- Listar nombre y edad de los estudiantes.
SELECT e.nombre, e.apellido, e.edad FROM estudiante e;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT e.nombre, e.apellido FROM estudiante e
where e.carrera = 'Informática';

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT e.nombre, e.apellido FROM estudiante e
where e.nombre like 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres)

-- ¿Qué libros se prestaron al lector “Filippo Galli”?

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

--Listar títulos de los libros que debían devolverse el 16/07/2021.