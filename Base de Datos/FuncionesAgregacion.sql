-- Obtienen un dato en conclusion
-- Obtener la cantidad de registros en la tabla
SELECT COUNT(*) 
FROM categorias;
-- Obtener el valor maximo de la columna
SELECT MAX(Transporte) 
FROM facturas;
-- Obtener el valor minimo de la columna
SELECT MIN(Transporte)
FROM facturas;
-- Hacer una sumatoria
SELECT SUM(Transporte) 
FROM facturas;
-- Hacer un Promedio
SELECT AVG(Transporte)
FROM facturas;