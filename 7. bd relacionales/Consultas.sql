use biblioteca;
#Listar los datos de los autores.
select * from Autor;
#Listar nombre y edad de los estudiantes
select nombre,edad from Estudiante;
#¿Qué estudiantes pertenecen a la carrera informática?
select * from Estudiante
where carrera = 'informatica';
#¿Qué autores son de nacionalidad francesa o italiana?
select * from Autor 
where nacionalidad = 'italiana' or nacionalidad ='francesa';
#¿Qué libros no son del área de internet?
select * from Libro
where area= 'internet';
#Listar los libros de la editorial Salamandra.
select * from Libro
where editorial = 'Salamandra';

