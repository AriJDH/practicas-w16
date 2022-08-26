Select * FROM movies;

SELECT a.first_name, a.last_name, a.rating FROM actors a;

SELECT title as titulo FROM series;

SELECT first_name, last_name FROM actors WHERE rating > 7.5;

SELECT title, awards, rating FROM movies WHERE rating > 7.5 AND awards > 2;

SELECT title,rating FROM movies order by rating asc;

SELECT title FROM movies limit 3;

SELECT title, rating FROM movies order by rating desc limit 5;

SELECT first_name FROM actors limit 10;

SELECT title, rating FROM movies WHERE title LIKE '%Toy Story%';

SELECT  * FROM actors WHERE first_name LIKE 'Sam%';

SELECT title FROM movies WHERE release_date between '2004-01-01' AND '2008-12-31';

SELECT title FROM movies WHERE release_date between '1988-01-01' AND '2009-12-31'
AND rating > 3 AND awards > 1
order by rating desc;















