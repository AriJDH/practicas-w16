use movies_db;

-- Agregar una película a la tabla movies.
INSERT into movies values
(null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Bootcamp Java W16', 10.0, 10, '2022-07-19', 360, null);


-- Agregar un género a la tabla genres.
INSERT INTO genres values (null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'HardCoding', 13, 1);

-- Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies set genre_id=13
where id=22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors set favorite_movie_id=13
where id=4;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_tmp SELECT * FROM movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_tmp where awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT distinct g.* FROM genres g 
left join movies m on m.genre_id=g.id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.* from actors a 
inner join movies m on a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
create index title_index on movies(title);

-- Chequee que el índice fue creado correctamente.
show index from movies
where key_name = 'title_index';

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Creemos que no se notaría ningun cambio debido al tamaño tan pequeño de la misma.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Podriamos crear un indice sobre el nombre y los apellidos de los actores para reducir el tiempo en las busquedas.
