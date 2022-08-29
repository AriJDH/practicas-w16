SELECT DISTINCT nombre_depto, localidad, empleados.puesto FROM departamentos INNER JOIN empleados
ON departamentos.depto_nro = empleados.depto_nro WHERE empleados.puesto = "Vendedor" ;

SELECT departamentos.depto_nro, departamentos.nombre_depto, departamentos.localidad FROM departamentos 
INNER JOIN empleados
ON empleados.depto_nro=departamentos.depto_nro 
GROUP BY departamentos.depto_nro HAVING COUNT(*)>5; 

SELECT empleados.nombre, empleados.salario, departamentos.nombre_depto FROM departamentos INNER JOIN empleados 
ON empleados.depto_nro = departamentos.depto_nro 
AND empleados.puesto = (SELECT puesto FROM empleados WHERE nombre = "Mito" AND apellido= "Barchuk");

SELECT * FROM departamentos INNER JOIN empleados ON empleados.depto_nro = departamentos.depto_nro 
AND departamentos.nombre_depto = "Contabilidad" ORDER BY empleados.nombre;

SELECT nombre , apellido FROM empleados WHERE salario = (SELECT MIN(salario) FROM empleados);

SELECT * FROM empleados WHERE salario = (SELECT MAX(salario) from empleados INNER JOIN departamentos 
										ON empleados.depto_nro = departamentos.depto_nro AND departamentos.nombre_depto = "Ventas");