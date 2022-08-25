-- Listar los datos de los autores.
SELECT nombre, nacionalidad FROM Autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM Estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido, carrera FROM Estudiante WHERE carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre, nacionalidad FROM Autor WHERE nacionalidad = 'Francesa' OR nacionalidad = 'Italiana';

-- ¿Qué libros no son del área de internet?
SELECT titulo, area, editorial FROM Libro WHERE area != 'Internet';

-- Listar los libros de la editorial Salamandra.
SELECT titulo, area, editorial FROM Libro WHERE editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT nombre, apellido, edad FROM Estudiante WHERE edad > (SELECT AVG(edad) FROM Estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido, edad FROM Estudiante WHERE apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT autor.nombre FROM LibroAutor
INNER JOIN Libro ON LibroAutor.idLibro = Libro.idLibro
INNER JOIN Autor ON LibroAutor.idAutor = Autor.idAutor
WHERE libro.titulo = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT libro.titulo, libro.editorial, libro.area FROM Prestamo
INNER JOIN Libro ON Prestamo.idLibro = Libro.idLibro
INNER JOIN Estudiante ON Prestamo.idLector = Estudiante.idLector
WHERE estudiante.nombre = 'Filippo' AND estudiante.apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT nombre, apellido, edad FROM Estudiante WHERE edad = (SELECT MIN(edad) FROM Estudiante);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT estudiante.nombre, estudiante.apellido FROM Prestamo
INNER JOIN Libro ON Prestamo.idLibro = Libro.idLibro
INNER JOIN Estudiante ON Prestamo.idLector = Estudiante.idLector
WHERE libro.area = 'Base de datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT libro.titulo FROM LibroAutor
INNER JOIN Libro ON LibroAutor.idLibro = Libro.idLibro
INNER JOIN Autor ON LibroAutor.idAutor = Autor.idAutor
WHERE autor.nombre = 'J.K. Rowling.';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT libro.titulo, libro.area FROM Prestamo
INNER JOIN Libro ON Prestamo.idLibro = Libro.idLibro
WHERE prestamo.fechaDevolucion = '2021-07-16';

