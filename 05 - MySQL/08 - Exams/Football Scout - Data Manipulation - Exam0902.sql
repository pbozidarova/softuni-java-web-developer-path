-- 02.	Insert
-- You will have to insert records of data into the coaches table, based on the players table. 
-- For players with age over 45 (inclusive), insert data in the coaches table with the following values:
-- •	first_name – set it to first name of the player
-- •	last_name – set it to last name of the player.
-- •	salary – set it to double as player’s salary. 
-- •	coach_level – set it to be equals to count of the characters in player’s first_name.

INSERT INTO `coaches` (`first_name`, `last_name`, `salary`, `coach_level`)
SELECT `first_name`, `last_name`, `salary` * 2, LENGTH(`first_name`) FROM `players`
WHERE `players`.`age` >= 45;

-- 03.	Update
-- Update all coaches, who train one or more players and their first_name starts with ‘A’. Increase their level with 1.
UPDATE `coaches` as c
SET c.`coach_level` = c.`coach_level` + 1
WHERE c.`first_name` like 'A%' AND
	( SELECT COUNT(p.`id`) FROM `players` AS p 
    JOIN `players_coaches` AS pc ON pc.`player_id` = p.`id`
    WHERE c.`id` = pc.`coach_id`
    ) > 0;

SELECT * FROM `coaches`
#LEFT JOIN `players_coaches` ON `coaches`.id = `players_coaches`.coach_id
WHERE `first_name` LIKE 'A%';
 
 
-- 04.	Delete
-- As you remember at the beginning of our work, we promoted several football players to coaches. 
-- Now you need to remove all of them from the table of players in order for our database to be updated accordingly.	
-- Delete all players from table players, which are already added in table coaches. 

DELETE p FROM `players` as p
JOIN `players_coaches` as pc
JOIN `coaches` AS c 
WHERE CONCAT(p.`first_name`, ' ', p.`last_name`) = CONCAT(c.`first_name`, ' ', c.`last_name`);

SELECT * FROM `players` AS p
JOIN `players_coaches` AS pc ON pc.`player_id` = p.`id`
JOIN `coaches` AS c ON c.`id` = pc.`coach_id`
WHERE CONCAT(p.`first_name`, p.`last_name`) = CONCAT(c.`first_name`, c.`last_name`);

DELETE FROM `players`
WHERE `age` >= 45;

-- 05.	Players 
-- Extract from the Football Scout Database (fsd) database, info about all of the players. 
-- Order the results by players - salary descending.
-- Required Columns
-- •	first_name
-- •	age
-- •	salary
SELECT `first_name`, `age`, `salary` FROM `players` ORDER BY `salary` DESC;

-- 06.	Young offense players without contract
-- One of the coaches wants to know more about all the young players (under age of 20) who can strengthen his team in 
-- the offensive (played on position ‘A’). As he is not paying a transfer amount, he is looking only for 
-- those who have not signed a contract so far (haven’t hire_date) 
-- and have strength of more than 50. Order the results ascending by salary, then by age.
-- Required Columns
-- •	id (player)
-- •	full_name 
-- •	age
-- •	position
-- •	hire_date
SELECT `p`.`id`, CONCAT(`first_name`, ' ' , `last_name`) AS `full_name`, `age`, `position`, `hire_date` FROM `players` AS `p`
JOIN `skills_data` AS `sd` ON `p`.`skills_data_id` = `sd`.`id`
WHERE `p`.`age` < 20 AND 
`p`.`position` = 'A'AND
`p`.`hire_date` IS NULL AND
`sd`.`strength` > 50
ORDER BY `salary` ASC, `age`;

-- 07.	Detail info for all teams
-- Extract from the database all of the teams and the count of the players that they have.
-- Order the results descending by count of players, then by fan_base descending. 
-- Required Columns
-- •	team_name
-- •	established
-- •	fan_base
-- •	count_of_players
SELECT t2.`name`, `established`, `fan_base`, 
	(SELECT COUNT(*) 
		FROM `players`
		JOIN `teams` AS t1 ON t1.`id` = `players`.`team_id`
		WHERE t1.`name` = t2.`name`) AS `count_of_players`
FROM teams AS t2
ORDER BY `count_of_players` DESC, `fan_base` DESC;

-- 08.	The fastest player by towns
-- Extract from the database, the fastest player (having max speed), in terms of towns where their team played.
-- Order players by speed descending, then by town name.
-- Skip players that played in team ‘Devify’
-- Required Columns
-- •	max_speed
-- •	town_name
SELECT MAX(sd.`speed`) AS `max_speed`, twn.`name` AS `town_name` FROM `players` AS p
RIGHT JOIN `skills_data` AS sd ON sd.`id` = p.`skills_data_id`
RIGHT JOIN `teams` AS t ON t.`id` = p.`team_id`
RIGHT JOIN `stadiums` AS s ON s.`id` = t.`stadium_id`
RIGHT JOIN `towns` AS twn ON twn.`id` = s.`town_id`
WHERE t.`name` != 'Devify'
GROUP BY twn.`name`
ORDER BY `max_speed` desc, `town_name`;

-- 09.	Total salaries and players by country
--  And like everything else in this world, everything is ultimately about finances. 
--  Now you need to extract detailed information on the amount of all salaries given to football players by the criteria of the country in which they played.
-- If there are no players in a country, display NULL.  Order the results by total count of players in descending order, then by country name alphabetically.
-- Required Columns
-- •	name (country)
-- •	total_sum_of_salaries
-- •	total_count_of_players
SELECT c.`name`,
    COUNT(p.`id`) `total_count_of_players`,
    SUM(p.`salary`) `total_sum_of_salaries`
FROM `countries` c
LEFT JOIN `towns` t
ON c.`id` = t.`country_id`
LEFT JOIN `stadiums` s
ON s.`town_id` = t.`id`
LEFT JOIN `teams` ta
ON ta.`stadium_id` = s.`id`
LEFT JOIN `players` p
ON ta.`id` = p.`team_id`
GROUP BY c.`id`
ORDER BY `total_count_of_players` DESC, c.`name`;

-- 10.	Find all players that play on stadium
-- Create a user defined function with the name udf_stadium_players_count (stadium_name VARCHAR(30)) that receives a stadium’s name 
-- and returns the number of players that play home matches there.
DELIMITER $$
CREATE FUNCTION udf_stadium_players_count (stadium_name VARCHAR(30))
RETURNS INTEGER
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(p.`id`) FROM `players` AS p
	RIGHT JOIN `teams` AS t ON t.`id` = p.`team_id`
	RIGHT JOIN `stadiums` AS s ON s.`id` = t.`stadium_id`
	WHERE s.`name` = `stadium_name`);
END $$
SELECT udf_stadium_players_count ('Jaxworks') AS `count`; 

-- 11.	Find good playmaker by teams
-- Create a stored procedure udp_find_playmaker which accepts the following parameters:
-- •	min_dribble_points 
-- •	team_name (with max length 45)
-- And extracts data about the players with the given skill stats (more than min_dribble_points), 
-- played for given team (team_name) and have more than average speed for all players. 
-- Order players by speed descending. Select only the best one.
-- Show all needed info for this player: full_name, age, salary, dribbling, speed, team name.
-- CALL udp_find_playmaker (20, ‘Skyble’);

DELIMITER $$
CREATE PROCEDURE `udp_find_playmaker` (min_dribble_points INT, team_name VARCHAR(45))
BEGIN
	DECLARE avg_speed double;
    SET avg_speed := (SELECT AVG(`speed`) FROM `skills_data`);
	SELECT CONCAT(p.`first_name`, ' ',p.`last_name`) AS `full_name`, p.`age`, p.`salary`, sd.`dribbling`, sd.`speed`, `team_name` FROM `players` AS p
    JOIN `skills_data` AS sd ON sd.`id` = p.`skills_data_id`
    JOIN `teams` AS t ON t.`id` = p.`team_id`
    WHERE sd.`dribbling` > `min_dribble_points` AND
          t.`name` = `team_name` AND
          sd.`speed` > `avg_speed`
	ORDER BY sd.`speed` DESC LIMIT 1;
END $$
CALL udp_find_playmaker (20, 'Skyble');