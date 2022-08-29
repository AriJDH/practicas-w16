CREATE TEMPORARY TABLE TWD (id INT, created_at TIMESTAMP, updated_at TIMESTAMP, title VARCHAR(500), number INT, release_date DATETIME, rating DECIMAL(3,1), season_id INT);

INSERT INTO TWD SELECT e.* 
FROM series s 
INNER JOIN seasons se ON se.serie_id = s.id
INNER JOIN episodes e ON e.season_id = se.id
WHERE s.title LIKE '%The Walking Dead%';

SELECT * FROM TWD;