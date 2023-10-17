-- CONCAT()
-- Concatena las columnas
SELECT CONCAT(first_name, " ", last_name) as nombre_completo
FROM actors;

-- COALESCE()
-- Si el valor en ambas columnas es nulo, se muestra el texto 'Sin Datos'
SELECT id, apellido, nombre, COALESCE(telefono_movil, telefono_fijo, "Sin Datos") as telefono
FROM cliente;

-- DATEDIFF()
-- Nos muestra los dias de diferencia entre fechas
SELECT DATEDIFF("2021-02-03", "2021-01-01");

-- TIMEDIFF()
-- Nos muestra la hora, min, segundos de diferencia entre fechas
-- El primer valor debe ser el mas reciente o mayor, y el segundo el mas antiguo o menor
SELECT TIMEDIFF("2021-01-01 12:45:00", "2021-01-01 07:45:10");
SELECT TIMEDIFF("18:45:00", "12:30:00");

-- EXTRACT() 
-- Extrae componentes de una fecha(Seg, Min, Hora, Dia, Semana, Mes, Año)
SELECT EXTRACT(SECOND FROM "2014-02-13 08:44:21");
SELECT EXTRACT(MINUTE FROM "2014-02-13 08:44:21");
SELECT EXTRACT(HOUR FROM "2014-02-13 08:44:21");
SELECT EXTRACT(DAY FROM "2014-02-13 08:44:21");
SELECT EXTRACT(WEEK FROM "2014-02-13 08:44:21");
SELECT EXTRACT(MONTH FROM "2014-02-13 08:44:21");
SELECT EXTRACT(QUARTER FROM "2014-06-13 08:44:21");
SELECT EXTRACT(YEAR FROM "2014-02-13 08:44:21");

-- REPLACE()
-- Reemplaza los valores de una columna (Columna, <Campo a reemplazar>, <Nuevo valor>)
SELECT REPLACE("Buenas tardes", "tardes", "noches");
SELECT REPLACE("Buenas tardes", "a", "A");

-- DATE_FORMAT()
-- Da formato a las fechas
SELECT DATE_FORMAT("2017-06-15","%Y");
SELECT DATE_FORMAT("2017-06-15","%W %M %e %Y");

-- DATE_ADD()
-- Agrega una cantidad específica de tiempo a una fecha o marca de tiempo existente
SELECT DATE_ADD("2021-06-30",INTERVAL "3" DAY);
SELECT DATE_ADD("2021-06-30",INTERVAL "9" MONTH);
SELECT DATE_ADD("2021-06-30 09:30:00",INTERVAL "4" HOUR);

-- DATE_SUB()
-- Resta una cantidad específica de tiempo a una fecha o marca de tiempo existente
SELECT DATE_SUB("2021-06-30", INTERVAL "3" DAY);
SELECT DATE_SUB("2021-06-30", INTERVAL "9" MONTH);
SELECT DATE_SUB("2021-06-30 09:30:00", INTERVAL "4" HOUR);

-- CASE
SELECT id, titulo, rating,
	CASE
		WHEN rating < 4 THEN "Mala"
        WHEN rating BETWEEN 4 AND 6 THEN "Regular"
        WHEN rating BETWEEN 7 AND 9 THEN "Buena"
        ELSE "Excelente"
	END AS calificacion
FROM pelicula;