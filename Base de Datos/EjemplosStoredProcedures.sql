-- 1)
DELIMITER $$
CREATE PROCEDURE sp_informacion_clientes (IN p_pais VARCHAR(50), IN p_ciudad VARCHAR(50))
BEGIN 
	 IF p_ciudad = '' THEN
        SELECT * FROM clientes WHERE pais = p_pais;
    ELSE
        SELECT * FROM clientes WHERE pais = p_pais AND ciudad = p_ciudad;
    END IF;
END $$
CALL sp_informacion_clientes("Brazil","Brasilia");
CALL sp_informacion_clientes('Brazil', '');

-- 2)
DELIMITER $$
CREATE PROCEDURE sp_informacion_generos (IN nombre VARCHAR(50), OUT nuevo_id INT)
BEGIN 
	SET nuevo_id = (SELECT MAX(id) FROM generos) + 1;
	INSERT INTO generos (id,nombre) VALUES (nuevo_id,nombre);
END $$
CALL sp_informacion_generos("Bachata", @id_genero);
SELECT @id_genero;

-- E-MARKET
-- 1)
DELIMITER $$
CREATE PROCEDURE sp_informacion_empleados () 
BEGIN 
	SELECT Apellido, Nombre
    FROM empleados
    ORDER BY nombre, apellido;
END $$
CALL sp_informacion_empleados();

-- 2)
DELIMITER $$
CREATE PROCEDURE sp_ciudad_empleados(IN city VARCHAR(50))
BEGIN
	SELECT * 
    FROM empleados
    WHERE ciudad = city;
END $$
CALL sp_ciudad_empleados("Seattle");

-- 3) 
DELIMITER $$
CREATE PROCEDURE sp_pais_clientes(IN country VARCHAR(50))
BEGIN
	SELECT *
    FROM clientes
    WHERE pais = country;
END $$
CALL sp_pais_clientes("Mexico");

-- 4)
-- a)
DELIMITER $$
CREATE PROCEDURE sp_productos (IN numero int)
BEGIN 
	SELECT p.ProductoNombre, p.UnidadesStock, c.CategoriaNombre
    FROM productos p 
	INNER JOIN categorias c ON c.CategoriaID = p.CategoriaID
    WHERE p.UnidadesStock < numero;
END $$
CALL sp_productos(15);

-- b)
DELIMITER $$
CREATE PROCEDURE sp_productos_stock_bajo ()
BEGIN 
	SELECT *
    FROM productos
    WHERE UnidadesStock < 10;
END $$
CALL sp_productos_stock_bajo();

-- c)
DELIMITER $$
CREATE PROCEDURE sp_productos_sin_stock ()
BEGIN 
	SELECT *
    FROM productos
    WHERE UnidadesStock = 0 ;
END $$
CALL sp_productos_sin_stock();

-- 5)
-- a)
DELIMITER $$
CREATE PROCEDURE sp_ventas_descuento(IN porcentaje DOUBLE)
BEGIN
	SELECT p.ProductoNombre, c.Contacto
    FROM productos p 
    INNER JOIN facturadetalle fd ON fd.ProductoID = p.ProductoID
    INNER JOIN facturas f ON f.FacturaID = fd.FacturaID
    INNER JOIN clientes c ON c.ClienteID = f.ClienteID
    WHERE fd.Descuento >= porcentaje ;
END $$
CALL sp_ventas_descuento(0.2);

-- b)
DELIMITER $$
CREATE PROCEDURE sp_ventas_descuento_mayor()
BEGIN
	SELECT *
    FROM productos p 
    INNER JOIN facturadetalle fd ON fd.ProductoID = p.ProductoID
    WHERE fd.Descuento > 0.10 ;
END $$
CALL sp_ventas_descuento_mayor()