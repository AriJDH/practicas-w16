-- Mostrar todos los registros de la tabla de Cliente.
SELECT * FROM Cliente;

-- Mostrar nombre y apellido y provincia de todos los clientes.
SELECT nombre, apellido, provincia FROM Cliente;

-- Mostrar todos los registros de la tabla de Plan.
SELECT * FROM Plan;

-- Mostrar el plan de internet para el cliente con id 5;
SELECT velocidad, precio, descuento FROM Plan WHERE id = 5;

-- Mostrar el id del cliente, velodicidad, descuento del plan de internet con el descuento ordenado ascendentemente.
SELECT cliente_id, velocidad, descuento FROM Plan ORDER BY descuento;

-- Mostrar todos los clientes cuya provincia es Cordoba
SELECT nombre, apellido, provincia FROM Cliente WHERE provincia = 'Cordoba';

-- Mostrar los nombres de los clientes ordenados descendentemente
SELECT nombre, apellido FROM CLiente ORDER BY nombre DESC;

-- Mostrar la velocidad, el precio y el descuento de los planes con una velocidad mayor o igual a 100 Megas ordenados ascendentemente.
SELECT velocidad, precio, descuento FROM Plan WHERE velocidad >=100 ORDER BY velocidad ASC; 

-- Mostrar los 3 clientes mas jovenes
SELECT nombre, apellido, fecha_nacimiento FROM Cliente ORDER BY fecha_nacimiento DESC LIMIT 3;

-- Mostrar los clientes nacido entre 1990 y 1995
SELECT nombre, apellido, fecha_nacimiento FROM Cliente WHERE year(fecha_nacimiento) BETWEEN 1990 AND 1995;
