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
('El cliente', 'Booket', 'Novela'),
('El informe pelicano', 'De Bolsillo', 'Novela'),
('Cien años de soledad', 'Literatura Random House', 'Novela'),
('Doce cuentos peregrinos', 'Editorial Temis', 'Cuento'),
('Harry potter y las reliquias de la muerte', 'Casa del libro', 'Ficcion'),
('Harry potter y el caliz de fuego', 'Casa del libro','Ficcion'),
('Animales fantasticos y donde encontrarlos', 'Casa del libro', 'Novela'),
('Ickabog', 'Salamandra', 'Cuento');


INSERT INTO autor(nombre, nacionalidad) VALUES
('J.K. Rowling', 'Reino Unido'),
('Gabriel Garcia Márquez', 'Colombia'),
('William Shakespeare', 'Reino Unido'),
('Miguel de Cervantes', 'Italia'),
('John Grisham', 'Estados Unidos');

INSERT INTO libro_autor(id_autor, id_libro) VALUES
(1,5),
(1,6),
(1,7),
(1,8),
(2,2),
(2,3),
(5,1),
(5,2);

INSERT INTO estudiante(nombre, apellido, direccion, carrera, edad) VALUES
('Ana Maria', 'Alvarez Perez', 'Av 1 calle 16AN', 'Literatura', 24),
('Gabriel Alejandro', 'Pelaez Gutierrez', 'Carrera 12 calle 4B', 'Idiomas', 21),
('Diana Valentina', 'Guerrero', 'Av 1 calle 10N', 'Informática', 18),
('Elena Andrea', 'Gilbert Bermudez', 'Avenida 0 calle 8AN', 'Ingenieria Industrial', 22),
('Miguel Fabian', 'Gutierrez Ortiz', 'Avenida 0 calle 1', 'Informática', 24);

INSERT INTO prestamo(id_lector, id_libro,fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1,4,'2022-01-05', '2022-04-12', true),
(5,2,'2022-07-19', '2022-09-19', true),
(4,7,'2022-04-01', '2022-04-29', true),
(2,1,'2022-01-15', '2022-02-19', true),
(1,6,'2022-05-24', '2022-11-24', false);

-- Listar los datos de los autores
SELECT * FROM autor;

-- Listar nombre y edad de los estudiantes.
SELECT e.nombre, e.apellido, e.edad AS nombre_edad_estudiantes FROM estudiante e;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT e.nombre, e.apellido AS estudiantes_carrera_informática FROM estudiante e
where e.carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT a.nombre AS autor_nacionalidad_francesa_o_italiana FROM autor a 
where a.nacionalidad = 'Italia' OR a.nacionalidad = 'Francia';

-- ¿Qué libros no son del área de internet?
SELECT l.titulo AS libro_area_internet FROM libro l
where l.area = 'Internet';

-- Listar los libros de la editorial Salamandra
SELECT l.titulo AS libro_editorial_salamandra FROM libro l
where l.editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio
SELECT * FROM estudiante e 
where e.edad > (SELECT avg(edad) FROM estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT e.nombre, e.apellido AS nombre_estudiante_comienza_G FROM estudiante e
where e.nombre like 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre AS autores_de_El_Universo_Guía_de_viaje FROM libro_autor la 
INNER JOIN libro l ON l.id_libro = la.id_libro
INNER JOIN autor a ON a.id_autor = la.id_autor
WHERE l.titulo = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo AS libros_prestados_a_Filippo_Galli FROM prestamo p
INNER JOIN libro l ON l.id_libro = p.id_libro
INNER JOIN estudiante e ON e.id_lector = p.id_lector
WHERE e.nombre = 'Filippo Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT e.nombre, e.apellido AS estudiante_menor FROM estudiante e 
where e.edad = (SELECT min(edad) FROM estudiante);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos
SELECT e.nombre AS lectores_de_bd FROM prestamo p
INNER JOIN libro l ON l.id_libro = p.id_libro
INNER JOIN estudiante e ON e.id_lector = p.id_lector
WHERE l.area like '%Base de Datos%';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo AS libros_JK_Rowling FROM libro_autor la 
inner join libro l on l.id_libro=la.id_libro 
inner join autor a on a.id_autor=la.id_autor 
where a.nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021
SELECT l.titulo AS libros_devolucion_16_07_2021 FROM prestamo p
INNER JOIN libro l ON l.id_libro = p.id_libro 
AND p.fecha_devolucion = '2021-07-16';



