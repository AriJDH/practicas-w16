INSERT INTO autor(nombre, nacionalidad)
VALUES ('Emanuel', 'Argentina');
INSERT INTO autor(nombre, nacionalidad)
VALUES ('Condori', 'Argentina');
INSERT INTO autor(nombre, nacionalidad)
VALUES ('Juan1', 'Argentina');
INSERT INTO autor(nombre, nacionalidad)
VALUES ('Juan2', 'Argentina');
INSERT INTO autor(nombre, nacionalidad)
VALUES ('Pepe', 'Colombia');
INSERT INTO autor(nombre, nacionalidad)
VALUES ('Melisa', 'Uruguay');

INSERT INTO estudiante(nombre, apellido, direccion, carrera, edad)
VALUES ('Fernando', 'Rivero', 'Calle falsa 123', 'ING Informatica', 54);

INSERT INTO estudiante(nombre, apellido, direccion, carrera, edad)
VALUES ('Priscila', 'Mujica', 'San Rafa 123', 'ING Civil', 21);

INSERT INTO estudiante(nombre, apellido, direccion, carrera, edad)
VALUES ('Eduardo', 'Juan Cruz', 'Veni a buscarlo', 'ING Electronica', 34);

INSERT INTO estudiante(nombre, apellido, direccion, carrera, edad)
VALUES ('Juan', 'Pala', 'Calle 443', 'ING Mecanica', 24);

INSERT INTO estudiante(nombre, apellido, direccion, carrera, edad)
VALUES ('Pedro', 'Cruz', 'Bosbonia 123', 'ING Mecatronica', 44);

INSERT INTO estudiante(nombre, apellido, direccion, carrera, edad)
VALUES ('Falso', 'Duki', 'duki 443', 'ING Nava', 27);


INSERT INTO libro(titulo, editorial, Area)
VALUES ('Game Of Thrones', 'Alfa Omega', 'Ciencia Ficcion');

INSERT INTO libro(titulo, editorial, Area)
VALUES ('El juego del calamar', 'Los Asiaticos', 'Muerte');

INSERT INTO libro(titulo, editorial, Area)
VALUES ('Perro Salchicha', 'Editorial 2', 'Animales');

INSERT INTO libro(titulo, editorial, Area)
VALUES ('Harry Potter', 'Una Editorial', 'Ciencia Ficcion');

INSERT INTO libro(titulo, editorial, Area)
VALUES ('Shotter', 'Editorial Buena', 'Accion');


#Listar los datos de los autores.
SELECT *
FROM autor;
#Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM estudiante;

#¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM estudiante
WHERE carrera LIKE '%Informatica%';
#¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM autor
WHERE autor.nacionalidad LIKE '%Italiana%';

#¿Qué libros no son del área de internet?
SELECT *
FROM libro
WHERE Area LIKE '%Internet%';

#Listar los libros de la editorial Salamandra.
SELECT *
FROM libro
WHERE libro.editorial LIKE '%Salamandra%';

#Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE edad > (SELECT avg(edad) FROM estudiante);

#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre
FROM estudiante
WHERE estudiante.nombre LIKE 'G%';

#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT autor.*
FROM libroautor
         INNER JOIN autor on libroautor.idAutor = autor.idAutor
         INNER JOIN libro on libroautor.idLibro = libro.idLibro
WHERE libro.titulo LIKE '%El universo:Guia de viaje%';
#¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT libro.titulo
FROM prestamo
         INNER JOIN estudiante on estudiante.idLector = prestamo.idLector
         INNER JOIN libro on libro.idLibro = prestamo.idLibro
WHERE estudiante.nombre LIKE '%Filipo%'
  AND estudiante.apellido LIKE '%Galle%';
#Listar el nombre del estudiante de menor edad.
SELECT nombre
FROM estudiante
WHERE edad = (SELECT min(edad) FROM estudiante);
#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT DISTINCT nombre
FROM prestamo
         INNER JOIN estudiante on estudiante.idLector = prestamo.idLector
         INNER JOIN libro on libro.idLibro = prestamo.idLibro
WHERE libro.titulo LIKE '%Bases de datos%';
#Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.*
FROM libroautor
         INNER JOIN autor ON libroautor.idAutor = autor.idAutor
         INNER JOIN libro l on libroautor.idLibro = l.idLibro
WHERE autor.nombre LIKE '%J.K. Rowling.%';
#Listar títulos de los libros que debían devolverse el 16/07/2021.

SELECT l.titulo
FROM prestamo
         INNER JOIN libro l on prestamo.idLibro = l.idLibro
    WHERE prestamo.fecha_devolucion= DATE '2022-08-28';
