#Mostrar todos los registros de la tabla de movies
select * from movies;

#Mostrar el nombre, apellido y rating de todos los actores.
select first_name, last_name, rating 
from actors;

#Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
select title as titulo
from series;

#Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
select first_name, last_name, rating
from actors
where rating >= 7.5;

#Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
select title, rating, awards
from movies
where rating >= 7.5 and awards > 2;

#Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
select title, rating
from movies
order by rating;

#Mostrar los títulos de las primeras tres películas en la base de datos.
select title
from movies
limit 3;

#Mostrar el top 5 de las películas con mayor rating.
select title, rating
from movies
order by rating desc
limit 5;

#Listar los primeros 10 actores.
select first_name, last_name
from actors
limit 10;

#Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
select title, rating
from movies
where title like 'Toy Story';

#Mostrar a todos los actores cuyos nombres empiezan con Sam.
select first_name, last_name
from actors
where first_name like 'Sam';

#Mostrar el título de las películas que salieron entre el 2004 y 2008.
select title, release_date
from movies
where release_date
between '2004-01-01' and '2008-01-01';

#Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
select title, rating
from movies
where rating > 3 and awards > 1 and release_date between '1988-01-01' and '2009-01-01'
order by rating;