


-- ejercicio 2
-- primera key de cliente es el dni, ya que es un dni unico para cada cliente y no hay necesidad de crear un identificador aparte
-- la primary key de planes de internet es un id autoincremental creado para identificar un Id a un plan
-- existe una relacion de 1 n entre plan y cliente ya que un plan puede estar asociado a muchos clientes y un cliente tiene un solo plan de internet, la foreign key debe estar  en la tabla cliente por formas normales y esta anterior debe hacer alusion al id del plan

-- ejercicio 3

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
-- Table `internet`.`internet_plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`internet_plan` (
  `idplan` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `velocidad` INT NOT NULL,
  `precio` DECIMAL(10) NOT NULL,
  `descuento` DECIMAL(10) NOT NULL,
  PRIMARY KEY (`idplan`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`cliente` (
  `dni` VARCHAR(15) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATETIME NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `internet_plan_idplan` INT NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE,
  INDEX `fk_cliente_internet_plan_idx` (`internet_plan_idplan` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_internet_plan`
    FOREIGN KEY (`internet_plan_idplan`)
    REFERENCES `empresa_internet`.`internet_plan` (`idplan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- inserts

Insert into `empresa_internet`.`internet_plan` values (0,'plan mega super rapido',5000,23654,231);
Insert into `empresa_internet`.`internet_plan` values (0,'plan mega super lento',10,2654,231);
Insert into `empresa_internet`.`internet_plan` values (0,'plan medio',2500,12054,0);
Insert into `empresa_internet`.`internet_plan` values (0,'plan medio rapido',3500,18654,0);
Insert into `empresa_internet`.`internet_plan` values (0,'plan medio lento',1000,8654,231);

select * from `internet_plan`;


select * from  `empresa_internet`.`cliente`;
Insert into `empresa_internet`.`cliente` values('19.090.005-3','Rodrigo','Cifuentes','1995-08-08','bio-bio','concepcion',1);
Insert into `empresa_internet`.`cliente` values('19.090.999-3','Alberto','Vasquez','1996-08-08','nuble','chillan',1);
Insert into `empresa_internet`.`cliente` values('19.090.111-3','Enrique','Herrera','1978-08-08','nuble','chillan viejo',2);
Insert into `empresa_internet`.`cliente` values('19.090.568-3','Carolina','Martinez','1975-08-08','nuble','pinto',2);
Insert into `empresa_internet`.`cliente` values('19.090.345-3','Isidora','Herrera','1990-08-08','bio-bio','concepcion',3);
Insert into `empresa_internet`.`cliente` values('19.094.999-3','Marcelo','Herrera','1921-08-08','nuble','pinto',1);
Insert into `empresa_internet`.`cliente` values('23.546.005-3','Pablo','Ampuero','1968-08-08','nuble','chillan',4);
Insert into `empresa_internet`.`cliente` values('65.325.005-3','Patricia','Vidal','1543-08-08','nuble','chillan',4);
Insert into `empresa_internet`.`cliente` values('99.112.215-9','Maria','Contreras','1546-08-08','Metropolitana','Santiago',5);
Insert into `empresa_internet`.`cliente` values('15.112.215-9','Gilberto','Cifuentes','1999-08-08','nuble','chillan',4);

-- ejercicio 4

-- seleccionar nombre y apellido de los clientes nacidos despues del anio 1993
select `nombre`,`apellido` from `cliente` where year(`cliente`.`fecha_nacimiento`) >1993;
-- seleccionar el dni de los clientes de la provincia de nuble
select `dni` from `cliente` where `provincia` = 'nuble';
-- seleccionar todos los datos de los clientes con el plan 2
select `dni`,`nombre`,`apellido` from `cliente` where `internet_plan_idplan` = 2;
-- seleccionar a todos los clientes de apellido Herrera
select `dni`,`nombre`,`apellido` from `cliente` where `apellido` = 'Herrera';
-- seleccionar el plan con id 2
select `nombre` from `internet_plan` where `idplan`=2;
-- seleccionar los planes donde su velocidad sea mas de 1450 megas
select `nombre` from `internet_plan` where `velocidad`>1450;
-- seleccionar nombre y velocidad del plan donde su precio sea mas de 10000
select `nombre`,`velocidad` from `internet_plan` where `precio`>10000;
-- selececcionar nombre del plan cullo descuento sea de 0
select `nombre`,`velocidad` from `internet_plan` where `descuento`=0;
-- seleccionar nombre del cliente cullo plan sea plan medio
select c.`nombre` from `cliente`as c left join `internet_plan` as i on c.`internet_plan_idplan` = i.`idplan` where i.`nombre`='plan medio';
-- seleccionar nombre del cliente cullo plan sea el plan plan mega super rapido y sea de nuble
select c.`nombre` from `cliente`as c left join `internet_plan` as i on c.`internet_plan_idplan` = i.`idplan` where i.`nombre`='plan mega super rapido' and c.`provincia` ='nuble';
-- seleccionar nombre y fecha de nacimiento, nombre del plan que tienen donde su plan sea plan mega super rapido
select c.`nombre`,c.`fecha_nacimiento`, i.`nombre` as `plan` from `cliente`as c left join `internet_plan` as i on c.`internet_plan_idplan` = i.`idplan` where i.`nombre`='plan mega super rapido';

