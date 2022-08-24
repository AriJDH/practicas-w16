#1
select e.nombre, d.nombre_dpto, d.localidad,e.puesto from departamento d inner join empleado e on d.id = e.departamento_id;
#2
select d.id, d.nombre_dpto ,COUNT(e.departamento_id) as cantidad from departamento d inner join empleado e on d.id = e.departamento_id group by d.id having cantidad>5;
#3
select e.nombre, e.salario, d.nombre_dpto from empleado e inner join departamento d on e.departamento_id = d.id where e.puesto in (select e2.puesto  from empleado e2 where e.nombre = 'Mito' and e2.apellido = 'Barchuk');
#4
select * from empleado e where e.departamento_id in (select d.id from departamento d where d.nombre_dpto = 'Contabilidad') ORDER BY e.nombre ASC;
#5
select e.nombre  from empleado e where e.salario in (SELECT min(e2.salario) FROM empleado e2);
#6
select e.nombre, e.salario from empleado e where e.salario in (SELECT max(salario) from empleado e2 where e2.departamento_id = 4)