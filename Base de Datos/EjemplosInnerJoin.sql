SELECT title, name
FROM series
INNER JOIN genres
ON series.genre_id = genres.id;

SELECT episodes.title, actors.first_name, actors.last_name
FROM actors
INNER JOIN actor_episode 
ON actors.id = actor_episode.actor_id
INNER JOIN episodes
ON episodes.id = actor_episode.episode_id;

SELECT actors.first_name, actors.last_name
FROM actors
INNER JOIN actor_movie ON actors.id = actor_movie.actor_id
INNER JOIN movies ON movies.id = actor_movie.movie_id
WHERE movies.title LIKE "La Guerra de las galaxias%";

SELECT genres.name, COUNT(movies.id)
FROM movies
RIGHT JOIN genres ON genres.id = movies.genre_id
GROUP BY genres.name