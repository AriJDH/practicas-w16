-- Ejercicio 1
-- Crear tabla temporal TWD con los episodios de The Walking Dead
CREATE TEMPORARY TABLE `TWD`
(select s.title as Serie, s1.title as Temporada, e.title as Episodio 
from series s inner join seasons s1 on s.id = s1.serie_id 
inner join episodes e on s1.id = e.season_id
where s.title = 'The Walking Dead');

-- Consultar la tabla temporal creada en el punto anterior para ver los episodio de la primer temporada
select * from TWD where Temporada = 'Primer Temporada';

-- Crear un inidice sobre alguna/s columnas de una tabla
CREATE INDEX actor_last_name_index
ON actors (last_name);

-- Chequeamos la creacion del indice
SHOW INDEX FROM actors;
-- Realizamos un explain para validar la columna Rows
explain select * from movies m inner join actor_movie a on m.id = a.movie_id inner join actors a1 on a.actor_id = a1.id
where a1.last_name = 'Di Caprio';
-- Borramos indice

ALTER TABLE `movies_db`.`actors` 
DROP INDEX `actor_last_name_index` ;

-- Realizamos un explain a un nuevo indice creado para el nombre del genero
explain select * from movies m inner join genres g on m.genre_id = g.id
where g.name = 'Drama';

-- Creamos nuev
CREATE INDEX genre_name_index
ON genres (name);

SHOW INDEX FROM genres;
-- Ejercicio 2
-- Agregar una película a la tabla movies.
select * from movies;
insert into movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
values (null, null, 'Rapido y furioso reto cordoba', 9.0, 12, '2020-05-11', 250, null);

-- Agregar un género a la tabla genres.
select * from genres;
INSERT into genres (created_at, updated_at, name, ranking, active)
values ('2022-06-01', null,'Gaming',13,1);

-- Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies set genre_id = 13 where id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
select * from actors where id = 3;
update actors set favorite_movie_id = 22 where id = 3;

-- Crear una tabla temporal copia de la tabla movies.
create temporary table temp_movies
select * from movies;

select * from temp_movies where awards < 5;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
delete from temp_movies where  awards < 5;
SET SQL_SAFE_UPDATES = 1;

-- Obtener la lista de todos los géneros que tengan al menos una película.
explain select distinct name from genres g inner join movies m on g.id = m.genre_id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select distinct a.first_name, a.last_name from actors a inner join movies m on a.favorite_movie_id = m.id
where m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movie_title_index
ON movies(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta


