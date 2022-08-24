/*1 - Mostrar todos los clientes*/
SELECT * FROM cliente;
/*2 - Mostrar todos los planes*/
SELECT * FROM plan;
/*3 - Mostrar que cliente es el mayor*/
SELECT * FROM cliente ORDER BY fecha_nacimiento LIMIT 1;
/*4 - Mostrar la cantidad de planes que tiene un cliente*/
SELECT COUNT(*) FROM plan GROUP BY cliente_id;
/*5 - Mostrar los cliente organizados por nombre*/
SELECT * FROM cliente ORDER BY nombre;
/*6 - Mostrar los planes con mas de 100 megas y con un precio menor a 100000*/
SELECT * FROM plan WHERE velocidad_megas > 100 AND precio < 100000;
/*7 - Mostrar los clientes mayores a 30 años*/
SELECT * FROM cliente WHERE (now() - fecha_nacimiento) > 300000000000;
/*8 - Mostrar planes sin descuento*/
SELECT * FROM plan WHERE descuento = 0;
/*9 - Mostrar la fecha de nacieminto año, mes,dia*/
SELECT  dni, nombre, apellido, Date_format(fecha_nacimiento,'%Y/%m/%d') AS fecha_nacimiento, provincia, ciudad FROM cliente;
/*10 - Mostrar dni de los clientes*/
SELECT dni FROM cliente;