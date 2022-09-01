select em.puesto,concat( em.nombre, " ", em.apellido) as nombres, dep.localidad from departamento dep
inner join empleado em
on dep.depto_nro = em.dept_nro;

select  dep.depto_nro, count(em.dept_nro) as 'numero de empleados' from departamento dep
inner join empleado em
on dep.depto_nro = em.dept_nro
group by(em.dept_nro)
HAVING count(em.dept_nro) > 5;


select em.puesto, concat( em.nombre, " ", em.apellido) as nombres, dep.nombre_depto, em.salario , dep.localidad from departamento dep
inner join empleado em
on dep.depto_nro = em.dept_nro
where em.puesto in (select puesto from empleado where nombre like 'mito' );

select * from departamento dep
inner join empleado em
on dep.depto_nro = em.dept_nro
where dep.nombre_depto like 'contabilidad%'
order by em.nombre asc;

select * from empleado
order by salario asc limit 1;


select * from empleado em
inner join departamento dep
on dep.depto_nro = em.dept_nro
where dep.nombre_depto like 'venta%'
order by salario desc limit 1;



