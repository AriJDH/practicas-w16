select * from autor;

select nombre, edad from estudiante;

select * from estudiante where carrera = "informatica";

select * from autor where nacionalidad != "frances" and nacionalidad != "intaliano";

select * from libro where area != "internet";

select * from libro where editorial = "Salamandra";

select * from estudiante where edad < (select avg(edad) from estudiante);

select * from estudiante where apellido like "G%";

select L.titulo
from Libro as L
inner join prestamo as P on P.idLibro = L.idLibro
inner join estudiante as E on E.idLector = P.idLector
where E.nombre = "Filippo" and E.Apellido = "Galli";

select nombre from estudiante where edad < 18;

select E.nombre
from Libro as L
inner join prestamo as P on P.idLibro = L.idLibro
inner join estudiante as E on E.idLector = P.idLector
where L.area = "Base de Datos";

select L.titulo
from Libro as L
inner join libroAutor as LA on LA.Libro_idLibro = L.idLibro
inner join autor as A on A.idAutor = LA.Autor_idAutor
where A.Nombre = "J. K. Rowling";

select L.titulo
from Libro as L
inner join prestamo as P on P.idLibro = L.idLibro
where P.fechaDevolucion = "2021-07-16";




