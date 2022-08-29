
#Consultar todos los registros de la tabla cliente mediante inner join
select 
idCliente,dni,nombre,fecha_nacimiento,p.indentificacion_plan,ciudad.nombre_ciudad
from Cliente c
inner join Plan p on p.idPlan = c.Plan_idPlan
inner join Ciudad ciudad on ciudad.idCiudad = c.Ciudad_idCiudad;

#Consultar registros de la tabla cliente que su fecha de nacimiento sea mayor a 

##Falta realizar 10 consultas
