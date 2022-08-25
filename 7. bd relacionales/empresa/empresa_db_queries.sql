/*
 * Ejercicio > Modulo 15: BD Relacionales > ConsultasSQLAvanzadas-Parte1-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */

-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad
FROM Empleado e
    INNER JOIN Departamento d ON d.depto_nro = e.depto_nro;
    
-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT d.depto_nro, d.nombre_depto, d.localidad
FROM Departamento d
WHERE (SELECT COUNT(*) FROM Empleado e WHERE e.depto_nro = d.depto_nro) > 5;
    
-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e1.nombre, e1.salario, d.nombre_depto
FROM Empleado e1
    INNER JOIN Departamento d ON d.depto_nro = e1.depto_nro
WHERE
	e1.puesto = (SELECT e2.puesto FROM Empleado e2 WHERE e2.nombre = 'Mito' AND e2.apellido = 'Barchuk')
    AND NOT e1.nombre = 'Mito' AND NOT e1.apellido = 'Barchuk';
    
-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.cod_emp, e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, e.depto_nro
FROM Empleado e
    INNER JOIN Departamento d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;
    
-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e1.nombre
FROM Empleado e1
WHERE e1.salario = (SELECT MIN(e2.salario) FROM Empleado e2);
    
-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e1.cod_emp, e1.nombre, e1.apellido, e1.puesto, e1.fecha_alta, e1.salario, e1.comision, e1.depto_nro
FROM Empleado e1
WHERE e1.salario = (SELECT MAX(e2.salario) 
				    FROM Empleado e2
						INNER JOIN Departamento d ON d.depto_nro = e2.depto_nro
                    WHERE
						d.nombre_depto = 'Ventas');