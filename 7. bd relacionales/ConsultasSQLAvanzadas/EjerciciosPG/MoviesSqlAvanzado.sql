-- Mostrar el título y el nombre del género de todas las series.
SELECT serie.title, genres.name FROM series AS serie INNER JOIN genres ON serie.genre_id = genres.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT episodes.title, actors.first_name, actors.last_name FROM actor_episode
INNER JOIN episodes ON actor_episode.episode_id = episodes.id
INNER JOIN actors ON actor_episode.actor_id = actors.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, COUNT(seasons.number) AS number_seasons FROM series INNER JOIN seasons ON series.id = seasons.serie_id GROUP BY series.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name, COUNT(movies.title) AS total_movies FROM genres INNER JOIN movies ON genres.id = movies.genre_id GROUP BY genres.name HAVING total_movies >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT actors.first_name, actors.last_name FROM actor_movie 
INNER JOIN actors ON actors.id = actor_movie.actor_id
INNER JOIN movies ON movies.id = actor_movie.movie_id
WHERE movies.title LIKE 'La Guerra de las galaxias%';
