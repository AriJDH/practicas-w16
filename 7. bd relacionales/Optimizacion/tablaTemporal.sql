-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

DROP TABLE IF EXISTS TWD;
CREATE TEMPORARY TABLE TWD AS (SELECT episodes.* FROM seasons 
INNER JOIN series ON series.id = seasons.serie_id 
INNER JOIN episodes ON episodes.season_id = seasons.id
 WHERE series.title = 'The Walking Dead');

SELECT * FROM TWD;

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

SELECT TWD.* FROM TWD INNER JOIN seasons ON TWD.season_id = seasons.id WHERE seasons.number = 1;


