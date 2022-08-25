#1
SELECT idautor, nombre, nacionalidad 
FROM autor;

#2
SELECT e.nombre ,e.edad  
FROM estudiante e;

#3
SELECT * FROM estudiante e 
WHERE e.carrera = 'informática';

#4
SELECT * FROM autor a 
WHERE a.nacionalidad = 'francesa' OR a.nacionalidad = 'italiana';

#5
SELECT * FROM libro l 
WHERE l.area != 'internet';

#6
SELECT * FROM libro l 
WHERE l.editorial = 'Editorial Salamandra';

#7
SELECT * FROM estudiante e 
WHERE e.edad > (SELECT AVG(e.edad) FROM estudiante e2);

#8
SELECT * FROM estudiante e 
WHERE e.apellido LIKE 'G%';

#9
SELECT a.nombre 
FROM libroautor l 
INNER JOIN autor a ON a.idautor = l.autor_idautor 
WHERE l.libro_idlibro = (SELECT l2.idlibro FROM libro l2 WHERE l2.titulo = 'El Universo: Guia de viaje');

#10
SELECT * FROM prestamo p 
WHERE p.estudiante_idLector = (SELECT e.idLector FROM estudiante e WHERE e.nombre = 'Filippo Galli');

#11
SELECT e.nombre 
FROM estudiante e 
WHERE e.edad IN (SELECT MIN(e2.edad) FROM estudiante e2);

#12
SELECT e.nombre 
FROM prestamo p 
INNER JOIN estudiante e ON e.idLector = p.estudiante_idLector
INNER JOIN libro l ON l.idlibro = p.idLibro 
WHERE l.area = 'Base de datos';

#13
SELECT l.titulo FROM libro l 
INNER JOIN libroautor la ON la.libro_idlibro = l.idlibro 
INNER JOIN autor a ON a.idautor  = la.autor_idautor 
WHERE a.nombre = 'J.K. Rowling';

#14
SELECT * FROM libro l 
INNER JOIN prestamo p ON p.idLibro = l.idlibro
WHERE p.fechaDevolucion = '2021-07-16';
    

