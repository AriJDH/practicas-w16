use empresa_db;

-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT
	e.nombre,
    e.puesto,
    d.localidad
FROM
	empleado e
    INNER JOIN departamento d ON d.depto_nro = e.depto_nro;
    
-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT
	d.*
FROM
	departamento d
WHERE 
	(SELECT COUNT(*) FROM empleado e WHERE e.depto_nro = d.depto_nro) >= 2;
    
-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT
	e.nombre,
    e.salario,
    d.nombre_depto
FROM
	empleado e
    INNER JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE
	e.puesto = (SELECT puesto FROM empleado emp WHERE emp.nombre = 'Mito' AND emp.apellido = 'Barchuk')
    AND NOT e.nombre = 'Mito' AND NOT e.apellido = 'Barchuk';
    
-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT
	e.*
FROM
	empleado e
    INNER JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE
	d.nombre_depto = 'Contabilidad'
ORDER BY
	e.nombre;
    
-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT
	nombre
FROM
	empleado
WHERE
	salario = (SELECT MIN(e.salario) FROM empleado e);
    
-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT
	e.*
FROM
	empleado e
WHERE
	salario = (SELECT MAX(emp.salario) 
				FROM empleado emp
                INNER JOIN departamento d ON d.depto_nro = emp.depto_nro
                WHERE
					d.nombre_depto = 'Ventas');
