DROP DATABASE IF EXISTS empresa_sql_avanzado;
CREATE DATABASE empresa_sql_avanzado;
USE empresa_sql_avanzado;

CREATE TABLE departamento(
depto_nro VARCHAR(7) NOT NULL PRIMARY KEY,
nombre_depto VARCHAR(20) NOT NULL,
localidad VARCHAR(20) NOT NULL
);

CREATE TABLE empleado(
cod_emp VARCHAR(6) NOT NULL PRIMARY KEY,
nombre VARCHAR(20) NOT NULL,
apellido VARCHAR(20) NOT NULL,
puesto VARCHAR(20) NOT NULL,
fecha_alta DATETIME NOT NULL,
salario INT NOT NULL,
comision INT NOT NULL,
depto_nro VARCHAR(7) NOT NULL,
FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
);

INSERT INTO departamento VALUES('D-000-1', 'Software', 		'Los Tigres');
INSERT INTO departamento VALUES('D-000-2', 'Sistemas', 		'Guadalupe');
INSERT INTO departamento VALUES('D-000-3', 'Contabilidad', 	'La Roca');
INSERT INTO departamento VALUES('D-000-4', 'Ventas', 		'Plata');

INSERT INTO empleado VALUES ('E-0001', 'César', 	'Piñero', 		'Vendedor', 		'2018-05-12', '80000', 	'15000',	'D-000-4');
INSERT INTO empleado VALUES ('E-0002', 'Yosep', 	'Kowaleski', 	'Analista', 		'2015-07-14', '140000', '0', 		'D-000-2');
INSERT INTO empleado VALUES ('E-0003', 'Mariela', 	'Barrios', 		'Director', 		'2014-06-05', '185000', '0', 		'D-000-3');
INSERT INTO empleado VALUES ('E-0004', 'Jonathan', 	'Aguilera', 	'Vendedor', 		'2015-06-03', '85000', 	'10000',	'D-000-4');
INSERT INTO empleado VALUES ('E-0005', 'Daniel', 	'Brezezicki', 	'Vendedor', 		'2018-03-03', '83000', 	'10000', 	'D-000-4');
INSERT INTO empleado VALUES ('E-0006', 'Mito', 		'Barchuk', 		'Presidente', 		'2014-06-05', '190000', '0', 		'D-000-3');
INSERT INTO empleado VALUES ('E-0007', 'Emilio', 	'Galarza', 		'Desarrollador', 	'2014-08-02', '60000', 	'0', 		'D-000-1');


# 1
SELECT e.nombre, e.apellido, e.puesto, d.localidad
FROM empleado e
INNER JOIN departamento d on e.depto_nro = d.depto_nro;

#2
SELECT COUNT(*) as cant_emp, d.*
FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
GROUP BY e.depto_nro
HAVING cant_emp > 2;

#3
SELECT e.nombre, e.apellido, e.salario, d.nombre_depto
FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto IN (SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');

#4
SELECT e.*
FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre DESC;

#5
SELECT e.nombre, e.apellido
FROM empleado e
ORDER BY e.salario ASC
LIMIT 1;

#6
SELECT e.*
FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
LIMIT 1;
