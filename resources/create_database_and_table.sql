create database if not exists Storehouse;
use Storehouse;
CREATE TABLE if not exists `Storehouse`.`Products`(`idProduct` INT AUTO_INCREMENT, `name` VARCHAR(45) NULL,`quantity`INT NULL, `dateOfManufactures` DATETIME NULL, `dayToExpire` INT NULL, PRIMARY KEY (`idProduct`));
INSERT INTO `Storehouse`.`Products` (`name`, `quantity`, `dateOfManufactures`, `dayToExpire`)VALUES ('Salt', '1000', LOCALTIME, '3000');
INSERT INTO `Storehouse`.`Products` (`name`, `quantity`, `dateOfManufactures`, `dayToExpire`)VALUES ('Sugar', '3000', LOCALTIME, '5000');
INSERT INTO `Storehouse`.`Products` (`name`, `quantity`, `dateOfManufactures`, `dayToExpire`)VALUES ('Potato', '500', LOCALTIME, '50');
INSERT INTO `Storehouse`.`Products` (`name`, `quantity`, `dateOfManufactures`, `dayToExpire`)VALUES ('Aplle', '300', LOCALTIME, '30');