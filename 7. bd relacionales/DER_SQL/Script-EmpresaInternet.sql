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
    
    
  
  
  


