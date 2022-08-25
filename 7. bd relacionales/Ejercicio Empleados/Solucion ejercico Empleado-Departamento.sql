use empleados;
-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores. 
select e.nombre, e.puesto, d.localidad from Empleado e 
	inner join Departamento d 
	on e.dpto_nro = d.dpto_nro;

-- Visualizar los departamentos con más de cinco empleados.
select d.* from Departamento d 
	inner join Empleado e 
	on d.dpto_nro = e.dpto_nro 
group by dpto_nro having count(*) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’. 
select e.nombre, e.salario, d.nombre_dpto from Departamento d 
	inner join Empleado e 
	on e.dpto_nro = d.dpto_nro 
where e.puesto in (
	select puesto from Empleado 
    where nombre= "Mito" and apellido="Barchuk"
);

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

select e.* from Empleado e 
	inner join Departamento d 
	on e.dpto_nro = d.dpto_nro 
where d.nombre_dpto="Contabilidad" 
order by e.nombre;


-- Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre from empleado 
where salario = (select min(salario) from empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
with temp as 
	(select e.*
    from empleado e 
		inner join departamento d 
		on e.dpto_nro = d.dpto_nro 
    where d.nombre_dpto="Ventas")
select *
from temp
where salario = 
	(select max(salario) from temp);

