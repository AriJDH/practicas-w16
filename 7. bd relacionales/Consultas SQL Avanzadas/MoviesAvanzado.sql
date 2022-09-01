
-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name FROM genres g 
INNER JOIN series s 
ON s.genre_id = g.id;  

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.


