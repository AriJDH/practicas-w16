/*Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/
SELECT e.nombre, e.puesto, d.localidad FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro;
/*Visualizar los departamentos con más de cinco empleados.*/
SELECT d.*, COUNT(d.depto_nro) AS total FROM departamento d
INNER JOIN empleado e ON e.depto_nro = d.depto_nro
GROUP BY d.depto_nro
HAVING total > 5;
/*Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.*/
SELECT e.nombre, e.apellido, e.salario, d.nombre_depto FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.depto_nro IN (SELECT depto_nro FROM empleado WHERE nombre LIKE 'Mito%' AND apellido LIKE '%Barchuk');
/*Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.*/
SELECT e.* FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto LIKE 'Contabilidad'
ORDER BY e.nombre;
/*Mostrar el nombre del empleado que tiene el salario más bajo.*/
SELECT nombre, apellido, salario FROM empleado
WHERE salario IN (SELECT MIN(salario) FROM empleado);
/*Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.*/
SELECT nombre, apellido, salario FROM empleado
WHERE salario IN (SELECT MAX(salario) FROM empleado e INNER JOIN departamento d ON e.depto_nro = d.depto_nro WHERE d.nombre_depto LIKE 'Ventas');