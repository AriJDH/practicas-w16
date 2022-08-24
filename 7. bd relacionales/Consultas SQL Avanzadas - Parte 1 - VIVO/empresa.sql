-- 1) Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad FROM empleado e
INNER JOIN departamento d ON d.depto_nro = e.depto_nro;
-- 2) Visualizar los departamentos con más de 2 empleados.
SELECT Departamento, Cantidad FROM (
SELECT d.nombre_depto AS Departamento, COUNT(*) AS Cantidad FROM departamento d
INNER JOIN empleado e ON e.depto_nro = d.depto_nro
GROUP BY d.nombre_depto) AS PREVIEW where Cantidad > 1;
-- 3) Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre AS Nombre, e.salario AS Salario, d.nombre_depto AS Departamento FROM empleado e
INNER JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE puesto = (SELECT puesto AS Puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');
-- 4) Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.nombre AS Nombre, e.puesto AS Puesto, d.nombre_depto AS Departamento FROM empleado e
INNER JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;
-- 5) Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, salario FROM empleado
ORDER BY salario ASC
LIMIT  1;
-- 6) Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT nombre, salario FROM empleado
ORDER BY salario DESC
LIMIT  1;


INSERT empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4');

INSERT empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2');

INSERT empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3');

INSERT empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4');

INSERT empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4');

INSERT empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3');

INSERT empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');