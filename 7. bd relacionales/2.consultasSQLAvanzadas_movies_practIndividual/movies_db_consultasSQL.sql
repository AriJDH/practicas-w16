use movies_db;
select * from movies_db.movies;
select * from movies_db.actors;
select * from movies_db.series;
select * from movies_db.episodes;
select * from movies_db.seasons;

SELECT * FROM movies_db.movies mo LEFT JOIN movies_db.actors ac ON mo.id = ac.favorite_movie_id;

SELECT * FROM movies_db.movies mo INNER JOIN movies_db.actors ac ON mo.id = ac.favorite_movie_id;

-- Mostrar el título y el nombre del género de todas las series.
select s.title, g.name
from series s
inner join genres g on s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title, a.first_name, a.last_name 
from episodes e
inner join actor_episode ae on e.id = ae.episode_id
inner join actors a on ae.actor_id = a.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title, count(se.number) as total
from series s
inner join seasons se on s.id = se.serie_id
group by s.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name, count(m.genre_id) as total
from genres g
inner join movies m on g.id = m.genre_id
group by g.name, m.genre_id;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select DISTINCT a.first_name, a.last_name
from actors a
inner join actor_movie am on a.id = am.actor_id
inner join movies m on am.movie_id = m.id
where m.title like "La Guerra de las galaxias%";







