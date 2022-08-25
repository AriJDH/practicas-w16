USE empresa_db;

# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad
FROM empleado e INNER JOIN departamento d
ON d.depto_nro = e.dept_nro;

# Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto
FROM departamento d
WHERE ( SELECT COUNT(*) 
		FROM Empleado e 
		WHERE e.dept_nro = d.depto_nro) >5;

#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e INNER JOIN departamento d
ON d.depto_nro = e.dept_nro 
WHERE 
	e.puesto = (SELECT e2.puesto FROM Empleado e2 WHERE e2.nombre = 'Mito' AND e2.apellido = 'Barchuk')
	AND NOT e.nombre = 'Mito' AND NOT e.apellido = 'Barchuk';
    
#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.nombre, e.apellido, e.salario
FROM empleado e INNER JOIN departamento d
ON d.depto_nro = e.dept_nro AND d.nombre_depto = 'contabilidad'
ORDER BY e.nombre ASC;

#Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre
FROM empleado e 
ORDER BY e.salario asc limit 1;

SELECT e.nombre
FROM empleado e
WHERE e.salario = (SELECT MIN(e2.salario) FROM Empleado e2);

#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT *
FROM empleado e
WHERE e.salario = (SELECT MAX(e2.salario) 
				   FROM empleado e2 INNER JOIN departamento d
				   ON d.depto_nro = e2.dept_nro 
				   WHERE d.nombre_depto = 'Ventas');
