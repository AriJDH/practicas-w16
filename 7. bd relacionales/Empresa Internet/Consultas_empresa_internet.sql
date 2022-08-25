/*
##### Respuestas a preguntas del ejercicio 2 #####

¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
Al menos en mi caso personal, más allá del trabajo en grupo, voy a considerar el DNI de los cliente como la PK, ya que basta
con que el parámetro sea unívoco para cada cliente. Si bien se podría generar un parámetro como una ID de cliente o un legajo, me parece que el DNI
es suficiente para cumplir con este criterio y facilita la búsqueda de clientes dentro de la BBDD en un entorno real.

b. ¿Cuál es la primary key para la tabla de planes de internet?
Durante el desarrollo grupal se consideró una id como PK para cada plan de internet,
a fin de facilitar la relación entre las tablas de Cliente y Plan de Internet.

c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.
Como respuesta a esta pregunta, favor referirse al archivo 'DER Empresa_Internet.png'. Para efectos del ejercicio, se consideró que un cliente puede tener
sólo un plan y declarar una sola ciudad como domicilio, mientras que un plan de internet puede tener varios clientes (relación uno a muchos) y una ciudad
contiene varias provincias (ídem al anterior).
*/

##### Respuestas ejercicios 3 y 4 #####

USE empresa_internet;
#Ingresar Provincias
insert into Provincia (nombre_provincia)values('Cordoba');
insert into Provincia (nombre_provincia)values('Santiago');
insert into Provincia (nombre_provincia) values('Buenos Aires');
insert into Provincia (nombre_provincia) values('Santa Fe');

#Ingresar Ciudades
insert into Ciudad (nombre_ciudad,Provincia_idProvincia)
values('Capital Cordoba','1');
insert into Ciudad (nombre_ciudad,Provincia_idProvincia)
values('Capital Santiago','2');
insert into Ciudad (nombre_ciudad,Provincia_idProvincia)
values('La Plata','3');
insert into Ciudad (nombre_ciudad,Provincia_idProvincia)
values('Rosario','4');

#Ingresar 5 planes
insert into Plan (identificacion_plan,velocidad,precio,descuento)
values('Basico','200',3000,200);
insert into Plan (identificacion_plan,velocidad,precio,descuento)
values('Personal','300',10000,200);
insert into Plan (identificacion_plan,velocidad,precio,descuento)
values('Medio','400',6000,200);
insert into Plan (identificacion_plan,velocidad,precio,descuento)
values('Empresa','500',10000,200);
insert into Plan (identificacion_plan,velocidad,precio,descuento)
values('Avanzado','800',10000,200);

#Ingresar 10 clientes
insert into Cliente (dni,nombre,fecha_nacimiento,Plan_idPlan,Ciudad_idCiudad)
values('1234','Gabriel','1996-09-18',6,2);
insert into Cliente (dni,nombre,fecha_nacimiento,Plan_idPlan,Ciudad_idCiudad)
values('12345','Ruth','1995-11-02',7,1);
insert into Cliente (dni,nombre,fecha_nacimiento,Plan_idPlan,Ciudad_idCiudad)
values('123456','Pamela','1990-10-23',8,1);
insert into Cliente (dni,nombre,fecha_nacimiento,Plan_idPlan,Ciudad_idCiudad)
values('1234567','Gonzalo','1990-10-23',10,2);
insert into Cliente (dni,nombre,fecha_nacimiento,Plan_idPlan,Ciudad_idCiudad)
values('12345678','Nahuel','1995-10-23',8,2);
insert into Cliente (dni,nombre,fecha_nacimiento,Plan_idPlan,Ciudad_idCiudad)
values('987','Alejandro','1997-10-21',6,3);
insert into Cliente (dni,nombre,fecha_nacimiento,Plan_idPlan,Ciudad_idCiudad)
values('9876','Esteban','1997-10-27',9,2);
insert into Cliente (dni,nombre,fecha_nacimiento,Plan_idPlan,Ciudad_idCiudad)
values('98765','Claudio','1998-10-25',10,3);
insert into Cliente (dni,nombre,fecha_nacimiento,Plan_idPlan,Ciudad_idCiudad)
values('987654','Erika','1992-10-20',7,2);
insert into Cliente (dni,nombre,fecha_nacimiento,Plan_idPlan,Ciudad_idCiudad)
values('9876543','Felipe','1994-10-20',6,3);

#Consultar todos los registros de la tabla cliente mediante inner join
select dni,nombre,fecha_nacimiento,p.identificacion_plan,ciudad.nombre_ciudad
from Cliente c
inner join Plan p on p.idPlan = c.Plan_idPlan
inner join Ciudad ciudad on ciudad.idCiudad = c.Ciudad_idCiudad;

#### 10 consultas ####

#Mostrar todos los registros de la tabla clientes
select * from Cliente;

#Mostrar DNI, nombre y tipo de plan de todos los clientes cuyo plan tiene un costo de 10.000
select dni, nombre, p.identificacion_plan, p.precio
from Cliente c
inner join Plan p on p.idPlan = c.Plan_idPlan
having p.precio = 10000;

#Calcular el total de precio que pagan todos los clientes de la BBDD
select SUM(precio) as suma_precio
from Plan;

#Mostrar nombre, fecha de nacimiento y ciudad donde viven los clientes
select nombre, fecha_nacimiento, city.nombre_ciudad
from Cliente c
inner join Ciudad city on c.Ciudad_idCiudad = city.idCiudad;

#Mostrar nombre, fecha de nacimiento, ciudad y provincia donde residen los clientes
select nombre, fecha_nacimiento, city.nombre_ciudad, p.nombre_provincia
from Cliente c
inner join Ciudad city on c.Ciudad_idCiudad = city.idCiudad
inner join Provincia p on city.Provincia_idProvincia = p.idProvincia;

#Mostrar nombre, fecha de nacimiento, plan, precio y ciudad donde residen los clientes
select nombre, fecha_nacimiento, p.identificacion_plan, p.precio, city.nombre_ciudad
from Cliente c
inner join Ciudad city on c.Ciudad_idCiudad = city.idCiudad
inner join Plan p on c.Plan_idPlan = p.idPlan;

#Mostrar nombre, fecha de nacimiento, plan y precio del plan ordenando los clientes por nombre de forma ascendente
select nombre, fecha_nacimiento, p.identificacion_plan, p.precio
from Cliente c
inner join Plan p on c.Plan_idPlan = p.idPlan
order by c.nombre;

#Mostrar nombre, fecha de nacimiento, plan y precio del plan ordenando los clientes por Precio del plan de forma descendente
select nombre, fecha_nacimiento, p.identificacion_plan, p.precio
from Cliente c
inner join Plan p on c.Plan_idPlan = p.idPlan
order by p.precio desc;

#Mostrar nombre, plan y velocidad de los clientes que tienen contratado el plan Medio
select nombre, p.identificacion_plan, p.velocidad
from Cliente c
inner join Plan p on c.Plan_idPlan = p.idPlan
where p.identificacion_plan like 'Medio';

#Mostrar la cantidad de clientes que tienen contratado el plan Avanzado
select COUNT(identificacion_plan)
from Plan
where identificacion_plan like 'Avanzado';