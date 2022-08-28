USE movies_db;

/* Consultas SQL Avanzadas 2 */

/* 1. Agregar una película a la tabla movies. */

INSERT INTO `movies_db`.`movies` 
VALUES ('2022-25-08', '2022-25-08', 'La vida de Mariana', 10.0, 8, '2022-25-08',80, 9);

/* 2. Agregar un género a la tabla genres. */

INSERT INTO `movies_db`.`genres` 
VALUES ('2013-07-04 03:00:00', null, 'Historia', 10, 1);



select * from genres;


/* 3. Asociar a la película del punto 1. con el género creado en el punto 2. */
/* 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1. */
/* 5. Crear una tabla temporal copia de la tabla movies. */
/* 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards. */
/* 7. Obtener la lista de todos los géneros que tengan al menos una película. */
/* 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards. */
/* 9. Crear un índice sobre el nombre en la tabla movies. */
/* 10. Chequee que el índice fue creado correctamente. */
/* 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta. */
/* 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta */



