-- Part I – Queries for SoftUni Database
-- 1.	Employees with Salary Above 35000
USE `soft_uni`;
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN 
	SELECT `first_name`, `last_name` 
	FROM `employees`
	WHERE `salary` >= 35000
	ORDER BY `first_name`, `last_name`, `employee_id`;
END $$
DELIMITER ;

CALL usp_get_employees_salary_above_35000();

-- 2.	Employees with Salary Above Number
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(min_salary DECIMAL(19, 4))
BEGIN 
	SELECT `first_name`, `last_name` 
	FROM `employees`
	WHERE `salary` >= min_salary
	ORDER BY `first_name`, `last_name`, `employee_id`;
END $$
DELIMITER ;

CALL usp_get_employees_salary_above(48100);

-- 3.	Town Names Starting With
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(start_str VARCHAR(50))
BEGIN
	SELECT `name` FROM `towns`
    WHERE `name` LIKE CONCAT(start_str, '%')
    ORDER BY `name`;
END $$
DELIMITER ;

CALL usp_get_towns_starting_with('b');

-- 4.	Employees from Town
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(30))
BEGIN
	SELECT e.`first_name`, e.`last_name` FROM `employees` AS e
    JOIN `addresses` AS a
    ON e.`address_id` = a.`address_id`
    JOIN `towns` AS t
    ON a.`town_id` = t.`town_id`
    WHERE t.`name` = town_name
    ORDER BY `first_name`, `last_name`, e.`employee_id`;
END $$
DELIMITER ;

CALL usp_get_employees_from_town('Sofia');

-- 5.	Salary Level Function
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(e_salary DECIMAL(19,4))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN	
	RETURN ( CASE
			WHEN e_salary < 30000 THEN 'Low'
			WHEN e_salary BETWEEN 30000 AND 50000 THEN 'Average'
			WHEN e_salary > 50000 THEN 'High'
		END
	);
END $$
DELIMITER ;

SELECT ufn_get_salary_level(13500.00);
SELECT ufn_get_salary_level(43300.00);
SELECT ufn_get_salary_level(125500.00);

-- 6.	Employees by Salary Level
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(s_level VARCHAR(10))
BEGIN
	SELECT `first_name`, `last_name` FROM `employees`
    WHERE ufn_get_salary_level(salary) = s_level
    ORDER BY `first_name` DESC, `last_name` DESC;
END $$
DELIMITER ;

CALL usp_get_employees_by_salary_level('High');

-- 7.	Define Function
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
RETURNS BIT
DETERMINISTIC
BEGIN
	RETURN word REGEXP (concat('^[', set_of_letters, ']+$'));
END $$
DELIMITER ;

SELECT ufn_is_word_comprised('oistmiahf', 'Sofia');
SELECT ufn_is_word_comprised('oistmiahf', 'halves');
SELECT ufn_is_word_comprised('bobr', 'Rob');
SELECT ufn_is_word_comprised('pppp', 'Guy');

DROP FUNCTION IF EXISTS ufn_is_word_comprised;

-- PART II – Queries for Bank Database
-- 8.	Find Full Name
DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
	SELECT CONCAT(`first_name`, ' ' ,`last_name`) AS `full_name`
    FROM `account_holders`
    ORDER BY CONCAT(`first_name`, ' ' ,`last_name`);
END $$
DELIMITER ;

CALL usp_get_holders_full_name();

-- 9.	People with Balance Higher Than
-- Your task is to create a stored procedure usp_get_holders_with_balance_higher_than that accepts a number as a parameter and returns all 
-- people who have more money in total of all their accounts than the supplied number. The result should be sorted by account_holders.id ascending. 
DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(balance_higher INT)
BEGIN
	SELECT ah.`first_name`, ah.`last_name`, SUM(a.balance)
    FROM `account_holders` AS ah
    JOIN `accounts` AS a
	ON ah.`id` = a.`account_holder_id`
    GROUP BY ah.`id`
    HAVING SUM(a.balance) > balance_higher
    ORDER BY ah.`id`;
END $$
DELIMITER ;

CALL usp_get_holders_with_balance_higher_than(7000)

-- 10.	Future Value Function
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(
		sum DECIMAL(19,4), 
		interest DOUBLE, 
        years INT 
	)
RETURNS DECIMAL(19,4)
DETERMINISTIC
BEGIN
	RETURN( sum * POW(1 + interest, years) );
END $$
DELIMITER ;

SELECT ufn_calculate_future_value(1000, 0.5, 5);

-- 11.	Calculating Interest
DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(
	acc_id INT,
    interest DOUBLE
)
BEGIN
	SELECT a.id, ah.first_name, ah.last_name, a.balance,
    ufn_calculate_future_value(a.balance, interest, 5) AS balance_in5_years
    FROM accounts AS a
    JOIN account_holders AS ah
    ON a.account_holder_id = ah.id
    WHERE a.id = acc_id;
END $$
DELIMITER ;

CALL usp_calculate_future_value_for_account(1, 0.1);

-- 12.	Deposit Money
DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
	START TRANSACTION;
    IF( 
    (SELECT COUNT(*) FROM accounts WHERE id = account_id ) = 0
	OR 
    (money_amount <= 0))
    THEN ROLLBACK;
    ELSE
		UPDATE accounts SET balance = balance + money_amount
        WHERE id = account_id;
    END IF;
END$$
DELIMITER ;

CALL usp_deposit_money(1, 10);
SELECT * FROM `accounts`;

-- 13.	Withdraw Money
DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
	START TRANSACTION;
    IF( 
    (SELECT COUNT(*) FROM accounts WHERE id = account_id ) = 0
	OR 
    (money_amount <= 0) OR 
    ((SELECT balance FROM accounts WHERE id = account_id ) < money_amount ))
    THEN ROLLBACK;
    ELSE
		UPDATE accounts SET balance = balance - money_amount
        WHERE id = account_id;
    END IF;
END$$
DELIMITER ;

CALL usp_withdraw_money(1, 10);
SELECT * FROM `accounts`;

-- 14.	Money Transfer
DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, money_amount DECIMAL(19,4))
BEGIN
	START TRANSACTION;
    IF( 
		(SELECT COUNT(*) FROM accounts WHERE id = from_account_id ) = 0
	OR 
		(SELECT COUNT(*) FROM accounts WHERE id = to_account_id ) = 0
    OR
		(money_amount <= 0) 
    OR 
		((SELECT balance FROM accounts WHERE id = from_account_id ) < money_amount ))
    THEN ROLLBACK;
    ELSE
		UPDATE accounts SET balance = balance - money_amount WHERE id = from_account_id;
		UPDATE accounts SET balance = balance + money_amount WHERE id = to_account_id;
    END IF;
END$$
DELIMITER ;

CALL usp_transfer_money(1, 2, 10);
SELECT * FROM `accounts`;

-- 15.	Log Accounts Trigger
CREATE TABLE `logs`(
	`log_id` INT PRIMARY KEY AUTO_INCREMENT, 
    `account_id` INT, 
    `old_sum` DECIMAL(19,2),  
    `new_sum` DECIMAL(19,2)
);

DELIMITER $$
CREATE TRIGGER tr_update_accounts
AFTER UPDATE
ON `accounts`
FOR EACH ROW
BEGIN
	INSERT INTO `logs` (`account_id`, `old_sum`, `new_sum`)
    VALUES (OLD.`id`, OLD.`balance`, NEW.`balance`);
END $$
DELIMITER ;

UPDATE `accounts` SET `balance` = 6000 WHERE `id` = 4;

-- 16.	Emails Trigger
CREATE TABLE `notification_emails`(
	`id` INT PRIMARY KEY AUTO_INCREMENT, 
    `recipient` VARCHAR(30), 
    `subject` VARCHAR(30), 
    `body` VARCHAR(150));
    
DELIMITER $$
CREATE TRIGGER tr_emails
AFTER INSERT 
ON `logs`
FOR EACH ROW
BEGIN
	INSERT INTO `notification_emails` (`recipient`, `subject`, `body`)
    VALUES 
    (NEW.`account_id`, 
    CONCAT('Balance change for account: ', NEW.`account_id`), 
    CONCAT('On date ', NOW(), ' your balance was changed from ', NEW.`old_sum` ,' to ', NEW.`new_sum`, '.')
    );
END $$
DELIMITER ;    