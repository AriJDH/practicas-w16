-- Listar los datos de los autores.
select * from autor;

-- Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante where carrera="Informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad in ('francesa','italiana');

-- ¿Qué libros no son del área de internet?
select * from libro where area <> 'internet';

-- Listar los libros de la editorial Salamandra.
select * from libro where editorial = 'salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad > (select avg(edad) from estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre from estudiante where apellido like 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.nombre from autor a inner join libroautor la on a.idAutor = la.idAutor inner join libro l on la.idLibro = l.idLibro where l.titulo='El Universo: Guia de viaje';

-- ¿Qué libros se prestaron al lector “Jonathan Bracco”?
select distinct l.titulo from libro l inner join prestamo p on l.idLibro = p.idLibro inner join estudiante e on p.idLector = e.idLector where e.nombre = "Jonathan" and e.apellido="Bracco";

-- Listar el nombre del estudiante de menor edad.
select nombre from estudiante where edad = (select min(edad) from estudiante);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select distinct e.nombre from estudiante e inner join prestamo p on e.idLector = p.idLector ;

-- Listar los libros que pertenecen a la autora J.K.Rowling.
select l.* from libro l inner join libroAutor la on l.idLibro = la.idLibro inner join autor a on la.idAutor = a.idAutor where a.nombre='J.K.Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
select l.titulo from libro l inner join prestamo p on l.idLibro = p.idLibro where p.fecha_devolucion = '2021-07-16';

