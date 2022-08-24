#1
select * from autor a;
#2
select e.nombre ,e.edad  from estudiante e;
#3
SELECT * from estudiante e where e.carrera = 'informática';
#4
SELECT * from autor a where a.nacionalidad = 'francesa' OR a.nacionalidad = 'italiana';
#5
select * from libro l where l.area != 'internet';
#6
select * from libro l where l.editorial = 'salamandra';
#7
select * from estudiante e where e.edad > (select AVG(e.edad) from estudiante e2);
#8
select * from estudiante e where e.apellido like '%G';
#9
select a.nombre from libroautor l inner join autor a on a.idautor = l.autor_idautor where l.libro_idlibro = (select l2.idlibro from libro l2 WHERE l2.titulo = 'El Universo: Guía de viaje');
#10
select * from prestamo p where p.estudiante_idLector = (select e.idLector from estudiante e where e.nombre = 'Filippo Galli');
#11
select e.nombre from estudiante e where e.edad in (SELECT min(e2.edad) from estudiante e2);
#12
select e.nombre from prestamo p 
	inner join estudiante e on e.idLector = p.estudiante_idLector
	inner join libro l on l.idlibro = p.idLibro 
	where l.area = 'Base de datos';
#13
select l.titulo from libro l 
	inner join libroautor la on la.libro_idlibro = l.idlibro 
	inner join autor a  on a.idautor  = la.autor_idautor 
where a.nombre = 'J.K. Rowling.';
#14
select * from libro l 
	inner join prestamo p on p.idLibro = l.idlibro
	where p.fechaDevolucion = '2021-07-16';