# Agregar una película a la tabla movies.
INSERT INTO movies VALUES (100, null, null, 'World of Warcraft', 10.0, 2, '2015-12-07', 150, 5);
# Agregar un género a la tabla genres.
INSERT INTO genres VALUES (50, '2020-01-01', null, 'Gaming', 13, 1);
# Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies SET genre_id = 50 WHERE id = 100;
# Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 100 WHERE id = 1;
# Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy AS SELECT * FROM movies;
# Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy WHERE awards < 5;
# Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.* FROM genres g
INNER JOIN movies m 
ON g.id = m.genre_id;
# Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT ac.*
FROM actors ac
INNER JOIN movies mo
ON ac.favorite_movie_id = mo.id
WHERE mo.awards > 3;
# Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movie_title
ON movies (title);
# Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;
# En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
# En esta BD no tiene una mejora notable porque es una bd chica, pero si tuviera muchos registros
# crear indices ayudaria muchisimo en cuanto a performance o tiempo de filtrado.
# ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
# Crearia en actors, porque considero que junto a movies podrian llegar a ser dos de las tablas mas accedidas
# Por consultas externas o como foreign keys de otras tablas.
