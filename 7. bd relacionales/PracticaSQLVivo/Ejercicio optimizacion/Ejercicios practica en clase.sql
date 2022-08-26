# EJercicio 1 VIVO
CREATE TEMPORARY TABLE TWD (
	id INT,
    created_at DATE,
    updated_at DATE,
    title VARCHAR(50),
    number INT,
    release_date DATE,
    rating FLOAT(10,0),
    season_id INT,
    PRIMARY KEY (id)
);

INSERT INTO TWD 
select e.*
from episodes e 
inner join seasons s on e.season_id = s.id
inner join series se on se.id = s.serie_id
where se.title = 'The Walking Dead';

select * from TWD;

# Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT t.* FROM TWD t
INNER JOIN seasons s
ON t.season_id = s.id
WHERE s.number = 1;

# Ejercicio 2 VIVO
# Elijo la tabla 'movies' ya que considero que la frecuencia de actualizacion es muy baja
# Y además es bastante accedida/leida por ser utilizada como foreign key en varias tablas
SHOW INDEX FROM movies;

CREATE INDEX idMovie ON movies (id);