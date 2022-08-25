/*inserts departamento*/
INSERT INTO departamento VALUES('D-000-1', 'Software', 'Los Tigres');
INSERT INTO departamento VALUES('D-000-2', 'Sistemas', 'Guadalupe');
INSERT INTO departamento VALUES('D-000-3', 'Contabilidad', 'La Roca');
INSERT INTO departamento VALUES('D-000-4', 'Ventas', 'Plata');
/*insert empleados*/
INSERT INTO empleado VALUES('E-0001','César','Piñero', 'Vendedor','2018-05-12', 80000, 15000 , 'D-000-4');
INSERT INTO empleado VALUES('E-0002', 'Yosep','Kowaleski','Analista','2015-07-14',140000,0,'D-000-2');
INSERT INTO empleado VALUES('E-0003', 'Mariela','Barrios','Director','2014-06-05',185000,0,'D-000-3');
INSERT INTO empleado VALUES('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03',85000,10000,'D-000-4');
INSERT INTO empleado VALUES('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4');
INSERT INTO empleado VALUES('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-05-06', 190000, 0, 'D-000-3');
INSERT INTO empleado VALUES('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

/*selects*/
SELECT * from empleado;
SELECT * FROM departamento;
/* Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores. */

SELECT e.nombre, e.puesto, d.localidad, d.depto_nro 
FROM empleado as e
INNER JOIN departamento as d ON d.depto_nro=e.depto_nro
WHERE e.puesto = 'Vendedor';

/* Visualizar los departamentos con más de cinco empleados. return null*/

SELECT d.*
FROM departamento as d
INNER JOIN empleado as e ON d.depto_nro=e.depto_nro
GROUP BY e.depto_nro
HAVING COUNT(*) > 5;

/* Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’. */

SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
INNER JOIN departamento as d ON d.depto_nro=e.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');

/* Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre. */

SELECT e.*
FROM empleado as e
INNER JOIN departamento as d ON d.depto_nro=e.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;

/*Mostrar el nombre del empleado que tiene el salario más bajo. consultar having*/

SELECT nombre, salario
FROM empleado
WHERE salario = (SELECT min(salario) FROM empleado);


/* Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’*/

SELECT e.*
FROM empleado as e
INNER JOIN departamento as d ON d.depto_nro=e.depto_nro
WHERE e.salario = (SELECT max(e.salario) 
FROM empleado e 
INNER JOIN departamento as d ON d.depto_nro=e.depto_nro
WHERE d.nombre_depto = 'Ventas');









