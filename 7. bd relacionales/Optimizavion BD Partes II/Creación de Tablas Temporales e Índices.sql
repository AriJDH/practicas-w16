-- EJERCICIO 1
-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
create temporary table twd as 
select e.* from series s
join seasons n on n.serie_id = s.id
join episodes e on e.season_id = n.id
where s.title = 'The Walking Dead';

drop table twd;

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
select e.* from twd e
join seasons s on s.id = e.season_id
where s.title like '%Primer%';


-- EJERCICIO 2
-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `title_index` (`title` ASC) VISIBLE;
;

Show index from movies;

-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- Movies es una de las tablas mas importantes de la base y es frecuente querer buscar peliculas por su titulo.


