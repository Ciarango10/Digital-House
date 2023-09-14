-- Crear Stored Procedure
DELIMITER $$
CREATE PROCEDURE sp_nombre_procedimiento(IN id_usuario INT, OUT salario FLOAT, INOUT aumento FLOAT) -- IN: Entrada de datos, recibir valores. OUT: Entrada de salidad de datos devolver valores, INOUT: Ambas, entrada y salida de datos en la misma variable
BEGIN
	-- Bloque de instrucciones
    DECLARE bono FLOAT DEFAULT 1000.00; -- Declaracion de Variables
    SET bono = 2000.00; -- Asignacion de Variables
    SET aumento = aumento + 25700.00;
END $$

-- Ejecucion
SET @salario = 2000.00; -- Declaracion y asignacion de Variables
CALL sp_nombre_procedimiento(11, @salario, @salario); -- Llamar al stored procedure
SELECT @salario; -- Muestra el resultado

-- Eliminar 
DROP PROCEDURE IF EXISTS sp_nombre_procedimiento;

-- DDL---------------------------------------------------------------------
-- CREATE TABLE
DELIMITER $$
CREATE PROCEDURE sp_crear_tabla()
BEGIN 
	CREATE TABLE nombre_tabla (
		id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
        descripcion VARCHAR(200)
	);
END $$
CALL sp_crear_tabla();

-- ALTER TABLE
DELIMITER $$
CREATE PROCEDURE sp_modificar_tabla()
BEGIN 
	ALTER TABLE nombre_tabla ADD COLUMN campo VARCHAR(50) NOT NULL;
END $$
CALL sp_modificar_tabla();

-- DROP TABLE
DELIMITER $$
CREATE PROCEDURE sp_eliminar_tabla()
BEGIN
	DROP TABLE IF EXISTS nombre_tabla;
END $$
CALL sp_eliminar_tabla();

-- DML---------------------------------------------------------------------
-- INSERT
DELIMITER $$ 
CREATE PROCEDURE sp_agregar_usuario(IN nombre VARCHAR(30), IN apellido VARCHAR(30))
BEGIN 
	INSERT INTO actor (first_name, last_name) VALUES (nombre, apellido);
END $$
CALL sp_agregar_usuario("CARLOS", "ARANGO");

-- UPDATE
DELIMITER $$ 
CREATE PROCEDURE sp_modificar_usuario(IN id INT,IN nombre VARCHAR(30))
BEGIN 
	UPDATE actor SET first_name = nombre WHERE actor_id = id;
END $$
CALL sp_modificar_usuario(1, "CARLOS");

-- DELETE
DELIMITER $$
CREATE PROCEDURE sp_eliminar_usuario(IN id INT)
BEGIN 
	DELETE FROM actor WHERE actor_id = id;
END $$
CALL sp_eliminar_usuario(203);

-- SELECT CON IN - OUT 
DELIMITER $$
CREATE PROCEDURE sp_dame_nombre_usuario(INOUT id INT, OUT nom VARCHAR(30))
BEGIN 
	SELECT first_name INTO nom FROM actor WHERE actor_id = id;
END $$

CALL sp_dame_nombre_usuario(1, @nombre); -- Ejecucion del sp y envia "1" como dato
SELECT @nombre; -- Muestra el resultado

-- SELECT CON INOUT
DELIMITER $$
CREATE PROCEDURE sp_dame_nombre_usuario2(INOUT valor VARCHAR(30))
BEGIN 
	SELECT COUNT(*) INTO valor FROM actor
    WHERE first_name LIKE CONCAT('%',valor,'%');
END $$

SET @letra = 'a'; -- Declaracion y asignacion
CALL sp_dame_nombre_usuario2(@letra); -- Ejecucion del sp y envia "a" como dato
SELECT @letra; -- Muestra el resultado
