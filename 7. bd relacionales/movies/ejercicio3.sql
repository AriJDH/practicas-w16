select * from movies;

select first_name, last_name, rating from actors;

select title as Titulo from series as Series;

select first_name, last_name 
from actors 
where rating > 7.5;

select title, rating, awards 
from movies
where rating > 7.5 and awards > 1;

select title, rating 
from movies
order by rating asc;

select title
from movies
limit 3;

select title, rating 
from movies
order by rating desc
limit 5;

select *
from actors
limit 10;

select title, rating 
from movies
where title like 'Toy Story';

select *
from actors
where first_name like 'Sam';

select title, release_date 
from movies 
where release_date between '2004/01/01' AND '2008/12/31';

select title 
from movies 
where rating > 3 and awards > 1 and release_date between '2004/01/01' and '2008/12/31' order by rating;

