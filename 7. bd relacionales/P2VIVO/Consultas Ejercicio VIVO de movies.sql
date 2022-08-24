SELECT * FROM movies;

SELECT a.first_name, a.last_name, a.rating FROM actors a; 

SELECT s.title AS 'Título' FROM series s;

SELECT a.first_name, a.last_name 
FROM actors a
WHERE a.rating > 7.5; 

SELECT m.title, m.rating, m.awards
FROM movies m
WHERE m.rating > 7.5 AND m.awards > 2;

SELECT m.title, m.rating
FROM movies m
ORDER BY m.rating ASC;

SELECT m.title 
FROM movies m
LIMIT 3;

SELECT m.title
FROM movies m
ORDER BY m.rating DESC
LIMIT 5;

SELECT a.first_name, a.last_name
FROM actors a
LIMIT 10;

SELECT m.title, m.rating
FROM movies m
WHERE m.title LIKE '%Toy Story%';

SELECT a.first_name, a.last_name
FROM actors a
WHERE a.first_name LIKE 'Sam%';

SELECT m.title
FROM movies m
WHERE m.release_date BETWEEN '2004-01-01' AND '2008-12-31';

SELECT m.title
FROM movies m
WHERE m.release_date BETWEEN '1988-01-01' AND '2009-12-31'
AND m.rating > 3 AND m.awards > 1
ORDER BY m.rating DESC;

