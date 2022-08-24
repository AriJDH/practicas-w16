

/*Ej 1 */

select 
	empleado.nombre,
    empleado.puesto,
    departameno.localidad
from empleado
	join departamento on empleado.depto_nro = departamento.depto_nro
where
	empleado.puesto = 'Vendedor';
	
/*Ej 2 */

select 
    departameno.nombre_depto
from empleado
	join departamento on empleado.depto_nro = departamento.depto_nro
group by  departameno.nombre_depto
having count(nombre_depto) > 5;

/*Ej 3 */

select 
	empleado.nombre,
    empleado.salario,
    departameno.nombre_depto
from empleado
	join departamento on empleado.depto_nro = departamento.depto_nro
where
	empleado.puesto in (select puesto from empleados where nombre = 'Mito' and apellido = 'Barchuk');
    
/*Ej 4 */
select 
	empleado.*
from empleado
	join departamento on empleado.depto_nro = departamento.depto_nro
where 
	departamento.nombre_depto = 'Contabilidad'
order by empleado.nombre asc;

/*Ej 5 */

select 
	empleado.nombre 
from empleados
order by salario asc
limit 1;

/*Ej 6 */
select 
	empleado.*
from empleado
	join departamento on empleado.depto_nro = departamento.depto_nro
where 
	departamento.nombre_depto = 'Ventas'
order by salary desc
limit 1;
