SELECT * FROM seguros_db.vehiculos;

SELECT v.patente FROM seguros_db.vehiculos v where v.cantidad_ruedas>4 AND date_part('year', (SELECT current_timestamp)) = date_part('year',v.anio_fabricacion);