-- REPORTES PARTE 1
SELECT first_name as Nombre, last_name as Apellido
FROM actor
LIMIT 5;

SELECT first_name as Nombre, last_name as Apellido, email as Correo
FROM customer
WHERE active = 0;

SELECT title as Titulo, release_year as Año, description as Descripcion
FROM film
WHERE rental_duration > 5
ORDER BY rental_duration DESC;

SELECT * 
FROM rental
WHERE rental_date like "2005-05-%";

-- REPORTES PARTE 2
SELECT COUNT(rental_id) as Cantidad
FROM rental;

SELECT SUM(amount) as Total, COUNT(*) as Cantidad, AVG(amount) as 'Importe Promedio'
FROM payment;

SELECT
    customer.customer_id,
    COUNT(rental.customer_id) AS rental_count,
    SUM(payment.amount) AS total_payment_amount
FROM customer
JOIN payment ON customer.customer_id = payment.customer_id
JOIN rental ON payment.rental_id = rental.rental_id
GROUP BY customer.customer_id
ORDER BY total_payment_amount DESC
LIMIT 10;

SELECT
    customer.customer_id,
    COUNT(rental.customer_id) as CantidadAlquileres,
    SUM(payment.amount) as MontoTotal
FROM customer
JOIN rental ON rental.customer_id = customer.customer_id
JOIN payment ON payment.customer_id = customer.customer_id
GROUP BY customer.customer_id
HAVING MontoTotal > 150;

SELECT COUNT(*),SUM(payment.amount) as SumaTotal
FROM rental
JOIN payment ON payment.rental_id = rental.rental_id
GROUP BY rental_date
HAVING rental_date LIKE "2005-%-%"


