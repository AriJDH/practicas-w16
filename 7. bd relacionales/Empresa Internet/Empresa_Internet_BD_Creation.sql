-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa_internet` DEFAULT CHARACTER SET utf8 ;
USE `empresa_internet` ;

-- -----------------------------------------------------
-- Table `empresa_internet`.`Provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Provincia` (
  `idProvincia` INT NOT NULL AUTO_INCREMENT,
  `nombre_provincia` VARCHAR(45) NULL,
  PRIMARY KEY (`idProvincia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`Ciudad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Ciudad` (
  `idCiudad` INT NOT NULL AUTO_INCREMENT,
  `nombre_ciudad` VARCHAR(45) NULL,
  `Provincia_idProvincia` INT NOT NULL,
  PRIMARY KEY (`idCiudad`, `Provincia_idProvincia`),
  INDEX `fk_Ciudad_Provincia1_idx` (`Provincia_idProvincia` ASC) VISIBLE,
  CONSTRAINT `fk_Ciudad_Provincia1`
    FOREIGN KEY (`Provincia_idProvincia`)
    REFERENCES `empresa_internet`.`Provincia` (`idProvincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`Plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Plan` (
  `idPlan` INT NOT NULL AUTO_INCREMENT,
  `identificacion_plan` VARCHAR(45) NOT NULL,
  `velocidad` INT NOT NULL,
  `precio` INT NULL,
  `descuento` DECIMAL(4) NULL,
  PRIMARY KEY (`idPlan`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Cliente` (
  `dni` VARCHAR(30) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATETIME NOT NULL,
  `Ciudad_idCiudad` INT NOT NULL,
  `Plan_idPlan` INT NOT NULL,
  PRIMARY KEY (`Ciudad_idCiudad`, `dni`, `Plan_idPlan`),
  INDEX `fk_Cliente_Ciudad1_idx` (`Ciudad_idCiudad` ASC) VISIBLE,
  INDEX `fk_Cliente_Plan1_idx` (`Plan_idPlan` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_Ciudad1`
    FOREIGN KEY (`Ciudad_idCiudad`)
    REFERENCES `empresa_internet`.`Ciudad` (`idCiudad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cliente_Plan1`
    FOREIGN KEY (`Plan_idPlan`)
    REFERENCES `empresa_internet`.`Plan` (`idPlan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
