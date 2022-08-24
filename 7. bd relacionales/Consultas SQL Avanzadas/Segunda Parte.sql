/*Mostrar el título y el nombre del género de todas las series.*/
SELECT s.title, g.name FROM series AS s
LEFT JOIN genres AS g ON s.genre_id = g.id;
/*Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.*/
SELECT e.title, a.first_name, a.last_name FROM episodes AS e
INNER JOIN actor_episode AS ae ON e.id = ae.episode_id
LEFT JOIN actors AS a ON a.id = ae.actor_id;
/*Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.*/
SELECT s.title, COUNT(se.serie_id) AS seasons FROM series s
LEFT JOIN seasons se ON s.id = se.serie_id
GROUP BY s.id;
/*Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.*/
SELECT g.name, COUNT(m.genre_id) AS total FROM genres AS g
LEFT JOIN movies AS m ON g.id = m.genre_id
GROUP BY g.id
HAVING total >= 3;
/*Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.*/
SELECT a.first_name, a.last_name FROM actors a
LEFT JOIN actor_movie am ON am.actor_id = a.id
LEFT JOIN movies m ON m.id = am.movie_id
WHERE m.title LIKE '%Guerra%'
GROUP BY a.id;