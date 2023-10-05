SELECT * 
FROM artista
INNER JOIN artista_x_pelicula ON artista_x_pelicula.artista_id = artista.id
INNER JOIN pelicula ON artista_x_pelicula.pelicula_id = pelicula.id;

SELECT pelicula.id, pelicula.titulo, COUNT(artista_x_pelicula.artista_id) AS cantidad_artistas
FROM pelicula 
INNER JOIN artista_x_pelicula ON artista_x_pelicula.pelicula_id = pelicula.id
INNER JOIN artista ON artista.id = artista_x_pelicula.artista_id
GROUP BY pelicula_id, pelicula.titulo
HAVING COUNT(artista_x_pelicula.artista_id) > 1;

SELECT * 
FROM artista
LEFT JOIN artista_x_pelicula ON artista_x_pelicula.artista_id = artista.id
LEFT JOIN pelicula ON artista_x_pelicula.pelicula_id = pelicula.id;

SELECT *
FROM pelicula 
LEFT JOIN artista_x_pelicula ON artista_x_pelicula.pelicula_id = pelicula.id
LEFT JOIN artista ON artista.id = artista_x_pelicula.artista_id
WHERE artista.id IS NULL;

SELECT * 
FROM artista
LEFT JOIN artista_x_pelicula ON artista_x_pelicula.artista_id = artista.id
LEFT JOIN pelicula ON artista_x_pelicula.pelicula_id = pelicula.id
WHERE pelicula.id IS NULL;

SELECT artista.id, COUNT(artista_x_pelicula.pelicula_id) as Peliculas
FROM artista
LEFT JOIN artista_x_pelicula ON artista_x_pelicula.artista_id = artista.id
LEFT JOIN pelicula ON artista_x_pelicula.pelicula_id = pelicula.id
GROUP BY artista.id
HAVING Peliculas >= 2;

SELECT *
FROM pelicula 
LEFT JOIN artista_x_pelicula ON artista_x_pelicula.pelicula_id = pelicula.id
LEFT JOIN artista ON artista.id = artista_x_pelicula.artista_id;

SELECT genres.name, COUNT(movies.id)
FROM movies
RIGHT JOIN genres ON genres.id = movies.genre_id
GROUP BY genres.name