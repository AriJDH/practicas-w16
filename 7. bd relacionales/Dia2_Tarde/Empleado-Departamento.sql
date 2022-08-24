Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT empleado.nombre,
		empleado.puesto,
        departamento.localidad
FROM	empleado JOIN departamento
ON	empleado.depto_nro = departamento.depto_nro

Visualizar los departamentos con más de cinco empleados.

SELECT departamento.nombre_depto
FROM empleado JOIN departamento
ON empleado.depto_nro = departamento.depto_nro
GROUP BY departamento.nombre_depto
HAVING COUNT(nombre_depto) > 5

Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT empleado.nombre,
		empleado.salario,
        departamento.nombre_depto
FROM 	empleado JOIN departamento ON empleado.depto_nro = departamento_nro
WHERE	empleado.puesto IN (SELECT puesto
							FROM empleados
                            WHERE nombre = "Mito" AND
                            apellido ="Barchuck")

Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT empleado.*
FROM 	empleado JOIN departamento ON empleado.depto_nro = departamento_nro
WHERE departamento.nombre_depto= "Contabilidad"
ORDER BY empleado.nombre ASC;

Mostrar el nombre del empleado que tiene el salario más bajo.

SELECT empleado.nombre
FROM empleados
ORDER BY salario ASC
LIMIT 1

Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT empleado.*
FROM 	empleado JOIN departamento ON empleado.depto_nro = departamento_nro
WHERE departamento.nombre_depto = "Ventas"
ORDER BY salario DESC
LIMIT 1
