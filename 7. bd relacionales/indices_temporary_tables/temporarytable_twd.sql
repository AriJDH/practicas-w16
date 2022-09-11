use movies_db;

drop table if exists TWD;

CREATE TEMPORARY TABLE TWD SELECT e.* 
FROM episodes e
INNER JOIN seasons s ON e.season_id = s.id
INNER JOIN series ss ON ss.id = s.serie_id
WHERE ss.id = 3;


-- season_id 20 -> primer temporada de twd
SELECT * from TWD WHERE season_id = 20;

-- creación de indice

CREATE INDEX release_date_index on movies(release_date);
-- Indice para realizar las busquedas por fecha 