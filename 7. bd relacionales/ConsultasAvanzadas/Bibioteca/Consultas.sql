use biblioteca;
#Listar los datos de los autores.
select * from Autor;
#Listar nombre y edad de los estudiantes
select nombre,edad from Estudiante;
#¿Qué estudiantes pertenecen a la carrera informática?
select * from Estudiante
where carrera = 'informatica';
#¿Qué autores son de nacionalidad francesa o italiana?
select * from Autor 
where nacionalidad = 'italiana' or nacionalidad ='francesa';
#¿Qué libros no son del área de internet?
select * from Libro
where area= 'internet';
#Listar los libros de la editorial Salamandra.
select * from Libro
where editorial = 'Salamandra';
#Listar los datos de los estudiantes cuya edad es mayor al promedio.
select AVG(ALL edad) from Estudiante;#Promedio de edad
select * from Estudiante 
where edad>(select AVG(ALL edad) from Estudiante);
#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM Estudiante WHERE nombre LIKE 'G%';
#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select
Autor.nombre AS 'Autor'
from Autor autor
INNER JOIN Libro 
ON libro.idLibro = autor.idAutor
where libro.titulo = 'El Universo: Guía de viaje';
#¿Qué libros se prestaron al lector “Filippo Galli”?
select 
titulo
from Prestamo prestamo
INNER JOIN Estudiante estudiante ON prestamo.Estudiante_idLector = estudiante.idLector
INNER JOIN Libro libro ON prestamo.Libro_idLibro = libro.idLibro
where Estudiante.nombre = 'Filippo' and Estudiante.apellido = 'Galli';
#Listar el nombre del estudiante de menor edad.
select 
nombre
from Estudiante
where edad = (select MIN(edad) from Estudiante);
#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select 
nombre
from Prestamo prestamo
INNER JOIN Estudiante estudiante ON prestamo.Estudiante_idLector = estudiante.idLector
INNER JOIN Libro libro ON prestamo.Libro_idLibro = libro.idLibro
where area = 'Base de Datos';
#Listar los libros que pertenecen a la autora J.K. Rowling.
select 
titulo 
from Autor autor
INNER JOIN LibroAutor libroautor ON autor.idAutor = libroautor.Autor_idAutor
INNER JOIN Libro libro ON libro.idLibro = libroautor.Libro_idLibro
where nombre LIKE 'J.K%';
#Listar títulos de los libros que debían devolverse el 16/07/2021.
select 
titulo
from Prestamo prestamo
INNER JOIN Estudiante estudiante ON prestamo.Estudiante_idLector = estudiante.idLector
INNER JOIN Libro libro ON prestamo.Libro_idLibro = libro.idLibro
where fecha_devolucion = '2021-07-16';









