-- CLIENTES
-- 1
CREATE VIEW view_clientes AS
SELECT ClienteID, Contacto,
CASE
	WHEN NOT Fax = "" THEN Fax
    ELSE CONCAT("TEL: ", Telefono)
    END AS FaxTelefono
FROM clientes;

-- 2
SELECT telefono
FROM clientes
WHERE Fax = "";

-- B)
SELECT *
FROM view_clientes
WHERE FaxTelefono LIKE "TEL:%";

-- PROVEEDORES
-- 1
CREATE VIEW view_proveedores AS
SELECT ProveedorID, Contacto, Compania,CONCAT(Direccion, ', ', Ciudad, ', ', CodigoPostal, ', ', Pais) AS DireccionCompleta
FROM proveedores;

-- 2
SELECT * 
FROM proveedores
WHERE Direccion = "Av. das Americanas 12.890" AND pais = "Brazil";

-- B)
SELECT * FROM view_proveedores
WHERE DireccionCompleta
LIKE "%Americanas%Brazil";

-- PARTE 2
-- 1)
CREATE VIEW view_productos AS
SELECT ProductoID, ProductoNombre, ROUND(PrecioUnitario, 0) as Precio, UnidadesStock, UnidadesPedidas,
 CASE
        WHEN UnidadesPedidas = 0 THEN 'BAJA'
        WHEN UnidadesPedidas < UnidadesStock THEN 'MEDIA'
        WHEN UnidadesPedidas <= (2 * UnidadesStock) THEN 'URGENTE'
        ELSE 'SUPER URGENTE'
    END AS Prioridad
FROM productos;

-- 2)
SELECT Prioridad, COUNT(ProductoID) AS CantidadProductos, AVG(precio) AS PromedioPrecio
FROM view_productos
GROUP BY Prioridad
HAVING COUNT(ProductoID) >= 5;
