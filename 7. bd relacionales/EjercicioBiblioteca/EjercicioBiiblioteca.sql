

/*Ej 1 */

select * from autor;

/*Ej 2 */

select nombre,edad from estudiante;

/*Ej 3 */

select nombre from estudiante where carrera = 'informática';

/*Ej 4 */

select nombre from autor where nacionalidad in( 'francesa','italiana');

/*Ej 5 */

select titulo from libro where area <> 'internet';

select titulo from libro where area not in ('internet');

select titulo from libro where idLibro not in (select idLibro from libro where area = 'internet') ;

/*Ej 6 */

select titulo from libro where editorial = 'salamandra';

/*Ej 7 */

select 
	*
from estudiante
where edad > (select avg(edad) from estudiantes);

select 
	*
from estudiante
where edad > avg(edad);


/*Ej 8 */

select nombre from estudainte where apelllido like 'g%';

/*Ej 9 */

select 
	autor.nombre
from autor 
	join libroautor on autor.idautor = libroautor.idautor
    join libro on libroautor.idlibro = libro.idlibro
where 
	libro.titulo = 'El Universo: Guía de viaje';

/*Ej 10 */

select 
	libro.titulo
from estudiante
	join prestamo on estudiante.idLector = prestamo.idlector
    join libro on prestamo.idlibro = libro.idlibro
where 
	estudiante.nombre = 'Filippo Galli';

/*Ej 11 */

select 
	nombre
from estudiante 
order by edad asc
limit 1;

/*Ej 12 */

select 
	estudiante.nombre
from estudiante
	join prestamo on estudiante.idLector = prestamo.idlector
    join libro on prestamo.idlibro = libro.idlibro
where 
	libro.area = 'Base de Datos';

/*Ej 13 */

select 
	libro.titulo
from autor 
	join libroautor on autor.idautor = libroautor.idautor
    join libro on libroautor.idlibro = libro.idlibro
where 
	autor.nombre = 'J.K. Rowling';

/*Ej 14 */

select 
	libro.titulo
from libro 
	join prestamo on libro.idlibro = prestamo.idlibro
where 
	prestamo.fechaDevolucion = '2021-07-16';