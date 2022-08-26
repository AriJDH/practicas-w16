-- Agregar una película a la tabla movies.
INSERT INTO movies (title,rating,awards,release_date,length) VALUE ('El Padrino',9.0,17,'1972-03-24',175);
SELECT * FROM movies;

-- Agregar un género a la tabla genres.
INSERT INTO genres (created_at,name,ranking,active) VALUE ('2022-08-26','Crimen',13,1);
SELECT * FROM genres;

-- Asociar a la película del punto 1. con el género creado en el punto 2.

UPDATE movies SET genre_id=15 WHERE id=22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
SELECT * FROM actors;
UPDATE actors SET favorite_movie_id=22 WHERE id=47;
UPDATE actors SET favorite_movie_id=22 WHERE id=39;

-- Crear una tabla temporal copia de la tabla movies.
DROP TABLE IF EXISTS movies_temp;
CREATE TEMPORARY TABLE movies_temp (SELECT * FROM movies);
SELECT * FROM movies_temp;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM movies_temp WHERE awards <5;
SELECT * FROM movies_temp;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT * FROM genres WHERE id IN (SELECT DISTINCT genre_id FROM movies WHERE genre_id IS NOT NULL);

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT * FROM actors WHERE favorite_movie_id IN (SELECT DISTINCT id FROM movies WHERE awards>3);

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX nombre_movies ON movies(title);

-- Chequee que el índice fue creado correctamente.
EXPLAIN SELECT * FROM movies WHERE title = 'El Padrino';