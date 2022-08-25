/*
 * Ejercicio > Modulo 15: BD Relacionales > ConsultasSQLAvanzadas-Parte1-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
 
-- 1. Listar los datos de los autores.
SELECT idAutor, nombre, nacionalidad FROM Autor;

-- 2. Listar nombre y edad de los estudiantes.
SELECT nombre, edad FROM Estudiante;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT idLector, nombre, apellido, direccion, carrera, edad FROM Estudiante WHERE carrera = 'Informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT idAutor, nombre, nacionalidad FROM Autor WHERE nacionalidad = 'Francesa' OR nacionalidad = 'Italiana';

-- 5. ¿Qué libros no son del área de internet?
SELECT idLibro, titulo, editorial, area FROM Libro WHERE area <> 'Internet';

-- 6. Listar los libros de la editorial Salamandra.
SELECT idLibro, titulo, editorial, area FROM Libro WHERE editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT idLector, nombre, apellido, direccion, carrera, edad 
FROM Estudiante 
WHERE edad > (SELECT AVG(e.edad) FROM Estudiante e);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT idLector, nombre, apellido, direccion, carrera, edad FROM Estudiante WHERE apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM Autor a
	INNER JOIN LibroAutor la ON la.idAutor = a.idAutor
    INNER JOIN Libro l ON l.idLibro = la.idLibro
WHERE l.titulo = 'El Universo: Guía de viaje';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.idLibro, l.titulo, l.editorial, l.area 
FROM Libro l
	INNER JOIN Prestamo p ON p.idLibro = l.idLibro
WHERE p.idLector = (SELECT e.idLector FROM Estudiante e WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli');

-- 11. Listar el nombre del estudiante de menor edad.
SELECT nombre 
FROM Estudiante 
WHERE edad = (SELECT MIN(e.edad) FROM Estudiante e);

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre
FROM Estudiante e
	INNER JOIN Prestamo p ON p.idLector = e.idLector
WHERE p.idLibro IN (SELECT l.idLibro FROM Libro l WHERE l.area = 'Base de datos');

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.idLibro, l.titulo, l.editorial, l.area
FROM Libro l
	INNER JOIN LibroAutor la ON la.idLibro = l.idLibro
    INNER JOIN Autor a ON a.idAutor = la.idAutor
WHERE a.nombre = 'J. K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT titulo
FROM Libro
WHERE idLibro IN (SELECT p.idLibro FROM Prestamo p WHERE p.fechaDevolucion = '2021-07-16');