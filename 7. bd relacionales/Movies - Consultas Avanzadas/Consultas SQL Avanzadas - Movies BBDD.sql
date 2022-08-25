#Mostrar el título y el nombre del género de todas las series.
select title, g.name as genero
from series ser
inner join genres g on ser.genre_id = g.id;

#Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select title, ac.first_name, ac.last_name
from episodes ep
inner join actor_episode ac_ep on ep.id = ac_ep.episode_id
inner join actors ac on ac_ep.actor_id = ac.id;

#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select ser.title as serie, count(sea.id) as seasons
from series ser
inner join seasons sea on ser.id = sea.serie_id
group by ser.title;

#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select gen.name, count(mov.id) as cant_films
from genres gen
inner join movies mov on mov.genre_id = gen.id
group by gen.name
having cant_films >= 3;

#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select ac.first_name, ac.last_name
from movies mov
inner join actor_movie act_mov on mov.id = act_mov.movie_id
inner join actors ac on act_mov.actor_id = ac.id
where mov.title like 'La Guerra de las galaxias%'
group by ac.first_name, ac.last_name;