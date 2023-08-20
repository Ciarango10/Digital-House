-- Cumple la misma funcion que el where a diferencia de que este permite la implementacion
-- de alias y funciones de agregacion
SELECT titulo, COUNT(*)
FROM clientes
GROUP BY titulo
HAVING COUNT(*) >=3;