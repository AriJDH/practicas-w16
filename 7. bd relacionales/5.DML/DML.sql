#USE empresa_db;
​
​
INSERT INTO departamento VALUES 
	('D-000-',1, 'Software','Los Tigres'),
	('D-000-',2, 'Sistemas','Guadalupe'),
    ('D-000-',3, 'Contabilidad','La Roca'),
	('D-000-',4, 'Ventas','Plata');
​
​
# Inserción de datos empleado
INSERT INTO empleado VALUES
	('E-','0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-','4'),
    ('E-','0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-','2'),
    ('E-','0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-','3'),
	('E-','0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-','4'),
	('E-','0005', 'Daniel',  'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-','4'),
	('E-','0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-','3'),
	('E-','0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-','1');
​
​
SELECT * FROM empleado;
# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT nombre, puesto, localidad FROM departamento d
INNER JOIN empleado e 
ON e.ref_dpto = d.ref_dpto 
AND e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';
​
#Visualizar los departamentos con más de cinco empleados.
SELECT count(d.nombre_depto) cant_emp, d.nombre_depto as name_dpto FROM departamento d
INNER JOIN empleado e 
ON e.ref_dpto = d.ref_dpto 
AND e.depto_nro = d.depto_nro 
GROUP BY name_dpto
HAVING cant_emp > 5;
​
#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e1.nombre, e1.salario, e1.puesto, d.nombre_depto FROM empleado e1 
INNER JOIN departamento d
ON e1.ref_dpto = d.ref_dpto 
AND e1.depto_nro = d.depto_nro
WHERE e1.puesto in (SELECT e.puesto FROM empleado e
WHERE e.nombre = 'Mito' and e.apellido = 'Barchuk');
​
#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.* FROM empleado e 
INNER JOIN departamento d
ON e.ref_dpto = d.ref_dpto 
AND e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;
​
#Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT salario, nombre FROM empleado
WHERE salario = (SELECT min(salario) FROM empleado);
​
#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.* FROM empleado e
WHERE salario = (SELECT max(salario) FROM empleado, departamento d
WHERE d.nombre_depto = 'Ventas');