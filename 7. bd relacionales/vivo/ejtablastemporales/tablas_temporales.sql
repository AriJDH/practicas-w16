CREATE TEMPORARY TABLE TWD(
id integer not null,
title varchar(50) not null,
number integer not null,
release_date date not null,
rating integer not null,
title_season varchar(50) not null,
title_serie varchar(50) not null
);

-- Ejercicio 1
INSERT INTO TWD select e.id, e.title, e.number, e.release_date, e.rating, s.title, se.title
from episodes e 
inner join seasons s on e.season_id = s.id
inner join series se on se.id = s.serie_id
where se.title = 'The Walking Dead';

SELECT * FROM TWD;

-- Ejercicio 2
SHOW INDEX FROM movies;

-- Consultas SQL Avanzadas 2
-- Agregar una película a la tabla movies.
INSERT INTO movies VALUES (100, null, null, 'V de vendetta', 9.9, 6, '2009-06-07 000000', 120, 13);

-- Agregar un género a la tabla genres.
INSERT INTO genres VALUES (13, '2022-08-26 000000', null, 'Horror', 13, 1);

-- Asociar a la película del punto 1. con el género creado en el punto 2.
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 100 WHERE id = 1;
SELECT * from actors where id = 1;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies(
id integer not null,
create_at datetime,
update_at datetime,
title varchar(100) not null,
rating integer ,
awards integer ,
release_date datetime ,
legth integer,
genre_id integer
);

INSERT INTO temp_movies SELECT * FROM movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

DELETE FROM temp_movies WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT distinct name FROM genres g
INNER JOIN movies m ON g.id = m.genre_id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT DISTINCT first_name, last_name FROM actors a
INNER JOIN movies m ON m.id = a.favorite_movie_id
WHERE awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;





