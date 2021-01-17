-- Problem 1: Select Employee Information
SELECT `id`, `first_name`, `last_name`, `job_title` FROM `employees`
ORDER BY `id`;

-- Problem 2: Select Employees with Filter
SELECT `id`, concat(`first_name`, ' ', `last_name`) AS `full_name`, 
`job_title` AS `Job Title`, `salary` FROM `employees`
WHERE `salary` > 1000;

SELECT DISTINCT `department_id` FROM `employees`;

-- Problem 3: Update Employees Salary

-- Problem 4: Top Paid Employee

-- Problem 5: Select Employees by Multiple Filters

-- Problem 6: Delete from Table