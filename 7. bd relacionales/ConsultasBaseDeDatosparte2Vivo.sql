
/* parte 1 */
SELECT * FROM movies;

/* parte 2 */
SELECT first_name,last_name,rating FROM actors;

/* parte 3 */
SELECT series.title AS titulo FROM series AS series;

/* parte 4 */
SELECT first_name,last_name FROM actors WHERE rating > 7.5;

/* parte 5 */
SELECT title,rating,awards FROM movies WHERE rating >7.5 AND awards > 2;

/* parte 6 */
SELECT title,rating FROM movies ORDER BY rating ASC;

/* parte 7 */
SELECT title FROM movies LIMIT 3;

/* parte 8 */
SELECT title,rating FROM movies ORDER BY rating DESC LIMIT 5 ;

/* parte 9 */
SELECT first_name,last_name FROM actors LIMIT 10;

/* parte 10 */
SELECT title,rating FROM movies WHERE title LIKE "%Toy Story%";

/* parte 11 */
SELECT first_name,last_name FROM actors WHERE first_name LIKE "Sam%";

/* parte 12 */
SELECT title FROM movies WHERE RELEASE_DATE BETWEEN '2004-01-01' AND '2008-12-30' ;

/* parte 13 */
SELECT title FROM movies WHERE rating > 3 AND awards > 1 AND RELEASE_DATE BETWEEN '1988-01-01' AND '2009-12-30' ORDER BY rating ASC;
