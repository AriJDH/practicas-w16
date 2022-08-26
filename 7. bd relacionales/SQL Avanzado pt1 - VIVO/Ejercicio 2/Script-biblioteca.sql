DROP DATABASE IF EXISTS biblioteca_db;
CREATE DATABASE biblioteca_db;
USE biblioteca_db;

CREATE TABLE Autor (
  `id_autor` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `nacionalidad` varchar(50) NOT NULL,
  PRIMARY KEY (`id_autor`)
  );
  
  CREATE TABLE Estudiante (
  `id_lector` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `carrera` varchar(50) NOT NULL,
  `edad` int(10) NOT NULL,
  PRIMARY KEY (`id_lector`)
  );
  
    CREATE TABLE Libro (
  `id_libro` int unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `editorial` varchar(50) NOT NULL,
  `area` varchar(50) NOT NULL,
  PRIMARY KEY (`id_libro`)
  );
  
  CREATE TABLE LibroAutor (
  `id_autor` int unsigned NOT NULL,
  `id_libro` int unsigned NOT NULL,
  KEY `autor_libroAutor_id_foreign` (`id_autor`),
  CONSTRAINT `autor_libroAutor_id_foreign` FOREIGN KEY (`id_autor`) REFERENCES `Autor` (`id_autor`),
    KEY `libro_libroAutor_id_foreign` (`id_libro`),
  CONSTRAINT `libro_libroAutor_id_foreign` FOREIGN KEY (`id_libro`) REFERENCES `Libro` (`id_libro`)
  );
  
CREATE TABLE Prestamo(
`id_lector` int unsigned NOT NULL,
  `id_libro` int unsigned NOT NULL,
  `fecha_prestamo` timestamp NOT NULL,
  `fecha_devolucion` timestamp NOT NULL,
  `devuelto` bool NOT NULL,
   KEY `lector_prestamo_id_foreign` (`id_lector`),
  CONSTRAINT `lector_prestamo_id_foreign` FOREIGN KEY (`id_lector`) REFERENCES `Estudiante` (`id_lector`),
    KEY `libro_prestamo_id_foreign` (`id_libro`),
  CONSTRAINT `libro_prestamo_id_foreign` FOREIGN KEY (`id_libro`) REFERENCES `Libro` (`id_libro`)
);
  
  
      INSERT INTO Autor (nombre, nacionalidad) VALUES 
    ('Gabriel Garcia Marquez', 'Colombiana'),
     ('Miguel de Cervantes', 'Española'),
      ('William Shakespeare', 'Britanica'),
       ('Oliver Berry', 'Italiana'),
       ('Mark A. Garlick', 'Francesa');
       
      
      INSERT INTO Estudiante (nombre, apellido, direccion, carrera, edad) VALUES 
    ('Gabriela', 'Mejia', 'Cra 11 # 148', 'Ing sistemas', 22),
     ('Guillermo', 'Marcano', 'Calle 85', 'Ing sistemas', 25),
      ('Nicolás', 'Mejia', 'Calle 125', 'Admin empresas', 18);
      
      INSERT INTO Libro(titulo, editorial, area) VALUES
      ('100 años de soledad', 'Planeta', 'Novela'),
       ('El amor en los tiempos del colera', 'Planeta', 'Novela'),
       ('El quijote de la mancha', 'Huellas', 'Novela'),
       ('Hamlet', 'Salamandra', 'Novela'),
       ('Prgramación web', 'Salamandra', 'Internet'),
       ('El Universo: Guía de viaje', 'Planeta', 'Internet');
       
       INSERT INTO LibroAutor VALUES
       (1, 1),
       (1,2),
       (2,3),
       (3,4),
       (4,5),
       (5,6);
       
       INSERT INTO Prestamo VALUES
       (1, 1, '2022-08-20','2022-08-26', true ),
       (2, 2, '2022-08-19','2022-08-22', false ),
       (3, 4, '2022-08-15','2022-08-25', true );
       
       
       
       -- CONSULTAS --
       
       -- Listar los datos de los autores.
       SELECT * FROM Autor;
       
       -- Listar nombre y edad de los estudiantes
       SELECT nombre, edad FROM Estudiante;
      
      -- ¿Qué estudiantes pertenecen a la carrera informática?
      SELECT nombre from Estudiante WHERE carrera = 'Ing sistemas';
      
      -- ¿Qué libros no son del área de internet?
      SELECT titulo FROM Libro WHERE area = 'Internet';
      
      -- Listar los libros de la editorial Salamandra.
      SELECT titulo FROM Libro WHERE editorial = 'Salamandra';
      
      -- Listar los datos de los estudiantes cuya edad es mayor al promedio.
      SELECT * FROM Estudiante WHERE edad > (SELECT AVG(edad) FROM Estudiante);
      
      -- Listar los nombres de los estudiantes cuyo nombre comience con la letra G.alte
      SELECT nombre FROM Estudiante WHERE nombre LIKE 'G%';
      
      -- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
      SELECT a.nombre FROM Autor as a 
      INNER JOIN LibroAutor as la ON la.id_autor = a.id_autor
      INNER JOIN Libro as l ON l.id_libro = la.id_libro
      WHERE titulo = 'El Universo: Guía de viaje';
      
      -- ¿Qué libros se prestaron al lector “Gabriela Mejia”?
      SELECT l.titulo FROM Libro as l
      INNER JOIN Prestamo as p ON p.id_libro = l.id_libro
      INNER JOIN Estudiante as e ON e.id_lector = p.id_lector
      WHERE e.nombre = 'Gabriela' AND e.apellido = 'Mejia';
      
      -- Listar el nombre del estudiante de menor edad.
      SELECT nombre FROM Estudiante WHERE edad = (SELECT MIN(edad) FROM Estudiante);
      
      
