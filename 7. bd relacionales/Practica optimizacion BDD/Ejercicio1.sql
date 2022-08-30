CREATE TEMPORARY TABLE TWD SELECT e.* 
FROM episodes e
INNER JOIN seasons s ON e.season_id = s.id
INNER JOIN series ss ON ss.id = s.serie_id
WHERE ss.id = 3;

SELECT * from TWD where season_id = 20;

CREATE INDEX release_date_index on movies(release_date);