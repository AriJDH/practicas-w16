-- Se crea una provincia

insert into provincia (name)
value ("San Luis");

-- Se crea una ciudad de una provincia

insert into ciudad (name,provincia_id) 
values
("Merlo",1);

-- Se crean clientes

insert into cliente (first_name,last_name,dni,birth_date) 
values 
("Juan","Perez",33333333,"2000-01-01"),
("Alberto","Pindudez",42546867,"1976-01-01"),
("Marcela","Gomez",12234234,"1988-01-01"),
("Estefania","Gonzalez",85234234,"1997-01-01"),
("Maximiliano","Ribeiro",84234234,"1992-01-01"),
("Alejandro","Martinez",23423412,"1986-01-01"),
("Marcelo","Martinez",87623412,"1995-01-01"),
("Sebastian","Andrada",43562622,"1999-01-01"),
("Dario","Pollo",23423422,"2002-01-01"),
("Cristian","Rodriguez",23422342,"1945-01-01")
;

-- Se crean descuentos

insert into discount (type,value)
values
("Descuento 10%",10),
("Descuento 20%",20)
;

-- Se crean planes con y sin descuentos

insert into plan (description,mb,value,discount_id)
values 
("Plan 100 mb",100,2500,null),
("Plan 200mb",200,3500,null),
("Plan 300mb",300,4000,null),
("Plan 500mb",500,4500,null),
("Plan 1000mb",1000,5500,null),
("Plan 1000mb",1000,5500,2)
;

-- Se crean los domicilios sin importar el cliente 
-- (En un mismo domicilio pueden vivir varios clientes con diferentes planes, o en un domicilio un solo cliente con diferentes planes)

insert into domicilio(adress,number,ciudad_id)
value ("Calle Falsa",123,1);

insert into domicilio(adress,number,ciudad_id)
value ("Av de la fantasia",56,1);

insert into domicilio(adress,number,ciudad_id)
value ("La calandria",1234,1);

insert into domicilio(adress,number,ciudad_id)
value ("La catitas",134,1);

-- Se crean los enlaces entre clientes y domicilios

-- Un cliente tiene dos domicilios

insert into domicilio_has_cliente (cliente_id, domicilio_id)
values (1,1);

-- El domicilio es el punto donde converge el plan con el cliente 
-- El cliente puede mudarse de domicilio y conservar su plan
-- El cliente puede mudarse de domicilio y ceder la titularidad del plan
-- El domicilio puede cambiar el o los planes asociados

-- Se agregan planes a los domicilios

insert into domicilio_has_plan(domicilio_id,plan_id,cliente_id)
value (1,1,1)
;

-- Se agrega un domicilio a otro cliente
-- Este cliente comparte el domicilio con el cliente 1

insert into domicilio_has_cliente (cliente_id,domicilio_id)
value (2,1)
;

-- Se agrega un plan al mismo domicilio a nombre del cliente 2

insert into domicilio_has_plan(domicilio_id,plan_id,cliente_id)
value (1,2,2)
;

-- Se agrega un domicilio a otro cliente

insert into domicilio_has_cliente (cliente_id,domicilio_id)
value (10,2);

-- Se agrega un plan con descuento al domicilio 2 del cliente 10

insert into domicilio_has_plan (domicilio_id,plan_id,cliente_id)
value (2,6,10);

-- El cliente 10 tiene un nuevo domicilio

insert into domicilio_has_cliente (cliente_id,domicilio_id)
value (10,3);

-- El cliente 10 adquiere un nuevo plan en el domicilio 3

insert into domicilio_has_plan (domicilio_id,plan_id,cliente_id)
value (3,5,10);


-- Se listan todos los domicilios que tienen planes activos

select *
from domicilio_has_plan
inner join cliente
on domicilio_has_plan.cliente_id = cliente.id
inner join domicilio
on domicilio_has_plan.domicilio_id = domicilio.id
inner join plan
on domicilio_has_plan.plan_id = plan.id
left join discount
on plan.discount_id = discount.id

;


-- Consulta de todos los clientes que no tengan descuento

select *
from domicilio_has_plan
inner join cliente
on domicilio_has_plan.cliente_id = cliente.id
inner join domicilio
on domicilio_has_plan.domicilio_id = domicilio.id
inner join plan
on domicilio_has_plan.plan_id = plan.id
left join discount
on plan.discount_id = discount.id
where  discount.type is null
;

-- Consulta de todos los clientes que tienen descuento

select *
from domicilio_has_plan
inner join cliente
on domicilio_has_plan.cliente_id = cliente.id
inner join domicilio
on domicilio_has_plan.domicilio_id = domicilio.id
inner join plan
on domicilio_has_plan.plan_id = plan.id
inner join discount
on plan.discount_id = discount.id
;


-- Un cliente actualiza su plan

update domicilio_has_plan
inner join cliente
on domicilio_has_plan.cliente_id = cliente.id
inner join domicilio
on domicilio_has_plan.domicilio_id = domicilio.id
inner join plan
on domicilio_has_plan.plan_id = plan.id
left join discount
on plan.discount_id = discount.id
set plan_id = 5
where cliente.id = 10
and plan.id = 6
and domicilio.id = 2
;

-- Un cliente cambia la tituralidad de un plan a otro cliente

update domicilio_has_plan
inner join cliente
on domicilio_has_plan.cliente_id = cliente.id
inner join domicilio
on domicilio_has_plan.domicilio_id = domicilio.id
inner join plan
on domicilio_has_plan.plan_id = plan.id
left join discount
on plan.discount_id = discount.id
set cliente_id = 5
where domicilio_has_plan.id = 1
;

-- Lista todos los domicilios registrados con clientes

select *
from domicilio_has_cliente;

-- Un cliente realiza un cambio de domicilio

update domicilio_has_cliente set domicilio_id = 4 where cliente_id = 10 and domicilio_id = 3;

-- Un cliente traslada su plan antiguo al nuevo domicilio

update domicilio_has_plan set domicilio_id = 4 where domicilio_has_plan.id = 2;

-- Seleccionar un detalle completo de un clinete especifico que tiene un plan en un domicilio

select first_name,last_name,adress,number,description,mb,plan.value,type
from domicilio_has_plan
inner join plan
on domicilio_has_plan.plan_id = plan.id
left join discount
on plan.discount_id = discount.id
inner join cliente_has_domicilio
on domicilio_has_plan.domicilio_id = cliente_has_domicilio.domicilio_id
inner join cliente
on cliente_has_domicilio.cliente_id = cliente.id
inner join domicilio
on cliente_has_domicilio.domicilio_id = domicilio.id
where cliente.id = 1
and domicilio.id = 1
and plan.id = 6
;


-- Un cliente contrata un segundo plan

insert into domicilio_has_cliente (cliente_id,domicilio_id)
value (10,3);


insert into domicilio_has_plan (domicilio_id,plan_id,cliente_id)
value (3,6,10);

-- Consulta de todos los clientes que tengan planes activos agrupados por cliente y con los subtotales de todos sus servicios y sus respectivos descuentos

select cliente.first_name,cliente.last_name,sum(plan.value) as subtotal ,sum(discount.value) as discount
from domicilio_has_plan
inner join cliente
on domicilio_has_plan.cliente_id = cliente.id
inner join domicilio
on domicilio_has_plan.domicilio_id = domicilio.id
inner join plan
on domicilio_has_plan.plan_id = plan.id
left join discount
on plan.discount_id = discount.id
group by cliente.first_name,cliente.last_name
;



