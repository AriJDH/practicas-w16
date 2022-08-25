- PRIMERA PARTE

1. ¿A qué se denomina JOIN en una base de datos y para qué se utiliza?
Se utiliza para obtener datos de varias tablas relacionadas entre sí. Consiste en combinar datos de una tabla con datos de la otra tabla, a partir de una o varias condiciones en común.

2. Explicar dos tipos de JOIN
-Inner Join se utiliza para traer los datos relacionados de dos o más tablas.
-Left Join se utiliza para traer los datos de la tabla izquierda más los relacionados de la tabla derecha.

3. ¿Para que se utiliza el GROUP BY?
Se suele utilizar en conjunto con funciones de agregación, para obtener datos resumidos y agrupados por las columnas que se necesiten.

4. ¿Para que se utiliza el HAVING?
La cláusula HAVING se utiliza para incluir condiciones con algunas funciones SQL.
Afecta a los resultados traidos por Group By.

5. Escribir una consulta segun los diagramas:
SELECT movies.*, actors.first_name, actors.last_name 
FROM movies INNER JOIN actors 
ON movies.id = actors.favorite_movie_id;

SELECT * FROM movies mo LEFT JOIN actors ac ON mo.id = ac.favorite_movie_id;

- SEGUNDA PARTE

Mostrar el título y el nombre del género de todas las series
1. select series.title, genres.name from series inner join genres on series.genre_id=genres.id;

Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos
2. select episodes.title, actors.first_name, actors.last_name from episodes, actors inner join actor_episode on actor_episode.actor_id=actors.id;

Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas
3. select series.title, count(seasons.number) as total from series inner join seasons on series.id=seasons.serie_id group by title;

Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3
4. select genres.id, genres.name, count(movies.genre_id) total from genres inner join movies on movies.genre_id=genres.id group by id having total > 3;

Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan
5. select distinct actors.first_name, actors.last_name from actors, movies where movies.title like "%La Guerra de las Galaxias%";



