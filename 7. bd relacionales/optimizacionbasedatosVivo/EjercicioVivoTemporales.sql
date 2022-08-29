USE movies_db;

-- EJERCICIO 1
#1
CREATE TEMPORARY TABLE TWD (serie varchar(50), temporada Varchar(50), episodio varchar(50));

#Guarda los datos de la consulta. en TDW
INSERT INTO TWD
SELECT  se.title AS serie, s.title AS temporada, e.title AS episodio
FROM episodes e
INNER JOIN seasons s ON s.id = e.season_id
INNER JOIN series se ON se.id = s.serie_id
WHERE se.title LIKE '%The Walking Dead%';

#2
SELECT *
FROM TWD
WHERE temporada LIKE 'Primer Temporada';

-- EJERCICIO 2 
#1
CREATE INDEX index_name
ON genres (name);

SHOW INDEX FROM genres;
#2
-- La tabla genres es una de las que recibe menos actualizaciones de forma recurrente y la cuál puede ser motivo de varias consultas, 
-- la primary key tiene por defecto indice por ende seleccionamos el nombre del genero a lo cuál nos puede llevar a muchas consultas optimizadas. 

-- EJERCICIO 3
#Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ('Top Gun', 21, 3,'2022-04-04', 100, 4);

#Agregar un género a la tabla genres.
INSERT INTO genres (name, ranking)
VALUES ('Romantico', 13);

#Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies
SET genre_id=13
where id = 22;

#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id=22
WHERE id = 12;

#Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE copia_movies(SELECT * FROM movies);

#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE
FROM copia_movies
WHERE awards < 5;

#Obtener la lista de todos los géneros que tengan al menos una película.
SELECT COUNT(m.genre_id) as canitdad_pelicula_X_genero, name
FROM genres
JOIN movies m ON genres.id = m.genre_id
GROUP BY m.genre_id, name
HAVING m.genre_id >= 1;

#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actors.*
FROM actors
JOIN movies ON actors.favorite_movie_id = movies.id
WHERE awards > 3;

#Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX index_title
ON movies_db.movies (title);

#Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;
#En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
#Existe una mejora eficencia a la hora de busqueda cuando la tabla tiene un
#gran volumnen de datos y no tengan modificaciones recurrentes.
#¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
# Creariamos un index en la tabla de actors en el campo last_name, para
# traer los nombres mas rapido ya que son cosas recurrentes a la hora de hacer la peticion.

# Creariamos un index en la tabla episodies en el campo title para cuando traigamos
# todos los episodios de una temprada sea mas facil buscarlo.