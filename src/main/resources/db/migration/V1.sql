CREATE TABLE IF NOT EXISTS `mydb`.`keys` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `key_device` VARCHAR(45) NULL,
  `key_app` VARCHAR(45) NULL,
  `uid_device` VARCHAR(45) NULL,
  `connected` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB