DROP DATABASE IF EXISTS biblioteca_sql_avanzado;
CREATE DATABASE biblioteca_sql_avanzado;
USE biblioteca_sql_avanzado;


CREATE TABLE estudiante(
idLector INT NOT NULL auto_increment PRIMARY KEY,
nombre VARCHAR(20) NOT NULL,
apellido VARCHAR(20) NOT NULL,
direccion VARCHAR(20) NOT NULL,
carrera VARCHAR(20) NOT NULL,
edad INT NOT NULL
);

CREATE TABLE autor(
idAutor INT NOT NULL auto_increment PRIMARY KEY,
nombre VARCHAR(20) NOT NULL,
nacionalidad VARCHAR(20) NOT NULL
);

CREATE TABLE libro(
idLibro INT NOT NULL auto_increment PRIMARY KEY,
titulo VARCHAR(20) NOT NULL,
editorial VARCHAR(20) NOT NULL,
larea VARCHAR(20) NOT NULL
);
​
CREATE TABLE libroAutor(
idLibro INT NOT NULL,
idAutor INT NOT NULL,
FOREIGN KEY (idLibro) REFERENCES libro(idLibro),
FOREIGN KEY (idAutor) REFERENCES autor(idAutor),
PRIMARY KEY(idLibro, idAutor)
);
​
CREATE TABLE prestamo(
idLector INT NOT NULL,
idLibro INT NOT NULL,
fechaPrestamo DATETIME NOT NULL,
fechaDevolucion DATETIME NOT NULL,
devuelto BOOL NOT NULL,
FOREIGN KEY (idLibro) REFERENCES libro(idLibro),
FOREIGN KEY (idLector) REFERENCES estudiante(idLector),
PRIMARY KEY(idLibro, idLector)
);
​
INSERT INTO estudiante values (1, 'Guillermo', 'Bariani', 'Los Pinos 65', 'Developer', 29);
INSERT INTO estudiante values (2, 'Camilo', 'Palma', 'Sargento Aldea', 'Comercial', 30);
INSERT INTO estudiante values (3, 'Nicolas', 'De Maio', 'Los Alcones 23', 'Developer', 24);
INSERT INTO estudiante values (4, 'Rodrigo', 'Cifuentes', 'Cuspides 1212', 'Informatica', 27);
INSERT INTO estudiante values (5, 'Sofia', 'Petrides', 'Mar de Plata 45', 'Literatura', 28);
​
INSERT INTO autor values (1, 'Michael Sarmiento', 'Chileno');
INSERT INTO autor values (2, 'Andres Nahuel', 'Argentino');
INSERT INTO autor values (3, 'Angie Areta', 'Venezolana');
INSERT INTO autor values (4, 'Raul Astoroaga', 'Brasileño');
INSERT INTO autor values (5, 'Americo Moure', 'Colombiano');
​
​
INSERT INTO libro VALUES
(1, 'La comarca', 'Duende', 'Streaming'),
(2, '9zTeam', 'Frankkaster', 'Gaming'),
(3, 'Manchester', 'Elvis', 'Musica'),
(4, 'El colo colo', 'Residente', 'Deporte'),
(5, 'Peñarol', 'Pou', 'Publico'),
(6, 'Nacional', 'Pou', 'Internet');

INSERT INTO libroAutor VALUES (1,1);
INSERT INTO libroAutor VALUES (1,2);
INSERT INTO libroAutor VALUES (2,3);
INSERT INTO libroAutor VALUES (4,4);
INSERT INTO libroAutor VALUES (5,5);

INSERT INTO prestamo VALUES(1, 2, '2020-09-12', '2021-07-11', true);
INSERT INTO prestamo VALUES(1, 1, '2020-10-22', '2022-05-13', false);
INSERT INTO prestamo VALUES(2, 4, '2020-03-01', '2021-05-22', true);
INSERT INTO prestamo VALUES(2, 5, '2020-02-09', '2022-12-24', false);
INSERT INTO prestamo VALUES(3, 3, '2020-02-23', '2021-05-22', true);
INSERT INTO prestamo VALUES(3, 2, '2020-08-31', '2022-08-04', false);
INSERT INTO prestamo VALUES(4, 1, '2020-12-16', '2021-07-16', true);
INSERT INTO prestamo VALUES(5, 2, '2020-01-25', '2022-05-22', false);


# Listar los datos de los autores.
SELECT autor.nombre, autor.nacionalidad FROM autor;

# Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre,apellido,direccion,carrera,edad FROM estudiante WHERE carrera = 'Informatica';

# ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre,nacionalidad FROM autor WHERE nacionalidad IN ('Brasileño', 'Colombiano');

# ¿Qué libros no son del área de internet?
SELECT l.titulo,l.editorial,l.larea FROM libro l WHERE NOT l.larea = 'Internet';

# Listar los libros de la editorial Salamandra.
SELECT l.titulo,l.editorial,l.larea FROM libro l WHERE l.editorial = 'Frankkaster';

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT nombre,apellido,direccion,carrera,edad FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra P.
SELECT e.nombre FROM estudiante e WHERE e.apellido LIKE 'P%';

# Listar los autores del libro "La comarca". (Se debe listar solamente los nombres).
SELECT a.nombre 
FROM autor a
INNER JOIN libroAutor la ON la.idAutor = a.idAutor
INNER JOIN libro l ON la.idLibro = l.idLibro
WHERE l.titulo = 'La comarca';

# ¿Qué libros se prestaron al lector "Filippo Galli"?
SELECT l.titulo,l.editorial
FROM libro l
INNER JOIN prestamo p ON p.idLibro = l.idLibro
INNER JOIN estudiante e ON p.idLector = e.idLector
WHERE e.nombre = 'Guillermo' AND e.apellido = 'Bariani';

# Listar el nombre del estudiante de menor edad.
SELECT e.nombre
FROM estudiante e
ORDER BY e.edad ASC
LIMIT 1;

# Listar nombres de los estudiantes a los que se prestaron libros de Deporte.
SELECT e.nombre, e.apellido
FROM estudiante e
INNER JOIN prestamo p ON p.idLector = e.idLector
INNER JOIN libro l ON l.idLibro = p.idLibro
WHERE l.larea = 'Deporte';

# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo
FROM libro l
INNER JOIN libroAutor la ON la.idLibro = l.idLibro
INNER JOIN autor a ON a.idAutor = la.idAutor
WHERE a.nombre = 'Michael Sarmiento';

# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM libro l
INNER JOIN prestamo p ON p.idLibro = l.idLibro
WHERE p.fechaDevolucion = '2021-07-16';