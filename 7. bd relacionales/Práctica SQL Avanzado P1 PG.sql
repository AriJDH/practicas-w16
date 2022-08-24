SELECT m.title, g.name AS genre 
	FROM movies AS m 
    LEFT JOIN genres AS g 
    ON m.genre_id = g.id;

SELECT e.title, a.first_name, a.last_name 
	FROM episodes as e 
    JOIN actor_episode as ae
    ON e.id = ae.episode_id
    JOIN actors AS a
    ON ae.actor_id = a.id;

SELECT ser.title, COUNT(seas.id) AS num_seasons
	FROM series AS ser
    LEFT JOIN seasons AS seas
    ON ser.id = seas.serie_id
	GROUP BY ser.id;

SELECT g.name AS genre, COUNT(m.id) AS num_movies
	FROM genres AS g 
    LEFT JOIN movies AS m
    ON g.id = m.genre_id
    GROUP BY g.id
    HAVING num_movies >= 3;

SELECT a.first_name, a.last_name
	FROM actors AS a
    JOIN actor_movie AS am
    ON a.id = am.actor_id
    JOIN movies AS m
    ON am.movie_id = m.id
    WHERE m.title LIKE "La Guerra de las galaxias%"
    GROUP BY a.id
    HAVING COUNT(*) = (
		SELECT COUNT(*) 
        FROM movies 
        WHERE title LIKE "La Guerra de las galaxias%"
	);
