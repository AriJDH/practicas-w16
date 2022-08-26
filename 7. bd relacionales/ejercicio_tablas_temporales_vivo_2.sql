insert into movies (title,rating,awards,release_date,length,genre_id) values ('El hombre gris', 9.9,5, now(),150, 4);

insert into genres (created_at,name,ranking,active) values (now(),'Anime',13,1);

update movies m set genre_id = 13 where m.id = 22;

update actors set favorite_movie_id = 22 where id = 30;

create temporary table movies_copy Select * from movies;

select * from movies_copy;

delete from movies_copy mc where mc.id in (select id from movies where awards < 5);

select g.name, count(m.genre_id) as cantidad from movies m
	inner join genres g on m.genre_id = g.id group by g.name;

select a.first_name from actors a 
	inner join movies m on m.id = a.favorite_movie_id
    where m.awards > 3;

alter table movies add index index_awards (awards);

show index from movies;

-- Se creo un indice en awards para la mejora de consultas a travez de awards para las consultas y para que el motor no compare 1 x 1 las filas

-- Se creo index en la tabla de movies con el index rating para encontrar de forma mas eficiente las peliculas con mas rating 