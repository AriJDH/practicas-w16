USE biblioteca_bd;

# Listar los datos de los autores.
SELECT *
FROM Autor;

# Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM Estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre
FROM Estudiante
WHERE carrera = 'Informática';

# ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre 
FROM Autor 
WHERE nacionalidad ='francesa' AND nacionalidad ='italiana';

# ¿Qué libros no son del área de internet?
SELECT titulo 
FROM Libro 
WHERE nacionalidad ='internet';

# Listar los libros de la editorial Salamandra.
SELECT titulo 
FROM Libro 
WHERE editorial ='Salamandra' ;

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM Estudiante
WHERE edad > (SELECT AVG(edad)
			  FROM Estudiante );

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre
FROM Estudiante
WHERE apellido LIKE 'G%';

# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM Autor a
INNER JOIN LibroAutor la
INNER JOIN Libro l
WHERE l.titulo = 'El Universo: Guía de viaje';

# ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo
FROM Libro l
INNER JOIN Prestamo p
INNER JOIN Estudiante e
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

# Listar el nombre del estudiante de menor edad.
SELECT nombre
FROM Estudiante
WHERE edad = (SELECT MIN(edad)
			  FROM Estudiante );

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre 
FROM Estudiante e
INNER JOIN Prestamo p
INNER JOIN Libro l
WHERE l.area = 'Base de Datos';

# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo
FROM Libro l
INNER JOIN LibroAutor la
INNER JOIN Autor a
WHERE a.nombre = 'EJ.K. Rowling';

# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM Libro l
INNER JOIN Prestamo p
WHERE p.fechaDevolucion = '2021-07-16';
