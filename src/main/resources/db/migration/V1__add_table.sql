CREATE TABLE if not exists `Storehouse`.`products`
(
    `id_product`          INT AUTO_INCREMENT,
    `name`               VARCHAR(45) NULL,
    `quantity`           INT         NULL,
    `date_of_manufacture` DATETIME    NULL,
    `days_to_expire`        INT         NULL,
    PRIMARY KEY (`id_product`)
);