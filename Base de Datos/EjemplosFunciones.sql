SELECT LEFT(nombre,locate("1",nombre)-1) from musimundos.playlists WHERE nombre LIKE "%1%";
SELECT RIGHT(nombre,locate("1",nombre)-1) from musimundos.playlists WHERE nombre LIKE "%1%";

SELECT * FROM musimundos.empleados WHERE YEAR(fecha_nacimiento)="1990";
SELECT * FROM musimundos.empleados WHERE EXTRACT(YEAR FROM now())-EXTRACT(YEAR FROM fecha_nacimiento) >= 30;
SELECT * FROM musimundos.empleados WHERE TIMESTAMPDIFF(YEAR,fecha_nacimiento,curdate()) >= 30;
SELECT * FROM musimundos.empleados WHERE length(nombre) >= 4;

SELECT * FROM musimundos.clientes WHERE empresa IS NULL;
SELECT COUNT(*) FROM musimundos.clientes WHERE empresa IS NULL;
UPDATE musimundos.clientes SET empresa = "" WHERE empresa IS NULL;

