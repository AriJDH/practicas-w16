-- ejercicio movie 
drop table TWD;
Create temporary table TWD(
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `title` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `number` int(10) unsigned DEFAULT NULL,
  `release_date` datetime ,
  `rating` decimal(3,1) NOT NULL,
  `season_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `episodes_season_id_foreign` (`season_id`));
  
  	-- traer los datos de la tabla
  insert into TWD SELECT e.id, e.created_at,e.updated_at,e.title,e.number,e.release_date,e.rating,e.season_id from series as s 
  left join seasons as se on s.id = se.serie_id 
  left join episodes as e on se.id = e.season_id 
  where s.id =3 and e.id is NOT NULL;
  
  -- consulta
  select * from TWD where season_id=20;
-- limpiar la tabla
  delete from TWD where id<>0;

ALTER TABLE `movies_db`.`password_resets` 
ADD INDEX `indice_email` (`email` ASC) VISIBLE;


-- practica 2
-- 1
select * from movies;
INSERT INTO `movies` VALUES (22,NULL,NULL,'Ex-Machina',8.9,0,'2022-06-04 00:00:00',120,5);
-- 2
select * from genres;
  INSERT INTO `movies_db`.`genres`
(`id`,
`created_at`,
`updated_at`,
`name`,
`ranking`,
`active`)
VALUES
(14,
'2020-08-08',
null,
'Shonnen',
100,
1);
-- 3
select * from genres;
update movies
	set genre_id = 14
    where id = 22;
-- 4
select * from actors;
update actors
	set favorite_movie_id = 22
    where id =3;
    
-- 5    
Create temporary table tempMovies (`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `title` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `rating` decimal(3,1) unsigned NOT NULL,
  `awards` int(10) unsigned NOT NULL DEFAULT '0',
  `release_date` datetime NOT NULL,
  `length` int(10) unsigned DEFAULT NULL,
  `genre_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `movies_genre_id_foreign` (`genre_id`));
  
  Insert into tempMovies SELECT * from movies;
  -- 6
  delete from tempMovies where awards<5 and id <> 0;
  
  select * from tempMovies;
  
-- 7
select count(m.genre_id) as numero_peliculas,g.name from movies as m  right join genres as g on m.genre_id = g.id group by g.name having numero_peliculas >0;
-- 8
select a.first_name,a.last_name from actors as a left join movies as m on a.favorite_movie_id=m.id where m.awards>3; 

-- 9
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `movies_name` (`title` ASC) VISIBLE;
;

-- 10
describe movies;

-- 11 existe una mejoria al agregar index  ya que se puede trackear de mejora manera los cambios y el seguimiento de cambios, esto va de la mano con la pregunta 12
-- 12 en la tabla password_reset agregar un index del email, para consultar cuantas veces un suaurio cambia la contrasena