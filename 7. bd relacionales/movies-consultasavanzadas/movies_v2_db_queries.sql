/*
 * Ejercicio > Modulo 15: BD Relacionales > ConsultasSQLAvanzadas-Parte1-PG
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
 
-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name
FROM series s
	INNER JOIN genres g ON g.id = s.genre_id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
-- 2.1. Con producto cartesiano
SELECT e.title, a.first_name, a.last_name
FROM episodes e
	INNER JOIN actor_episode ae ON ae.episode_id = e.id
    INNER JOIN actors a ON a.id = ae.actor_id;
    
-- 2.2. Con la utilización GROUP_CONCAT
SELECT 
	e.title, 
    GROUP_CONCAT(a.first_name, ' ', a.last_name separator ', ') AS actors
FROM episodes e
	INNER JOIN actor_episode ae ON ae.episode_id = e.id
    INNER JOIN actors a ON a.id = ae.actor_id
GROUP BY e.title;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT
	serie.title,
    (SELECT COUNT(*) FROM seasons season WHERE season.serie_id = serie.id) AS seasons_count
FROM series serie;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT
	g.name,
    (SELECT COUNT(*) FROM movies m WHERE m.genre_id = g.id) AS movies_count
FROM genres g
GROUP BY g.name, movies_count
HAVING movies_count >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT a.first_name, a.last_name
FROM actors a
	INNER JOIN actor_movie am ON am.actor_id = a.id
    INNER JOIN movies m ON m.id = am.movie_id
WHERE m.title LIKE 'La Guerra de las galaxias%'
GROUP BY a.first_name, a.last_name;