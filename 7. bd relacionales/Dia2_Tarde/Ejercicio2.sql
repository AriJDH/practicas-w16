Mostrar el título y el nombre del género de todas las series.
SELECT sr.title, gn.name
FROM series sr INNER JOIN genres gn
ON sr.genre_id = gn.id

Mostrar el título de los episodios, el nombre y apellido de los actores
 que trabajan en cada uno de ellos.
 
 SELECT e.title,a.first_name, a.last_name
 FROM actor_episode ae INNER JOIN actors a INNER JOIN episodes e
 ON ae.actor_id = a.id AND  ae.episode_id = e.id
 
Mostrar el título de todas las series y 
el total de temporadas que tiene cada una de ellas.

SELECT s.title, COUNT(*)
FROM series s INNER JOIN seasons se
ON s.id = se.serie_id
GROUP BY s.id

Mostrar el nombre de todos los géneros y
 la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
 
 SELECT g.name, COUNT(*)
 FROM movies m INNER JOIN genres g
 ON m.genre_id = g.id
 GROUP BY m.genre_id
 HAVING COUNT(*)>=3
 
Mostrar sólo el nombre y apellido de los actores que trabajan
en todas las películas de la guerra de las galaxias y que estos no se repitan.

SELECT  first_name, last_name
FROM actors a
WHERE a.id IN (SELECT DISTINCT am.id
		  FROM actor_movie am INNER JOIN movies m 
          ON  am.movie_id = m.id
          WHERE m.title LIKE 'La Guerra de las galaxias:%'
          GROUP BY m.title)