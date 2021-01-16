-- 1.	Simple Database Operations Using MySQL Workbench
-- Create New Database
-- Drop database
DROP SCHEMA IF EXISTS `gamebar`;
CREATE SCHEMA `gamebar` DEFAULT CHARACTER SET utf8mb4;

-- Create New Table
-- Deleting Data
-- Dropping Tables
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

-- Insert Data in Tables
INSERT INTO `employees` (`first_name`, `last_name`) VALUES
	('Ivan', 'Petrov'),
    ('Milen', 'Ivanov'),
    ('Dimityr', 'Todorov');

-- Alter Tables
ALTER TABLE `products`
ADD INDEX `fk_cateories_ind` (`category_id` ASC) INVISIBLE;

-- Adding Constraints
ALTER TABLE `products`
ADD CONSTRAINT `fk_category_id`
	FOREIGN KEY (`category_id`)
    REFERENCES `categories` (`id`)
    ON DELETE NO ACTiON
    ON UPDATE CASCADE;
    
ALTER TABLE `employees`
ADD COLUMN `salary` DECIMAL(10, 2);

ALTER TABLE `employees`
ADD `middle_name` VARCHAR(50) NOT NULL DEFAULT '';

-- Modifying Columns
ALTER TABLE `employees`
MODIFY `middle_name` VARCHAR(100) NOT NULL DEFAULT '';

-- Truncate table
TRUNCATE TABLE `employees`;