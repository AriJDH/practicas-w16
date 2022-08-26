-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”

CREATE TEMPORARY TABLE TWD (
	id INT NOT NULL PRIMARY KEY,
    created_at DATE,
    updated_at DATE,
    title VARCHAR(100) NOT NULL,
    number INT NOT NULL,
    release_date DATE NOT NULL,
    rating DECIMAL(3,1) NOT NULL,
    season_id INT NOT NULL
);
INSERT INTO TWD 
	SELECT id, created_at, updated_at, title, number, release_date, rating, season_id
		FROM episodes as e WHERE id IN (
			SELECT id FROM seasons WHERE serie_id = 3
		);

SELECT * FROM TWD WHERE number = 1;

CREATE INDEX genre_namex ON genres (name);
-- La tabla generos no se actualiza frecuentemente, por lo que decidimos utilizarla para aplicar el indice al nombre del genero, que puede ser una busqueda
-- recurrente.

INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length)
values(NOW(), NOW(), "Top gun: maverick", 10, 0, "2022-06-12", 220);

INSERT INTO genres (created_at, updated_at, name, ranking, active)
VALUES (NOW(), NOW(), "Thriller", 13, 1);

UPDATE movies as m SET genre_id = 13 WHERE m.id = 22;

UPDATE actors as a SET favorite_movie_id = 22 WHERE a.id = 47;

CREATE TEMPORARY TABLE tempMovies (
	`id` int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `title` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `rating` decimal(3,1) unsigned NOT NULL,
  `awards` int(10) unsigned NOT NULL DEFAULT '0',
  `release_date` datetime NOT NULL,
  `length` int(10) unsigned DEFAULT NULL,
  `genre_id` int(10) unsigned DEFAULT NULL
);

INSERT INTO tempMovies SELECT * FROM movies;

SELECT * FROM tempMovies;

DELETE FROM tempMovies as m  WHERE m.awards < 5;

SELECT * FROM genres as g
	INNER JOIN movies as m ON g.id = m.genre_id; -- siempre es mejor hacer el inner join con la tabla con menos datos a la izq.
    
SELECT * FROM actors as a
	WHERE a.id IN (
		SELECT id FROM movies as m
			WHERE m.awards >= 3
        );

CREATE INDEX index_title ON movies(title);

SHOW INDEX FROM movies;
