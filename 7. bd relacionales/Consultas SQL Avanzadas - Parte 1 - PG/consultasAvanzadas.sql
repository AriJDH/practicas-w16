select S.title, G.name
from series as S
inner join genres as G where G.id = S.genre_id;

select E.title, A.first_name, A.last_name
from episodes as E
join actor_episode as AE on AE.episode_id = E.id
join actors as A on a.id = AE.actor_id;

select S.title, count(SA.id)as seasons
from series as S
join seasons as SA on SA.serie_id = S.id
group by S.id;

select G.name, count(*) as total_movies
from genres as G
join movies as M on m.genre_id = G.id
group by M.id
having total_movies > 3;

select distinct A.first_name, A.last_name
from actors as A
left join actor_movie as AE on AE.actor_id = A.id
join movies as M on M.id = AE.movie_id
where M.title like "La Guerra de las galaxias%";
