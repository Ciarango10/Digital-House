SELECT cliente.id, cliente.nombre, factura.fecha
FROM cliente 
INNER JOIN factura
ON cliente.id = factura.cliente_id;

SELECT cliente.id, cliente.nombre, factura.fecha
FROM cliente 
LEFT JOIN factura
ON cliente.id = factura.cliente_id;

SELECT cliente.id, cliente.nombre, factura.fecha
FROM cliente 
RIGHT JOIN factura
ON cliente.id = factura.cliente_id;