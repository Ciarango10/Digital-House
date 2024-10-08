DROP TABLE IF EXISTS DOMICILIOS;
CREATE TABLE DOMICILIOS(
ID INT AUTO_INCREMENT PRIMARY KEY,
CALLE VARCHAR(50) NOT NULL,
NUMERO INT NOT NULL,
LOCALIDAD VARCHAR(50) NOT NULL,
PROVINCIA VARCHAR(50) NOT NULL);

DROP TABLE IF EXISTS PACIENTES;
CREATE TABLE PACIENTES(
ID INT AUTO_INCREMENT PRIMARY KEY,
NOMBRE VARCHAR(50) NOT NULL,
APELLIDO VARCHAR(50) NOT NULL,
DNI VARCHAR(50) NOT NULL,
FECHA_INGRESO DATE NOT NULL,
ID_DOMICILIO INT);

INSERT INTO DOMICILIOS VALUES(DEFAULT, 'SIEMPRE VIVA', 123, 'SAN PEDRO', 'JUJUY');
INSERT INTO PACIENTES VALUES(DEFAULT, 'COSME', 'FULANITO', '1239081', '2024-02-15', 1);