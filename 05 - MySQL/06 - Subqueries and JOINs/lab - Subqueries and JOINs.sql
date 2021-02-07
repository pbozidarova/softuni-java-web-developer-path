-- 1.	Managers
-- Write a query to retrieve information about the managers – id, full_name, deparment_id and department_name. Select the first 5 departments ordered by employee_id.
SELECT `employee_id` AS id, 
	CONCAT(`first_name`, ' ', `last_name`) as `full_name`, 
	d.`department_id`, `name` AS `department_name`
FROM `departments` AS d 
JOIN `employees` AS e 
ON d.`manager_id` = e.`employee_id`
ORDER BY `employee_id` LIMIT 5;

SELECT COUNT(`employee_id`) FROM `employees`
WHERE `salary` > (
	SELECT AVG(`salary`) FROM `employees`
);

SELECT `employee_id`, 
	CONCAT(`first_name`, ' ', `last_name`) AS `full_name`, `salary` FROM `employees`
WHERE `salary` > (
	SELECT AVG(`salary`) FROM `employees`
);

-- 2.	Towns Addresses
-- Write a query to get information about the addresses in the database, which are in San Francisco, Sofia or Carnation. 
-- Retrieve town_id, town_name, address_text. Order the result by town_id, then by address_id. 
SELECT a.`town_id`, `name` AS `town_name`, `address_text` 
FROM `addresses` AS a, `towns` AS t
WHERE a.`town_id` = t.`town_id` 
AND `name` IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY t.`town_id`;

SELECT a.`town_id`, t.`name` AS `town_name`, `address_text` 
FROM `addresses` AS a 
JOIN `towns` AS t
ON a.`town_id` = t.`town_id` AND t.`name` IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY t.`town_id`;

-- 3.	Employees Without Managers
-- Write a query to get information about employee_id, first_name, last_name, department_id and salary for all employees who don’t have a manager.
SELECT e.`employee_id`, e.`first_name`, e.`last_name`, d.`department_id`, e.`salary` 
FROM `employees` e 
JOIN `departments` d 
ON e.`department_id` = d.`department_id`
WHERE e.`manager_id` IS NULL;

-- 4.	Higher Salary
-- Write a query to count the number of employees who receive salary higher than the average.
SELECT COUNT(*) as `count` FROM `employees` 
WHERE `salary` > (SELECT AVG(`salary`) FROM `employees`);