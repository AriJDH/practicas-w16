

select nombre, puesto, localidad from empleado inner join  departamento on empleado.depto_nro=departamento.depto_nro where puesto="Software Test Engineer III";

select departamento.depto_nro,nombre_dpto,localidad, count(*) as cantidad_de_empleados 
from departamento inner join empleado on departamento.depto_nro=empleado.depto_nro 
group by departamento.depto_nro, nombre_dpto having cantidad_de_empleados>=3;

select nombre, salario, nombre_dpto from empleado 
inner join departamento on empleado.depto_nro=departamento.depto_nro 
where empleado.puesto= (select puesto from empleado  where(nombre="Alex" and apellido="Lassen" ) );

select * from empleado inner join
 departamento on empleado.depto_nro=departamento.depto_nro 
 where departamento.nombre_dpto="Accounting" order by empleado.nombre;
 
select * from empleado order by salario limit 1;


select * from empleado inner join 
departamento dpto on empleado.depto_nro=dpto.depto_nro 
 where dpto.nombre_dpto="Accounting" and   
 salario=(select max(salario) from empleado where dpto.depto_nro=empleado.depto_nro );
 















