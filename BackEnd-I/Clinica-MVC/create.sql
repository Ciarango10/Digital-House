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

DROP TABLE IF EXISTS ODONTOLOGOS;
CREATE TABLE ODONTOLOGOS(
ID INT AUTO_INCREMENT PRIMARY KEY,
NROMATRICULA INT NOT NULL,
NOMBRE VARCHAR(50) NOT NULL,
APELLIDO VARCHAR(50) NOT NULL
);

INSERT INTO DOMICILIOS VALUES(DEFAULT, 'SIEMPRE VIVA', 123, 'SAN PEDRO', 'JUJUY');
INSERT INTO PACIENTES VALUES(DEFAULT, 'SARA', 'FULANITO', '1239081', '2024-02-15', 1);

INSERT INTO DOMICILIOS VALUES (DEFAULT, 'SIEMPRE VIVA', 111, 'TILCARA','JUJUY');
INSERT INTO PACIENTES VALUES (DEFAULT, 'COSME','MENGANITO', '464646', '2024-02-16', 2);

INSERT INTO ODONTOLOGOS VALUES (DEFAULT, 1025, 'JANET', 'MARULANDA');
INSERT INTO ODONTOLOGOS VALUES (DEFAULT, 1111, 'CARLOS', 'ARANGO');