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

INSERT INTO `directors`
VALUES
(1, 'Director Important 1', 'No Notes'),
(2, 'Director Important 2', 'Some Notes'),
(3, 'Director Important 3', 'Many Notes'),
(4, 'Director Important 4', 'Many Notes'),
(5, 'Director Important 5', 'Many Notes');

CREATE TABLE `genres` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`genre_name` VARCHAR(30) NOT NULL, 
    `notes` TEXT
);
INSERT INTO `genres`
VALUES
(1, 'Thriller', ''),
(2, 'Comedy', ''),
(3, 'Movie', ''),
(4, 'Classic', ''),
(5, 'Genre', '');
    
CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
    `category_name` VARCHAR(30) NOT NULL, 
    `notes` TEXT
);
INSERT INTO `categories`
VALUES
(1, 'Category 1', ''),
(2, 'Category 2', ''),
(3, 'Category 3', ''),
(4, 'Category 4', ''),
(5, 'Category 5', '');
  
CREATE TABLE `movies` (	
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
    `title` VARCHAR(40) NOT NULL, 
    `director_id` INT NOT NULL, 
    `copyright_year` INT NOT NULL, 
    `length` TIME, 
    `genre_id` INT NOT NULL, 
    `category_id` INT, 
    `rating` INT, 
    `notes` TEXT,
    CONSTRAINT fk_movies_director
    FOREIGN KEY (`director_id`)
    REFERENCES `directors`(`id`),
    CONSTRAINT fk_movies_genre
    FOREIGN KEY (`genre_id`)
    REFERENCES `genres`(`id`),
    CONSTRAINT fk_movies_categories
    FOREIGN KEY (`category_id`)
    REFERENCES `categories`(`id`)
);
INSERT INTO `movies`
(`id`, `title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`)
VALUES
(1, 'Godzilla', 2, '1990', 55, 3, 4, 100, 'No Notes'),
(2, 'BBT', 1, '2000', 55, 4, 2, 150, 'Some Notes'),
(3, 'HIMYM', 5, '2015', 55, 5, 1, 1555, 'Big Notes'),
(4, 'Friends', 4, '1996', 55, 2, 3, 135, 'Yo Notes'),
(5, 'Forest Gump', 3, '2001', 55, 1, 5, 200, 'Notes');

-- 12.	Car Rental Database
CREATE DATABASE `car_rental`;
USE `car_rental`;

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`category` VARCHAR(40) NOT NULL, 
`daily_rate` DECIMAL(10,2) NOT NULL,
`weekly_rate` DECIMAL(10,2), 
`monthly_rate` DECIMAL(10,2), 
`weekend_rate` DECIMAL(10,2)
);

INSERT INTO `categories` 
VALUES
(1, 'Category 1', 40.5, null, null, null),
(2, 'Category 2', 50.5, null, null, null),
(3, 'Category 3', 60.5, null, null, null),
(4, 'Category 4', 70.5, null, null, null),
(5, 'Category 5', 20.5, null, null, null);

CREATE TABLE `cars` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`plate_number` VARCHAR(20) NOT NULL, 
	`make` VARCHAR(30) NOT NULL, 
	`model` VARCHAR(30) NOT NULL, 
	`car_year` INT NOT NULL, 
	`category_id` INT, 
	`doors` TINYINT, 
	`picture` BLOB, 
	`car_condition` VARCHAR(30), 
	`available` TINYINT NOT NULL,
    CONSTRAINT fk_cars_categories
    FOREIGN KEY (`category_id`)
    REFERENCES `categories`(`id`)
);

INSERT INTO `cars` 
VALUES
(1, 'CA1234BA', 'Audi', '1', '2000', 2, 4, 'pic', 'Good', 0),
(2, 'C4321BA', 'Toyota', 'Corolla', '2000', 1, 2, 'pic', 'Good', 0),
(3, 'CC5678BA', 'Ford', 'Escort', '2001', 5, 4, 'pic', 'Good', 0),
(4, 'CA9999BA', 'Mercedes', '3', '2005', 3, 4, 'pic', 'Good', 0),
(5, 'CO4444HH', 'BMW', 'Model', '2003', 4, 2, 'pic', 'Good', 0);

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`first_name` VARCHAR(30) NOT NULL, 
	`last_name` VARCHAR(30) NOT NULL,
	`title` VARCHAR(30) NOT NULL, 
	`notes` TEXT
);

INSERT INTO `employees` 
VALUES 
	(1, 'Ivan', 'Petrov', 'CEO', 'Notes'),
	(2, 'Ivan', 'Ivanov', 'Intern', 'No Notes'),
	(3, 'Aleksandar', 'Petrov', 'Manager', 'Some Notes'),
	(4, 'Petar', 'Petrov', 'Front-office', 'Short Notes'),
	(5, 'Ivana', 'Petrova', 'Front-office', 'Long Notes');

CREATE TABLE `customers` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`driver_licence_number` VARCHAR(30) NOT NULL, 
	`full_name` VARCHAR(50) NOT NULL,  
	`address` VARCHAR(50) NOT NULL, 
	`city` VARCHAR(30) NOT NULL, 
	`zip_code` VARCHAR(10) NOT NULL,  
	`notes` TEXT
);

INSERT INTO `customers`
VALUES
	(1, 'ABC123456', 'Ivan Ivanov Dimitrov', 'Address 1', 'Sofia', '1000', 'Notes'),
	(2, 'ZXW123456', 'Dimitar Dimitrov Dimitrov', 'Address 2', 'Sofia', '1000', 'Notes'),
	(3, 'QWERT3456', 'Ivan Ivanov Petrov', 'Address 4', 'Sofia', '1000', 'Notes'),
	(4, 'BGH123456', 'Petar Ivanov Dimitrov', 'Address 8', 'Sofia', '1000', 'Notes'),
	(5, 'MNB456789', 'Ivana Ivanova Dimitrova', 'Address 9', 'Sofia', '1000', 'Notes');

CREATE TABLE `rental_orders` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`employee_id` INT NOT NULL, 
	`customer_id` INT NOT NULL, 
	`car_id` INT NOT NULL, 
	`car_condition` VARCHAR(50), 
	`tank_level` INT NOT NULL, 
	`kilometrage_start` DECIMAL(15,2), 
	`kilometrage_end` DECIMAL(15,2), 
	`total_kilometrage` DECIMAL(15,2), 
	`start_date` DATE NOT NULL, 
	`end_date` DATE NOT NULL, 
	`total_days` INT NOT NULL, 
	`rate_applied` DECIMAL(10,2) NOT NULL, 
	`tax_rate` DECIMAL(10,2), 
	`order_status` VARCHAR(15), 
	`notes` TEXT,
	CONSTRAINT fk_rental_orders_employees
    FOREIGN KEY (`employee_id`)
    REFERENCES `employees`(`id`),
    CONSTRAINT fk_rental_orders_customers
    FOREIGN KEY (`customer_id`)
    REFERENCES `customers`(`id`),
    CONSTRAINT fk_rental_orders_cars
    FOREIGN KEY (`car_id`)
    REFERENCES `cars`(`id`)
);

INSERT INTO `rental_orders`
(`id`,
`employee_id`, `customer_id`,`car_id`,`car_condition`,`tank_level`,`kilometrage_start`,`kilometrage_end`,`total_kilometrage`,`start_date`,`end_date`,
`total_days`,`rate_applied`,`tax_rate`,`order_status`,`notes`)
VALUES
(1, 1, 1, 1, 'Good', 50, 100000, 120000, 20000, '2018-10-05', '2018-10-10', 5, 50, 5, 'Finished', 'Notes'),
(2, 2, 2, 2, 'Good', 30, 110000, 150000, 40000, '2018-10-05', '2018-10-10', 5, 50, 5, 'In Progress', 'Notes'),
(3, 4, 5, 4, 'Good', 40, 100000, 120000, 20000, '2018-10-05', '2018-10-10', 5, 50, 5, 'Finished', 'Notes'),
(4, 5, 3, 5, 'Good', 10, 100000, 120000, 20000, '2018-10-05', '2018-10-10', 5, 50, 5, 'Finished', 'Notes'),
(5, 3, 4, 3, 'Good', 60, 100000, 120000, 20000, '2018-10-05', '2018-10-10', 5, 50, 5, 'Finished', 'Notes');

-- 13.	Hotel Database
CREATE DATABASE `hotel`;
USE `hotel`;

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`first_name` VARCHAR(30) NOT NULL, 
	`last_name` VARCHAR(30) NOT NULL,  
	`title`  VARCHAR(30) NOT NULL, 
	`notes` TEXT
);

INSERT INTO `employees` 
VALUES
(1, 'Ivan', 'Georgiev', 'Manager', 'Notes'),
(2, 'Milena', 'Peneva', 'Reception', 'Notes'),
(3, 'Victoria', 'Dimitrova', 'Front-office', 'Notes'),
(4, 'Dilyana', 'Ivanova', 'Reception', 'Notes'),
(5, 'Ivana', 'Georgieva', 'Maid', 'Notes');

CREATE TABLE `customers` (
	`account_number` INT PRIMARY KEY UNIQUE, 
	`first_name`  VARCHAR(30) NOT NULL, 
	`last_name`  VARCHAR(30) NOT NULL, 
	`phone_number` VARCHAR(30) NOT NULL, 
	`emergency_name` VARCHAR(30) NOT NULL, 
	`emergency_number` VARCHAR(30) NOT NULL, 
	`notes` TEXT
);

INSERT INTO `customers`
VALUES
(1, 'Petya', 'Ivanova', '+359 898', 'Aleksandar', '+359 978', 'Notes'),
(2, 'Iva', 'Ivanova', '+359 898', 'Aleksandar', '+359 978', 'Notes'),
(3, 'Petar', 'Ivanova', '+359 898', 'Aleksandar', '+359 978', 'Notes'),
(4, 'Boyana', 'Ivanova', '+359 898', 'Aleksandar', '+359 978', 'Notes'),
(5, 'Yana', 'Ivanova', '+359 898', 'Aleksandar', '+359 978', 'Notes');

CREATE TABLE `room_status` (
	`room_status` VARCHAR(30) NOT NULL PRIMARY KEY, 
    `notes` TEXT
);

INSERT INTO `room_status`
VALUES
('Occupied', 'Notes'),
('Available', 'Notes'),
('Needs cleaning', 'Notes');

CREATE TABLE `room_types` (
	`room_type` VARCHAR(30) NOT NULL PRIMARY KEY, 
    `notes` TEXT
);

INSERT INTO `room_types`
VALUES
('Studio', 'Notes'),
('Single Bed', 'Notes'),
('Apartment', 'Notes'),
('Two-beded Room', 'Notes'),
('Big Apartment', 'Notes');

CREATE TABLE `bed_types` (
	`bed_type` VARCHAR(30) NOT NULL PRIMARY KEY, 
    `notes` TEXT
);

INSERT INTO `bed_types`
VALUES
('Standard', 'Notes'),
('Single', 'Notes'),
('Queen', 'Notes');

CREATE TABLE `rooms` (
	`room_number` INT NOT NULL PRIMARY KEY, 
	`room_type` VARCHAR(30) NOT NULL, 
	`bed_type` VARCHAR(30), 
	`rate` DECIMAL(10,2), 
	`room_status` VARCHAR(30) NOT NULL, 
	`notes` TEXT,
    CONSTRAINT fk_rooms_room_types
    FOREIGN KEY (`room_type`)
    REFERENCES `room_types`(`room_type`),
    CONSTRAINT fk_rooms_bed_types
    FOREIGN KEY (`bed_type`)
    REFERENCES `bed_types`(`bed_type`),
    CONSTRAINT fk_rooms_room_status
    FOREIGN KEY (`room_status`)
    REFERENCES `room_status`(`room_status`)
);

INSERT INTO `hotel`.`rooms`
(`room_number`, `room_type`, `bed_type`, `rate`, `room_status`, `notes`)
VALUES
(111, 'Apartment', 'Single', 50, 'Available', 'Notes'),
(222, 'Studio', 'Queen', 150, 'Occupied', 'Notes'),
(333, 'Studio', 'Standard', 150, 'Needs cleaning', 'Notes'),
(444, 'Apartment', 'Single', 70, 'Occupied', 'Notes'),
(555, 'Studio', 'Standard', 50, 'Available', 'Notes');

CREATE TABLE `payments` (
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
	`employee_id` INT NOT NULL, 
	`payment_date` DATE, 
	`account_number` INT NOT NULL, 
	`first_date_occupied` DATE, 
	`last_date_occupied` DATE, 
	`total_days` INT, 
	`amount_charged` DECIMAL(10,2), 
	`tax_rate` DECIMAL(10,2), 
	`tax_amount` DECIMAL(10,2), 
	`payment_total` DECIMAL(10,2), 
	`notes` TEXT
);

CREATE TABLE `occupancies` (
	`id`, 
	`employee_id`, 
	`date_occupied`, 
	`account_number`, 
	`room_number`, 
	`rate_applied`, 
	`phone_charge`, 
	`notes` TEXT
);

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