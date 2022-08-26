-- Listar los datos de los autores.
select * 
from Autor;
-- Listar nombre y edad de los estudiantes
select nombre, edad 
from Estudiante;
-- ¿Qué estudiantes pertenecen a la carrera informática?
select * 
from Estudiante 
where carrera = "Informatica";
-- ¿Qué autores son de nacionalidad francesa o italiana?
select * 
from Autor 
where nacionalidad ="Francesa" or nacionalidad = "Italiana";  
-- ¿Qué libros no son del área de internet?
select * 
from Libro 
where area != "Internet";
-- Listar los libros de la editorial Salamandra.
select * 
from Libro 
where editorial = "Salamandra";
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * 
from Estudiante 
where edad > 
	(select avg(edad) from Estudiante);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre, apellido 
from Estudiante 
where nombre like "G%";
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.nombre 
from LibroAutor la
	inner join Autor a on a.idAutor = la.idAutor
    inner join Libro l on l.idLibro = la.idLibro
where l.titulo = "El Universo: Guia de viaje";
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select l.* 
from Prestamo p
	inner join Estudiante e on e.idLector = p.idLector
    inner join Libro l on l.idLibro = p.idLibro
where e.nombre = "Filippo" and e.apellido = "Galli";
-- Listar el nombre del estudiante de menor edad.
select nombre from Estudiante where edad = (select min(edad) from Estudiante);
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select l.* 
from Prestamo p
	inner join Estudiante e on e.idLector = p.idLector
    inner join Libro l on l.idLibro = p.idLibro
where l.area = "Base de Datos";
-- Listar los libros que pertenecen a la autora J.K. Rowling.
select l.* 
from LibroAutor la
	inner join Autor a on a.idAutor = la.idAutor
    inner join Libro l on l.idLibro = la.idLibro
where a.nombre = "J.K. Rowling";
-- Listar títulos de los libros que debían devolverse el 16/07/2021.
select l.titulo 
from Prestamo p
	inner join Libro l on p.idLibro = l.idLibro
where p.fechaDevolucion = "2021-07-16";
