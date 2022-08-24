
/* parte 1 */
SELECT 
	s.title,
    g.name 
FROM series s 
	JOIN genres g ON s.genre_id = g.id
;

/* parte 2 */
SELECT 
	episodes.title ,
    actors.first_name,
    actors.lASt_name
FROM episodes
	INNER JOIN actor_episode AS AE ON episodes.id = AE.episode_id
    INNER JOIN actors ON AE.actor_id = actors.id
;
/* parte 3 */
SELECT 
	series.title,
    count(*) AS 'cantidad de temporadAS' 
FROM series 
	INNER JOIN seASONs ON series.id = seASONs.serie_id 
GROUP BY series.title
; 

/* parte 4 */
SELECT 
	genres.name,
    count(*) AS 'cantidad de peliculAS' 
FROM genres 
	INNER JOIN movies ON genres.id = movies.genre_id 
GROUP BY genres.name 
HAVING count(*)>= 3
;

/* parte 5 */
 SELECT 
	actors.first_name,
    actors.lASt_name 
FROM actors
	JOIN actor_movie ON actors.id = actor_movie.actor_id
	JOIN movies ON actor_movie.movie_id = movies.id  
WHERE movies.title LIKE '%galaxi%' 
GROUP BY actors.first_name,
    actors.last_name 
HAVING count(*) = (SELECT count(*) FROM movies  WHERE title LIKE '%galaxi%')
;

