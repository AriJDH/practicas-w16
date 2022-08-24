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
    
    -- Consultas --
    
    -- 1. Traer todos los clientes de provincia Cordoba
    SELECT * FROM cliente WHERE provincia = 'Cordoba';
    
    -- 2. Traer los primeros dos clientes con mayor precio de plan
    SELECT c.nombre, p.precio FROM cliente as c LEFT JOIN plan as p ON c.id = p.cliente_id WHERE p.precio >= 100;
    
    -- 3. Traer los clientes nacidos antes de 1995
    SELECT nombre, apellido, fecha_nacimiento FROM cliente WHERE year(fecha_nacimiento) < 1995;
    
    -- 4. Traer los 2 planes con mayores megas de velocidad
    SELECT cliente_id, velocidad FROM plan ORDER BY velocidad DESC LIMIT 2;
    
    -- 5. Traer el promedio de precios de todos los planes
    SELECT AVG(precio) as promedio_precio FROM plan;
    
    -- 6. Traer clientes con descuentos mayores a 15%
    SELECT c.nombre, p.descuento FROM cliente as c LEFT JOIN plan as p ON c.id = p.cliente_id WHERE p.descuento >0.15;
    
    -- 7. Contar todos los clientes que su nombre empieza por la letra G
    SELECT COUNT(nombre) as cantidad_clientes_empiza_G FROM cliente WHERE nombre LIKE 'G%';
    
    -- 8. Contar todos los clientes que tienen plan con velidad de 200 megas
    SELECT COUNT(velocidad) as cantidad_clientes_velocidad_200_megas FROM plan WHERE velocidad = 200;
    
    -- 9. Sumar el valor de todas las ventas de planes
    SELECT SUM(precio) as valor_total_ventas FROM plan;
    
    -- 10. Devolver el menor precio de los planes
    SELECT MIN(precio) as menor_precio FROM plan;
    
    
  
  
  


