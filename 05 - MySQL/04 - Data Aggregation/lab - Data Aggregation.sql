----------------------------------------------------------------------------------------------
-- 1.	 Departments Info
-- Write a query to count the number of employees in each department by id. Order the information by deparment_id, then by employees count. 
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
-- Write a query to calculate the average salary in each department. Order the information by department_id. Round the salary result to two digits after the decimal point. 
SELECT `department_id`, ROUND(AVG(`salary`), 2) AS `Avarage Salary` FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

-- 3.	 Min Salary
-- Write a query to retrieve information about the departments grouped by department_id with minumum salary higher than 800. 
-- Round the salary result to two digits after the decimal point. 
SELECT `department_id`, MIN(`salary`) AS `Min Salary` FROM `employees`
GROUP BY `department_id`
HAVING `Min Salary` > 800
ORDER BY `department_id`;

-- 4.	 Appetizers Count
-- Write a query to retrieve the count of all appetizers (category id = 2) with price higher than 8. 
SELECT COUNT(*) AS `Count` FROM `products` WHERE `category_id` = 2 AND price > 8; 

-- 5.	 Menu Prices
-- Write a query to retrieve information about the prices of each category. The output should consist of:
-- •	Category_id
-- •	Average Price 
-- •	Cheapest Product
-- •	Most Expensive Product
-- See the examples for more information. Round the results to 2 digits after the decimal point. 
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