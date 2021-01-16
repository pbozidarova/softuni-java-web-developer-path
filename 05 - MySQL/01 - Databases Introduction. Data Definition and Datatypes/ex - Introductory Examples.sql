-- 0.	Create Database
CREATE DATABASE `minions`;
USE `minions`;

-- 1.	Create Tables
CREATE TABLE `minions` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `age` INT NOT NULL
);

CREATE TABLE `towns` (
	`town_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR (20) NOT NULL
);

INSERT INTO `minions`(`id`, `name`, `age`)
VALUES  
(1, 'Ivan', 20),
(2, 'Pesho', 20);

SELECT * FROM `minions`;

-- 2.	Alter Minions Table
ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD CONSTRAINT `fk_minions_towns`
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`);

-- 3.	Insert Records in Both Tables
INSERT INTO `towns` (`id`, `name`) 
VALUES 
(1, 'Sofia'), (2, 'Plovdiv'), (3, 'Varna');

INSERT INTO `minions` (`id`, `name`, `age`, `town_id`)
VALUES
(1, 'Kevin', 22, 1), 
(2, 'Bob', 22, 3), 
(3, 'Steward', Null, 2);

-- 4.	Truncate Table Minions 
TRUNCATE `minions`;

-- 5.	Drop All Tables
DROP TABLE `minions`;
DROP TABLE `towns`;

-- 6.	Create Table People
CREATE TABLE `people` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB, 
`height` DECIMAL, 
`weight` DECIMAL,
`gender` CHAR(1),
`birthdate` DATE NOT NULL,
`biography` TEXT
);

INSERT INTO `people` 
VALUES
(1, 'Gina', 'pic1', 150, 50, 'f', 10/10/1990, 'Very long text'),
(2, 'Tisho', 'pic2', 180, 70, 'm', 10/10/1990, 'Very long text'),
(3, 'Mila', 'pic3', 190, 80, 'f', 10/10/1990, 'Very long text'),
(4, 'Pesh0', 'pic4', 200, 90, 'm', 10/10/1990, 'Very long text'),
(5, 'Gosho', 'pic5', 160, 60, 'm', 10/10/1990, 'Very long text');

-- 7.	Create Table Users
CREATE TABLE `users` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`username` VARCHAR(30) UNIQUE NOT NULL, 
	`password` VARCHAR(26) NOT NULL, 
	`profile_picture` BLOB, 
	`last_login_time` TIMESTAMP,
	`is_deleted` TINYINT
);

INSERT INTO `users`
VALUES
(1, 'user123', 'password123', '', now(), 0),
(2, 'user1234', 'password123', '', now(), 1),
(3, 'user1235', 'password123', '', now(), 1),
(4, 'user1236', 'password123', '', now(), 1),
(5, 'user1237', 'password123', '', now(), 0);


-- 8.	Change Primary Key
ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users` PRIMARY KEY (`id`, `username`);

-- 9.	Set Default Value of a Field
ALTER TABLE `users`
MODIFY `last_login_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

-- 10.	 Set Unique Field
ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users` PRIMARY KEY (`id`),
ADD CONSTRAINT `uc_username` PRIMARY KEY (`username`);

-- 11.	Movies Database
CREATE DATABASE `movies`;
USE `movies`;

CREATE TABLE `directors` ( 
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`director_name` VARCHAR (30) NOT NULL, 
    `notes` TEXT
); 
CREATE TABLE `genres` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`genre_name` VARCHAR(30), 
    `notes` TEXT
);
    
CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
    `category_name` VARCHAR(30), 
    `notes` TEXT
);
  
CREATE TABLE `movies` (	
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
    `title` VARCHAR(40) NOT NULL, 
    `director_id` INT NOT NULL, 
    `copyright_year` INT NOT NULL, 
    `length` TIME, 
    `genre_id` INT, 
    `category_id` INT, 
    `rating` INT, 
    `notes` TEXT)

-- 12.	Car Rental Database

-- 13.	Hotel Database

-- 14.	Create SoftUni Database
CREATE DATABASE `softuni`;
USE `softuni`;

CREATE TABLE `towns` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`name` VARCHAR(45)
 );
CREATE TABLE	`addresses` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`address_text` VARCHAR(45), 
	`town_id` INT,
    CONSTRAINT `fk_addresses_towns`
    FOREIGN KEY (`town_id`)
    REFERENCES `towns`(`id`)
);

CREATE TABLE `departments` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`name` VARCHAR(45)
);
 
CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`first_name` VARCHAR(30) NOT NULL, 
	`middle_name`VARCHAR(30) NOT NULL, 
	`last_name` VARCHAR(30) NOT NULL,
	`job_title` VARCHAR(20) NOT NULL, 
	`department_id` INT NOT NULL, 
	`hire_date` DATE, 
	`salary` DECIMAL(19, 2), 
	`address_id` INT,
    CONSTRAINT fk_employees_departments
    FOREIGN KEY (`department_id`)
    REFERENCES `departments`(`id`),
    CONSTRAINT fk_employees_addresses
    FOREIGN KEY (`address_id`)
    REFERENCES `addresses`(`id`)
);

-- 15.	Basic Insert
INSERT INTO `towns` 
VALUES
(1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna'),
(4, 'Burgas');

-- Engineering, Sales, Marketing, Software Development, Quality Assurance
INSERT INTO `departments`
VALUES
(1, 'Engineering'),
(2, 'Sales'),
(3, 'Marketing'),
(4, 'Software Development'),
(5, 'Quality Assurance');

INSERT INTO `employees` (`id`, `first_name`, `middle_name`, 
`last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
VALUES 
(1, 'Ivan', 'Ivanov', ' Ivanov', '.NET Developer', 4, '2013-02-01', 3500),
(2, 'Petar', 'Petrov', ' Petrov', 'Senior Engineer', 1, '2004-03-02', 4000),
(3, 'Maria', 'Petrova', ' Ivanova', 'Intern', 5, '2016-08-28', 525.25),
(4, 'Georgi', 'Terziev', ' Ivanov', 'CEO', 2, '2007-09-12', 3000),
(5, 'Petar', 'Pan', ' Pan', 'Intern', 3, '2016-08-28', 599.88);

-- 16.	Basic Select All Fields
SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;

-- 17.	Basic Select All Fields and Order Them
SELECT * FROM `towns` ORDER BY `name` ASC;
SELECT * FROM `departments` ORDER BY `name` ASC;
SELECT * FROM `employees` ORDER BY `salary` DESC;

-- 18.	Basic Select Some Fields
SELECT `name` FROM `towns` ORDER BY `name`;
SELECT `name` FROM `departments` ORDER BY `name`;
SELECT `first_name`, `last_name`, `job_title`, `salary` FROM `employees` ORDER BY `salary` DESC;

-- 19.	Increase Employees Salary
UPDATE `employees` SET `salary` = `salary` * 1.1;
SELECT `salary` FROM `emloyees`;

-- 20.	Decrease Tax Rate
USE `hotel`;
UPDATE `payments`
SET `tax_rate` = `tax_rate` - `tax_rate` * 0.03;

-- 21.	Delete All Records
TRUNCATE `occupancies`;