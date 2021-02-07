USE `soft_uni`;
-- 1.	Employee Address
-- Write a query that selects:
-- •	employee_id
-- •	job_title
-- •	address_id
-- •	address_text
-- Return the first 5 rows sorted by address_id in ascending order.
SELECT e.`employee_id`, e.`job_title`, a.`address_id`, a.`address_text`
FROM `employees`AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
ORDER BY `address_id`
LIMIT 5;

-- 2.	Addresses with Towns
-- Write a query that selects:
-- •	first_name
-- •	last_name
-- •	town
-- •	address_text
-- Sort the result by first_name in ascending order then by last_name. Select first 5 employees.
SELECT e.`first_name`, e.`last_name`, t.`name` as `town`, a.`address_text` 
FROM `employees` as e
JOIN `addresses` AS a 
ON e.`address_id` = a.`address_id`
JOIN `towns` AS t 
ON a.`town_id` = t.`town_id`
ORDER BY `first_name`
LIMIT 5;

-- 3.	Sales Employee
-- Write a query that selects:
-- •	employee_id
-- •	first_name
-- •	last_name
-- •	department_name
-- Sort the result by employee_id in descending order. Select only employees from the “Sales” department.
SELECT e.`employee_id`, e.`first_name`,	e.`last_name`, 
	d.`name` AS `department_name`
FROM `employees` as e
JOIN `departments` as d
ON e.`department_id` = d.`department_id`
WHERE d.`name` = 'Sales'
ORDER BY `employee_id` DESC;

-- 4.	Employee Departments
-- Write a query that selects:
-- •	employee_id
-- •	first_name
-- •	salary
-- •	department_name
-- Filter only employees with salary higher than 15000. Return the first 5 rows sorted by department_id in descending order.
SELECT e.`employee_id`, e.`first_name`,	e.`salary`, 
	d.`name` AS `department_name`
FROM `employees` as e
JOIN `departments` as d
ON e.`department_id` = d.`department_id`
WHERE e.`salary` >  15000
ORDER BY d.`department_id` DESC
LIMIT 5;

-- 5.	Employees Without Project
-- Write a query that selects:
-- •	employee_id
-- •	first_name
-- Filter only employees without a project. Return the first 3 rows sorted by employee_id in descending order.
SELECT e.`employee_id`, e.`first_name` FROM `employees` AS e
WHERE e.`employee_id` 
NOT IN (SELECT `employee_id` FROM `employees_projects`)
ORDER BY e.`employee_id` DESC
LIMIT 3;

SELECT e.`employee_id`, e.`first_name` 
FROM `employees` AS e
LEFT JOIN `employees_projects` AS ep
ON e.`employee_id` = ep.`employee_id`
WHERE ep.`project_id` IS NULL
ORDER BY e.`employee_id` DESC
LIMIT 3;

-- 6.	Employees Hired After
-- Write a query that selects:
-- •	first_name
-- •	last_name
-- •	hire_date
-- •	dept_name
-- Filter only employees hired after 1/1/1999 and from either the "Sales" or the "Finance" departments. Sort the result by hire_date (ascending).
SELECT e.`first_name`, e.`last_name`, e.`hire_date`, d.`name` as `dept_name`
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE e.`hire_date` > '1999-01-01' 
AND d.`name` IN ('Sales', 'Finance')
ORDER BY `hire_date`;

-- 7.	Employees with Project
-- Write a query that selects:
-- •	employee_id
-- •	first_name
-- •	project_name
-- Filter only employees with a project, which has started after 13.08.2002 and it is still ongoing (no end date). Return the first 5 rows sorted by first_name then by project_name both in ascending order.
SELECT e.`employee_id`, e.`first_name`, p.`name` AS `project_name`
FROM `employees` AS e
JOIN `employees_projects` AS ep
ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p
ON p.`project_id` = ep.`project_id`
WHERE p.`start_date` > '2002-08-13' AND p.`end_date` IS NULL
ORDER BY e.`first_name`, p.`name`
LIMIT 5;

-- 8.	Employee 24
-- Write a query that selects:
-- •	employee_id
-- •	first_name
-- •	project_name
-- Filter all the projects of employees with id 24. If the project has started after 2005 inclusively the return value should be NULL. Sort the result by project_name alphabetically.
SELECT e.`employee_id`, e.`first_name`, 
IF(YEAR(p.`start_date`) >= '2005', NULL, p.`name`) AS `project_name`
FROM `employees` AS e
JOIN `employees_projects` AS ep
ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p
ON p.`project_id` = ep.`project_id`
WHERE e.`employee_id` = 24
ORDER BY `project_name`;

-- 9.	Employee Manager
-- Write a query that selects:
-- •	employee_id
-- •	first_name
-- •	manager_id
-- •	manager_name
-- Filter all employees with a manager who has id equal to 3 or 7. Return all rows sorted by employee first_name in ascending order.
SELECT e1.`employee_id`, e1.`first_name`, e1.`manager_id`, 
	(SELECT e2.`first_name` 
		FROM `employees` e2 
        WHERE e2.`employee_id` = e1.`manager_id`) AS `manager_name`
FROM `employees` AS e1
WHERE e1.`manager_id` IN (3, 7)
ORDER BY e1.`first_name`;

-- 10.	Employee Summary
-- Write a query that selects:
-- •	employee_id
-- •	employee_name
-- •	manager_name		
-- •	department_name
-- Show the first 5 employees (only for employees who have a manager) with their managers and the departments they are in (show the departments of the employees). Order by employee_id.
SELECT e.`employee_id`, 
	CONCAT(e.`first_name`, ' ', e.`last_name`) AS `employee_name`, 
    (SELECT CONCAT(e2.`first_name`, ' ', e2.`last_name`) 
		FROM `employees` e2 
        WHERE e2.`employee_id` = e.`manager_id`) 
    AS `manager_name`, 
d.`name` AS `department_name`
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
ORDER BY e.`employee_id`
LIMIT 5;

-- 11.	Min Average Salary
-- Write a query that returns the value of the lowest average salary of all departments.
SELECT AVG(`salary`) AS `min_average_salary` FROM `employees`
GROUP BY `department_id`
ORDER BY AVG(`salary`)
LIMIT 1;

-- 12.	Highest Peaks in Bulgaria
-- Write a query that selects:
-- •	country_code	
-- •	mountain_range
-- •	peak_name
-- •	elevation
-- Filter all peaks in Bulgaria with elevation over 2835. Return all rows sorted by elevation in descending order.
USE `geography`;
SELECT c.`country_code`, m.`mountain_range`, p.`peak_name`, p.`elevation`
FROM `countries` AS c
JOIN `mountains_countries` AS mc
ON mc.`country_code` = c.`country_code`
JOIN `mountains` AS m
ON m.`id` = mc.`mountain_id`
JOIN `peaks` AS p
ON p.`mountain_id` = m.`id`
WHERE c.`country_code` = 'BG' AND p.`elevation` > 2835 
ORDER BY p.`elevation` DESC;

-- 13.	Count Mountain Ranges
-- Write a query that selects:
-- •	country_code
-- •	mountain_range
-- Filter the count of the mountain ranges in the United States, Russia and Bulgaria. Sort result by mountain_range count in decreasing order.
SELECT c.`country_code`, COUNT(m.`mountain_range`) AS `mountain_range`
FROM `countries` AS c
JOIN `mountains_countries` AS mc
ON mc.`country_code` = c.`country_code`
JOIN `mountains` AS m
ON m.`id` = mc.`mountain_id`
WHERE c.`country_name` IN ('United States', 'Russia','Bulgaria')
GROUP BY c.`country_code`;

-- 14.	Countries with Rivers
-- Write a query that selects:
-- •	country_name
-- •	river_name
-- Find the first 5 countries with or without rivers in Africa. Sort them by country_name in ascending order.
SELECT c.`country_name`, r.`river_name` 
FROM `countries` AS c
LEFT JOIN `countries_rivers` AS cr
ON c.`country_code` = cr.`country_code`
LEFT JOIN `rivers` AS r
ON r.`id` = cr.`river_id`
WHERE c.`continent_code`= 'AF'
ORDER BY c.`country_name`
LIMIT 5;

-- 15.	*Continents and Currencies
-- Write a query that selects:
-- •	continent_code
-- •	currency_code
-- •	currency_usage
-- Find all continents and their most used currency. Filter any currency that is used in only one country. Sort the result by continent_code and currency_code.
SELECT f.`continent_code`, f.`currency_code`, f.`currency_usage` FROM
	(SELECT c1.`continent_code`, c1.`currency_code`, 
    COUNT(c1.`currency_code`) AS `currency_usage`
	FROM `countries` as c1
	GROUP BY c1.`currency_code`, c1.`continent_code` HAVING `currency_usage` > 1) AS f
LEFT JOIN
	(SELECT c2.`continent_code`, c2.`currency_code`, 
    COUNT(c2.`currency_code`) AS `currency_usage`
	FROM `countries` as c2
	GROUP BY c2.`currency_code`, c2.`continent_code` HAVING `currency_usage` > 1) AS s
ON f.`continent_code` = s.`continent_code` AND s.`currency_usage` > f.`currency_usage`
WHERE s.`currency_usage` IS NULL
ORDER BY f.`continent_code`, f.`currency_code`;

-- 16.  Countries Without Any Mountains
-- Find the count of all countries which don’t have a mountain.
SELECT COUNT(*) AS `country_count`
FROM `countries`
WHERE `country_code` 
NOT IN (SELECT `country_code` FROM `mountains_countries`);

SELECT COUNT(*) AS `country_count`
FROM `countries` AS c
LEFT JOIN `mountains_countries` AS mc
ON c.`country_code` = mc.`country_code`
WHERE mc.`country_code` IS NULL;

-- 17.  Highest Peak and Longest River by Country
-- For each country, find the elevation of the highest peak and the length of the longest river, sorted by the highest peak_elevation (from highest to lowest), 
-- then by the longest river_length (from longest to smallest), then by country_name (alphabetically). Display NULL when no data is available in some of the columns. 
-- Limit only the first 5 rows.
SELECT 
    c.`country_name`,
    MAX(p.`elevation`) AS `highest_peak_elevation`,
    MAX(r.`length`) AS `longest_river_length`
FROM
    `countries` AS c
        JOIN
    `countries_rivers` AS cr ON c.`country_code` = cr.`country_code`
        JOIN
    `rivers` AS r ON cr.`river_id` = r.`id`
        JOIN
    `mountains_countries` AS mc ON mc.`country_code` = c.`country_code`
        JOIN
    `mountains` AS m ON mc.`mountain_id` = m.`id`
        JOIN
    `peaks` AS p ON p.`mountain_id` = m.`id`
GROUP BY `country_name`
ORDER BY MAX(p.`elevation`) DESC
LIMIT 5;