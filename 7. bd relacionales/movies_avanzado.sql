SELECT title, genre.name FROM series INNER JOIN genres
ON series.genre_id = genres.id