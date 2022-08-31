
CREATE TEMPORARY TABLE TWD (
	select s.title as Serie, se.title as Temporada, e.title as Episodios
	from episodes e
	inner join seasons se on e.season_id = sPRIMARYPRIMARYseries_genre_id_foreigne.id
	inner join series s on se.serie_id = s.id
	where s.title like "The Walking Dead");


   explain select * from series where title like "The Walking Dead";


   select * from movies;
   select * from genres;

   insert into movies(title,rating,awards,release_date,length,genre_id)
   values("El señor de los anillos",10.0,15,"2010-10-03",300,5);

   insert into genres(name,ranking,active)
   values("Tragi Comedia",90,1);

   update movies set genre_id=16
   where  title like "El señor de los anillos";

   select * from movies where title like "El señor de los anillos";

   select * from actors ;

   update actors
   set favorite_movie_id=22
   where first_name like "Sam";

   create temporary table copy_movies
   select* from movies;

   select * from copy_movies;

   delete from copy_movies
   where awards<5;

   select distinct genre_id,genres.name movies from genres
   inner join movies on genre_id=genres.id;

   select first_name,last_name from actors inner join
   movies on favorite_movie_id=movies.id
   where movies.awards>3;

   create index title_index on movies (title);


   show index from movies
