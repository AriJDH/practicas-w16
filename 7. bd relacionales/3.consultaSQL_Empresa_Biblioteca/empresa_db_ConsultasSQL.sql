use empresa_db;
select * from empleado;
select * from departamento;

INSERT INTO departamento(depto_nro, nombre_depto, localidad)
VALUES("D-000-1", "Software", "Los Tigres");

INSERT INTO departamento(depto_nro, nombre_depto, localidad)
VALUES("D-000-2", "Sistemas", "Guadalupe");

INSERT INTO departamento(depto_nro, nombre_depto, localidad)
VALUES("D-000-3", "Contabilidad", "La Roca");

INSERT INTO departamento(depto_nro, nombre_depto, localidad)
VALUES("D-000-4", "Ventas", "Plata");

INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES("E-0001", "César", "Piñero", "Vendedor", "2018-05-12", "80000", "15000", "D-000-4");

INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES("E-0002", "Yosep", "Kowaleski", "Analista", "2015-07-14", "140000", "0", "D-000-2");

INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES("E-0003", "Mariela", "Barrios", "Director", "2014-06-05", "185000", "0", "D-000-3");

INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES("E-0004", "Jonathan", "Aguilera", "Vendedor", "2015-06-03", "85000", "10000", "D-000-4");

INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES("E-0005", "Daniel", "Brezezicki", "Vendedor", "2018-03-03", "83000", "10000", "D-000-4");

INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES("E-0006", "Mito", "Barchuk", "Presidente", "2014-06-05", "190000", "0", "D-000-3");

INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES("E-0007", "Emilio", "Galarza", "Desarrollador", "2014-08-02", "60000", "0", "D-000-1");


-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad 
FROM empleado e 
INNER JOIN departamento d ON d.depto_nro = e.depto_nro;

-- 2. Visualizar los departamentos con más de cinco empleados.
select d.nombre_depto, count(e.nombre) 
from departamento d
inner join empleado e on d.depto_nro = e.depto_nro
group by d.nombre_depto
having count(e.nombre) > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select * from empleado;
select e.nombre, e.salario, d.nombre_depto 
from empleado e
inner join departamento d on e.depto_nro = d.depto_nro
where e.puesto in (select e.puesto
					from empleado e
					where e.cod_emp = "E-0006");

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select * 
from empleado e
inner join departamento d on e.depto_nro = d.depto_nro
where d.nombre_depto = "contabilidad"
order by e.nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre
from empleado
order by salario asc
limit 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de 'Ventas'.
select e.cod_emp, e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, e.depto_nro
from empleado e
inner join departamento d on e.depto_nro = d.depto_nro
where d.nombre_depto = "Ventas"
order by e.salario desc
limit 1;
