DROP TABLE IF EXISTS MEDICAMENTOS;
CREATE TABLE MEDICAMENTOS(
ID INT AUTO_INCREMENT PRIMARY KEY,
CODIGO INT NOT NULL,
NOMBRE VARCHAR(50) NOT NULL,
LABORATORIO VARCHAR(50) NOT NULL,
CANTIDAD INT NOT NULL,
PRECIO NUMERIC(7,2) NOT NULL);

INSERT INTO MEDICAMENTOS
VALUES (DEFAULT, 567, 'IBUPROFENO','PFIZER', 12, 3500),
(DEFAULT, 859, 'PARACETAMOL','PFIZER', 10, 3000);
