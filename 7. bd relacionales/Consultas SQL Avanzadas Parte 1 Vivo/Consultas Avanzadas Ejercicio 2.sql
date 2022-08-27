CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

INSERT INTO autor VALUES (null,'Tamara','Colombiana');
INSERT INTO autor VALUES (null,'Jose Pablo','Mexicana');
INSERT INTO autor VALUES (null,'Mildred','Italiana');
INSERT INTO autor VALUES (null,'Dante','Francesa');
INSERT INTO autor VALUES (null,'Alberich','Francesa');

UPDATE autor SET nombre="J.K. Rowling" WHERE id_autor=3;

INSERT INTO estudiante VALUES (1,'Alejandra','Mendoza','Calle 15','Informatica',23); 
INSERT INTO estudiante VALUES (2,'Alberto','Reinosa','Xalostoc','Derecho',17); 
INSERT INTO estudiante VALUES (3,'Filippo','Galli','Buenos Aires','Informatica',22); 
INSERT INTO estudiante VALUES (4,'Juan','Betancourt','Medellin','Medicina',25); 
INSERT INTO estudiante VALUES (5,'Susana','Ramirez','Santiago de Chile','Informatica',17); 

INSERT INTO libro VALUES (null,'El Universo: Guía de viaje','Salamabra','astronomia');
INSERT INTO libro VALUES (null,'Base de Datos','Santillana','informatica');
INSERT INTO libro VALUES (null,'La web','Salamandra','internet');
INSERT INTO libro VALUES (null,'Baase de Datos Relacionales','Schaums','informatica');
INSERT INTO libro VALUES (null,'Redes sociales','Schaums','internet');

UPDATE libro SET titulo = 'Base de Datos Relacionales' WHERE id_libro = 4;

INSERT INTO libroautor VALUES (null,1,1);
INSERT INTO libroautor VALUES (null,5,2);
INSERT INTO libroautor VALUES (null,2,3);
INSERT INTO libroautor VALUES (null,4,1);
INSERT INTO libroautor VALUES (null,3,5);
INSERT INTO libroautor VALUES (null,4,4);

INSERT INTO prestamo VALUES (null,1,2,"2021-06-16","2021-07-16",0);
INSERT INTO prestamo VALUES (null,2,1,"2021-06-16","2021-07-16",1);
INSERT INTO prestamo VALUES (null,4,3,"2021-05-10","2021-06-10",1);
INSERT INTO prestamo VALUES (null,5,4,"2021-03-05","2021-04-05",1);
INSERT INTO prestamo VALUES (null,3,5,"2021-07-12","2021-08-12",0);


-- Listar los datos de los autores.
SELECT * FROM autor;
-- Listar nombre y edad de los estudiantes
SELECT nombre,edad FROM estudiante;
-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = 'informatica';
-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad = 'Francesa' OR nacionalidad='Italiana';
-- ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE NOT area = 'internet';
-- Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = 'Salamandra';
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante WHERE edad>(SELECT AVG(edad) FROM estudiante);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM estudiante WHERE apellido LIKE 'G%';
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT autor.* FROM libro JOIN libroautor ON (libro.id_libro = libroautor.id_libro)
JOIN autor ON (libroautor.id_autor=autor.id_autor)
WHERE titulo = 'El Universo: Guía de viaje'
GROUP BY libroautor.id_autor;
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT libro.* FROM libro JOIN prestamo ON (libro.id_libro = prestamo.id_libro)
JOIN estudiante ON (estudiante.id_lector = prestamo.id_lector)
WHERE nombre = 'Filippo' AND apellido = 'Galli';
-- Listar el nombre del estudiante de menor edad.
SELECT nombre FROM estudiante WHERE edad<18 LIMIT 1;
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT estudiante.nombre FROM libro JOIN prestamo ON (libro.id_libro = prestamo.id_libro)
JOIN estudiante ON (estudiante.id_lector = prestamo.id_lector)
WHERE titulo LIKE '%Base de Datos%'
GROUP BY estudiante.id_lector;
-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT libro.* FROM libro JOIN libroautor ON (libro.id_libro = libroautor.id_libro)
JOIN autor ON (autor.id_autor = libroautor.id_autor)
WHERE nombre = 'J.K. Rowling'
GROUP BY libroautor.id_libro;
-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT libro.titulo FROM libro JOIN prestamo ON (libro.id_libro = prestamo.id_libro)
WHERE fecha_devolucion = "2021-07-16";

