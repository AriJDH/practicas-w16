SELECT *
FROM movies
WHERE release_date BETWEEN '1988-01-01' AND '2009-12-31'
AND awards >= 1
AND rating >= 3
ORDER BY rating ASC;