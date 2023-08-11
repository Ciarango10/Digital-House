CREATE TABLE `playground`.`usuarios` (
	`idusuario` INT NOT NULL,
    `nombre` VARCHAR(100) NULL,
    `apellido` VARCHAR(100) NULL,
    `email` VARCHAR(50) NULL,
    `categoria` INT NULL,
    PRIMARY KEY(`idusuario`),
    INDEX `FKcategoria_idx` (`categoria` ASC) VISIBLE,
    CONSTRAINT `FKcategoria`
		FOREIGN KEY (`categoria`) 
        REFERENCES `playground`.`categorias` (`idcategoria`)
);