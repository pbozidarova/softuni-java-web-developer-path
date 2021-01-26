-- 01. You will have to insert records of data into the cards table, based on the clients table. 
-- For clients with id between 191 and 200 (inclusive), insert data in the cards table with the following values:
-- •	card_number – set it to full name of the client, but reversed!
-- •	card_status – set it to "Active".
-- •	bank_account_id –set it to client's id value. `;
INSERT INTO `cards` (`card_number`, `card_status`, `bank_account_id`)
(
	SELECT REVERSE(`full_name`), 'Active', `id`
	FROM clients
	#WHERE `id` >= 191 AND `id` <=200
	WHERE `id` BETWEEN 191 AND 200
);

INSERT INTO `cards` (`card_number`, `bank_account_id`, `card_status`)
(
	SELECT REVERSE(`full_name`), `id`,
	(
		CASE 
			WHEN `id` BETWEEN 191 AND 200 THEN 'Active'
			WHEN `id` BETWEEN 201 AND 300 THEN 'Inactive'
			WHEN `id` BETWEEN 301 AND 1000 THEN 'Deleted'
		END ) AS `custom_Status`
	FROM `clients`
	WHERE `id` BETWEEN 191 AND 200
);

-- 02. Update all clients which have the same id as the employee they are appointed to. Set their employee_id with the employee with the lowest count of clients.
-- If there are 2 such employees with equal count of clients, take the one with the lowest id.
UPDATE `employees_clients` AS ec
SET ec.`employee_id` = 
(
	SELECT ecc.`employee_id` FROM (SELECT * FROM `employees_clients`) AS ecc
	GROUP BY ecc.`employee_id`
	ORDER BY COUNT(ecc.`client_id`) ASC, ecc.`employee_id` ASC LIMIT 1
)
WHERE ec.`employee_id` = ec.`client_id`;
 
SELECT ee.`id`, ee.`first_name`, COUNT(ecc.`client_id`) AS cnt FROM `employees` AS ee
JOIN `employees_clients` AS ecc ON `employee_id` = ee.`id`
GROUP BY ecc.`employee_id`
ORDER BY cnt ASC, `id` ASC 
LIMIT 1;

SELECT ecc.`employee_id` FROM `employees` as ee
JOIN `employees_clients` AS ecc ON `employee_id` = ee.`id`
GROUP BY ecc.`employee_id`
ORDER BY COUNT(ecc.`client_id`) ASC, ecc.`employee_id` ASC LIMIT 1;

-- R.U.K. Bank is a sophisticated network. As such, it cannot allow procrastination and lazy behavior. 
-- Delete all employees which do not have any clients. 
DELETE emp FROM `employees` as emp
LEFT JOIN `employees_clients` as ec	
ON ec.`employee_id` = emp.`id`
WHERE ec.`client_id` IS NULL ;

DELETE FROM `employees` WHERE `id` = 
(
	SELECT emp.`id` FROM (SELECT * FROM `employees`) as emp
	LEFT JOIN `employees_clients` AS ec	
	on ec.`employee_id` = emp.`id`
	WHERE ec.`client_id` IS NULL LIMIT 1
);

-- Extract from the database, all of the clients. 
-- Order the results ascending by client id.
-- Required Columns
-- •	id (clients)
-- •	full_name
SELECT `id`, `full_name` FROM `clients` ORDER BY `id` asc;

-- One of your bosses has requested a functionality which checks the newly employed – highly paid people.
-- Extract from the database, all of the employees, which have salary greater than or equal to 100000 and have started later than or equal 
-- to the 1st of January - 2018. 
-- The salary should have a "$" as a prefix.
-- Order the results descending by salary, then by id.
-- Required Columns
-- •	id (employees)
-- •	full_name (first_name + " " + last_name)
-- •	salary
-- •	started_on
SELECT `id`, CONCAT(`employees`.`first_name`, " ", `employees`.`last_name`) AS `full_name`, CONCAT('$', `salary`) AS `salary`, `started_on`
FROM `employees`
WHERE `salary` >=100000 AND `started_on` >= '2018-01-01'
ORDER BY `salary` DESC, `id`;

-- Extract from the database, all of the cards, and the clients that own them, so that they end up in the following format:
-- {card_number} : {full_name}
-- Order the results descending by card id.
-- Required Columns
-- •	id (cards)
-- •	card_token
SELECT `cards`.`id`, CONCAT(`cards`.`card_number`, ' : ', `clients`.`full_name`) AS `card_token` FROM `cards`
LEFT JOIN `bank_accounts` AS ba 
ON ba.`id` = `cards`.`bank_account_id`
RIGHT JOIN `clients` ON `clients`.`id` = `ba`.`client_id`
ORDER BY `cards`.`id` DESC;

SELECT CONCAT(c.`card_number`, ' : ', cl.`full_name`) AS `card_token` FROM `cards` AS c
JOIN `bank_accounts` AS ba ON c.`bank_account_id` = ba.`id`
JOIN `clients` AS cl ON ba.`client_id` = cl.`id`
ORDER BY c.`id` DESC;

-- Extract from the database, the top 5 employees, in terms of clients assigned to them.
-- Order the results descending by count of clients, and ascending by employee id.
-- Required Columns
-- •	name (employees)
-- •	started_on
-- •	count_of_clients
SELECT CONCAT(e.`first_name`, ' ', `last_name`) AS `name`, e.`started_on`, COUNT(ec.`client_id`) AS `count_of_clients`
FROM `employees` AS e
LEFT JOIN `employees_clients` AS ec ON ec.`employee_id` = e.`id`
GROUP BY ec.`employee_id`
ORDER BY `count_of_clients` DESC, e.`id` ASC
LIMIT 5;

-- Extract from the database, all branches with the count of their issued cards. Order the results by the count of cards, then by branch name.
-- Required Columns
-- •	name (branch)
-- •	count_of_cards
SELECT b.`name`, COUNT(cards.`id`) AS `count_of_cards` FROM `branches` as b
LEFT JOIN `employees` ON `employees`.`branch_id` = b.`id`
LEFT JOIN `employees_clients` ON `employees_clients`.`employee_id` = `employees`.`id`
LEFT JOIN `clients` ON `clients`.`id` = `employees_clients`.`client_id`
LEFT JOIN `bank_accounts` ON `bank_accounts`.`client_id` = `clients`.`id`
LEFT JOIN `cards` ON `cards`.`bank_account_id` = `bank_accounts`.`id`
GROUP BY b.`id`
ORDER BY `count_of_cards` DESC, b.`name` ASC;

-- 10.	Extract client cards count
-- Create a user defined function with the name udf_client_cards_count(name VARCHAR(30)) 
-- that receives a client's full name and returns the number of cards he has.
-- Required Columns
-- •	full_name (clients)
-- •	cards (count of cards)
DELIMITER $$
CREATE FUNCTION `udf_client_cards_count`(name_param VARCHAR(30))
RETURNS INTEGER
BEGIN
RETURN (SELECT COUNT(c.`id`) FROM `cards` AS c
	LEFT JOIN `bank_accounts` AS ba ON ba.`id` = c.`bank_account_id`
	LEFT JOIN `clients` AS cl ON cl.`id` = ba.`client_id`
	WHERE cl.`full_name` = `name_param`);
END$$

DELIMITER $$
CREATE FUNCTION `udf_client_cards_count`(name_param VARCHAR(30))
RETURNS INTEGER
DETERMINISTIC
BEGIN

DECLARE myvar INT(11); 
SET myvar := (SELECT COUNT(c.`id`) FROM `cards` AS c
				LEFT JOIN `bank_accounts` AS ba ON ba.`id` = c.`bank_account_id`
				LEFT JOIN `clients` AS cl ON cl.`id` = ba.`client_id`
				WHERE cl.`full_name` = `name_param`);
RETURN myvar;
END$$

-- Create a stored procedure udp_clientinfo which accepts the following parameters:
-- •	full_name
-- And extracts data about the client with the given full name.
-- Aside from the full_name, the procedure should extract the client's age, bank account number and balance.
-- The account’s salary should have "$" prefix.

CREATE PROCEDURE `udp_clientinfo` (nameParam varchar(45))
BEGIN

 SELECT `full_name`, `clients`.`age`, `bank_accounts`.`account_number`, CONCAT('$', `bank_accounts`.`balance`) AS `balance` FROM `clients`
 LEFT JOIN `bank_accounts` ON `bank_accounts`.`client_id` = `clients`.`id`
 WHERE `clients`.`full_name` = nameParam;

END$$
CALL `udp_clientinfo`('Hunter Wesgate');
