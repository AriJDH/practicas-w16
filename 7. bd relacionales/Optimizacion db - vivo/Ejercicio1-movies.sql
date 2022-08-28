USE movies_db;

/* Ejercicio 1 - Creación de Tablas Temporales e Índices */


/* 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”. */

CREATE TEMPORARY TABLE TWD select e.id, e.created_at, e.updated_at, e.title, e.number, e.release_date, e.rating, e.season_id from episodes e
where e.season_id in (select id from seasons where serie_id = 3);

/* 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada */

select * from TWD where season_id = (select id from seasons where title = 'Primer Temporada' and serie_id = 3);


/* Ejercicio 2 - En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. */

/* 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.  */

CREATE FULLTEXT INDEX index_name_actor ON actors (first_name, last_name);

SHOW INDEX FROM actors;

/* 2. Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos. */

/* Es buena idea crear el indice de nombre y apellido del actor ya que se pueden hacer 
consultas constantes de las series o peliculas de dicho actor y este se hace mediante 
el nombre y apellido para tener una mejor precision en la busqueda. */
