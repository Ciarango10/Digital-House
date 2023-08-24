SELECT clientes.id as id, clientes.nombre, ventas.fecha
FROM clientes,ventas
WHERE clientes.id = ventas.cliente_id