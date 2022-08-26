
/*Creacion de tablas temporales e indices*/
/*Ejercicio 1 1*/
CREATE TEMPORARY TABLE TWD(
SELECT 
	series.title as 'Titulo serie',
    series.release_date as 'Fecha lanzamiento serie',
    series.end_date as 'Fecha finalizacion serie',
    seasons.title as 'Temporada',
    episodes.title as 'Episodio',
    episodes.release_date as 'Fecha Episodio',
    episodes.number as 'Numero Episodio'
FROM series 
	join seasons on series.id = seasons.serie_id
    join episodes on seasons.id = episodes.season_id
WHERE 
	series.title = 'The Walking Dead'
);

/*Ejercicio 1 2*/
select * from TWD where Temporada = 'Primer Temporada';

/*Ejercicio 2 1*/
CREATE INDEX TitleIndex ON movies(title);

/*Ejercicio 2 2*/
-- Elegimos poner este indice porque consideramos que siempre que se busque una pelicula, la consulta se haria por titulo, por lo cual es conveniente que la busqueda por ese parametro sea mas rapida


/*Conultas SQL avanzado 2*/

select * from movies;

#1 Agregar una película a la tabla movies.
INSERT INTO `movies_db`.`movies`
(
`title`,
`rating`,
`awards`,
`release_date`,
`length`)
VALUES
('Pelicula de testeo',8.0,5,'2022-05-04 00:00:00',120);

#2 Agregar un género a la tabla genres.
INSERT INTO `movies_db`.`genres`
(
`created_at`,
`name`,
`ranking`,
`active`)
VALUES
(CURDATE(),'Gore',13,1);

#3 Asociar a la película del punto 1. con el género creado en el punto 2.
Update movies set genre_id =13 where Title = 'Pelicula de testeo';

#4 Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
update actors set favorite_movie_id = 22 where id = 1;

#5 Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE moviesTemp(
select * from movies
);

#6 Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
Delete from moviesTemp where awards < 5;

#7 Obtener la lista de todos los géneros que tengan al menos una película.
select distinct Genres.name from genres 
	join movies on genres.id = movies.genre_id;

#8 Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select 
	actors.first_name,
    actors.last_name
from actors 
	join movies on actors.favorite_movie_id = movies.id
where movies.awards >3;

#9 Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX TitleIndex ON movies(title);

#10 Chequee que el índice fue creado correctamente.
SELECT DISTINCT INDEX_NAME
FROM INFORMATION_SCHEMA.STATISTICS
WHERE TABLE_SCHEMA = 'movies_db'
	and TABLE_NAME = 'movies';
    
#11 En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- No pues en esta base de datos, la tabla movies solamente contiene 22 peliculas, lo cual es un valor muy pequeño, y no se veria reflejado la mejora en performance que brindan los indices.

#12 ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- igualmente a la tabla movies, creemos que es una buena idea crear un indice en la tabla actor, sobre la columna nombre, de esta forma cuando se quiere buscar un actor por su nombre, el tiempo de ejecucion seria eficiente.


