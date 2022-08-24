-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa_internet` DEFAULT CHARACTER SET utf8 ;
USE `empresa_internet` ;

-- -----------------------------------------------------
-- Table `empresa_internet`.`Pack`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Pack` (
  `idPack` INT NOT NULL AUTO_INCREMENT,
  `VELOCIDAD` VARCHAR(45) NOT NULL,
  `PRECIO` DOUBLE NOT NULL,
  `DESCUENTO` DOUBLE NOT NULL,
  PRIMARY KEY (`idPack`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `DNI` VARCHAR(45) NOT NULL,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `APELLIDO` VARCHAR(45) NOT NULL,
  `FECHA_NACIMIENTO` DATETIME NOT NULL,
  `PROVINCIA` VARCHAR(45) NOT NULL,
  `CIUDAD` VARCHAR(45) NOT NULL,
  `idPack` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `idPack_idx` (`idPack` ASC) VISIBLE,
  CONSTRAINT `idPack`
    FOREIGN KEY (`idPack`)
    REFERENCES `empresa_internet`.`Pack` (`idPack`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- ----------- -- --------
-- PREGUNTAS EJERCICIO 2
-- ----------- -----------

-- a. ¿Cuál es la primary key para la tabla de clientes?

-- Generamos un ID unico para la tabla Cliente "idCliente" que es autoincrementable

-- b. ¿Cuál es la primary key para la tabla de planes de internet?

-- Generamos un ID unico para la tabla Pack "idPack" que es autoincrementable

-- c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key?
-- ¿A qué campo de qué tabla hace referencia dicha foreign key?

-- Tenemos que la relacion entre las tablas es de que muchos Clientes pueden tener un mismo Pack -> n:1.
-- Por cada registro en la tabla Cliente existe una foreign key "idPack" de la tabla Pack.

-- ----------- -- --------
-- PREGUNTAS EJERCICIO 3
-- ----------- -----------

/* CREATE SCHEMA IF NOT EXISTS `empresa_internet` DEFAULT CHARACTER SET utf8 ;
 USE `empresa_internet` ; */

-- Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.

-- TABLA PACK
INSERT INTO `empresa_internet`.`Pack`
(`VELOCIDAD`,`PRECIO`,`DESCUENTO`)
VALUES
("50",1000.0,0.10);

INSERT INTO `empresa_internet`.`Pack`
(`VELOCIDAD`,`PRECIO`,`DESCUENTO`)
VALUES
("80",2000.0,0.15);

INSERT INTO `empresa_internet`.`Pack`
(`VELOCIDAD`,`PRECIO`,`DESCUENTO`)
VALUES
("100",3000.0,0.15);

INSERT INTO `empresa_internet`.`Pack`
(`VELOCIDAD`,`PRECIO`,`DESCUENTO`)
VALUES
("120",4000,0.20);

INSERT INTO `empresa_internet`.`Pack`
(`VELOCIDAD`,`PRECIO`,`DESCUENTO`)
VALUES
("150",5200.0,0.25);

SELECT * FROM Pack;


-- TABLA CLIENTE
INSERT INTO `empresa_internet`.`Cliente`
(`DNI`,`NOMBRE`,`APELLIDO`,`FECHA_NACIMIENTO`,`PROVINCIA`,`CIUDAD`,`idPack`)
VALUES
("1","nombre1","apellido1","1998-01-01","provincia1","ciudad1",1);

INSERT INTO `empresa_internet`.`Cliente`
(`DNI`,`NOMBRE`,`APELLIDO`,`FECHA_NACIMIENTO`,`PROVINCIA`,`CIUDAD`,`idPack`)
VALUES
("2","nombre2","apellido2","1999-04-05","provincia2","ciudad2",1);

INSERT INTO `empresa_internet`.`Cliente`
(`DNI`,`NOMBRE`,`APELLIDO`,`FECHA_NACIMIENTO`,`PROVINCIA`,`CIUDAD`,`idPack`)
VALUES
("3","nombre3","apellido3","1995-03-04","provincia3","ciudad3",2);

INSERT INTO `empresa_internet`.`Cliente`
(`DNI`,`NOMBRE`,`APELLIDO`,`FECHA_NACIMIENTO`,`PROVINCIA`,`CIUDAD`,`idPack`)
VALUES
("4","nombre3","apellido3","1996-04-02","provincia4","ciudad4",2);

INSERT INTO `empresa_internet`.`Cliente`
(`DNI`,`NOMBRE`,`APELLIDO`,`FECHA_NACIMIENTO`,`PROVINCIA`,`CIUDAD`,`idPack`)
VALUES
("5","nombre4","apellido4","1993-06-02","provincia4","ciudad4",3);

INSERT INTO `empresa_internet`.`Cliente`
(`DNI`,`NOMBRE`,`APELLIDO`,`FECHA_NACIMIENTO`,`PROVINCIA`,`CIUDAD`,`idPack`)
VALUES
("6","nombre5","apellido5","1996-04-02","provincia4","ciudad4",3);

INSERT INTO `empresa_internet`.`Cliente`
(`DNI`,`NOMBRE`,`APELLIDO`,`FECHA_NACIMIENTO`,`PROVINCIA`,`CIUDAD`,`idPack`)
VALUES
("7","nombre5","apellido5","1992-04-02","provincia3","ciudad3",4);

INSERT INTO `empresa_internet`.`Cliente`
(`DNI`,`NOMBRE`,`APELLIDO`,`FECHA_NACIMIENTO`,`PROVINCIA`,`CIUDAD`,`idPack`)
VALUES
("8","nombre6","apellido6","1997-06-02","provincia6","ciudad6",4);

INSERT INTO `empresa_internet`.`Cliente`
(`DNI`,`NOMBRE`,`APELLIDO`,`FECHA_NACIMIENTO`,`PROVINCIA`,`CIUDAD`,`idPack`)
VALUES
("9","nombre6","apellido6","1993-04-22","provincia4","ciudad4",5);

INSERT INTO `empresa_internet`.`Cliente`
(`DNI`,`NOMBRE`,`APELLIDO`,`FECHA_NACIMIENTO`,`PROVINCIA`,`CIUDAD`,`idPack`)
VALUES
("10","nombre7","apellido7","1999-08-21","provincia4","ciudad4",5);

SELECT * FROM Cliente;

-- ----------- -- --------
-- PREGUNTAS EJERCICIO 4
-- ----------- -----------

-- Consultas

SELECT NOMBRE, APELLIDO, DNI FROM Cliente;

SELECT VELOCIDAD, PRECIO FROM Pack;

SELECT NOMBRE, APELLIDO, DNI FROM Cliente WHERE NOMBRE LIKE "%nombre5%";

SELECT NOMBRE, APELLIDO, DNI FROM Cliente WHERE APELLIDO LIKE "%apellido6%";

SELECT NOMBRE, APELLIDO, DNI, FECHA_NACIMIENTO FROM Cliente WHERE FECHA_NACIMIENTO BETWEEN "1997-01-01" AND "2000-01-01";

SELECT NOMBRE, APELLIDO, DNI, idPack FROM Cliente WHERE idPack = 3;

SELECT VELOCIDAD, PRECIO, DESCUENTO FROM Pack ORDER BY PRECIO DESC;

SELECT VELOCIDAD, PRECIO, DESCUENTO FROM Pack ORDER BY VELOCIDAD DESC;

SELECT VELOCIDAD, PRECIO, DESCUENTO FROM Pack WHERE DESCUENTO > 0.15;

SELECT MAX(PRECIO) PRECIO FROM Pack;
