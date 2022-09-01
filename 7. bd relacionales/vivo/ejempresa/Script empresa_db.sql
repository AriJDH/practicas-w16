DROP SCHEMA IF EXISTS `empresa_db`;
CREATE SCHEMA `empresa_db` ;

CREATE TABLE `empresa_db`.`empleado` (
  `cod_emp` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `puesto` VARCHAR(45) NULL,
  `fecha_alta` DATE NULL,
  `salario` FLOAT NULL,
  `comision` FLOAT NULL,
  `depto_nro` VARCHAR(45) NULL,
  PRIMARY KEY (`cod_emp`));

CREATE TABLE `empresa_db`.`departamento` (
  `depto_nro` VARCHAR(45) NOT NULL,
  `nombre_depto` VARCHAR(45) NULL,
  `localidad` VARCHAR(45) NULL,
  PRIMARY KEY (`depto_nro`));

ALTER TABLE `empresa_db`.`empleado` 
ADD INDEX `depto_nro_idx` (`depto_nro` ASC) VISIBLE;
;
ALTER TABLE `empresa_db`.`empleado` 
ADD CONSTRAINT `depto_nro`
  FOREIGN KEY (`depto_nro`)
  REFERENCES `empresa_db`.`departamento` (`depto_nro`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
  
INSERT INTO `empresa_db`.`departamento` (`depto_nro`, `nombre_depto`, `localidad`) VALUES ('D-000-1', 'Software', 'Los Tigres');
INSERT INTO `empresa_db`.`departamento` (`depto_nro`, `nombre_depto`, `localidad`) VALUES ('D-000-2', 'Sistemas', 'Guadalupe');
INSERT INTO `empresa_db`.`departamento` (`depto_nro`, `nombre_depto`, `localidad`) VALUES ('D-000-3', 'Contabilidad', 'La Roca');
INSERT INTO `empresa_db`.`departamento` (`depto_nro`, `nombre_depto`, `localidad`) VALUES ('D-000-4', 'Ventas', 'Plata');


INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0001', 'Cesar', 'Piñero', 'vendedor', '2018-05-12', '80000', '15000', 'D-000-4');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0002', 'Yosep', 'Kowaleski', 'analista', '2015-07-14', '140000', '0', 'D-000-2');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0003', 'Mariela', 'Barrios', 'director', '2014-06-05', '185000', '0', 'D-000-3');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0004', 'Jonathan', 'Aguilera', 'vendedor', '2015-06-03', '85000', '10000', 'D-000-4');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0005', 'Daniel', 'Brezezicki', 'vendedor', '2018-03-03', '83000', '10000', 'D-000-4');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0006', 'Mito', 'Barchuk', 'presidente', '2014-06-05', '190000', '0', 'D-000-3');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0007', 'Emilio', 'Galarza', 'desarrollador', '2014-08-02', '60000', '0', 'D-000-1');
