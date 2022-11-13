

ALTER TABLE `desa_daviddev`.`publication` 
ADD COLUMN `creation_date` DATETIME NOT NULL AFTER `title`,
ADD COLUMN `created_by` BIGINT NOT NULL AFTER `creation_date`,
ADD COLUMN `update_date` DATETIME NOT NULL AFTER `created_by`,
ADD COLUMN `update_by` BIGINT NULL AFTER `update_date`,
ADD COLUMN `deleted` TINYINT NULL AFTER `update_by`,
ADD COLUMN `deleted_date` DATETIME NULL AFTER `deleted`,
ADD COLUMN `deleted_by` BIGINT NULL AFTER `deleted_date`,
ADD CONSTRAINT `FK Creteby`
  FOREIGN KEY (`created_by`)
  REFERENCES `desa_daviddev`.`users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK Update`
  FOREIGN KEY (`update_by`)
  REFERENCES `desa_daviddev`.`users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK Delete`
  FOREIGN KEY (`deleted_by`)
  REFERENCES `desa_daviddev`.`users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  