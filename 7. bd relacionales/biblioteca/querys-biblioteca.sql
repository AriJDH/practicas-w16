SELECT * FROM biblioteca.Autor;




#Listar los datos de los autores.
Select * From biblioteca.Autor;

#Listar nombre y edad de los estudiantes
Select Nombre, Edad From biblioteca.Estudiante;

#¿Qué estudiantes pertenecen a la carrera informática?
Select Nombre, Edad From biblioteca.Estudiante Where Curso Like "Informatica";

#¿Qué autores son de nacionalidad francesa o italiana?
Select * From biblioteca.Autor Where Nacionalidad Like "Francia" OR Nacionalidad Like "Italia";

#¿Qué libros no son del área de internet?
Select * From biblioteca.Autor Where Nacionalidad Like "Francia" OR Nacionalidad Like "Italia";


#Listar los libros de la editorial Salamandra.
Select * From biblioteca.Libro Where Editorial Like "Salamandra";

#Listar los datos de los estudiantes cuya edad es mayor al promedio.
Select * From biblioteca.Estudiante Where Edad > (Select AVG(Edad) From biblioteca.Estudiante);

#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
Select * From biblioteca.Estudiante Where Apellido Like "G%";

#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
Select a.Nombre From biblioteca.Autor a
Inner Join biblioteca.Libro l On l.Libro
 Where Edad > (Select AVG(Edad) From biblioteca.Estudiante);


#¿Qué libros se prestaron al lector “Filippo Galli”?
#Listar el nombre del estudiante de menor edad.
#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
#Listar los libros que pertenecen a la autora J.K. Rowling.
#Listar títulos de los libros que debían devolverse el 16/07/2021.
