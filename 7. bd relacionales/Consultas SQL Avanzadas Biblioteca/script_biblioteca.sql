
insert into libro(titulo,editorial,area) values ('titulo1', 'edirotial1', 'area1');
insert into libro(titulo,editorial,area) values ('titulo2', 'edirotial2', 'area2');
insert into libro(titulo,editorial,area) values ('titulo3', 'edirotial3', 'area3');
insert into libro(titulo,editorial,area) values ('titulo4', 'edirotial4', 'area4');
insert into libro(titulo,editorial,area) values ('titulo5', 'edirotial5', 'area5');

insert into autor(nombre,nacionalidad) values ('nombreautor1', 'nacionalidad1');
insert into autor(nombre,nacionalidad) values ('nombreautor2', 'nacionalidad1');
insert into autor(nombre,nacionalidad) values ('nombreautor3', 'nacionalidad3');
insert into autor(nombre,nacionalidad) values ('nombreautor4', 'nacionalidad3');
insert into autor(nombre,nacionalidad) values ('nombreautor5', 'nacionalidad2');

insert into estudiante(nombre,apellido,direccion,carrera,edad) values ('nombreestudiante1', 'apellidoestudiante1','direccion1','carrera1',20);
insert into estudiante(nombre,apellido,direccion,carrera,edad) values ('nombreestudiante2', 'apellidoestudiante2','direccion2','carrera2',23);
insert into estudiante(nombre,apellido,direccion,carrera,edad) values ('nombreestudiante3', 'apellidoestudiante3','direccion3','carrera3',26);
insert into estudiante(nombre,apellido,direccion,carrera,edad) values ('nombreestudiante4', 'apellidoestudiante4','direccion4','carrera4',29);
insert into estudiante(nombre,apellido,direccion,carrera,edad) values ('nombreestudiante5', 'apellidoestudiante5','direccion5','carrera5',32);

select * from autor;

insert into libro_has_autor(libro_idLibro,autor_idAutor) values (11, 14);
insert into libro_has_autor(libro_idLibro,autor_idAutor) values (12, 15);
insert into libro_has_autor(libro_idLibro,autor_idAutor) values (13, 11);
insert into libro_has_autor(libro_idLibro,autor_idAutor) values (14, 12);
insert into libro_has_autor(libro_idLibro,autor_idAutor) values (15, 13);

insert into prestamo(libro_idLibro,estudiante_idLector,fechaPrestamo,fechaDevolucion,devuelto) values (11,12,'2022-01-01','2022-02-02',true);
insert into prestamo(libro_idLibro,estudiante_idLector,fechaPrestamo,fechaDevolucion,devuelto) values (12,13,'2022-02-03','2022-03-04',true);
insert into prestamo(libro_idLibro,estudiante_idLector,fechaPrestamo,fechaDevolucion,devuelto) values (13,14,'2022-01-02','2022-02-03',true);
insert into prestamo(libro_idLibro,estudiante_idLector,fechaPrestamo,fechaDevolucion,devuelto) values (14,15,'2022-03-06','2022-05-02',true);
insert into prestamo(libro_idLibro,estudiante_idLector,fechaPrestamo,fechaDevolucion,devuelto) values (15,11,'2022-02-01','2022-03-04',true);


-- Listar los datos de los autores.
select * from autor;

-- Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante where carrera = 'carrera1';

-- ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad = 'nacionalidad1' or nacionalidad = 'nacionalidad2';

-- ¿Qué libros no son del área de internet?
select * from libro where area = 'area1';

-- Listar los libros de la editorial Salamandra.
select * from libro where editorial = 'edirotial1';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad > (select avg(edad) from estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre from estudiante where apellido like 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.nombre from autor a 
join libro_has_autor lha on lha.autor_idAutor = autor_idAutor
join libro l on lha.libro_idLibro = l.idLibro
where l.titulo = 'titulo1';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select l.* from libro l
join prestamo p on l.idLibro = libro_idLibro
join estudiante e on p.estudiante_idLector = e.idLector
where e.nombre = 'nombreestudiante1';

-- Listar el nombre del estudiante de menor edad.
select nombre from estudiante
where edad = (select min(edad) from estudiante);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select e.nombre from estudiante e
join prestamo p on e.idLector = p.estudiante_idLector
join libro l on p.libro_idLibro = l.idLibro
where area = 'area1';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
select l.* from libro l
join libro_has_autor lha on lha.libro_idLibro = l.idLibro
join autor a on lha.autor_idAutor = a.idAutor
where a.nombre = 'nombreautor1';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
select l.titulo from libro l
join prestamo p on p.libro_idLibro = l.idLibro
where p.fechaDevolucion = '2022-03-04';




