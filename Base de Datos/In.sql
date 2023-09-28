-- Es el valor que se utiliza para verificar si un valor esta en una lista de valores.
SELECT nombre, apellido
FROM empleados
WHERE id IN (101, 105, 110);