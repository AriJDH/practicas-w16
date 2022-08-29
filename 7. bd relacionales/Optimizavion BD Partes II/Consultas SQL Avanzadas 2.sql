-- Agregar una película a la tabla movies.

INSERT INTO `movies_db`.`movies`
VALUES
(NULL,
NULL,
NULL,
'Pelicula1',
6.7,
0,
now(),
120,
3);

-- Agregar un género a la tabla genres.

INSERT INTO `movies_db`.`genres`
VALUES
(NULL,
now(),
NULL,
'Genero1',
13,
1);


-- Asociar a la película del punto 1. con el género creado en el punto 2.
update movies set genre_id = 13
where id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
update actors set favorite_movie_id = 22
where id = 3;

-- Crear una tabla temporal copia de la tabla movies.
create temporary table tempo_movies as
select * from movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from tempo_movies where awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
select distinct g.* from genres g
join movies m on g.id = m.genre_id
where exists (select id from genres);

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select a.* from actors a
join movies m on m.id = a.favorite_movie_id
where m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `title_index` (`title` ASC) VISIBLE;
;

-- Chequee que el índice fue creado correctamente.
Show index from movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Dado que se trata de una base de datos pequeña, agregar indices no supondria una mejora notable. 

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- En: title de la tabla episodes, title de la tabla seasons, awards de una película, a las fechas debido a que son campos consultados recurrentemente. 

