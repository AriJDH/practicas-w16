-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select nombre, puesto, D.localidad FROM Empleado e
inner join Departamento D on D.depto_nro = e.depto_nro;

-- 2. Visualizar los departamentos con más de 2.
select nombre_depto departamento, count(nombre_depto) total_empleados from Departamento d
inner join Empleado e on e.depto_nro = d.depto_nro
group by nombre_depto having total_empleados > 2;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select nombre, apellido, salario, nombre_depto from Empleado e
inner join Departamento d on d.depto_nro = e.depto_nro
where puesto = (select puesto from empleado where nombre = 'Mito' and apellido='Barchuk');

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select nombre, apellido, puesto, d.nombre_depto from Empleado e
inner join Departamento d on d.depto_nro = e.depto_nro
where d.nombre_depto = 'Contabilidad'
order by nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre from empleado
order by salario
limit 1;

-- 6. xMostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

select nombre, salario from empleado e
inner join Departamento d on d.depto_nro = e.depto_nro
where d.nombre_depto = 'Ventas'
order by salario desc
limit 1;