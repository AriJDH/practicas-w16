SELECT *
FROM movies;

SELECT first_name, last_name, rating
FROM actors;

SELECT title as titulo
FROM series;

SELECT first_name as Nombre, last_name as Apellido
FROM actors WHERE rating > 7.5;

SELECT title as Titulo, rating as Rating, awards as Premios
FROM movies WHERE rating > 7.5 AND awards > 2;

SELECT title as Titulo, rating as Rating
FROM movies ORDER BY rating ASC;

SELECT title as Titulo
FROM movies LIMIT 3;

SELECT title as Titulo, rating as Rating
FROM movies ORDER BY rating DESC LIMIT 5;

SELECT first_name as Nombre
FROM actors LIMIT 10;

SELECT title as Titulo, rating as Rating
FROM movies WHERE title LIKE '%Toy Story%';

SELECT first_name as Nombre
FROM actors WHERE first_name LIKE 'Sam%';

SELECT title as Titulo
FROM movies WHERE release_date BETWEEN '2004-01-01' AND '2008-12-31';

SELECT title as Titulo, rating as Rating
FROM movies
WHERE rating > 3 AND awards > 1 AND release_date BETWEEN '1988-01-01' AND '2009-12-31'
ORDER BY rating DESC;