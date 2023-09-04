SELECT nombre,
CASE
	WHEN edoCivil = 1 THEN 'Soltero'
    WHEN edoCivil = 2 THEN 'Casado'
    WHEN edoCivil = 3 THEN 'Separado'
    ELSE 'No hay dato'
END AS Estado
FROM empleados;