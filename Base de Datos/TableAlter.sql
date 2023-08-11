ALTER TABLE `playground`.`categorias`
ADD `apellido` VARCHAR(100) NULL;

ALTER TABLE `playground`.`categorias`
MODIFY `apellido` VARCHAR(50) NULL;

ALTER TABLE `playground`.`categorias`
DROP `apellido`;
