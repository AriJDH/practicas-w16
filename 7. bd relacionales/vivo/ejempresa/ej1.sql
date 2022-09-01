USE empresa_db;

SELECT e.nombre, e.puesto, d.localidad 
FROM empleado e, departamento d 
WHERE e.puesto = 'vendedor' AND e.depto_nro = d.depto_nro;

SELECT COUNT(*) total_empleados, e.depto_nro  FROM departamento d 
INNER JOIN empleado e ON e.depto_nro = d.depto_nro 
GROUP BY e.depto_nro 
HAVING total_empleados > 5;

SELECT e.nombre, e.salario, d.nombre_depto FROM departamento d 
INNER JOIN empleado e ON e.depto_nro = d.depto_nro 
WHERE e.puesto = (SELECT puesto FROM empleado WHERE apellido = "Barchuk" and nombre = "Mito");

SELECT * FROM departamento d 
INNER JOIN empleado e ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'contabilidad' ORDER BY e.nombre;

SELECT nombre, apellido, salario FROM empleado WHERE salario = (SELECT MIN(salario) FROM empleado);

SELECT * FROM empleado
WHERE salario = 
(SELECT MAX(salario) FROM empleado e 
	INNER JOIN departamento d 
    ON e.depto_nro = d.depto_nro 
    AND d.nombre_depto = 'ventas') 
    


