-- En base al mismo, plantear las consultas SQL para resolver los siguientes requerimientos:
-- Listar los datos de los autores.
select * from Autor;

-- Listar nombre y edad de los estudiantes
select Nombre, Edad from Estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select Nombre, Apellido 
from Estudiante
where Carrera = "Informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?
select Nombre, Nacionalidad 
from Autor
where Nacionalidad = "Francesa" or Nacionalidad = "Italiana";

-- ¿Qué libros no son del área de internet?
select Titulo, Area 
from Libro
where Area != "Internet";//

-- Listar los libros de la editorial Salamandra.
select Titulo, Editorial
from Libro
where Editorial = "Salamandra";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select idLector, Nombre, Apellido, Direccion, Carrera, Edad, avg(Edad)
from Estudiante 
group by idLector, Nombre, Apellido, Direccion, Carrera, Edad
having Edad > avg(Edad);//

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select Nombre, Apellido
from Estudiante
where Apellido = "G%";//

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.Nombre
from Autor a
inner join LibroAutor la on a.idAutor = la.idAutor
inner join Libro l on la.idLibro = l.idLibro
where l.Titulo = "El Universo: Guía de viaje";

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select l.Titulo
from Libro l
inner join Prestamo p on l.idLibro = p.idLibro
inner join Estudiante e on p.idLector = e.idLector
where e.Nombre = "Filippo";

-- Listar el nombre del estudiante de menor edad.
select Nombre
from Estudiante
order by Edad asc
limit 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select e.Nombre
from Estudiante e
inner join Prestamo p on e.idLector = p.idLector
inner join Libro l on p.idLibro = l.idLibro
where l.Area = "Base de Datos";

-- Listar los libros que pertenecen a la autora J.K. Rowling.
select l.Titulo
from Libro l
inner join LibroAutor la on l.idLibro = la.idLibro
inner join Autor a on la.idAutor = a.idAutor
where a.Nombre = "J.K.";

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
select l.Titulo
from Libro l
inner join Prestamo p on l.idLibro = l.idLibro
where p.FechaDevolucion = "2021-07-16";

use biblioteca_db;
select * from Autor;
select * from Estudiante;
select * from Libro;
select * from LibroAutor;
select * from Prestamo;

INSERT INTO Autor(idAutor, Nombre, Nacionalidad)
VALUES(1, "J.K. Rowling", "Inglesa");
INSERT INTO Autor(idAutor, Nombre, Nacionalidad)
VALUES(2, "Carmenza Rojas", "Francesa");
INSERT INTO Autor(idAutor, Nombre, Nacionalidad)
VALUES(3, "Jose Martinez", "Italiana");

INSERT INTO Estudiante(idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES(1, "Julio", "Gomez", "calle false", "Ingenieria", 20);
INSERT INTO Estudiante(idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES(2, "Dolis", "Franco", "calle false", "Licenciatura", 22);
INSERT INTO Estudiante(idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES(3, "Filippo", "Galli", "calle false", "Informatica", 25);
INSERT INTO Estudiante(idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES(4, "Armando", "Polo", "calle false", "Medicina", 50);

INSERT INTO Libro(idLibro, Titulo, Editorial, Area)
VALUES(1, "El Universo: Guía de viaje", "Salamandra", "Ciencia");
INSERT INTO Libro(idLibro, Titulo, Editorial, Area)
VALUES(2, "Base de datos", "Salamandra", "Informatica");
INSERT INTO Libro(idLibro, Titulo, Editorial, Area)
VALUES(3, "Servidor de datos", "Salamandra", "Base de datos");
INSERT INTO Libro(idLibro, Titulo, Editorial, Area)
VALUES(4, "Servidor de datos", "Salamandra", "Base de datos");

INSERT INTO LibroAutor(idLibro, idAutor)
VALUES(1,2);
-- --//
INSERT INTO LibroAutor(idLibro, idAutor)
VALUES(1,4);
-- 
INSERT INTO LibroAutor(idLibro, idAutor)
VALUES(2,3);
INSERT INTO LibroAutor(idLibro, idAutor)
VALUES(3,3);
INSERT INTO LibroAutor(idLibro, idAutor)
VALUES(4,3);

INSERT INTO Prestamo(idLibro, idLector, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES(1, 3, "2021-07-01", "2021-07-16", false);
INSERT INTO Prestamo(idLibro, idLector, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES(2, 2, "2021-03-21", "2021-07-16", false);
INSERT INTO Prestamo(idLibro, idLector, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES(3, 3, "2021-03-21", "2021-07-16", false);
INSERT INTO Prestamo(idLibro, idLector, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES(4, 3, "2021-03-21", "2021-07-16", false);

