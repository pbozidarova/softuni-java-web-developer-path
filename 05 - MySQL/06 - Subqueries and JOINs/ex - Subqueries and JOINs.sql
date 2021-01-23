USE `soft_uni`;
-- 1.	Employee Address
SELECT e.`employee_id`, e.`job_title`, a.`address_id`, a.`address_text`
FROM `employees`AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
ORDER BY `address_id`
LIMIT 5;

-- 2.	Addresses with Towns
SELECT e.`first_name`, e.`last_name`, t.`name` as `town`, a.`address_text` 
FROM `employees` as e
JOIN `addresses` AS a 
ON e.`address_id` = a.`address_id`
JOIN `towns` AS t 
ON a.`town_id` = t.`town_id`
ORDER BY `first_name`
LIMIT 5;

-- 3.	Sales Employee
SELECT e.`employee_id`, e.`first_name`,	e.`last_name`, 
	d.`name` AS `department_name`
FROM `employees` as e
JOIN `departments` as d
ON e.`department_id` = d.`department_id`
WHERE d.`name` = 'Sales'
ORDER BY `employee_id` DESC;

-- 4.	Employee Departments
SELECT e.`employee_id`, e.`first_name`,	e.`salary`, 
	d.`name` AS `department_name`
FROM `employees` as e
JOIN `departments` as d
ON e.`department_id` = d.`department_id`
WHERE e.`salary` >  15000
ORDER BY d.`department_id` DESC
LIMIT 5;

-- 5.	Employees Without Project
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
SELECT e.`first_name`, e.`last_name`, e.`hire_date`, d.`name` as `dept_name`
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE e.`hire_date` > '1999-01-01' 
AND d.`name` IN ('Sales', 'Finance')
ORDER BY `hire_date`;

-- 7.	Employees with Project
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
SELECT e1.`employee_id`, e1.`first_name`, e1.`manager_id`, 
	(SELECT e2.`first_name` 
		FROM `employees` e2 
        WHERE e2.`employee_id` = e1.`manager_id`) AS `manager_name`
FROM `employees` AS e1
WHERE e1.`manager_id` IN (3, 7)
ORDER BY e1.`first_name`;

-- 10.	Employee Summary
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
SELECT AVG(`salary`) AS `min_average_salary` FROM `employees`
GROUP BY `department_id`
ORDER BY AVG(`salary`)
LIMIT 1;

-- 12.	Highest Peaks in Bulgaria
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
SELECT c.`country_code`, COUNT(m.`mountain_range`) AS `mountain_range`
FROM `countries` AS c
JOIN `mountains_countries` AS mc
ON mc.`country_code` = c.`country_code`
JOIN `mountains` AS m
ON m.`id` = mc.`mountain_id`
WHERE c.`country_name` IN ('United States', 'Russia','Bulgaria')
GROUP BY c.`country_code`;

-- 14.	Countries with Rivers
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

-- 16.  Countries Without Any Mountains
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