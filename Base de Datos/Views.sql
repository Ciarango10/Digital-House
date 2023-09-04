CREATE VIEW view_registro AS
SELECT * FROM facturas;

ALTER VIEW view_registro AS
SELECT * FROM categorias;

DROP VIEW registro;

SELECT * FROM view_registro
WHERE Transporte > 30;

