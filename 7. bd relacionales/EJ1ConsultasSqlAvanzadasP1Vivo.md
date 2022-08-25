- CONSULTAS 

Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
1. select empleado.nombre, empleado.puesto, departamento.localidad 
    from empleado 
    inner join departamento 
    on empleado.depto_nro=departamento.depto_nro;

Visualizar los departamentos con más de cinco empleados.
2. SELECT count(e.depto_nro) as cantidad_empleados, nombre_depto from departamento d
    inner join empleado e on e.depto_nro  = d.depto_nro 
    group by nombre_depto
    HAVING count(e.depto_nro) > 5;

Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
3. SELECT e.nombre, e.salario, d.nombre_depto FROM empleados e
    inner join departamentos d on d.depto_nro  = e.depto_nro
    WHERE e.puesto = (SELECT puesto FROM empleados where nombre='Mito' and apellido='Barchuk');

Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
4. SELECT * FROM empleados e 
    where e.depto_nro = 'D-000-3'
    order by e.nombre asc;

Mostrar el nombre del empleado que tiene el salario más bajo.
5. SELECT e.nombre FROM empleados e 
    where e.salario = (SELECT min(salario) FROM empleados);

Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
6. SELECT e.nombre FROM empleados e 
    where e.salario = (SELECT max(salario) FROM empleados WHERE depto_nro='D-000-4')
    and e.depto_nro='D-000-4';




