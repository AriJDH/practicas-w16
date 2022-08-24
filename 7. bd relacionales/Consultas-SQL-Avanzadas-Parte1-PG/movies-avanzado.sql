USE movies_db;

-- Mostrar el título y el nombre del género de todas las series.
SELECT se.title AS title_movie, gen.name AS genre_name
FROM genres AS gen 
INNER JOIN series AS se ON gen.id = se.genre_id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores 
-- que trabajan en cada uno de ellos. 
SELECT epi.title AS title_episode, ac.first_name, ac.last_name
FROM seasons AS seas
INNER JOIN episodes AS epi ON seas.id = epi.season_id
INNER JOIN series AS se ON se.id = seas.serie_id
INNER JOIN genres AS ge ON ge.id = se.genre_id
INNER JOIN movies AS mo ON ge.id = mo.genre_id
INNER JOIN actor_movie as acmo ON mo.id = acmo.movie_id
INNER JOIN actors AS ac ON ac.id = acmo.actor_id
ORDER BY title_episode;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT se.title AS title_serie, COUNT(seas.id) AS total_seasons 
FROM series AS se 
INNER JOIN seasons AS seas ON se.id = seas.serie_id
GROUP BY title_serie;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, 
-- siempre que sea mayor o igual a 3.
SELECT name AS name_genre, COUNT(mo.id) AS amount_movie
FROM genres AS gen
INNER JOIN movies AS mo ON gen.id = mo.genre_id
GROUP BY name_genre;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas 
-- de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT(CONCAT(ac.first_name, ' ', ac.last_name)) AS actor
FROM movies AS mo 
INNER JOIN actor_movie AS acmo ON mo.id = acmo.movie_id
INNER JOIN actors AS ac ON ac.id = acmo.actor_id
WHERE mo.title LIKE '%La Guerra de las galaxias%';


