use movies_db;

--- mostrar todos los registros de la tabla movies ---
select * from movies;

--- mostrar el nombre, apellido y rating de todos los actores ---
select a.first_name, a.last_name, a.rating from actors a;

--- mostrar el titulo de todas las series y usar alias que tanto el nombre de la tabla como el campo este en español ---
select s.title  as `titulo` from series s;

--- mostrar el nombre y el apellido de los actores cuyo reting sea mayor a 7.5 ---
select a.first_name, a.last_name from actors a where a.rating >= '7.5';

--- mostrar el titulo de las peliculas y el rating ordenados en forma ascendente ---
select m.title, m.rating from movies m order by m.rating asc;

--- mostrar el titulo de las primeras 3 peliculas ---
select m.title from movies m limit 3;

--- mostrar el top 5 de las peliculas con mayor rating ---
select m.title from movies m order by m.rating desc limit 5;

--- listar los 10 primeros actores ---
select * from actors a limit 10;

--- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story. ---
select m.title from movies m where m.title = 'Toy Story';

--- Mostrar a todos los actores cuyos nombres empiezan con Sam. ---
select * from actors a where a.first_name = 'Sam';

--- Mostrar el título de las películas que salieron entre el 2004 y 2008 ---
select m.title, m.release_date from movies m where m.release_date between '2004-01-01' and '2008-12-31';

--- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating. ---
select m.title
from movies m 
where 
m.rating > '3' and
m.awards > '1' and
(m.release_date between '1988-01-01' and '2009-12-31')
order by m.rating desc;












