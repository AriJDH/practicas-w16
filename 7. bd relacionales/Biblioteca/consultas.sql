/* Listar los datos de los autores. */
SELECT * FROM autor;
/* Listar nombre y edad de los estudiantes */
SELECT nombre, edad FROM estudiante;
/* ¿Qué estudiantes pertenecen a la carrera informática? */
SELECT * FROM estudiante WHERE carrera LIKE 'informática';
/* ¿Qué autores son de nacionalidad francesa o italiana? */
SELECT *
FROM autor
WHERE nacionalidad LIKE 'Francesa' OR nacionalidad LIKE 'Italiana';
/* ¿Qué libros no son del área de internet? */
SELECT * FROM libro WHERE area <> "Internet";
/* Listar los libros de la editorial Salamandra. */
SELECT * FROM libro WHERE editorial = 'Salamandra';
/* Listar los datos de los estudiantes cuya edad es mayor al promedio. */
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);
/* Listar los nombres de los estudiantes cuyo apellido comience con la letra G. */
SELECT * FROM estudiante WHERE apellido like 'G%';
/* Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres). */
SELECT a.nombre FROM libro l
INNER JOIN libro_autor la ON la.libro_id = l.libro_id
INNER JOIN autor a ON a.autor_id = la.autor_id
WHERE l.titulo LIKE '%El Universo: Guía de viaje%';
/* ¿Qué libros se prestaron al lector “Filippo Galli”? */
SELECT l.* FROM prestamo p
INNER JOIN libro l ON l.libro_id = p.libro_id
INNER JOIN estudiante e ON e.lector_id = p.lector_id
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';
/* Listar el nombre del estudiante de menor edad. */
SELECT * FROM estudiante 
WHERE edad IN (SELECT MIN(edad) FROM estudiante);
/* Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos. */
SELECT e.nombre, e.apellido FROM prestamo p
INNER JOIN estudiante e on e.lector_id = p.lector_id;
/* Listar los libros que pertenecen a la autora J.K. Rowling. */
SELECT l.* FROM libro_autor la
INNER JOIN libro l ON l.libro_id = la.libro_id
INNER JOIN autor a ON a.autor_id = la.autor_id
WHERE a.nombre = 'J. K. Rowling';
/* Listar títulos de los libros que debían devolverse el 16/07/2021. */
SELECT * FROM prestamo p 
INNER JOIN libro l ON l.libro_id = p.libro_id
WHERE p.fecha_devolucion = "2021/07/16";