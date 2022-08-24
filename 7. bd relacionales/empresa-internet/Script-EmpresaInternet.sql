DROP DATABASE IF EXISTS empresa_internet_db;

CREATE DATABASE empresa_internet_db;

USE empresa_internet_db;

-- Creación tabla cliente
CREATE TABLE cliente (
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
CREATE TABLE plan (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cliente_id` int unsigned NOT NULL,
  `velocidad` int NOT NULL,
  `precio` decimal(5, 2) NOT NULL,
  `descuento` decimal(3, 2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_plan_id_foreign` (`cliente_id`),
  CONSTRAINT `cliente_plan_id_foreign` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
);

-- Inserción de datos de clientes
INSERT INTO
  cliente (
    dni,
    nombre,
    apellido,
    fecha_nacimiento,
    provincia,
    ciudad
  )
VALUES
  (
    '1234',
    'Gabriela',
    'Mejia',
    '1999-12-09',
    'Cundinamarca',
    'Bogota'
  );

INSERT INTO
  cliente (
    dni,
    nombre,
    apellido,
    fecha_nacimiento,
    provincia,
    ciudad
  )
VALUES
  (
    '3456',
    'Gianni',
    'Tiezzi',
    '1996-09-29',
    'Cordoba',
    'Corral de bustos'
  ),
  (
    '7347',
    'Daniel',
    'Condori',
    '1990-12-11',
    'Cordoba',
    'Cordoba'
  ),
  (
    '4343',
    'Gonzalo',
    'Di Pierro',
    '1993-06-19',
    'Buenos Aires',
    'Caseros'
  ),
  (
    '3443',
    'Tannia',
    'Hernandez',
    '2000-09-20',
    'Huila',
    'Neiva'
  ),
  (
    '9583',
    'Juliana',
    'Ortega',
    '1995-07-19',
    'Norte de Santander',
    'Cucuta'
  );

-- Inserción de datos de planes 
INSERT INTO
  plan (cliente_id, velocidad, precio, descuento)
VALUES
  (1, 200, 100, 0.2),
  (2, 150, 70, 0.15),
  (3, 150, 70, 0.15),
  (2, 250, 150, 0.25),
  (4, 200, 100, 0.10);

-- Consultas
-- Todos los clientes
SELECT
  nombre,
  apellido
FROM
  cliente;

-- Edad de los clientes
SELECT
  nombre,
  apellido,
  FLOOR(
    DATEDIFF(CURRENT_TIMESTAMP(), fecha_nacimiento) / 365.25
  ) as "edad"
from
  cliente;

-- Todos los clientes de Cordoba
SELECT
  nombre,
  apellido
FROM
  cliente
WHERE
  provincia = 'Cordoba';

-- Cantidad de clientes por ciudad
SELECT
  ciudad,
  provincia,
  COUNT(id) AS "cantidad_por_ciudad"
FROM
  cliente
GROUP by
  1,
  2
ORDER BY
  3 DESC;

-- Cantidad de clientes por provincia
SELECT
  provincia,
  COUNT(id) AS "cantidad_por_provincia"
FROM
  cliente
GROUP by
  1
ORDER BY
  2 DESC;

-- Todos los planes con sus clientes
SELECT
  p.velocidad,
  p.precio,
  c.nombre,
  c.apellido
FROM
  plan p
  LEFT JOIN cliente c on (c.id = p.cliente_id);

-- Plan más caro
SELECT
  id,
  velocidad,
  precio
FROM
  plan
ORDER BY
  precio DESC
LIMIT
  1;

-- Plan con más velocidad
SELECT
  id,
  velocidad,
  precio
FROM
  plan
ORDER BY
  velocidad DESC
LIMIT
  1;

-- Cliente con cantidad de planes ordenados de mayor a menor
SELECT
  c.nombre,
  c.apellido,
  COUNT(p.id) as "cantidad_planes"
FROM
  cliente c
  left join plan p on (p.cliente_id = c.id)
GROUP BY
  1,
  2
ORDER BY
  3 DESC;

-- Cliente con mas de un plan planes ordenados de mayor a menor
SELECT
  c.nombre,
  c.apellido,
  COUNT(p.id) as "cantidad_planes"
FROM
  cliente c
  left join plan p on (p.cliente_id = c.id)
GROUP BY
  1,
  2
HAVING
  COUNT(p.id) > 1
ORDER BY
  3 DESC;

-- Factura mensual (?
SELECT
  c.nombre,
  c.apellido,
  c.dni,
  IFNULL(SUM(p.precio * (1 - p.descuento)), 0) as "total"
FROM
  cliente c
  left join plan p on (p.cliente_id = c.id)
GROUP BY
  1,
  2,
  3
ORDER BY
  4 DESC;