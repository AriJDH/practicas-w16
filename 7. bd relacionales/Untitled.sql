create table provincia (
 id_provincia int NOT NULL AUTO_INCREMENT,
 nombre_provincia varchar(100),
 primary key(id_provincia)

);

create table ciudad(
id_ciudad int NOT NULL AUTO_INCREMENT,
id_provincia int,
nombre_ciudad varchar(100),
primary key(id_ciudad),
foreign key(id_provincia) references provincia(id_provincia)

);


create table cliente(
id_cliente int NOT NULL AUTO_INCREMENT,
dni varchar(30),
id_ciudad int,
nombre varchar(50),
apellido varchar(50),
fecha_nacimiento date,
primary key(id_cliente,dni),
foreign key(id_ciudad) references ciudad(id_ciudad)
);


create table plan(
id_plan int NOT NULL AUTO_INCREMENT,
velocida int,
precio double,
descuento double,
primary key(id_plan)
);


create table contrato(
id_contrato int NOT NULL AUTO_INCREMENT,
id_plan int,
id_cliente int,
primary key(id_contrato),
foreign key(id_plan) references plan(id_plan),
foreign key(id_cliente) references cliente(id_cliente)

);




insert into provincia (nombre_provincia) values ('Ohio');
insert into provincia (nombre_provincia) values ('Alaska');
insert into provincia (nombre_provincia) values ('Florida');
insert into provincia (nombre_provincia) values ('Florida');
insert into provincia (nombre_provincia) values ('Georgia');
insert into provincia (nombre_provincia) values ('Minnesota');
insert into provincia (nombre_provincia) values ('California');
insert into provincia (nombre_provincia) values ('Kentucky');
insert into provincia (nombre_provincia) values ('Indiana');
insert into provincia (nombre_provincia) values ('California');


insert into ciudad (id_provincia, nombre_ciudad) values (1, 'Kilifi');
insert into ciudad (id_provincia, nombre_ciudad) values (2, 'Bongandanga');
insert into ciudad (id_provincia, nombre_ciudad) values (3, 'Katipunan');
insert into ciudad (id_provincia, nombre_ciudad) values (4, 'Roslavl’');
insert into ciudad (id_provincia, nombre_ciudad) values (5, 'Kalajoki');
insert into ciudad (id_provincia, nombre_ciudad) values (6, 'Ketawang');
insert into ciudad (id_provincia, nombre_ciudad) values (7, 'Västerås');
insert into ciudad (id_provincia, nombre_ciudad) values (8, 'Shicha');
insert into ciudad (id_provincia, nombre_ciudad) values (9, 'Samsan');
insert into ciudad (id_provincia, nombre_ciudad) values (10, 'Bjuv');

insert into cliente (dni, id_ciudad, nombre, apellido, fecha_nacimiento) values ('41-151-4548', 1, 'Guilbert', 'Hollow', '2013-06-08');
insert into cliente (dni, id_ciudad, nombre, apellido, fecha_nacimiento) values ('50-476-3825', 2, 'Hersh', 'Goodredge', '2020-11-23');
insert into cliente (dni, id_ciudad, nombre, apellido, fecha_nacimiento) values ('00-323-7387', 3, 'Shelby', 'Braksper', '2019-03-31');
insert into cliente (dni, id_ciudad, nombre, apellido, fecha_nacimiento) values ('78-166-1816', 4, 'Issiah', 'Truett', '2001-07-29');
insert into cliente (dni, id_ciudad, nombre, apellido, fecha_nacimiento) values ('31-284-6167', 5, 'Alyce', 'Calken', '2003-12-09');
insert into cliente (dni, id_ciudad, nombre, apellido, fecha_nacimiento) values ('28-660-6945', 6, 'Nicolette', 'Viant', '2020-11-03');
insert into cliente (dni, id_ciudad, nombre, apellido, fecha_nacimiento) values ('22-513-0398', 7, 'Leigha', 'Dawkes', '2008-02-01');
insert into cliente (dni, id_ciudad, nombre, apellido, fecha_nacimiento) values ('34-199-2273', 8, 'Darrick', 'Chatelet', '2014-05-12');
insert into cliente (dni, id_ciudad, nombre, apellido, fecha_nacimiento) values ('71-791-1290', 9, 'Carlyle', 'Harriday', '2008-12-09');
insert into cliente (dni, id_ciudad, nombre, apellido, fecha_nacimiento) values ('15-834-6162', 10, 'Rebekah', 'Hoffner', '2015-08-11');


insert into plan (velocida, precio, descuento) values (60.1, 57.4, 38.5);
insert into plan (velocida, precio, descuento) values (41.1, 44.6, 13.9);
insert into plan (velocida, precio, descuento) values (7.6, 79.4, 6.3);
insert into plan (velocida, precio, descuento) values (4.8, 31.3, 2.3);
insert into plan (velocida, precio, descuento) values (83.6, 40.8, 25.3);
insert into plan (velocida, precio, descuento) values (66.2, 74.6, 10.2);
insert into plan (velocida, precio, descuento) values (58.4, 18.0, 79.7);
insert into plan (velocida, precio, descuento) values (9.3, 82.9, 13.2);
insert into plan (velocida, precio, descuento) values (84.5, 9.0, 96.7);
insert into plan (velocida, precio, descuento) values (73.2, 59.9, 13.6);

insert into contrato (id_plan, id_cliente) values (1, 1);
insert into contrato (id_plan, id_cliente) values (2, 2);
insert into contrato (id_plan, id_cliente) values (3, 3);
insert into contrato (id_plan, id_cliente) values (4, 4);
insert into contrato (id_plan, id_cliente) values (5, 5);
insert into contrato (id_plan, id_cliente) values (6, 6);
insert into contrato (id_plan, id_cliente) values (7, 7);
insert into contrato (id_plan, id_cliente) values (8, 8);
insert into contrato (id_plan, id_cliente) values (9, 9);
insert into contrato (id_plan, id_cliente) values (10, 10);












