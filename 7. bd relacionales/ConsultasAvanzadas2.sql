DROP DATABASE IF EXISTS empresa_db;
CREATE DATABASE empresa_db;
USE empresa_db;

CREATE TABLE `departamentos` (
                                 `depto_nro` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
                                 `nombre_depto` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
                                 `localidad` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
                                 PRIMARY KEY (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

CREATE TABLE `empleados` (
                             `cod_emp` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
                             `nombre` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
                             `apellido` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
                             `puesto` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
                             `fecha_alta` timestamp NULL DEFAULT NULL,
                             `salario` int unsigned NOT NULL,
                             `comision` int unsigned NOT NULL,
                             `depto_nro` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
                             PRIMARY KEY (`cod_emp`),
                             KEY `empleado_depto_nro_foreign` (`depto_nro`),
                             CONSTRAINT `empleado_depto_nro_foreign` FOREIGN KEY (`depto_nro`) REFERENCES `departamentos` (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

LOCK TABLES `departamentos` WRITE;
INSERT INTO `departamentos` VALUES ('D-000-1', 'Software','Los tigres'),
                                   ('D-000-2','Sistemas','Guadalupe'),
                                   ('D-000-3', 'Contabilidad','La Roca'),
                                   ('D-000-4', 'Ventas', 'Plata');
UNLOCK TABLES;

LOCK TABLES `empleados` WRITE;
INSERT INTO `empleados` VALUES ('E-0001', 'Cesar','Pinero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
                               ('E-0002', 'Yosep','Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
                               ('E-0003', 'Mariela','Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
                               ('E-0004', 'Jonathan','Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
                               ('E-0005', 'Daniel','Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
                               ('E-0006', 'Mito','Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
                               ('E-0007', 'Emilio','Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');
UNLOCK TABLES;

/*Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/
SELECT emp.nombre, emp.puesto, dep.localidad
FROM empleados emp
         INNER JOIN departamentos dep ON emp.depto_nro = dep.depto_nro
WHERE emp.puesto LIKE '%Vendedor%';

/*Visualizar los departamentos con más de tres empleados.*/
SELECT dep.nombre_depto, COUNT(*) numero_empleados
FROM departamentos dep
         INNER JOIN empleados emp ON emp.depto_nro = dep.depto_nro
GROUP BY dep.depto_nro
HAVING COUNT(*) >=3;

/*Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.*/
SELECT emp.nombre, emp.salario, dep.nombre_depto
FROM empleados emp
         INNER JOIN departamentos dep ON dep.depto_nro = emp.depto_nro
WHERE emp.puesto LIKE '%Presidente%';

/*Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.*/
SELECT *
FROM empleados emp
WHERE emp.depto_nro LIKE '%D-000-3%'
ORDER BY emp.nombre ASC;

/*Mostrar el nombre del empleado que tiene el salario más bajo.*/
SELECT emp.nombre
FROM empleados emp
ORDER BY emp.salario ASC
    LIMIT 1;

/*Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.*/
SELECT *
FROM empleados emp
WHERE emp.depto_nro LIKE '%D-000-4%'
ORDER BY emp.salario DESC
    LIMIT 1;