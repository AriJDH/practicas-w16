CREATE DATABASE Ejercicio_Der;

CREATE TABLE Libro (
id_libro integer not null,
titulo varchar(50) not null,
editorial varchar(50) not null,
area varchar(50) not null,
primary key(id_libro)
);

CREATE TABLE Autor (
id_autor integer not null,
nombre varchar(50) not null,
nacionalidad varchar(50) not null,
primary key(id_autor)
);

CREATE TABLE LibroAutor (
id_libro integer not null,
id_autor integer not null,
foreign key(id_libro) references Libro(id_libro),
foreign key(id_autor) references Autor(id_autor)
);

CREATE TABLE Estudiante (
id_lector integer not null,
nombre varchar(50) not null,
apellido varchar(50) not null,
direccion varchar(50) not null,
carrera varchar(50) not null,
edad integer not null,
nacionalidad varchar(50) not null,
primary key(id_lector)
);

CREATE TABLE Prestamo (
id_lector integer not null,
id_libro integer not null,
fecha_prestamo date not null,
fecha_devolucion date not null,
devuelto boolean not null,
foreign key(id_lector) references Libro(id_libro),
foreign key(id_libro) references Autor(id_autor)
);

-- Registros Estudiante
INSERT INTO Estudiante VALUES (1, 'César', 'Piñero', 'dir1', 'Musica', 20, 'Colombia');
INSERT INTO Estudiante VALUES (2, 'Pepe', 'Gomez', 'dir2', 'Informatica', 34, 'Argentina');
INSERT INTO Estudiante VALUES (3, 'Gonzalo', 'Saenz', 'dir3', 'Informatica', 18, 'Mexico');
INSERT INTO Estudiante VALUES (4, 'Maria', 'Olmos', 'dir4', 'Informatica', 26, 'Uruguay');
INSERT INTO Estudiante VALUES (5, 'Sofia', 'Garcia', 'dir5', 'Administracion', 30, 'Chile');


-- Registros Libro
INSERT INTO Libro VALUES (1, 'tit1', 'Edi1', 'Internet');
INSERT INTO Libro VALUES (2, 'tit2', 'Salamandra', 'Internet');
INSERT INTO Libro VALUES (3, 'El Universo: Guía de viaje', 'Edi3', 'Area3');
INSERT INTO Libro VALUES (4, 'tit4', 'Edi4', 'Area4');
INSERT INTO Libro VALUES (5, 'tit5', 'Edi5', 'Area5');

-- Registros Autor
INSERT INTO Autor VALUES (1, 'Han Solo', 'Colombia');
INSERT INTO Autor VALUES (2, 'Heisenberg', 'Francia');
INSERT INTO Autor VALUES (3, 'Joe', 'Mexico');
INSERT INTO Autor VALUES (4, 'Trevor', 'Brazil');
INSERT INTO Autor VALUES (5, 'Link', 'Italia');

-- Registros LibroAutor
INSERT INTO LibroAutor VALUES (1,5);
INSERT INTO LibroAutor VALUES (3,4);
INSERT INTO LibroAutor VALUES (2,3);
INSERT INTO LibroAutor VALUES (4,2);
INSERT INTO LibroAutor VALUES (5,1);

-- Registros Prestamo
INSERT INTO Prestamo VALUES(1, 3, '20220824', '20220825', true);
INSERT INTO Prestamo VALUES(2, 3, '20220824', '20220825', true);
INSERT INTO Prestamo VALUES(3, 1, '20200824', '20210716', false);
INSERT INTO Prestamo VALUES(4, 2, '20220824', '20220825', true);
INSERT INTO Prestamo VALUES(5, 4, '20200824', '20210716', false);


-- 1. Listar los datos de los autores.
SELECT id_autor, nombre, nacionalidad FROM Autor;

-- 2. Listar nombre y edad de los estudiantes
SELECT nombre, apellido, edad FROM Estudiante;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido, carrera FROM Estudiante
WHERE Carrera = 'Informatica';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre, nacionalidad FROM Autor
WHERE nacionalidad = 'Francia' OR nacionalidad = 'Italia';

-- 5. ¿Qué libros no son del área de internet?
SELECT titulo, editorial, area FROM Libro
WHERE area != 'Internet';

-- 6. Listar los libros de la editorial Salamandra.
SELECT titulo, editorial FROM Libro
WHERE editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT nombre, edad FROM Estudiante where edad > (SELECT AVG(edad) as promedio FROM Estudiante);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido FROM Estudiante WHERE apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT nombre FROM Autor A
INNER JOIN LibroAutor LA ON A.id_autor = LA.id_autor
INNER JOIN Libro L ON L.id_libro = LA.id_libro
WHERE L.titulo = 'El Universo: Guía de viaje';

-- 10. ¿Qué libros se prestaron al lector “César Piñero”?
SELECT titulo FROM Libro L
INNER JOIN Prestamo P ON P.id_libro = L.id_libro
INNER JOIN Estudiante E ON E.id_lector = P.id_lector
WHERE E.nombre = 'César' AND E.apellido = 'Piñero';

-- Listar el nombre del estudiante de menor edad.
SELECT nombre FROM Estudiante
ORDER BY edad
LIMIT 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Internet.
SELECT nombre FROM Estudiante E
INNER JOIN Prestamo P ON P.id_lector = E.id_lector
INNER JOIN Libro L ON L.id_libro = P.id_libro
WHERE L.area = 'Internet';

-- Listar los libros que pertenecen al autor Trevor.
SELECT titulo FROM Libro L
INNER JOIN LibroAutor LA ON LA.id_libro = L.id_libro
INNER JOIN Autor A ON LA.id_autor = A.id_autor
WHERE A.nombre = 'Trevor';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT titulo FROM Libro L
INNER JOIN Prestamo P ON P.id_libro = L.id_libro
WHERE P.fecha_devolucion = '20210716';




