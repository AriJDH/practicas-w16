DROP DATABASE IF EXISTS empresa_db;
CREATE DATABASE empresa_db;
USE empresa_db;

CREATE TABLE `departamentos` (
  `depto_nro` varchar(50) NOT NULL,
  `nombre_depto` varchar(50) NOT NULL,
  `localidad` varchar(50) NOT NULL,
  PRIMARY KEY (`depto_nro`)
);

CREATE TABLE `empleados` (
  `cod_empleado` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `puesto` varchar(50) NOT NULL,
  `fecha_alta` timestamp  NOT NULL,
  `salario` decimal(8,2)  NOT NULL,
  `comision` decimal(8,2) NOT NULL,
  `depto_nro` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_empleado`),
  KEY `empleados_departamentos_id` (`depto_nro`),
  CONSTRAINT `empleados_departamentos_id` FOREIGN KEY (`depto_nro`) REFERENCES `departamentos` (`depto_nro`)
);
INSERT INTO departamentos VALUES 
('D-000-1','Software','Los Tigres'),
('D-000-2', 'Sistemas','Guadalupe'),
('D-000-3','Contabilidad' , 'La Roca'),
('D-000-4', 'Ventas','Plata');

INSERT INTO empleados VALUES
('E-0001','César','Piñero','Vendedor','2018-05-12',80000,15000,'D-000-4'),
('E-0002','Yosep','Kowaleski','Analista','2015-07-14',140000,0,'D-000-2'),
('E-0003','Mariela','Barrios','Director','2014-06-05',185000,0,'D-000-3'),
('E-0004','Jonathan','Aguilera','Vendedor','2015-06-03',85000,10000,'D-000-4'),
('E-0005','Daniel','Brezezicki','Vendedor','2018-03-03',83000,10000,'D-000-4'),
('E-0006','Mito','Barchuk','Presidente','2014-06-05',190000,0, 'D-000-3'),
('E-0007','Emilio','Galarza','Desarrollador','2014-08-02',60000, 0, 'D-000-1'),
('E-0008','Daniel','Guzman','Vendedor','2018-03-03',83000,10000,'D-000-4'),
('E-0009','Daniela','Lopez','Vendedor','2018-03-03',83000,10000,'D-000-4'),
('E-0010','German','Martitgui','Vendedor','2018-03-03',83000,10000,'D-000-4');

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad FROM empleados e
inner join departamentos d on d.depto_nro  = e.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT count(e.depto_nro) as cantidad_empleados, nombre_depto from departamentos d
inner join empleados e on e.depto_nro  = d.depto_nro 
group by nombre_depto
HAVING count(e.depto_nro) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto FROM empleados e
inner join departamentos d on d.depto_nro  = e.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleados where nombre='Mito' and apellido='Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * FROM empleados e 
where e.depto_nro = 'D-000-3'
order by e.nombre asc;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre FROM empleados e 
where e.salario = (SELECT min(salario) FROM empleados);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.nombre FROM empleados e 
where e.salario = (SELECT max(salario) FROM empleados WHERE depto_nro='D-000-4')
and e.depto_nro='D-000-4';