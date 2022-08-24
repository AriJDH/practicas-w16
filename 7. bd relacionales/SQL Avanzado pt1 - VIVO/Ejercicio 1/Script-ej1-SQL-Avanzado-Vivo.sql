DROP DATABASE IF EXISTS empresa_db;
CREATE DATABASE empresa_db;
USE empresa_db;

    CREATE TABLE departamento  (
  `depto_nro` varchar(50)  NOT NULL ,
 `nombre_depto` varchar(50) NOT NULL,
  `localidad` varchar(50) NOT NULL,
  PRIMARY KEY (`depto_nro`)
  );
  
CREATE TABLE empleado  (
  `cod_emp` varchar(50)  NOT NULL ,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `puesto` varchar(50) NOT NULL,
  `fecha_alta` timestamp NOT NULL,
    `salario` decimal(10,2) NOT NULL,
    `comision` decimal(10,2) NOT NULL,
  `depto_nro` varchar(50)  NOT NULL ,
  PRIMARY KEY (`cod_emp`),
  KEY `empleado_depto_id_foreign` (`depto_nro`),
  CONSTRAINT `empleado_depto_id_foreign` FOREIGN KEY (`depto_nro`) REFERENCES `departamento` (`depto_nro`)
  );
  
    INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES 
    ('D-000-1', 'Software', 'Los Tigres'),
    ('D-000-2', 'Sistemas', 'Guadalupe'),
    ('D-000-3', 'Contabilidad', 'La roca'),
    ('D-000-4', 'Ventas', 'Plata');
    
    INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES 
    ('E-0001', 'Cesar', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
    ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
    ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
    ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
    ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
    ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
    ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');
  
  
  -- Consultas --
  
  -- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
  SELECT e.nombre, e.puesto, d.localidad 
  FROM empleado as e
  INNER JOIN departamento as d ON e.depto_nro = d.depto_nro;
  
  -- 2. Visualizar los departamentos con más de cinco empleados.
  SELECT d.nombre_depto, COUNT(e.cod_emp) as cant_empleados 
  FROM departamento as d
  INNER JOIN empleado as e ON e.depto_nro = d.depto_nro
  GROUP BY d.nombre_depto
  HAVING cant_empleados > 2;
  
  -- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
  SELECT e.nombre, e.salario, d.nombre_depto
  FROM empleado as e
  INNER JOIN departamento as d ON e.depto_nro = d.depto_nro
  WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre = 'Cesar' AND apellido = 'Piñero');
  
  -- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
  SELECT * FROM empleado as e
  INNER JOIN departamento as d ON e.depto_nro = d.depto_nro
  WHERE d.nombre_depto = 'Contabilidad'
  ORDER BY e.nombre ASC;
  
  -- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
  SELECT nombre FROM empleado ORDER BY salario ASC LIMIT 1;
  
  -- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
  SELECT * FROM empleado as e
  INNER JOIN departamento as d ON e.depto_nro = d.depto_nro
  WHERE d.nombre_depto = 'Ventas'
  ORDER BY e.salario DESC
  LIMIT 1;
  
