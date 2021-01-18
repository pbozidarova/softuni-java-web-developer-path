-- Problem 1: Select Employee Information
SELECT `id`, `first_name`, `last_name`, `job_title` FROM `employees`
ORDER BY `id`;

-- Problem 2: Select Employees with Filter
SELECT `id`, concat(`first_name`, ' ', `last_name`) AS `full_name`, 
`job_title` AS `Job Title`, `salary` FROM `employees`
WHERE `salary` > 1000;

SELECT DISTINCT `last_name`, `department_id` FROM `employees`
WHERE `department_id` = 1;

SELECT DISTINCT `last_name`, `department_id` FROM `employees`
WHERE `salary` <= 1500;

SELECT * FROM `employees`
WHERE `department_id` IN (1, 4) AND `salary` BETWEEN 900 AND 1600;

ALTER TABLE `employees` ADD COLUMN `manager_id` INT;
UPDATE `employees` SET `manager_id` = 1 WHERE `id` != 1;

SELECT `first_name`, `last_name`, `manager_id` FROM `employees` 
WHERE `manager_id` IS NULL;

SELECT `first_name`, `last_name`, `manager_id` FROM `employees` 
WHERE `manager_id` IS NOT NULL;

CREATE VIEW `employees_name_salary` AS
SELECT `id`, concat(`first_name`, ' ', `last_name`) AS `full_name`, 
`salary` FROM `employees`
WHERE `salary` > 1000;

SELECT * FROM `employees_name_salary`;

-- Problem 3: Update Employees Salary
SET SQL_SAFE_UPDATES = 0;

UPDATE `employees`
SET `salary` = `salary` * 1.10
WHERE `job_title` = 'Therapist';

SELECT `salary` FROM `employees` ORDER BY `salary`;

UPDATE `employees` 
SET `salary` = `salary` + 100
WHERE `job_title` = 'Manager';

SELECT `salary` FROM `employees` ORDER BY `salary` DESC;

-- Problem 4: Top Paid Employee
CREATE VIEW `v_top_paied_employee` AS
SELECT * FROM `employees`
ORDER BY `salary` DESC
LIMIT 1;

SELECT * FROM `v_top_paied_employee`;

CREATE TABLE `employee_salaries` AS 
SELECT `id`, concat_ws(' ', `first_name`, `last_name`) AS `full_name`, 
`salary` FROM `employees` ORDER BY `salary` DESC;

SHOW CREATE TABLE `employees`;

CREATE TABLE `projects` (
 `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(50) NOT NULL,
 `start_date` DATE,
 `manager_id` INT NOT NULL,
 CONSTRAINT fk_projects_employees
 FOREIGN KEY (`manager_id`)
 REFERENCES `employees`(`id`)
);
 
INSERT INTO `projects` (`name`, `start_date`, `manager_id`)
SELECT CONCAT(`name`, ' Restructuring'), NOW(), 1 FROM `departments`;

-- Problem 5: Select Employees by Multiple Filters
SELECT * FROM `employees`
WHERE `department_id` = 4 AND salary >= 1600
ORDER BY `id`;

-- Problem 6: Delete from Table
DELETE FROM `employees` WHERE `department_id` IN (2, 3);

-- Additional Demo
CREATE VIEW `v_employees_departments` AS 
SELECT e.`id` AS `employee_id`, e.`first_name`, e.`last_name`, d.`id` AS `department_id`, d.`name` 
FROM `employees` as e JOIN `departments` as d ON e.`department_id` = d.`id`;

SELECT * FROM `v_employees_departments`;