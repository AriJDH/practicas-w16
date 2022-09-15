SELECT title as titulo, rating, awards as premios
FROM movies
WHERE awards >= 3 AND rating > 7.5
ORDER BY rating asc;