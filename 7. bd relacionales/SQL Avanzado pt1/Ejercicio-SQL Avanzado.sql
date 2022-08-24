USE movies_db;

-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name 
FROM series as s 
LEFT JOIN genres as g ON g.id = s.genre_id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name 
FROM episodes as e 
LEFT JOIN actor_episode as ae ON e.id = ae.episode_id 
LEFT JOIN actors as a ON a.id = ae.actor_id ;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(se.title) as cantidad_temporadas 
FROM series as s 
LEFT JOIN seasons as se ON se.serie_id = s.id 
GROUP BY s.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(m.title) as total_peliculas 
FROM genres as g
LEFT JOIN movies as m ON m.genre_id = g.id
GROUP BY g.name
HAVING total_peliculas >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name FROM actors as a 
LEFT JOIN actor_movie as ac ON ac.actor_id = a.id
LEFT JOIN movies as m ON m.id = ac.movie_id 
WHERE m.title LIKE 'La Guerra de las galaxias%';

