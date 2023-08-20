-- Se usa para agrupar los registros de la tabla, 
-- resultante de una consulta por una o mas columnas.
SELECT titulo, COUNT(*)
FROM clientes
GROUP BY titulo;