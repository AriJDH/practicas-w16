use movies_db;

-- *************************************** Ejercicio 1
-- 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” 
-- y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
-- 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
select e.title from episodes e;
select s.title from series s;
select se.title from seasons se;

-- sentencia para traer los datos 
select s.title as Serie, se.title as Temporada, e.title as Episodios 
from episodes e
inner join seasons se on e.season_id = se.id
inner join series s on se.serie_id = s.id
where s.title like "The Walking Dead";

-- tabla temporal 
CREATE TEMPORARY TABLE TWD (
	select s.title as Serie, se.title as Temporada, e.title as Episodios 
	from episodes e
	inner join seasons se on e.season_id = se.id
	inner join series s on se.serie_id = s.id
	where s.title like "The Walking Dead");

-- consulta a la tabla temporal
select * from TWD;

-- **************** notas: 
-- explain select * from movies where title like "Avatar";
-- explain select * from genres where name like "Drama";
explain select * from genres;
-- show index from movies;
-- HELP INDEX movies_db.movies;

-- *************************************** Ejercicio 2
-- 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
-- creacion de un indice
create index genres_namex on genres (name);
-- chequeo del indice creado en generos
show index from genres;
-- 2. Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- Pienso que la tabla genero es una tabla con pocas 
-- actualizaciones posibles y escogi indexar el campo name porque es util para distintas consultas.

-- *************************************** Resolver las siguientes consignas
-- Tomando la base de datos movies_db.sql, se solicita:
-- 1. Agregar una película a la tabla movies.
select * from movies;
INSERT INTO movies (title,rating,awards,release_date,length,genre_id)
VALUES ("Irene, Yo y mi otro Yo", 8.5, 15, "2005-12-6",300, 3);

-- 2. Agregar un género a la tabla genres.
select * from genres;
insert into genres(name, ranking, active)
values ("Tragicomedia", 13, 1);

-- 3. Asociar a la película del punto 1. con el género creado en el punto 2.
update movies set genre_id=14
where id=22;

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
select * from actors;
update actors set favorite_movie_id=22
where id=3;

-- 5. Crear una tabla temporal copia de la tabla movies.
create temporary table moviesTemporary (
	select * from movies
);

select * from moviesTemporary;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from moviesTemporary 
where awards < 5;//

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
select * from genres;

select distinct ge.name
from genres ge
inner join movies mo on ge.id = mo.genre_id;//

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select first_name, last_name 
from actors
inner join movies on favorite_movie_id=movies.id
where movies.awards>3;

-- 9. Crear un índice sobre el nombre en la tabla movies.
create index title_index on movies (title);

-- 10. Chequee que el índice fue creado correctamente.
show index from movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Si, el usuario normalmente hace solicitudes para consultar peliculas por su titulo lo cual amerita indexarlo.

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Yo indexaria el titulo de la tabla series por la misma razon de que el usuario encuentra mas facil y rapida
-- la busqueda de una serie por su respectivo titulo. 



                              