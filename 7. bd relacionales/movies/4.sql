SELECT first_name as nombre, last_name as apellido
FROM actors
WHERE rating > 7.5
ORDER BY rating asc;