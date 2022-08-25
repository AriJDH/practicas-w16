
/* Consultas basicas */
select * from clients;

select * from services;

select * from type_plans;

select * from plans;

select * from detail_plan;

select * from contracts;

select * from detail_plan_contract;

/* Ejercicio 4 */

/* 1. Consultar el nombre de los planes del usuario Mariana */
select c.name, c.last_name, tp.name from clients c 
inner join services s on s.id_client = c.id_client
inner join contracts con on con.id_service = s.id_service
inner join detail_plan_contract dpc on dpc.id_contract = con.id_contract
inner join plans p on p.id_plan = dpc.id_plan
inner join detail_plan dp on dp.id_plan = p.id_plan
inner join type_plans tp on tp.id_type_plan = dp.id_type_plan
where c.name = 'Mariana';


/* 2. Consultar cuantos tipos de planes hay */
select COUNT(*) from type_plans;

/* 3. listar los nombre de los tipos de planes */
select t.name from type_plans t;

/* 4. Consultar cuantos tipos de plan de television hay vendidos */
select COUNT(*) as `planes tv vendidos` from detail_plan where id_type_plan = (select id_type_plan from type_plans where name = 'Television');

/* 5. Consultar los usuarios que tienen contratado el plan de television */
select c.name, c.last_name from clients c 
inner join services s on s.id_client = c.id_client
inner join contracts con on con.id_service = s.id_service
inner join detail_plan_contract dpc on dpc.id_contract = con.id_contract
inner join plans p on p.id_plan = dpc.id_plan
inner join detail_plan dp on dp.id_plan = p.id_plan
where dp.id_type_plan = (select id_type_plan from type_plans where id_type_plan = 2);

/* 6. Cual es el usuario mas viejo de todos */
select * from clients c where c.birth_date = (select MAX(birth_date) from clients);

/* 7. Consultar los clientes que no tienen un servicio activo */
select * from clients c
where id_client = (select id_client from services where is_active = false);

/* 8. Listar los planes contratados que esten activos */
select * from type_plans where id_type_plan in (select id_type_plan from detail_plan);

/* 9. Consultar el pago promedio de los usuarios */
select AVG(c.total_neto) as `pago promedio` from contracts c;

/* 10. Consultar quien obtiene el mayor descuento y que este activo */
select * from contracts c where c.total_discount = (select MAX(total_discount) from contracts where is_active = true);











