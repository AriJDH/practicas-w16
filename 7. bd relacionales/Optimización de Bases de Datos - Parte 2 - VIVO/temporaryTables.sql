-- Con la base de datos “movies”, se propone crear una tabla temporal 
-- llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD
SELECT e.title FROM episodes e
INNER JOIN seasons s
ON s.id = e.season_id
WHERE s.serie_id = (SELECT id FROM series WHERE title = 'The Walking Dead');

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD;

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
ALTER TABLE genres
ADD INDEX indice_genres(name);

SHOW INDEX FROM genres;


-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
/*
 Mejorar una consulta complicada puede buscar por el nombre del genero y no por el id
*/

SELECT * FROM movies m
INNER JOIN genres g
ON g.id = m.genre_id
WHERE g.name = 'Romance';

SELECT * FROM movies m
INNER JOIN genres g
ON g.id = m.genre_id
WHERE g.ranking = 13;


-- Consultas SQL Avanzadas 2

-- Agregar una película a la tabla movies.
INSERT INTO `movies_db`.`movies`
(`title`,
`rating`,
`awards`,
`release_date`,
`length`,
`genre_id`)
VALUES
('Animales Fantásticos y dónde encontrarlos',
7.2,
11,
'2016-11-17',
180,
11);
-- Agregar un género a la tabla genres.
INSERT INTO `movies_db`.`genres`
(`name`,
`ranking`,
`active`)
VALUES
('Romance',
13,
1);
-- Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE `movies_db`.`movies`
SET
`genre_id` = 13
WHERE `id` = 22;
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE `movies_db`.`actors`
SET
`favorite_movie_id` = 22
WHERE `id` = 1;
-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy
SELECT * FROM movies;
-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SELECT * FROM movies_copy;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM movies_copy
WHERE awards < 5;
SET SQL_SAFE_UPDATES = 1;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name FROM genres g
INNER JOIN movies m
ON m.genre_id = g.id
GROUP BY g.name;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT first_name, last_name FROM actors a
INNER JOIN movies m
ON m.id = a.favorite_movie_id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE movies
ADD INDEX indice_title(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
No por que es una tabla que se modifica frecuentemente y crear indice es optimo para aquellas tablas que no 
se modifican en el tiempo.. frecuentemente.
*/

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
En la tabla generos ya que es una tabla que no crece de forma constante entonces los indices podrian estar en el nombre.
*/






