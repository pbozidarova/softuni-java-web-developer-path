----------------------------------------------------------------------------------------------
-- 1.	 Departments Info
USE `restaurant`;
SELECT `department_id`, COUNT(`id`) as `Number of employees` FROM `employees` 
GROUP BY `department_id`
ORDER BY `department_id`;

SELECT `department_id`, COUNT(`id`) as `Number of employees` FROM `employees` 
GROUP BY `department_id`
ORDER BY COUNT(`id`);

SELECT `department_id`, COUNT(`salary`) AS 'Distinct Number of Salary' FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

SELECT `department_id`, COUNT( DISTINCT `salary`) AS 'Distinct Number of Salary' FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

SELECT `department_id`, SUM(`salary`) as `Total Salary`
FROM `employees`
GROUP BY `department_id`
HAVING `Total Salary` < 25000;

-- 2.	Average Salary
SELECT `department_id`, ROUND(AVG(`salary`), 2) AS `Avarage Salary` FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

-- 3.	 Min Salary
SELECT `department_id`, MIN(`salary`) AS `Min Salary` FROM `employees`
GROUP BY `department_id`
HAVING `Min Salary` > 800
ORDER BY `department_id`;

-- 4.	 Appetizers Count
SELECT COUNT(*) AS `Count` FROM `products` WHERE `category_id` = 2 AND price > 8; 

-- 5.	 Menu Prices
SELECT `category_id`, 
	ROUND(AVG(`price`), 2) AS `Average Price`,
	ROUND(MIN(`price`), 2) AS `Cheapest Product`,
	ROUND(MAX(`price`), 2) AS `Most Expensive Product`
FROM `products`
GROUP BY `category_id`;
----------------------------------------------------------------------------------------------

-- Additional Examples
USE `softuni`;
SELECT `department_id`, ROUND(SUM(`salary`), 2) as `Salary Sum` FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

SELECT COUNT(`employee_id`) FROM `employees`;

SELECT `first_name`, `last_name`, `salary` FROM `employees` WHERE `department_id` = 16;

SELECT `category_id`, `country`, 
	COUNT(`price`) AS `Number of Products`,
    ROUND(AVG(`price`), 2) AS `Average Price`
FROM `products`
GROUP BY `category_id`, `country`
HAVING `Number of Products` >= 2;
    
SELECT `country`, `category_id`, 
	COUNT(`price`) AS `Number of Products`,
    ROUND(SUM(`price`), 2) AS `Total Price`
FROM `products`
GROUP BY `category_id`, `country` WITH ROLLUP
HAVING `Number of Products` >= 2;
    
SELECT 
	IF(GROUPING(`country`) = 1, 'Total', `country`) AS `country`,
    COUNT(`price`) AS `Number of Products`,
    ROUND(SUM(`price`), 2) AS `Total Price`
FROM `products`
GROUP BY `country` WITH ROLLUP;
    
SELECT 
	IF(GROUPING(`category_id`) = 1, 'All categories', `category_id`) AS `category_id`,
	IF(GROUPING(`country`) = 1, 'All countries', `country`) AS `country`,
    COUNT(`price`) AS `Number of Products`,
    ROUND(SUM(`price`), 2) AS `Total Price`
FROM `products`
GROUP BY `category_id`, `country` WITH ROLLUP;

SELECT `country`,
	COUNT(`price`) AS `Number of Products`,
    ROUND(SUM(`price`), 2) AS `Total Price`
FROM `products`
GROUP BY `country`;

SELECT `country`,
	COUNT(`price`) AS `Number of Products`,
    ROUND(SUM(`price`), 2) AS `Total Price`
FROM `products`
GROUP BY `category_id`, `country`;