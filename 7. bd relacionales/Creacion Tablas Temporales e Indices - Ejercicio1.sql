CREATE TEMPORARY TABLE TWD (serieTitle varchar(40), seasonTitle varchar(40) ,episodioTitle varchar(40), episodioNumber int);

DROP TABLE TWD;

INSERT INTO TWD SELECT s.title, sea.title, e.title, e.number FROM movies_db.series s join movies_db.seasons sea on s.id = sea.serie_id join movies_db.episodes e on e.season_id = sea.id 
where s.title like "The Walking Dead";

SELECT * FROM TWD WHERE serieTitle = "The Walking Dead";