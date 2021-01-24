-- Functions
DROP FUNCTION IF EXISTS ufn_count_employees_by_town;
DELIMITER //
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50))
RETURNS INT DETERMINISTIC
BEGIN
	DECLARE emp_count INT;
    SET emp_count := 
		(SELECT COUNT(*) FROM `employees`
			JOIN `addresses` USING (`address_id`) 
			JOIN `towns` USING (`town_id`) 
            WHERE `towns`.`name` = town_name);
	RETURN emp_count;
END//
DELIMITER ;

SELECT ufn_count_employees_by_town('Sofia');
SELECT ufn_count_employees_by_town('Berlin');

SELECT employee_id, first_name, last_name, t.`name` FROM employees
	NATURAL JOIN  addresses
	NATURAL JOIN towns t
	WHERE t.`name` = 'Carnation';

-- Procedures
DROP FUNCTION IF EXISTS diff_years;
DELIMITER //
CREATE FUNCTION  diff_years(date1 DATETIME, date2 DATETIME)
RETURNS INT DETERMINISTIC
BEGIN
	RETURN ROUND(DATEDIFF(date1, date2) / 365.25);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_select_employees_by_seniority;
DELIMITER //
CREATE PROCEDURE usp_select_employees_by_seniority(IN years_employed INT)
BEGIN
	SELECT `employee_id`, `first_name`, `last_name`, `hire_date`, 
		diff_years(NOW(), `hire_date`) 
	FROM `employees`
    WHERE diff_years(NOW(), `hire_date`)  < years_employed;
END//
DELIMITER ;

CALL usp_select_employees_by_seniority(20);

-- IN-OUT Parameters
DROP procedure IF EXISTS `usp_add_numbers`;
DELIMITER $$
USE `soft_uni`$$
CREATE PROCEDURE `usp_add_numbers` (
	IN a INT, 
    IN b INT,
    OUT result INT)
BEGIN
	SET result := a + b;
END$$
DELIMITER ;

SET @answer = 0;
CALL usp_add_numbers(17, 9, @answer);
SELECT @answer;

-- 1.	Count Employees by Town

-- 2.	Employees Promotion

-- 3. Employees Promotion by ID

-- 4. Triggered