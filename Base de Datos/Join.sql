-- Devuelve los elementos coincidentes entre dos o mas tablas.
SELECT cliente.id, cliente.nombre, factura.fecha
FROM cliente 
INNER JOIN factura
ON cliente.id = factura.cliente_id;

-- Devuelve todos los registros donde se cruzan dos o mas tablas. Incluso los registros de una primera tabla que no cumplan la condicion indicada en el ON.
SELECT cliente.id, cliente.nombre, factura.fecha
FROM cliente 
LEFT JOIN factura
ON cliente.id = factura.cliente_id;

-- Devuelve los registros de una primera tabla excluyendo los registros que cumplan con la condicion indicada en el ON
SELECT cliente.id, cliente.nombre, factura.fecha
FROM cliente 
LEFT JOIN factura
ON cliente.id = factura.cliente_id
WHERE factura.id IS NULL;

-- Devuelve todos los registros donde se cruzan dos o mas tablas. Incluso los registros de una segunda tabla que no cumplan la condicion indicada en el ON.
SELECT cliente.id, cliente.nombre, factura.fecha
FROM cliente 
RIGHT JOIN factura
ON cliente.id = factura.cliente_id;

-- Devuelve los registros de una segunda tabla excluyendo los registros que cumplan con la condicion indicada en el ON.
SELECT cliente.id, cliente.nombre, factura.fecha
FROM cliente 
RIGHT JOIN factura
ON cliente.id = factura.cliente_id
WHERE factura.id IS NULL;
