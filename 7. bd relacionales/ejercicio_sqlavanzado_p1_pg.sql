#Mostrar el título y el nombre del género de todas las series.
select m.title, g.name  from movies m inner join genres g on m.genre_id = genre_id;
#Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select  a.first_name,a.last_name , e.title from actor_episode ae 
	inner join episodes e on ae.episode_id = e.id 
	inner join actors a on ae.actor_id  = a.id;
#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select se.title, count(s.title) from seasons s inner join series se on s.serie_id = se.id group by se.title;
#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name,COUNT(m.id) as cantidad from genres g inner join movies m on g.id = m.genre_id GROUP BY g.name having cantidad>3;
#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select DISTINCT a.first_name, a.last_name from actor_movie am inner join actors a ON am.actor_id = a.id where am.movie_id > 2 and am.movie_id < 5;