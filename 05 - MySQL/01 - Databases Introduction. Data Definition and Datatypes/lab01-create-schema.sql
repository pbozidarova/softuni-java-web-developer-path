DROP SCHEMA IF EXISTS `gamebar`;
CREATE SCHEMA `gamebar` DEFAULT CHARACTER SET utf8mb4;

USE `gamebar`;
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(45) NOT NULL,
`last_name` VARCHAR(45) NOT NULL
);

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`product_id` INT NOT NULL
);

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`category_id` INT NOT NULL
);

ALTER TABLE `products`
ADD INDEX `fk_cateories_ind` (`category_id` ASC) INVISIBLE;

ALTER TABLE `products`
ADD CONSTRAINT `fk_category_id`
	FOREIGN KEY (`category_id`)
    REFERENCES `categories` (`id`)
    ON DELETE NO ACTiON
    ON UPDATE CASCADE;