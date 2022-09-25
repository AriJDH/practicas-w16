USE movies_db;

SELECT * FROM movies_db.movies;

#1. Agregar una película a la tabla movies.
INSERT INTO movies_db.movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id) 
VALUES ('2022-08-26',NULL,'LIGHTYEAR',9.5,2,'2022-07-08',140,NULL); #creó la 22

#2. Agregar un género a la tabla genres.
SELECT * FROM movies_db.genres;
#CREÓ LA 13
INSERT INTO movies_db.genres (created_at, updated_at, name, ranking, active) 
VALUES ('2022-08-26', NULL, 'Historicas',13,1);

#3. Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies_db.movies SET genre_id = 13 WHERE id = 22;
SELECT * FROM movies_db.movies WHERE id = 22;

#4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
SELECT * FROM  movies_db.actors ;
UPDATE movies_db.actors SET favorite_movie_id = 22 WHERE id in (3,12);
SELECT * FROM  movies_db.actors WHERE id in (3,12);

#5. Crear una tabla temporal copia de la tabla movies.
DESCRIBE movies_db.movies;

CREATE TEMPORARY TABLE movies_db.MOVIESTMP
SELECT * FROM movies_db.movies;

DESCRIBE movies_db.MOVIESTMP ;
SELECT * FROM movies_db.MOVIESTMP;

#6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
/*Ir a Edit-->Preferences
Haga clic "SQL Editor"en la pestaña y uncheck"Actualizaciones seguras"check box
Query--> Reconnect to Server // cerrar sesión y luego iniciar sesión
Ahora ejecuta tu consulta SQ*/
DELETE FROM movies_db.MOVIESTMP WHERE awards < 5;

#7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT name FROM genres a
INNER JOIN movies_db.movies b ON a.id = b.genre_id;

SELECT  a.name, a.id, COUNT(*) AS cany 
FROM genres a
INNER JOIN movies_db.movies b ON a.id = b.genre_id 
GROUP BY a.id
HAVING cant > 0
;

#O8. btener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT  a.first_name, a.last_name 
FROM  movies_db.actors a
INNER JOIN movies_db.movies b ON a.favorite_movie_id = b.id
WHERE b.awards > 3
ORDER BY a.first_name;

#9. Crear un índice sobre el nombre en la tabla movies.
show index from movies_db.movies;

ALTER TABLE movies_db.movies
ADD INDEX titleIdx (title);

#10. Chequee que el índice fue creado correctamente.
show index from movies_db.movies;

#11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
EXPLAIN SELECT * FROM movies_db.movies WHERE title ='Toy Story';
#Si existe una mejora ya que al indezar, la búsqueda no va registro por registro de la tabla sino que con el índice va más directo y analiza solo el filtro que se desea

#12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
#En la tabla movies_db.episodes el campo title también se puede indexar ya que sería frecuene esa consulta y por cada película se tendría más episodios
EXPLAIN SELECT * FROM movies_db.episodes 
WHERE title = 'Pilot';

ALTER TABLE movies_db.movies
ADD INDEX titleIdx (title);

EXPLAIN SELECT * FROM movies_db.episodes 
WHERE title = 'Pilot';
#En la tabla actors el campo rating  también pudiera indexarse
#En la tabla movies el campo rating y awards
#En la tabla  series el campo title