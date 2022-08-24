create database EjercicioBiblioteca ;


CREATE TABLE `EjercicioBiblioteca`.`LIBRO` (
  `idLibro` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(45) NULL,
  `Editorial` VARCHAR(45) NULL,
  `Area` VARCHAR(45) NULL,
  PRIMARY KEY (`idLibro`));


CREATE TABLE `EjercicioBiblioteca`.`Autor` (
  `idAutor` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `Nacionalidad` VARCHAR(45) NULL,
  PRIMARY KEY (`idAutor`));

CREATE TABLE `EjercicioBiblioteca`.`Estudiante` (
  `IdLector` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `Apellido` VARCHAR(45) NULL,
  `Direccion` VARCHAR(45) NULL,
  `Carrera` VARCHAR(45) NULL,
  `Edad` INT NULL,
  PRIMARY KEY (`IdLector`));


CREATE TABLE `EjercicioBiblioteca`.`PRESTAMO` (
  `idPrestamo` INT NOT NULL,
  `idLector` INT NULL,
  `idLibro` INT NULL,
  `FechaPrestamo` DATE NULL,
  `FechaDevolucion` DATE NULL,
  `Devuelto` TINYINT NULL,
  PRIMARY KEY (`idPrestamo`),
  FOREIGN KEY (idLector) REFERENCES Estudiante(idLector),
  FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
  );
  
  CREATE TABLE `EjercicioBiblioteca`.`LIBROAUTOR` (
  `idAutor` INT NOT NULL,
  `idLibro` INT NOT NULL,
  PRIMARY KEY (`idAutor`, `IdLibro`),
  FOREIGN KEY (idAutor) REFERENCES Autor(idAutor),
  FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
  );
  
  
