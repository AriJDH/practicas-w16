Use movies_db;
#EJERCICIO 1
#1.- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD (
serie     varchar(50),
temporada varchar(50),
episodio  varchar(50)
);

#2.- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
#Guardamos los datos de la serie 'The Walking Dead' en la tabla temporal
INSERT INTO TWD
SELECT se.title AS serie, s.title AS temporada, e.title AS episodio
FROM episodes e
INNER JOIN seasons s ON s.id = e.season_id
INNER JOIN series se ON se.id = s.serie_id
WHERE se.title LIKE '%The Walking Dead%';

#Mostramos los episodios de la primera temporada
SELECT *
FROM TWD
WHERE temporada LIKE 'Primer Temporada';

#EJERCICIO 2
#1.- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
CREATE INDEX index_awards
ON movies(awards);

#2.- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
/*Si la base de datos se extrapolara a una situación real o a un ámbito de producción, sería conveniente contar con uno o varios índices
en la tabla de movies, pues en eventos masivos de cine es habitual el análisis de estadísticas actuales e históricas respecto de
películas nominadas o que han recibido premiación, a fin de contar rápidamente con esta data, por ejemplo, durante la emisión
de un programa de TV relacionado con este tema. */