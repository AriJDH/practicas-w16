/*
 * Ejercicio > Modulo 15: BD Relacionales > OptimizacionDeBasesDeDatos-Parte2-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */


-- Ejercicio 1
-- 1.1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE `TWD`(
	SELECT 
		serie.title AS Serie, 
        season.title AS Temporada, 
        episode.title AS Episodio 
	FROM series serie 
		INNER JOIN seasons season ON season.serie_id = serie.id 
		INNER JOIN episodes episode ON episode.season_id = season.id
	WHERE serie.title = 'The Walking Dead'
);

-- 1.2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD WHERE Temporada = 'Primer Temporada';


-- Ejercicio 2
-- 2.1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
-- Creamos un nuevo índice para la columna 'last_name' de la tabla 'actors'.
CREATE INDEX actor_last_name_index ON actors (last_name);
-- Chequeamos la creacion del índice.
SHOW INDEX FROM actors;
-- Realizamos un EXPLAIN de una consulta a la tabla 'actors'.
EXPLAIN (
	SELECT * 
	FROM movies m 
		INNER JOIN actor_movie a ON m.id = a.movie_id 
		INNER JOIN actors a1 ON a.actor_id = a1.id
	WHERE a1.last_name = 'Di Caprio'
);
-- Borramos índice.
ALTER TABLE `movies_v3_db`.`actors` DROP INDEX `actor_last_name_index`;

-- Creamos un nuevo índice para la columna 'name' de la tabla 'genres'.
CREATE INDEX genre_name_index ON genres (name);
-- Chequeamos la creacion del índice.
SHOW INDEX FROM genres;
-- Realizamos un EXPLAIN de una consulta a la tabla 'genres'.
EXPLAIN (
	SELECT * 
	FROM movies m 
		INNER JOIN genres g ON m.genre_id = g.id
	WHERE g.name = 'Drama'
);
-- Borramos índice.
ALTER TABLE `movies_v3_db`.`genres` DROP INDEX `genre_name_index`;


-- Ejercicio 3
-- 3.1. Agregar una película a la tabla movies.
SELECT * FROM movies;
INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (NULL, NULL, 'Rápido y furioso reto Córdoba', 9.0, 12, '2020-05-11', 250, NULL);

-- 3.2. Agregar un género a la tabla genres.
SELECT * FROM genres;
INSERT INTO genres (created_at, updated_at, name, ranking, active)
VALUES ('2022-06-01', NULL, 'Gaming', 13, 1);

-- 3.3. Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id = 22;

-- 3.4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
SELECT * FROM actors WHERE id = 3;
UPDATE actors SET favorite_movie_id = 22 WHERE id = 3;

-- 3.5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies (
	SELECT * FROM movies
);

-- 3.6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SELECT * FROM temp_movies WHERE awards < 5;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM temp_movies WHERE awards < 5;
SET SQL_SAFE_UPDATES = 1;

-- 3.7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.id, g.name
FROM genres g 
	INNER JOIN movies m ON m.genre_id = g.id
GROUP BY g.id, g.name
HAVING COUNT(m.title) >= 1;

-- 3.8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name 
FROM actors a 
	INNER JOIN movies m ON m.id = a.favorite_movie_id
where m.awards > 3;

-- 3.9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movie_title_index ON movies(title);

-- 3.10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;