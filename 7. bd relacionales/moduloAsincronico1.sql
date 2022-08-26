/*Resolver las siguientes consignas
Tomando la base de datos movies_db.sql, se solicita:
Agregar una película a la tabla movies.
Agregar un género a la tabla genres.
Asociar a la película del punto 1. con el género creado en el punto 2.
Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
Crear una tabla temporal copia de la tabla movies.
Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
Obtener la lista de todos los géneros que tengan al menos una película.
Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
Crear un índice sobre el nombre en la tabla movies.
Chequee que el índice fue creado correctamente.
En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
*/




INSERT INTO movies_db.movies
(created_at, updated_at, title, rating, awards, release_date, `length`, genre_id)
VALUES('', '', '', 0, 0, '', 0, 1);



INSERT INTO movies_db.genres
(created_at, updated_at, name, ranking, active)
VALUES('', '', '', 0, 1);



create temporary table movies_copy(
id int, created_at timestamp , updated_at timestamp,tittle varchar(500),
raiting decimal(3,1) , awards int , release_date datetime , lenght int , genre_id int)


delete from movies where awards < 5


select distinct(name) from genres g  left join movies m 
on(g.id=m.genre_id)

select * from actors a left join movies m on
(a.favorite_movie_id = m.id) where 
m.awards > 3


CREATE INDEX movies_id_IDX USING BTREE ON movies_db.movies (id,release_date);

