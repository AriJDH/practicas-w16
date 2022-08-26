select se.title as serie, s.title as temporada, e.title as episodio
from episodes e
         inner join seasons s on s.id = e.season_id
         inner join series se on se.id = s.serie_id
where se.title LIKE '%The Walking Dead%';

create temporary table TWD
(
    serie     varchar(50),
    temporada Varchar(50),
    episodio  varchar(50)
);

#Guarda los datos de la consulta. en TDW
INSERT INTO TWD
select se.title as serie, s.title as temporada, e.title as episodio
from episodes e
         inner join seasons s on s.id = e.season_id
         inner join series se on se.id = s.serie_id
where se.title LIKE '%The Walking Dead%';
;

SELECT *
FROM TWD;

SELECT *
FROM TWD
WHERE temporada LIKE 'Primer Temporada';

SELECT *
FROM movies
WHERE title LIKE 'Harry Potter%';

create index index_awards
    on movies_db.movies (awards);


#Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ('Top Gune', 21, 3, DATE '2022-04-04', 100, 4);
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
#Haciendo magia
CREATE TEMPORARY TABLE copia_movies(SELECT *
                                    FROM movies);
INSERT INTO copia_movies (title, rating, release_date, length, genre_id)
VALUES ('PRUEBA', 20, DATE '2022-05-05', 10, 4);
#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE
FROM copia_movies
WHERE awards < 5;
SELECT *
FROM copia_movies;

#Obtener la lista de todos los géneros que tengan al menos una película.
SELECT COUNT(m.genre_id) as canitdad_pelicula_X_genero, m.*
FROM genres
         join movies m on genres.id = m.genre_id
GROUP BY m.genre_id
HAVING m.genre_id >= 1;
#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actors.*
FROM actors
         join movies on actors.favorite_movie_id = movies.id
WHERE awards > 3;
#Crear un índice sobre el nombre en la tabla movies.
create index index_title
    on movies_db.movies (title);
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