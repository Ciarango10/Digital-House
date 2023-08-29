SELECT id as "Numero de Autor", apellido, nombre, email 
FROM autores
WHERE nombre LIKE "a%";

SELECT nombre, apellido, password 
FROM usuario
WHERE telefono_movil = "5492645661478";

SELECT *
FROM articulos
WHERE estadoart = 1;

SELECT * 
FROM recursos
WHERE articulos_id IN (8,16,29,35);

SELECT fechapublicacion, titulo
FROM articulos
WHERE id = 1;

SELECT nombre_recurso, ruta
FROM recursos
WHERE tiposrecursos_id = 1;

SELECT * 
FROM usuario
WHERE ciudad_id != 6 AND (fecha_nacimiento >= "1989-09-03" OR fecha_nacimiento = "1986-11-07")
ORDER BY fecha_nacimiento ASC;

SELECT * 
FROM articulos
WHERE subcategorias_id = 1 AND (fechalta > "2021-09-05" OR fechalta = "2021-06-25")
ORDER BY fechalta;

SELECT Cometario, Fecha
FROM comentarios
WHERE Cometario LIKE "%Gracias%" AND Fecha LIKE "20%-10-%";

SELECT titulo, contenido, fechapublicacion
FROM articulos
WHERE autores_id = 13
ORDER BY fechapublicacion DESC
LIMIT 1;

SELECT *
FROM comentarios
WHERE Fecha >= "2021-07-14" and Fecha < "2022-08-15" 
ORDER BY Fecha;

SELECT apellido,nombre,telefono_movil
FROM autores
WHERE nombre LIKE  "%ia";

SELECT COUNT(*) 
FROM articulos
WHERE fechapublicacion LIKE "2021%";

SELECT *
FROM articulos
WHERE fechapublicacion LIKE "2022%"
ORDER BY fechapublicacion
LIMIT 1
OFFSET 4;

SELECT DATEDIFF(NOW(), '2019-03-03') AS DiasTranscurridos
FROM articulos;

SELECT * 
FROM ciudad
WHERE nombre LIKE "__n__";


UPDATE categorias
SET nombre_categoria = "Cultura"
WHERE nombre_categoria = "Cultura y arte";
SELECT * FROM Categorias;

SELECT nombre_categoria
FROM categorias
WHERE estado_categoria = 0;	

INSERT INTO usuario(nombre,apellido,usuario,password,ciudad_id,fecha_nacimiento,telefono_movil,email)
VALUES("Omar Cuyo","Aznar Ricardo","rica28","az123",4,"1980-01-05","542645667714","pal1980sj@gmail.com");

DELETE FROM categorias
WHERE id = 8;








