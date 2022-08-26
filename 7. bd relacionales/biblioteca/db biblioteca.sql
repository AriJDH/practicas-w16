-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `biblioteca` ;

-- -----------------------------------------------------
-- Table `biblioteca`.`Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`Autor` (
  `idAutor` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Nacionalidad` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idAutor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `biblioteca`.`Estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`Estudiante` (
  `idLector` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Apellido` VARCHAR(45) NULL DEFAULT NULL,
  `Direccion` VARCHAR(45) NULL DEFAULT NULL,
  `Carrera` VARCHAR(45) NULL DEFAULT NULL,
  `Edad` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idLector`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `biblioteca`.`Libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`Libro` (
  `idLibro` INT NOT NULL,
  `Titulo` VARCHAR(45) NULL DEFAULT NULL,
  `Editorial` VARCHAR(45) NULL DEFAULT NULL,
  `Area` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idLibro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `biblioteca`.`LibroAutor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`LibroAutor` (
  `idAutor` INT NOT NULL,
  `idLibro` INT NOT NULL,
  PRIMARY KEY (`idLibro`, `idAutor`),
  INDEX `fk libro_idx` (`idLibro` ASC) VISIBLE,
  INDEX `fk autor_idx` (`idAutor` ASC) VISIBLE,
  CONSTRAINT `LibroAutor_FK_id_Autor`
    FOREIGN KEY (`idAutor`)
    REFERENCES `biblioteca`.`Autor` (`idAutor`),
  CONSTRAINT `LibroAutor_FK_id_Libro`
    FOREIGN KEY (`idLibro`)
    REFERENCES `biblioteca`.`Libro` (`idLibro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `biblioteca`.`Prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`Prestamo` (
  `idLector` INT NOT NULL,
  `idLibro` INT NOT NULL,
  `FechaPrestamo` DATETIME NULL DEFAULT NULL,
  `FechaDevolucion` DATETIME NULL DEFAULT NULL,
  `Devuelto` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`idLibro`, `idLector`),
  INDEX `w_idx` (`idLector` ASC) VISIBLE,
  CONSTRAINT `Prestamo_FK_id_Lector`
    FOREIGN KEY (`idLector`)
    REFERENCES `biblioteca`.`Estudiante` (`idLector`),
  CONSTRAINT `Prestamo_FK_id_Libro`
    FOREIGN KEY (`idLibro`)
    REFERENCES `biblioteca`.`Libro` (`idLibro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
