use movies_db;

-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name FROM series s
INNER JOIN genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name FROM actors a
INNER JOIN actor_episode ae ON a.id = ae.actor_id
INNER JOIN episodes e ON ae.episode_id = e.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, COUNT(seasons.serie_id) FROM series
INNER JOIN seasons ON series.id = seasons.serie_id
GROUP BY series.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno,
-- siempre que sea mayor o igual a 3.
SELECT genres.name GENERO, COUNT(*) CANT FROM movies
INNER JOIN genres ON movies.genre_id = genres.id
GROUP BY genres.name
HAVING CANT >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas
-- de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT actors.first_name, actors.last_name FROM actors
INNER JOIN actor_movie ON actors.id = actor_movie.actor_id
INNER JOIN movies ON movies.id = actor_movie.movie_id
WHERE movies.title LIKE '%La%Guerra%de%las%galaxias%';
