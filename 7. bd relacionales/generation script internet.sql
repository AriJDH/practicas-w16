-- MySQL Script generated by MySQL Workbench
-- Wed Aug 24 09:47:04 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema internet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema internet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa_internet` DEFAULT CHARACTER SET utf8 ;
USE `empresa_internet` ;

-- -----------------------------------------------------
-- Table `internet`.`plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`plan` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `velocidad` INT UNSIGNED NULL,
  `precio` DOUBLE UNSIGNED NULL,
  `descuento` DOUBLE UNSIGNED NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`cliente` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `fecha_nacimiento` DATE NULL,
  `provincia` VARCHAR(45) NULL,
  `ciudad` VARCHAR(45) NULL,
  `plan_id` INT UNSIGNED NOT NULL,
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  INDEX `fk_cliente_plan_idx` (`plan_id` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_plan`
    FOREIGN KEY (`plan_id`)
    REFERENCES `empresa_internet`.`plan` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
