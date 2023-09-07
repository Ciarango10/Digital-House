-- Camada: C4
-- Grupo: 13
-- Nombres: Armando Lopez, Alexander Machicado, Carlos Arango, Enrique Palomino

-- 1 pregunta
-- SELECT COUNT(A.id) AS CANT_ARTICULOS, A.autores_id, AU.nombre, AU.apellido FROM articulos A 
-- INNER JOIN autores AU ON A.autores_id=AU.id 
-- GROUP BY A.autores_id
-- HAVING CANT_ARTICULOS>10;
-- Devuelve 4 registros

-- 2 pregunta
-- SELECT CONCAT(UPPER(apellido), ', ', UPPER(nombre)) AS "Autor sin publicacion" 
-- FROM autores 
-- LEFT JOIN articulos ON autores.id = articulos.autores_id 
-- WHERE articulos.id IS NULL;
-- Devuelve 29 registros

-- 3 pregunta
-- SELECT autores.nombre, autores.apellido, articulos.titulo, articulos.fechapublicacion, ciudad.nombre, pais.nombre FROM autores
-- INNER JOIN ciudad ON autores.ciudad_id = ciudad.id
-- INNER JOIN pais ON pais.id = ciudad.pais_id
-- INNER JOIN articulos ON articulos.autores_id = autores.id
-- WHERE pais.id = 1;
-- Devuelve 62 registros

-- 4 pregunta 
-- SELECT DISTINCT autores.nombre, autores.apellido
-- FROM autores
-- JOIN articulos ON autores.id = articulos.autores_id
-- WHERE articulos.estadoart = 0
  -- AND SUBSTRING(autores.apellido, 2, 1) = 'a';
-- Devuelve 5 registros

-- 5 pregunta
-- SELECT COUNT(A.id), P.nombre AS CANT_AUTORES FROM autores A
-- INNER JOIN ciudad C ON A.ciudad_id=C.id
-- RIGHT JOIN pais P ON C.pais_id=P.id
-- GROUP BY P.id;
-- Devuelve 20 registros

-- 6 pregunta
-- SELECT usuario.nombre, usuario.apellido, articulos.titulo, comentarios.cometario, comentarios.fecha
-- FROM comentarios
-- JOIN usuario ON comentarios.usuario_id=usuario.id
-- JOIN articulos ON comentarios.articulos_id=articulos.id
-- WHERE comentarios.cometario LIKE '%muy bueno%';
-- Devuelve 3 registros

-- 7 pregunta
-- SELECT A.nombre, A.apellido, E.nombre AS ESPECIALIDAD FROM autores A
-- INNER JOIN especialidad_x_autores EXA ON A.id =EXA.autores_id
-- INNER JOIN especialidad E ON E.id=EXA.especialidad_id
-- WHERE A.nombre LIKE "Guillermina Lucia" AND A.apellido LIKE "Martin"
-- Devuelve 4 registros

-- 8 pregunta
-- SELECT pais.nombre, COUNT(autores.id) as Cantidad FROM autores
-- INNER JOIN ciudad ON autores.ciudad_id = ciudad.id
-- INNER JOIN pais ON pais.id = ciudad.pais_id
-- LEFT JOIN especialidad_x_autores ON especialidad_x_autores.autores_id = autores.id
-- LEFT JOIN especialidad ON especialidad.id = especialidad_x_autores.especialidad_id
-- WHERE especialidad.id IS NULL
-- GROUP BY pais.id;
-- Retorna 3 registros

-- 9 pregunta
-- SELECT COUNT(AR.id) AS CANT_ARTICULOS, A.nombre, A.apellido, C.nombre AS CIUDAD, P.nombre AS PAIS, AR.estadoart FROM autores A 
-- INNER JOIN articulos AR ON A.id=AR.autores_id
-- INNER JOIN ciudad C ON C.id=A.ciudad_id
-- INNER JOIN pais P ON P.id=C.pais_id
-- GROUP BY A.id, AR.estadoart
-- HAVING AR.estadoart = 1
-- ORDER BY CANT_ARTICULOS DESC
-- LIMIT 2,1;
-- Retorna 1 registro

-- 10 pregunta
-- SELECT categorias.nombre_categoria AS "Nombre de la categoria", COUNT(articulos.id) AS "Cantidad de articulos"
-- FROM categorias
-- INNER JOIN subcategorias ON categorias.id = subcategorias.categorias_id
-- INNER JOIN articulos ON subcategorias.id = articulos.subcategorias_id
-- WHERE articulos.estadoart = 0
-- GROUP BY categorias.nombre_categoria;
-- Devuelve 8 registros

-- 11 pregunta
-- SELECT autores.nombre, autores.apellido,
-- CASE
	-- WHEN COUNT(articulos.autores_id) = 1 THEN "tiene solo un artículo publicado"
    -- WHEN COUNT(articulos.autores_id) = 2 THEN "tiene dos artículos publicados"
    -- WHEN COUNT(articulos.autores_id) > 2 THEN "tiene más de dos artículos publicados"
    -- ELSE "no publicó ningún artículo"
-- END AS mensaje
-- FROM autores
-- LEFT JOIN articulos ON articulos.autores_id = autores.id
-- GROUP BY  autores.id, autores.nombre, autores.apellido;
-- Devuelve 50 registros

-- 12 pregunta
-- SELECT COUNT(R.id) AS CANT_RECURSOS FROM articulos AR
-- INNER JOIN recursos R ON R.articulos_id=AR.id
-- WHERE AR.estadoart=1 AND YEAR(AR.fechapublicacion)=2022;
-- Devuelve 31 registros

-- 13 pregunta
-- SELECT autores.nombre, autores.apellido, COUNT(especialidad.id) as NroEspecialidades
-- FROM autores
-- INNER JOIN especialidad_x_autores ON especialidad_x_autores.autores_id = autores.id
-- INNER JOIN especialidad ON especialidad_x_autores.especialidad_id = especialidad.id
-- GROUP BY  autores.id, autores.nombre, autores.apellido
-- HAVING COUNT(especialidad.id) = 3;
-- Devuelve 3 registros

-- 14 pregunta
-- SELECT A.usuario, A.email, P.nombre AS PAIS,
 -- CASE 
 -- WHEN AR.estadoart=0 THEN "NO PUBLICADO"
 -- ELSE "PUBLICADO"
 -- END AS ESTADO_ARTICULO,
-- COUNT(AR.id) AS CANT_ARTICULOS FROM articulos AR 
-- INNER JOIN autores A ON A.id=AR.autores_id
-- INNER JOIN ciudad C ON C.id=A.ciudad_id
-- INNER JOIN pais P ON P.id = C.pais_id
-- GROUP BY A.ID, AR.estadoart
-- HAVING AR.estadoart=0
-- Devuelve 14 registros

-- 15 pregunta
-- SELECT usuario.apellido, usuario.nombre, TIMESTAMPDIFF(YEAR, usuario.fecha_nacimiento, CURDATE()) AS edad,
-- CASE
	-- WHEN TIMESTAMPDIFF(YEAR, usuario.fecha_nacimiento, CURDATE()) <= 35 THEN "Junior"
    -- WHEN TIMESTAMPDIFF(YEAR, usuario.fecha_nacimiento, CURDATE()) BETWEEN 36 AND 40 THEN "Semi-senior"
    -- ELSE "Senior"
-- END AS categoria
-- FROM usuario 
-- ORDER BY edad DESC, categoria DESC;
-- Devuelve 25 registros

-- 16 pregunta
-- SELECT usuario.email, comentarios.cometario, ciudad.nombre
-- FROM usuario
-- JOIN comentarios ON usuario.id = comentarios.usuario_id
-- JOIN ciudad ON usuario.ciudad_id = ciudad.id
-- WHERE ciudad.nombre != 'Monroe - Buenos Aires'
	-- AND YEAR(comentarios.Fecha) BETWEEN 2019 AND 2020
-- ORDER BY comentarios.Fecha;
-- Devuelve 5 registros


-- 17 pregunta
-- SELECT usuario.nombre, usuario.apellido, pais.nombre FROM usuario
-- INNER JOIN comentarios ON comentarios.usuario_id = usuario.id
-- INNER JOIN ciudad ON usuario.ciudad_id = ciudad.id
-- INNER JOIN pais ON pais.id = ciudad.pais_id
-- GROUP BY usuario.id	
-- HAVING COUNT(comentarios.usuario_id)
-- ORDER BY COUNT(comentarios.usuario_id) DESC
-- LIMIT 5;
-- Devuelve 5 registros

-- 18 pregunta
-- SELECT R.nombre_recurso, A.fechalta FROM recursos R
-- INNER JOIN tiposrecursos TR ON R.tiposrecursos_id=TR.id
-- INNER JOIN articulos A ON A.id=R.articulos_id
-- INNER JOIN subcategorias SC ON SC.id=A.subcategorias_id
-- WHERE TR.TiposRecursos="audio" 
-- AND R.ruta LIKE "%.mp3%"
-- AND MONTH(A.fechalta) = 10;
-- Devuelve 1 registro

-- 19 pregunta
-- SELECT usuario.nombre, usuario.apellido, ciudad.nombre, pais.nombre, comentarios.Cometario FROM usuario
-- INNER JOIN comentarios ON comentarios.usuario_id = usuario.id
-- INNER JOIN ciudad ON usuario.ciudad_id = ciudad.id
-- INNER JOIN pais ON pais.id = ciudad.pais_id
-- WHERE TIMESTAMPDIFF(YEAR, usuario.fecha_nacimiento, CURDATE()) BETWEEN 36 AND 40;
-- Devuelve 15 registros

-- 20 pregunta
-- SELECT usuario.nombre, usuario.apellido, ciudad.nombre
-- FROM usuario
-- JOIN ciudad ON usuario.ciudad_id = ciudad.id
-- WHERE usuario.fecha_nacimiento > '1989-02-12' OR usuario.fecha_nacimiento >= '1979-12-17'
-- ORDER BY usuario.fecha_nacimiento ASC;
-- Devuelve 20 registros