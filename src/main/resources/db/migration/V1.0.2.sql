ALTER TABLE `desa_daviddev`.`publication` 
ADD COLUMN `imagen_header` VARCHAR(45) NULL DEFAULT NULL AFTER `deleted_by`,
ADD COLUMN `imagen_body` VARCHAR(45) NULL DEFAULT NULL AFTER `imagen_header`;
