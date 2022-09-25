USE movies_db;

DESCRIBE  movies_db.episodes ;
#Creación tablas tmp e indices

#Ejercicio 1: temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD
SELECT 	c.id
		,c.created_at
		,c.updated_at
		,c.title
		,c.number
		,c.release_date
		,c.rating
		,c.season_id
FROM movies_db.series serie
INNER JOIN movies_db.seasons seasons on serie.id = seasons.serie_id
INNER JOIN movies_db.episodes c on seasons.id = c.season_id
WHERE serie.id = 3;

SELECT * 
FROM TWD;

DESCRIBE TWD;


#EJERCICIO 2:

SHOW INDEX FROM movies_db.episodes;

SELECT * FROM movies_db.episodes;
EXPLAIN SELECT * FROM movies_db.episodes;
SELECT * FROM movies_db.episodes WHERE title = 'PILOT';
EXPLAIN SELECT * FROM movies_db.episodes WHERE title = 'PILOT';
#Viendo el explain, en la consulta se recorren todos los registros del título de episodios, al consultar por episodio sería conveniente tener un index que genere una optimización de la consulta
#Se crea el indice
ALTER TABLE movies_db.episodes 
ADD INDEX titleIdx (title);
#Al revisar el explain se optimiza el nombre de cada episodio lo que ayuda a que esas consultas frecuentes estén optimizadas
EXPLAIN SELECT * FROM movies_db.episodes WHERE title = 'PILOT';

#también se puede indexar el campo rating de la misma tabla ya que es frecuente consultar el rating
EXPLAIN SELECT * FROM movies_db.episodes WHERE rating > 9;

#Se crea el indice
ALTER TABLE movies_db.episodes 
ADD INDEX ratingIdx (rating);

EXPLAIN SELECT * FROM movies_db.episodes WHERE rating > 9;