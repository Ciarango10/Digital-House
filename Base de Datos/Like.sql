-- Permite especificar algo concreto que queremos encontrar en los registros
SELECT telefono
FROM universolector.editorial
WHERE razon_social LIKE '%i%'; -- Devuelve los telefonos donde la razon social tenga una i 

SELECT nombre 
FROM usuarios 
WHERE nombre LIKE '_a%'; -- Devuelve los nombres que tengan la letra 'a' como segundo caracter