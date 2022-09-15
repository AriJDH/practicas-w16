-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.employeesName, e.employeesPosition, d.departmentCity  FROM employees as e
INNER JOIN department as d
ON e.departmentNumber = d.departmentNumber;

-- Visualizar los departamentos con más de cinco empleados.

SELECT e.departmentNumber, COUNT(e.employeesCode) as count
FROM employees as e
GROUP BY e.departmentNumber
HAVING count >= 2;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.

SELECT e.employeesName, e.employeesSalary, d.departmentName FROM employees as e
INNER JOIN department as d
ON e.departmentNumber = d.departmentNumber
WHERE  e.employeesName = 'Mito' AND e.employeesLastname = 'Barchuk';

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * FROM employees as e
WHERE e.departmentNumber IN (
	SELECT d.departmentNumber
		FROM department as d
		WHERE d.departmentName = 'Contabilidad');
        
-- Mostrar el nombre del empleado que tiene el salario más bajo

SELECT e.employeesName FROM employees as e
ORDER BY e.employeesSalary ASC LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT * FROM employees as e
WHERE e.departmentNumber IN (
	SELECT d.departmentNumber
		FROM department as d
		WHERE d.departmentName = 'Ventas')
	ORDER BY e.employeesSalary DESC LIMIT 1;
