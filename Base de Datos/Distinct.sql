SELECT DISTINCT actor.nombre, actor.apellido
FROM actor
INNER JOIN actor_pelicula
ON actor_pelicula.actor_id = actor.id
INNER JOIN pelicula
ON pelicula.id = actor_pelicula.pelicula_id
WHERE pelicula.titulo LIKE "%Harry Potter%"