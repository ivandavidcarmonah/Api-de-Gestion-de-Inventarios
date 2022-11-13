ALTER TABLE `desa_daviddev`.`developer_blog` 
DROP FOREIGN KEY `FK Delete dev`;
ALTER TABLE `desa_daviddev`.`developer_blog` 
CHANGE COLUMN `description` `description` VARCHAR(5000) NOT NULL ,
DROP INDEX `FK Delete dev` ;
;