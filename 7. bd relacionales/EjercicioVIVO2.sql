INSERT INTO departamento(depto_nro, nombre_depto, localidad)
VALUES ('D-000-1', 'Software', 'Los Tigres');

INSERT INTO departamento(depto_nro, nombre_depto, localidad)
VALUES ('D-000-2', 'Sistema', 'Guadalupe');

INSERT INTO departamento(depto_nro, nombre_depto, localidad)
VALUES ('D-000-3', 'Contabilidad', 'La Roca');

INSERT INTO departamento(depto_nro, nombre_depto, localidad)
VALUES ('D-000-4', 'Ventas', 'Plata');


INSERT INTO empleado(cod_empleado, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0001', 'Cesar', 'Piñero', 'Vendedor', DATE '2018-05-12', 80000, 15000, 'D-000-4');

INSERT INTO empleado(cod_empleado, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0002', 'Yosep', 'Rivero', 'Analista', DATE '2015-07-14', 140000, 0, 'D-000-2');

INSERT INTO empleado(cod_empleado, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0003', 'Mariela', 'Barrios', 'Director', DATE '2014-06-05', 185000, 0, 'D-000-3');

INSERT INTO empleado(cod_empleado, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', DATE '2015-06-03', 85000, 10000, 'D-000-4');

INSERT INTO empleado(cod_empleado, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0005', 'Daniel', 'Condori', 'Vendedor', DATE '2018-03-03', 83000, 10000, 'D-000-4');

INSERT INTO empleado(cod_empleado, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0006', 'Mito', 'Barchuk', 'Presidente', DATE '2014-06-05', 190000, 0, 'D-000-3');

INSERT INTO empleado(cod_empleado, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', DATE '2014-08-02', 60000, 0, 'D-000-1');

### Ejercicio
#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT nombre, apellido, puesto, localidad
FROM empleado
         INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE puesto LIKE 'Vendedor%';

#Visualizar los departamentos con más de cinco empleados.
SELECT departamento.*, count(empleado.depto_nro) cantidad
FROM empleado
         INNER JOIN departamento on empleado.depto_nro = departamento.depto_nro
group by empleado.depto_nro
HAVING cantidad >= 5;
#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT nombre, apellido, salario, departamento.nombre_depto
FROM empleado
         INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE puesto = (SELECT puesto FROM empleado WHERE nombre LIKE 'Mito' AND apellido LIKE 'Barchuk');
#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT empleado.*
FROM empleado
         INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto LIKE 'Contabilidad'
ORDER BY nombre;
#Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, apellido
FROM empleado
WHERE salario = (SELECT min(salario) FROM empleado);
#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT empleado.*
FROM empleado
WHERE salario = (SELECT max(salario)
                 FROM empleado
                          INNER JOIN departamento on empleado.depto_nro = departamento.depto_nro
                 WHERE departamento.nombre_depto LIKE 'Ventas');
