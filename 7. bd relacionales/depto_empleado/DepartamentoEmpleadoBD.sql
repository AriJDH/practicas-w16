drop database if exists empresa_db;
create database empresa_db;
use empresa_db;


create table departamento(
depto_nro varchar(45) not null primary key,
nombre_depto varchar(45) not null,
localidad varchar(45) not null
);


create table empleado(
cod_emp varchar(45) primary key not null,
nombre varchar(45) not null,
apellido varchar(45) not null,
puesto varchar(45) not null,
fecha_alta datetime,
salario double(10,2) not null,
comision double,
dept_nro varchar(45),
foreign key(dept_nro) references departamento(depto_nro)
);

insert into departamento values ('D-000-1', 'Software', 'Los Tigres');
insert into departamento values ('D-000-2', 'Sistemas', 'Guadalupe');
insert into departamento values ('D-000-3', 'contabilidad', 'La Roca');
insert into departamento values ('D-000-4', 'ventas', 'Planta');

insert into empleado values ('E-0001', 'Cesar', 'Piñero', 'Vendedor', '2018-05-12', 8000.0, 15000.0, 'D-000-4');
insert into empleado values ('E-0002', 'Yosep', 'Kowaieski', 'Analista', '2015-07-14', 14000.0, 0.0, 'D-000-2');
insert into empleado values ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000.0, 0.0, 'D-000-3');
insert into empleado values ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000.0, 10000.0, 'D-000-4');
insert into empleado values ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000.0, 10000.0, 'D-000-4');
insert into empleado values ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2018-06-05', 19000.0, 0.0, 'D-000-3');
insert into empleado values ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-02-08', 6000.0, 0.0, 'D-000-1');


