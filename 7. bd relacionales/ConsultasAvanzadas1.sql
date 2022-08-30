/*Segunda Parte*/
/*Mostrar el título y el nombre del género de todas las series.*/
SELECT se.title, ge.name
FROM series se INNER JOIN genres ge
                          ON se.genre_id = ge.id;

/*Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.*/
SELECT ep.title, act.first_name, act.last_name
FROM episodes ep
         INNER JOIN actors act
         INNER JOIN actor_episode actp ON actp.actor_id = act.id AND actp.episode_id = ep.id;

/*Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.*/
SELECT ser.title, COUNT(*) as temporadas
FROM series ser INNER JOIN seasons sea
                           ON ser.id = sea.serie_id
GROUP BY ser.title;

/*Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.*/
SELECT ge.name as nombre, COUNT(*) cantidad_peliculas
FROM genres ge INNER JOIN movies mo
                          ON ge.id = mo.genre_id
GROUP BY ge.name;

/*Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.*/
SELECT mo.title as Pelicula, act.first_name as Nombre, act.last_name as Apellido
from actor_movie actm
         INNER JOIN actors act
         INNER JOIN movies mo ON mo.title LIKE 'La Guerra%'
WHERE actm.movie_id = mo.id AND actm.actor_id = act.id;