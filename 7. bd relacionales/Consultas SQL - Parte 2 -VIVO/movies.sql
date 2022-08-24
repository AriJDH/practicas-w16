USE movies_db;

SELECT * FROM movies;
SELECT first_name, last_name FROM actors;
SELECT title AS Titulo FROM series AS Series;
SELECT first_name, last_name FROM actors WHERE rating > 7.5;
SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;
SELECT title, rating FROM movies ORDER BY rating ASC;
SELECT title FROM movies LIMIT 3;
SELECT title, rating FROM movies ORDER BY  rating DESC LIMIT 5;
SELECT first_name, last_name FROM actors LIMIT 10;
SELECT title, rating FROM movies WHERE title LIKE '%Toy Story%';
SELECT first_name, last_name FROM actors WHERE first_name LIKE 'Sam%';
SELECT title, release_date FROM movies WHERE release_date BETWEEN '2004/01/01' AND '2008/12/31';
SELECT title FROM movies WHERE rating > 3 AND awards > 1 AND release_date BETWEEN '2004/01/01' AND '2008/12/31' ORDER BY rating;

