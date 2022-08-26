CREATE TEMPORARY TABLE Twd select e.title from episodes e 
	inner join seasons s ON e.season_id = s.id 
	inner join series se ON se.id = s.serie_id 
	where se.title LIKE '%The Walking Dead%';

select title from Twd;

-- Se creo index en la tabla de movies con el index rating para encontrar de forma mas eficiente
-- las peliculas con mas rating 