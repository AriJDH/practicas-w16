DROP DATABASE IF EXISTS empresa_internet_db;
CREATE DATABASE empresa_internet_db;
USE empresa_internet_db;

-- Creación tabla cliente
CREATE TABLE cliente  (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `dni` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fecha_nacimiento` timestamp NOT NULL,
   `provincia` varchar(50) NOT NULL,
   `ciudad` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
  );
  
  -- Creación tabla plan
  CREATE TABLE plan  (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cliente_id` int unsigned NOT NULL,
  `velocidad` int NOT NULL,
  `precio` decimal(5,2) NOT NULL,
  `descuento` decimal(3,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_plan_id_foreign` (`cliente_id`),
  CONSTRAINT `cliente_plan_id_foreign` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
  );
  
  
  -- Inserción de datos de clientes
  INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES ('1234', 'Gabriela', 'Mejia', '1999-12-09', 'Cundinamarca', 'Bogota');

    INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES 
    ('3456', 'Gianni', 'Tiezzi', '1996-09-29', 'Cordoba', 'Corral de bustos'),
    ('7347', 'Daniel', 'Condori', '1990-12-11', 'Cordoba', 'Cordoba'),
    ('4343', 'Gonzalo', 'Di Pierro', '1993-06-19', 'Buenos Aires', 'Caseros'),
    ('3443', 'Tannia', 'Hernandez', '2000-09-20', 'Huila', 'Neiva'),
    ('9583', 'Juliana', 'Ortega', '1995-07-19', 'Norte de Santander', 'Cucuta');
    
    -- Inserción de datos de planes 
    INSERT INTO plan (cliente_id, velocidad, precio, descuento) VALUES
    (1, 200, 100, 0.2),
    (2, 150, 70, 0.15),
    (3, 150, 70, 0.15),
    (2, 250, 150, 0.25),
    (4, 200, 100, 0.10);
  
  -- 10 Consultas --
  
  -- Consultar el nombre y apellido del cliente organizado de manera descendente por la fecha de cumpleaños
  SELECT nombre, apellido FROM cliente ORDER BY fecha_nacimiento DESC;
  
  -- Consultar los 3 primeros registros de la fecha de nacimiento y el dni del cliente organizado de manera ascendente por el dni
  SELECT fecha_nacimiento, dni FROM cliente ORDER BY dni LIMIT 3;
  
  -- Consultar el id, precio y descuento de los planes que tengan el precio menor e igual a 80.000 y la velocidad menor que 200
  SELECT id, precio, descuento FROM plan WHERE precio <= 80 AND velocidad < 200;
  
  -- Consultar el nombre y apellido del cliente que tenga la letra C en la provincia
  SELECT nombre, apellido FROM cliente WHERE provincia LIKE '%C%';
  
  -- Consultar la cantidad de planes que tiene el cliente con id igual a 2
  SELECT COUNT(cliente_id) FROM plan WHERE cliente_id = 2;
  
  -- Consultar el menor descuento de todos los planes
  SELECT MIN(descuento) FROM plan;
  
  -- Consultar la suma de todos los descuentos de los planes que cuesten menor o igual a 100
  SELECT SUM(descuento) FROM plan WHERE precio <= 100;
  
  -- Consultar el nombre y la provincia del cliente donde el nombre de la ciudad empiece por C y termine en a
  SELECT nombre, provincia FROM cliente WHERE ciudad LIKE 'C%' AND ciudad LIKE '%a';
  
  -- Consultar el promedio de los precios que tienen los planes
  SELECT AVG(precio) FROM plan;
  
  -- Consultar el nombre, apellido y ciudad de los clientes que tengan el número 34 dentro del dni
  SELECT nombre, apellido, ciudad FROM cliente WHERE dni LIKE '%34%';
  


