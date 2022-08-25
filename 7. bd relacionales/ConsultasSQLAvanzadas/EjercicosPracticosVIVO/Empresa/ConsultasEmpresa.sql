-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT empleado.nombre, empleado.puesto, depto.localidad FROM Empleado 
INNER JOIN Departamento AS depto ON empleado.depto_nro = depto.depto_nro
WHERE empleado.puesto = 'vendedor';

-- Visualizar los departamentos con más de cinco empleados.
SELECT depto.depto_nro, depto.nombre_depto, depto.localidad, COUNT(empleado.nombre) AS cantidad_empleados
FROM Departamento AS depto 
INNER JOIN Empleado ON empleado.depto_nro = depto.depto_nro
GROUP BY empleado.depto_nro HAVING cantidad_empleados > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT empleado.nombre, empleado.salario, depto.nombre_depto FROM Empleado 
INNER JOIN Departamento AS depto ON empleado.depto_nro = depto.depto_nro
WHERE empleado.puesto = (SELECT puesto FROM Empleado WHERE nombre='Mito' AND apellido = 'Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT Empleado.* FROM Empleado
INNER JOIN Departamento AS depto ON empleado.depto_nro = depto.depto_nro
WHERE depto.nombre_depto = 'Contabilidad'
ORDER BY empleado.nombre ASC;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, salario FROM empleado WHERE salario = (SELECT MIN(salario) FROM empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT Empleado.* FROM Empleado
INNER JOIN Departamento AS depto ON empleado.depto_nro = depto.depto_nro
WHERE depto.nombre_depto = 'Ventas' AND empleado.salario = 
(SELECT MAX(salario) FROM empleado INNER JOIN Departamento AS depto ON empleado.depto_nro = depto.depto_nro
WHERE depto.nombre_depto = 'Ventas');
