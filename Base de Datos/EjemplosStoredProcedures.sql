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