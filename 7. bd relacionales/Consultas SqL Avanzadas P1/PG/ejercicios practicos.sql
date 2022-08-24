-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name FROM series s INNER JOIN genres g ON g.id = s.genre_id;
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title, a.first_name , a.last_name 
from actor_episode ae
inner join episodes e on ae.episode_id = e.id
inner join actors a on ae.actor_id = a.id;
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title, count(t.id) as temporadas
from series s
inner join seasons t on t.serie_id=s.id
group by s.title; 
-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name, count(p.id) as peliculas
from genres g
inner join movies p on p.genre_id = g.id
group by g.name
having peliculas>=3;
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select concat(a.first_name," " ,a.last_name) as actor 
from actor_movie am
inner join movies m on am.movie_id = m.id
inner join actors a on am.actor_id = a.id
where m.title like "%de las galaxias%"
group by actor;
