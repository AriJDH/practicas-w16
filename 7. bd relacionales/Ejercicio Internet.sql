DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;



CREATE TABLE plan(
id_plan INT NOT NULL PRIMARY KEY auto_increment,
nombre_plan VARCHAR(30) NOT NULL,
velocidad_megas VARCHAR(30) NOT NULL,
precio DECIMAL(10,2) NOT NULL
);

CREATE table cliente (
dni INT NOT NULL PRIMARY KEY,
nombre VARCHAR(30) NOT NULL,
apellido VARCHAR(30) NOT NULL,
email VARCHAR(40),
genero VARCHAR(30),
fecha_nacimiento DATETIME NOT NULL,
pais VARCHAR(30),
ciudad VARCHAR(30) NOT NULL,
esta_activo BIT
);

CREATE TABLE contrato(
id_contrato INT NOT NULL primary KEY auto_increment,
inicio_contrato DATETIME NOT NULL,
final_contrato DATETIME,
total_neto DOUBLE,
iva FLOAT,
descuento float,
esta_activo BIT,
id_plan INT NOT NULL,
dni INT NOT NULL,
FOREIGN KEY (id_plan) REFERENCES plan(id_plan),
FOREIGN KEY (dni) REFERENCES cliente(dni) 
); 

INSERT INTO plan VALUES(1, 'COMBO POBRE', 			'30mb/s',  	800.50);
INSERT INTO plan VALUES(2, 'MEDIO COMBO', 			'40mb/s',  	1250.99);
INSERT INTO plan VALUES(3, 'ALTO COMBO', 			'50mb/s',  	1600.99);
INSERT INTO plan VALUES(4, 'COMBO MEDIOMEDIO', 		'60mb/s',  	1800.99);
INSERT INTO plan VALUES(5, 'MEGA COMBO', 			'100mb/s', 	2200.85);
INSERT INTO plan VALUES(5, 'COMBO MILLONARIO', 		'180mb/s', 	10000.85);


INSERT INTO cliente VALUES(111, 'WALDO', 	'BELTRAN', 	27,	'1999-08-30', 	'2021-03-12',	'MONTEVIDEO', 		'MONTEVIDEO', 		5);
INSERT INTO cliente VALUES(222, 'VELIA', 	'ZAMORA', 	34,	'1965-10-09', 	'2020-05-22',	'CÓRDOBA', 			'CÓRDOBA', 			4);
INSERT INTO cliente VALUES(333, 'RENATA',	'LOVATO', 	12,	'1915-12-07', 	'2018-12-21',	'BUENOS AIRES', 	'MAR DEL PLATA',	5);
INSERT INTO cliente VALUES(444, 'FRANCO', 	'GUAJARDO', 45,	'1959-05-24', 	'2021-08-01',	'TUCUMÁN', 			'SAN MIGUEL', 		2);
INSERT INTO cliente VALUES(555, 'JORGE', 	'PEREZ', 	64,	'1915-12-07', 	'2019-05-05',	'SANTA FE', 		'SANTA FE', 		3);
INSERT INTO cliente VALUES(666, 'LUIS', 	'OSORIO', 	75,	'1937-05-08', 	'2019-03-06',	'BUENOS AIRES', 	'BAHÍA BLANCA', 	4);
INSERT INTO cliente VALUES(777, 'MARTIN', 	'PEREZ', 	34,	'1936-05-17', 	'2019-08-15',	'CHACO', 			'RESISTENCIA', 		1);
INSERT INTO cliente VALUES(888, 'MATIAS', 	'RODRIGUEZ',24, '1917-09-14', 	'2021-03-22',	'JUJUY', 			'SAN SALVADOR', 	6);
INSERT INTO cliente VALUES(999, 'FACUNDO', 	'DÍAZ', 	45,	'1964-01-14', 	'2020-08-26',	'MENDOZA', 			'GUAYMALLÉN', 		3);
INSERT INTO cliente VALUES(911, 'RODRIGO', 	'MUNUA', 	87,	'1943-11-16', 	'2019-09-13',	'ENTRE RÍOS', 		'PARANÁ', 			2);