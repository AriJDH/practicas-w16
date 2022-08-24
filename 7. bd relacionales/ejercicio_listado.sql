#todos los registros de movies
select * from movies m;
#nombre apellido y rating actores
select a.first_name , a.last_name , rating from actors a;
#Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
select s.title as titulo from series s;
#Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
select a.first_name, a.last_name from actors a where a.rating  > 7.5;
#Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
select m.title, m.awards from movies m where m.rating >= 7.5 and m.awards > 2;
#Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
select m.title, m.rating  from movies m order by m.rating ASC;
#Mostrar los títulos de las primeras tres películas en la base de datos.
select m.title from movies m limit 3;
#Mostrar el top 5 de las películas con mayor rating.
select m.title from movies m order by m.rating DESC limit 5;
#Listar los primeros 10 actores.
select a.last_name  from actors a limit 10;
#Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
select m.title, m.rating from movies m  where m.title = 'Toy Story';
#Mostrar a todos los actores cuyos nombres empiezan con Sam.
select * from actors a where a.first_name like '%Sam';
#Mostrar el título de las películas que salieron entre el 2004 y 2008.
select m.title from movies m where m.release_date BETWEEN '2004-01-01' AND '2008-01-01';
#Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
select m.title from movies m where m.rating > 3 and m.awards > 1 and m.release_date BETWEEN '1988-01-01' and '2009-01-01';