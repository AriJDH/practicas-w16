
create table departamento(

depto_nro varchar(10),
nombre_dpto varchar(50),
localidad varchar(50),
primary key(depto_nro)
);


create table empleado(

cod_emp varchar(10),
nombre varchar(50),
apellido varchar(50),
puesto varchar(50),
fecha_alta date,
salario int,
comision int,
depto_nro varchar(10),
primary key(cod_emp),
foreign key(depto_nro) references departamento(depto_nro)

);

insert into departamento (depto_nro, nombre_dpto, localidad) values (1, 'Legal', 'Tambakbaya');
insert into departamento (depto_nro, nombre_dpto, localidad) values (2, 'Accounting', 'Rájec-Jestřebí');
insert into departamento (depto_nro, nombre_dpto, localidad) values (3, 'Support', 'Soroti');
insert into departamento (depto_nro, nombre_dpto, localidad) values (4, 'Product Management', 'København');
insert into departamento (depto_nro, nombre_dpto, localidad) values (5, 'Services', 'Liangzeng');
insert into departamento (depto_nro, nombre_dpto, localidad) values (6, 'Training', 'Shiziqiao');
insert into departamento (depto_nro, nombre_dpto, localidad) values (7, 'Product Management', 'Hermoso Campo');
insert into departamento (depto_nro, nombre_dpto, localidad) values (8, 'Engineering', 'Eckerö');
insert into departamento (depto_nro, nombre_dpto, localidad) values (9, 'Services', 'Piraí');
insert into departamento (depto_nro, nombre_dpto, localidad) values (10, 'Training', 'Hachiōji');



insert into empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) values (1, 'Dill', 'Moriarty', 'Database Administrator II', '2022-02-05', 6990, 18, 1);
insert into empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) values (2, 'Richmond', 'Lassen', 'Software Test Engineer III', '2022-07-29', 5892, 14, 2);
insert into empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) values (3, 'Shelley', 'Blencowe', 'Database Administrator III', '2022-06-23', 5491, 35, 3);
insert into empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) values (4, 'Walliw', 'Arangy', 'Dental Hygienist', '2021-11-24', 3115, 29, 4);
insert into empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) values (5, 'Bonni', 'Bruntje', 'Quality Engineer', '2022-08-19', 7553, 26, 5);
insert into empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) values (6, 'Temp', 'Epton', 'VP Marketing', '2021-10-07', 3827, 32, 6);
insert into empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) values (7, 'Tiffani', 'Hurton', 'Civil Engineer', '2021-12-25', 1602, 39, 7);
insert into empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) values (8, 'Tillie', 'Minchella', 'Account Representative III', '2021-10-15', 1909, 19, 8);
insert into empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) values (9, 'Crichton', 'Pitford', 'Senior Quality Engineer', '2021-10-21', 4763, 13, 9);
insert into empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) values (10, 'Ximenez', 'O''Brollachain', 'Information Systems Manager', '2022-07-06', 7745, 46, 10);
insert into empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) values (11, 'Jose', 'Lassen', 'Software Test Engineer III', '2022-07-29', 5892, 14, 2);
insert into empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) values (12, 'Alex', 'Lassen', 'Software Test Engineer III', '2022-07-29', 5892, 14, 2);


select nombre, puesto, localidad from empleado inner join  departamento on empleado.depto_nro=departamento.depto_nro where puesto="Software Test Engineer III";

select departamento.depto_nro,nombre_dpto,localidad, count(*) as cantidad_de_empleados 
from departamento inner join empleado on departamento.depto_nro=empleado.depto_nro 
group by departamento.depto_nro, nombre_dpto having cantidad_de_empleados>=3;

select nombre, salario, nombre_dpto from empleado 
inner join departamento on empleado.depto_nro=departamento.depto_nro 
where empleado.puesto= (select puesto from empleado  where(nombre="Alex" and apellido="Lassen" ) );

select * from empleado inner join
 departamento on empleado.depto_nro=departamento.depto_nro 
 where departamento.nombre_dpto="Accounting" order by empleado.nombre;
 
select * from empleado order by salario limit 1;


select * from empleado inner join 
departamento dpto on empleado.depto_nro=dpto.depto_nro 
 where dpto.nombre_dpto="Accounting" and   
 salario=(select max(salario) from empleado where dpto.depto_nro=empleado.depto_nro );
 















