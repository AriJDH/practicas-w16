DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE plan(
identificacion_plan INT NOT NULL PRIMARY KEY,
velocidad_megas VARCHAR(30) NOT NULL,
precio DECIMAL(10,2) NOT NULL,
descuento INT NOT NULL
);

CREATE table cliente (
dni INT NOT NULL PRIMARY KEY,
nombre VARCHAR(30) NOT NULL,
apellido VARCHAR(30) NOT NULL,
fecha_nacimiento DATETIME NOT NULL,
provincia VARCHAR(30) NOT NULL,
ciudad VARCHAR(30) NOT NULL,
identificacion_plan_cliente INT NOT NULL,
FOREIGN KEY (identificacion_plan_cliente) REFERENCES plan(identificacion_plan) 
);

INSERT INTO plan VALUES(1, '30mb/s',  '1000.50', 0);
INSERT INTO plan VALUES(2, '40mb/s',  '1250', 	 0);
INSERT INTO plan VALUES(3, '50mb/s',  '1600', 	 5);
INSERT INTO plan VALUES(4, '60mb/s',  '1800', 	 10);
INSERT INTO plan VALUES(5, '100mb/s', '2200.85', 15);

INSERT INTO cliente VALUES(111, 'WALDO', 	'BELTRAN', 	'1999-08-03', 'MONTEVIDEO', 	'MONTEVIDEO', 5);
INSERT INTO cliente VALUES(222, 'VELIA', 	'ZAMORA', 	'1965-10-09', 'CÓRDOBA', 		'CÓRDOBA', 4);
INSERT INTO cliente VALUES(333, 'RENATA',	'LOVATO', 	'1915-12-07', 'BUENOS AIRES', 	'MAR DEL PLATA', 5);
INSERT INTO cliente VALUES(444, 'FRANCO', 	'GUAJARDO', '1959-05-24', 'TUCUMÁN', 		'SAN MIGUEL', 2);
INSERT INTO cliente VALUES(555, 'JORGE', 	'PEREZ', 	'1915-12-07', 'SANTA FE', 		'SANTA FE', 3);
INSERT INTO cliente VALUES(666, 'LUIS', 	'OSORIO', 	'1937-05-08', 'BUENOS AIRES', 	'BAHÍA BLANCA', 4);
INSERT INTO cliente VALUES(777, 'MARTIN', 	'PEREZ', 	'1936-05-17', 'CHACO', 			'RESISTENCIA', 1);
INSERT INTO cliente VALUES(888, 'MATIAS', 	'RODRIGUEZ','1917-09-14', 'JUJUY', 			'SAN SALVADOR', 1);
INSERT INTO cliente VALUES(999, 'FACUNDO', 	'DÍAZ', 	'1964-01-14', 'MENDOZA', 		'GUAYMALLÉN', 3);
INSERT INTO cliente VALUES(911, 'RODRIGO', 	'MUNUA', 	'1943-11-16', 'ENTRE RÍOS', 	'PARANÁ', 2);


SELECT c.dni, c.nombre, c.apellido
FROM cliente c
WHERE c.fecha_nacimiento BETWEEN '1950-01-01' AND '2020-12-31';

SELECT c.nombre, c.apellido
FROM cliente c
WHERE c.identificacion_plan_cliente > 3;

SELECT c.dni, c.nombre, c.apellido
FROM cliente c
WHERE c.provincia = 'BUENOS AIRES';

SELECT c.dni, c.nombre, c.apellido
FROM cliente c
WHERE c.identificacion_plan_cliente = 5 
AND c.nombre LIKE 'W%';
    
SELECT p.precio, p.velocidad_megas
FROM plan p
WHERE p.identificacion_plan > 3;

SELECT p.identificacion_plan, p.precio, p.velocidad_megas
FROM plan p
WHERE p.descuento >= 10;

SELECT COUNT(*)
FROM cliente
WHERE identificacion_plan_cliente = 1;

SELECT c.dni, c.nombre, c.apellido, p.identificacion_plan, p.velocidad_megas, p.precio
FROM cliente c
INNER JOIN plan p ON p.identificacion_plan = c.identificacion_plan_cliente
ORDER BY p.precio DESC
LIMIT 5;

SELECT c.dni, c.nombre, c.apellido, p.identificacion_plan, p.velocidad_megas, p.precio
FROM cliente c
INNER JOIN plan p ON p.identificacion_plan = c.identificacion_plan_cliente
ORDER BY c.dni ASC;