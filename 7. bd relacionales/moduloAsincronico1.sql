/*Mostrar el título y el nombre del género de todas las series.
Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
*/




select s.title, g.name  from genres g inner join series s 
on (g.id = s.genre_id)

select e.title,a.first_name, a.last_name from episodes e inner join actor_episode ae
on(e.id = ae.episode_id)
left join actors a 
on(a.id = ae.actor_id)

select count(*) as total_temporadas , s.title  from series s left join seasons s2 ON (s.id=s2.serie_id) group by s.title 


select g.name , count(m.id) from genres g left join movies m  on (g.id = m.genre_id)
group by g.name 
having count(m.id) > 3 

select * from movies m 


select  distinct a.first_name, a.last_name from actor_movie am left join actors a 
on(a.id = am.id)
left join movies m on (m.id = am.movie_id)
where m.title like '%galaxias%'