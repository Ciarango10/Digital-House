SELECT * FROM canciones;

-- 10 primeros caracteres de la cancion en mayuscula
SELECT UPPER(SUBSTRING(nombre, 1, 10)) as Cancion
FROM canciones;

-- Años de antiguedad desde su publicacion
SELECT fecha_nacimiento,
TIMESTAMPDIFF(YEAR, fecha_nacimiento, CURDATE()) AS Edad
FROM empleados;

-- Peso en KBytes sin decimales
SELECT bytes,
CONCAT(FLOOR(bytes / 1024), ' kb') AS KBYTES -- FLOOR(), redoondea hacia abajo
FROM canciones;

SELECT bytes,
CONCAT(CEILING(bytes / 1024), ' kb') AS KBYTES -- CEILING(), redoondea hacia abajo
FROM canciones;

-- Precio formateado en 3 decimales
SELECT precio_unitario,
FORMAT(precio_unitario, 3) AS Precio
FROM canciones;

-- El primer compositor de la cancion(notar que hay mas de uno, separados por coma)
SELECT compositor,
SUBSTRING_INDEX(compositor, ',', 1) AS Compositor
FROM canciones;


