use movies_db;
#1.- Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ('Top Gun', 21, 3, DATE '2022-04-04', 100, 4);

#2.- Agregar un género a la tabla genres.
INSERT INTO genres (name, ranking)
VALUES ('Romantico', 13);

#3.- Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
where id = 22;

#4.- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 12;

#5.- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE copia_movies(SELECT *FROM movies);

#6.- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM copia_movies
WHERE awards < 5;

#7.- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name, m.genre_id AS cantidad_peliculas
FROM genres g
INNER JOIN movies m ON g.id = m.genre_id
GROUP BY m.genre_id
HAVING m.genre_id >= 1;
#8.- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actors.first_name, actors.last_name, movies.title, movies.awards
FROM actors
JOIN movies ON actors.favorite_movie_id = movies.id
WHERE movies.awards > 3;

#9.- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX index_title
ON movies_db.movies (title);

#10.- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;
#11.- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*Existe una mejora en términos de eficencia a la hora de realizar una búsqueda cuando la tabla tiene un
gran volumnen de datos, lo que resulta útil mientras la misma no tenga modificaciones recurrentes.*/

#12.- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*Crearíamos un index en la tabla de 'actors', en el campo 'last_name', para
traer los nombres más rápido, ya que es un parámetro recurrente a la hora de hacer peticiones.
Creariamos también un index en la tabla 'episodies', en el campo 'title',ya que eso haría más ágil 
la obtención de todos los episodios de una temporada completa.*/