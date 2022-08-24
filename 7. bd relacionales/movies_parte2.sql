
-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name FROM Series s JOIN Genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT 
	e.title, a.first_name, a.last_name 
FROM 
	Episodes e 
    JOIN Actor_Episode ae on e.id = ae.episode_id 
    JOIN Actors a ON ae.actor_id = a.id; 

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(ss.id) FROM Series s JOIN Seasons ss ON s.id = ss.serie_id GROUP BY s.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(m.id) FROM Genres g JOIN Movies m ON g.id = m.genre_id GROUP BY g.name HAVING Count(m.id) > 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT 
	a.first_name, a.last_name 
FROM 
	Actors a 
    JOIN Actor_Movie am ON a.id = am.actor_id
    JOIN Movies m ON am.movie_id = m.id
WHERE
	m.title LIKE ('La Guerra de las galaxias:%');

    