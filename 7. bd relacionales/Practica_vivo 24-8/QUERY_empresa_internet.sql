USE empresa_internet;

SELECT * FROM cliente;

SELECT * FROM plan;

SELECT idplan, velocidad_mb FROM plan ORDER BY velocidad_mb;

SELECT * FROM cliente WHERE fecha_nacimiento BETWEEN "1990-01-01" AND "1999-12-31";

SELECT * FROM cliente WHERE provincia = "buenos aires";

SELECT * FROM cliente WHERE provincia LIKE "cordoba";

SELECT * FROM cliente WHERE plan_idplan > 2 LIMIT 2;

SELECT COUNT(*) FROM cliente WHERE plan_idplan = 1;

SELECT MAX(velocidad_mb) FROM plan;
