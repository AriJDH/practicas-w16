use movies_db;


INSERT into movies values
(null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Rambo 3', 10.0, 10, '1988-08-20',120 , null);



INSERT INTO genres values (null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Nacionales', 13, 1);


UPDATE movies set genre_id=13
where id=22;


UPDATE actors set favorite_movie_id=13
where id=4;


CREATE TEMPORARY TABLE movies_tmp SELECT * FROM movies;

.
DELETE FROM movies_tmp where awards < 5;


SELECT distinct g.* FROM genres g 
left join movies m on m.genre_id=g.id;


SELECT a.* from actors a 
inner join movies m on a.favorite_movie_id = m.id
WHERE m.awards > 3;


create index title_index on movies(title);


show index from movies
where key_name = 'title_index';