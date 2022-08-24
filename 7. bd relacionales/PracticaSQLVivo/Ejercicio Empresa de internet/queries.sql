CREATE TABLE internet_service (
	plan_id INT PRIMARY KEY,
    offered_megabytes FLOAT,
    price FLOAT,
    discount FLOAT
);

CREATE TABLE customer (
	dni INT PRIMARY KEY,
    plan_id INT,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    birthdate DATE,
    city VARCHAR(50),
    state VARCHAR(50),
    FOREIGN KEY (plan_id) REFERENCES internet_service(plan_id)
);

INSERT INTO internet_service VALUES
(1, 5, 1500, 0),
(2, 25, 1700, 0),
(3, 50, 2000, 0),
(4, 100, 2300, 10),
(5, 300, 2500, 5);

INSERT INTO customer VALUES
(4124123, 1, 'Nicolas', 'De Maio', '1999-12-07', 'Quilmes', 'Buenos Aires'),
(313123, 2, 'Pepe', 'De Maio', '1970-12-07', 'Quilmes', 'Buenos Aires'),
(4123441, 3, 'Juan', 'De Maio', '1981-12-07', 'Quilmes', 'Buenos Aires'),
(55123, 5, 'Cruz', 'De Maio', '2000-12-07', 'Quilmes', 'Buenos Aires'),
(145123, 5, 'Diego', 'De Maio', '1988-12-07', 'Quilmes', 'Buenos Aires'),
(512333, 4, 'Rodri', 'De Maio', '1993-12-07', 'Quilmes', 'Buenos Aires'),
(123312, 1, 'Guada', 'De Maio', '1991-12-07', 'Quilmes', 'Buenos Aires'),
(34551, 2, 'Ezequiel', 'De Maio', '1990-12-07', 'Quilmes', 'Buenos Aires'),
(21334123, 2, 'Silvia', 'De Maio', '1989-12-07', 'Quilmes', 'Buenos Aires'),
(555123, 3, 'Carlos', 'De Maio', '2001-12-07', 'Quilmes', 'Buenos Aires');

# Queries
# Traer los nombres completos de todos los clientes
SELECT name, surname FROM customer;
# Mostrar los precios de los distintos planes
SELECT price FROM internet_service;
# Mostrar los clientes que tengan contratado el plan numero 3
SELECT * FROM customer WHERE plan_id = 3;
# Traer los clientes que tengan DNI que empiece en 5
SELECT name, surname, dni FROM customer WHERE dni lIKE '5%';
# Traer los clientes que hayan nacido antes del 1990
SELECT name, surname, birthdate FROM customer WHERE birthdate < '1990-01-01';
# Mostrar sumatoria del total de los precios de los planes
SELECT SUM(price) FROM internet_service;
# Mostrar los planes que tengan descuento
SELECT * FROM internet_service WHERE discount > 0;
# Mostrar cual es el plan mas contratado
SELECT plan.plan_id, COUNT(cust.dni) as customers
FROM customer AS cust
INNER JOIN internet_service AS plan
ON plan.plan_id = cust.plan_id
GROUP BY plan.plan_id
ORDER BY customers DESC
LIMIT 1;
# Mostrar el id de plan y los megas que ofrece
SELECT plan_id, offered_megabytes FROM internet_service;
# Mostrar el nombre completo del cliente y el id de plan con los megas que tiene contratado
SELECT name, surname, Cust.plan_id, offered_megabytes FROM customer AS Cust
INNER JOIN internet_service ON Cust.plan_id = internet_service.plan_id;