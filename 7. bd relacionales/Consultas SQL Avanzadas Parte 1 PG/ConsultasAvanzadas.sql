-- Mostrar el título y el nombre del género de todas las series.
SELECT series.title,genres.name FROM series INNER JOIN genres ON series.genre_id = genres.id;  

-- Mostrar el título de los episodios, el nombre y 
-- apellido de los actores que trabajan en cada uno de ellos.
SELECT episodes.title,actor_episode.actor_id
FROM episodes INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id;

SELECT episodes.title,CONCAT(actors.first_name," ",actors.last_name) AS full_name_actor
FROM episodes JOIN actor_episode ON (episodes.id = actor_episode.episode_id)
JOIN actors ON (actor_episode.actor_id = actors.id);

SELECT actors.first_name,actors.last_name FROM actors JOIN actor_episode ON (actor_episode.actor_id = actor_id);

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, MAX(seasons.number)AS total_temporadas FROM series INNER JOIN seasons ON series.id = seasons.serie_id
GROUP BY series.title;


-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name, COUNT(movies.genre_id) AS total_peliculas FROM genres INNER JOIN movies ON movies.genre_id = genres.id
GROUP BY genres.name HAVING total_peliculas>=3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT CONCAT(actors.first_name," ",actors.last_name) AS full_name,movies.title 
FROM movies JOIN actor_movie ON (movies.id = actor_movie.movie_id)
JOIN actors ON (actor_movie.actor_id = actors.id) 
GROUP BY actor_movie.id HAVING movies.title LIKE 'La Guerra de las galaxias%';

SELECT DISTINCT CONCAT(actors.first_name," ",actors.last_name) AS full_name,movies.title 
FROM movies JOIN actor_movie ON (movies.id = actor_movie.movie_id)
JOIN actors ON (actor_movie.actor_id = actors.id) 
WHERE movies.title LIKE 'La Guerra de las galaxias%'
GROUP BY actor_movie.id;

SELECT distinct actors.first_name, actors.last_name
FROM movies JOIN actor_movie ON (movies.id = actor_movie.movie_id)
JOIN actors ON (actor_movie.actor_id = actors.id) 
WHERE movies.title LIKE 'La Guerra de las galaxias%'
GROUP BY actor_movie.id;

SELECT distinct CONCAT(actors.first_name," ",actors.last_name) AS 'nombre completo'
FROM movies JOIN actor_movie ON (movies.id = actor_movie.movie_id)
JOIN actors ON (actor_movie.actor_id = actors.id) 
WHERE movies.title LIKE 'La Guerra de las galaxias%'
GROUP BY actor_movie.id;
