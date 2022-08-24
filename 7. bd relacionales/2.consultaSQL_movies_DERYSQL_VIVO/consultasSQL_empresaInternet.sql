-- a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
-- id_cliente, es la clave de la tabla el cual no se repite y es un identificador unico de cada cliente.
-- b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.
-- idplan_internet, es la clave de la tabla el cual no se repite y es un identificador unico de cada plan de internet.
-- c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.
-- Un cliente puede tener muchos plan y un plan corresponde solo a un cliente. En la tabla de plan_internet. Al id_cliente ya que hace la relacion entre cliente y plan de internet. 

INSERT INTO empresa_internet.cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad) VALUES ('000001','JUAN','PEREZ','2000-01-01','MONTEVIDEO', 'MONTEVIDEO');
INSERT INTO empresa_internet.cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad) VALUES ('000002','JUANA','RODRIGUEZ','2005-05-30','MONTEVIDEO', 'MONTEVIDEO');
INSERT INTO empresa_internet.cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad) VALUES ('000003','MARTIN','GOMEZ','1999-02-01','MONTEVIDEO', 'MONTEVIDEO');
INSERT INTO empresa_internet.cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad) VALUES ('000004','PEPE','GONZALEZ','2001-03-07','MONTEVIDEO', 'MONTEVIDEO');
INSERT INTO empresa_internet.cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad) VALUES ('000005','MARIA','RAMIREZ','2003-10-20','MONTEVIDEO', 'MONTEVIDEO');
INSERT INTO empresa_internet.cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad) VALUES ('000006','JUANI','PEREZ','1998-01-01','MONTEVIDEO', 'MONTEVIDEO');
INSERT INTO empresa_internet.cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad) VALUES ('000007','JUANO','RODRIGUEZ','2005-06-30','MONTEVIDEO', 'MONTEVIDEO');
INSERT INTO empresa_internet.cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad) VALUES ('000008','MARTINA','GOMEZ','1999-09-01','MONTEVIDEO', 'MONTEVIDEO');
INSERT INTO empresa_internet.cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad) VALUES ('000009','SANDRA','GONZALEZ','2001-12-07','MONTEVIDEO', 'MONTEVIDEO');
INSERT INTO empresa_internet.cliente(dni,nombre,apellido,fecha_nacimiento,provincia,ciudad) VALUES ('000010','MARIANA','RAMIREZ','2002-10-20','MONTEVIDEO', 'MONTEVIDEO');

INSERT INTO empresa_internet.plan_internet(velocidad, precio, descuento, cliente_idcliente) VALUES (200,200,10,1);
INSERT INTO empresa_internet.plan_internet(velocidad,precio,descuento,cliente_idcliente) VALUES (600,1700,0,2);
INSERT INTO empresa_internet.plan_internet(velocidad,precio,descuento,cliente_idcliente) VALUES (100,1000,15,3);
INSERT INTO empresa_internet.plan_internet(velocidad,precio,descuento,cliente_idcliente) VALUES (800,2000,5,4);
INSERT INTO empresa_internet.plan_internet(velocidad,precio,descuento,cliente_idcliente) VALUES (1000,2100,20,5);

select * from empresa_internet.cliente; 
select * from empresa_internet.plan_internet; 

select nombre, apellido, fecha_nacimiento FROM empresa_internet.cliente;

select provincia FROM empresa_internet.cliente group by provincia;

select ciudad FROM empresa_internet.cliente group by ciudad;

select nombre, apellido, fecha_nacimiento FROM empresa_internet.cliente where provincia like '%VIDE%';
--
select c.nombre, c.apellido, pi.precio FROM empresa_internet.cliente c 
inner join empresa_internet.plan_internet pi on pi.cliente_idcliente = c.idcliente;    

select c.nombre, c.apellido, pi.precio, descuento FROM empresa_internet.cliente c 
inner join empresa_internet.plan_internet pi on pi.cliente_idcliente = c.idcliente
where pi.descuento >= 10;

select max(precio) from empresa_internet.plan_internet;

select avg(descuento) from empresa_internet.plan_internet;

select count(*) from empresa_internet.plan_internet where descuento >=10;

select c.nombre, c.apellido, pi.precio, descuento FROM empresa_internet.cliente c 
inner join empresa_internet.plan_internet pi on pi.cliente_idcliente = c.idcliente
where pi.velocidad between 600 and 800 order by pi.velocidad desc, pi.precio asc;
