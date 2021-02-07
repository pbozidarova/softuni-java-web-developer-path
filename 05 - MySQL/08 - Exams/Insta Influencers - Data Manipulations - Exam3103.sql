-- 02.	Insert
-- You will have to insert records of data into the addresses table, based on the users table. 
-- For users with male gender, insert data in the addresses table with the following values:
-- •	address – set it to username of the user.
-- •	town – set it to password of the user.
-- •	country – set it to ip of the user. 
-- •	user_id – set it to age of the user. 
INSERT INTO `addresses` (`address`, `town`, `country`, `user_id`)
SELECT u.`username`, u.`password`, u.`ip`, u.`age` FROM `users` AS u
WHERE `gender` = 'M';

SELECT `username`, `password`, `ip`, `age` FROM `users` WHERE `gender` = 'M';

-- 03.	Update
-- Rename those countries, which meet the following conditions:
-- •	If the country name starts with 'B' – change it to 'Blocked'.
-- •	If the country name starts with 'T' – change it to 'Test'.
-- •	If the country name starts with 'P' – change it to 'In Progress'.
UPDATE `addresses` AS c
SET c.`country` = (
	CASE
		WHEN `country` LIKE 'B%' THEN 'Blocked'
		WHEN `country` LIKE 'T%' THEN 'Test'
		WHEN `country` LIKE 'P%' THEN 'In Progress'
        ELSE `country`
    END
);

-- 04.	Delete
-- As you remember at the beginning of our work, we inserted and updated some data. Now you need to remove some addresses.	
-- Delete all addresses from table addresses, which id is divisible by 3.
DELETE addr FROM `addresses` as addr
WHERE addr.`id` % 3 = 0;


-- 05.	Users
-- Extract from the Insta Database (instd), info about all the users. 
-- Order the results by age descending then by username ascending.
-- Required Columns
-- •	username
-- •	gender
-- •	age
SELECT `username`, `gender`, `age` FROM `users` ORDER BY `age` DESC, `username` ASC;

-- 06.	Extract 5 Most Commented Photos
-- Extract from the database, 5 most commented photos with their count of comments. 
-- Sort the results by commentsCount, descending, then by id in ascending order.
-- Required Columns
-- •	id
-- •	date_and_time
-- •	description
-- •	commentsCount
SELECT p.`id`, p.`date` AS date_and_time, p.`description`, COUNT(c.`id`) AS commentsCount 
FROM `photos` as p
JOIN `comments` AS c ON c.`photo_id` = p.`id`
GROUP BY p.`id`
ORDER BY `commentsCount` DESC, `id` ASC LIMIT 5;

-- 07.	Lucky Users
-- When the user has the same id as its photo, it is considered Lucky User. Extract from the database all lucky users. 
-- Extract id_username (concat id + " " + username) and email of all lucky users. Order the results ascending by user id.
-- Required Columns
-- •	id_username
-- •	email
SELECT CONCAT(u.`id`, ' ', u.`username`) AS id_username, u.`email` FROM `users` as u
JOIN `users_photos` AS up 
ON up.`user_id` = u.`id`
WHERE up.`user_id` = up.`photo_id` 
ORDER BY u.`id`;

-- 08.	Count Likes and Comments
-- Extract from the database, photos id with their likes and comments. 
-- Order them by count of likes descending, then by comments count descending and lastly by photo id ascending.
-- Required Columns
-- •	photo_id
-- •	likes_count
-- •	comments_count
SELECT 
    nt2.`photo_id`, nt2.`likes_count`, nt2.`comments_count`
FROM
    (SELECT 
        nt.`photo_id`, nt.`likes_count`, nt.`comments_count`
    FROM
        (SELECT 
        p.`id` AS photo_id,
            COUNT(DISTINCT l.`id`) AS likes_count,
            COUNT(DISTINCT c.`id`) AS comments_count
    FROM
        `photos` AS p
    JOIN `likes` AS l ON l.`photo_id` = p.`id`
    JOIN `comments` AS c ON c.`photo_id` = p.`id`
    GROUP BY p.`id`
    ORDER BY `photo_id` ASC) AS nt
    ORDER BY nt.`likes_count` DESC) AS nt2
ORDER BY nt2.`comments_count` DESC;

SELECT 
    nt.`photo_id`, nt.`likes_count`, nt.`comments_count`
FROM
    (SELECT 
        p.`id` AS photo_id,
            COUNT(DISTINCT l.`id`) AS likes_count,
            COUNT(DISTINCT c.`id`) AS comments_count
    FROM
        `photos` AS p
    LEFT JOIN `likes` AS l ON l.`photo_id` = p.`id`
    LEFT JOIN `comments` AS c ON c.`photo_id` = p.`id`
    GROUP BY p.`id`
    ORDER BY `likes_count` DESC , `comments_count` DESC , `photo_id` ASC) AS nt
ORDER BY nt.`likes_count` DESC , nt.`comments_count` DESC;
    
-- 09.	The Photo on the Tenth Day of the Month
-- Extract from the database those photos that their upload day is 10 and summarize their description. 
-- The summary must be 30 symbols long plus "..." at the end. Order the results by date descending order. 
-- Required Columns
-- •	summary
-- •	date
SELECT CONCAT(LEFT(`description`,30), '...') AS summary, `date` FROM photos
WHERE EXTRACT(DAY FROM `date`) = 10
ORDER BY `date` DESC;

-- 10.	Get User’s Photos Count
-- Create a user defined function with the name udf_users_photos_count(username VARCHAR(30)) 
-- that receives a username and returns the number of photos this user has upload.
DELIMITER $$
CREATE FUNCTION udf_users_photos_count(param VARCHAR(30)) 
RETURNS INTEGER
DETERMINISTIC
BEGIN
	DECLARE result INT;
    SET result := (
		SELECT COUNT(up.`photo_id`) 
        FROM `users_photos` AS up
        RIGHT JOIN `users` AS u ON u.`id` = up.`user_id`
        WHERE u.`username` = param
    );
    RETURN result;
END$$

SELECT udf_users_photos_count('ssantryd') AS photosCount;

-- 11. Create a stored procedure udp_modify_user which accepts the following parameters:
-- •	address
-- •	town 
-- udp_modify_user (address VARCHAR(30), town VARCHAR(30)) that receives an address and town and increase the age of the user by 10 years 
-- only if the given user exists. 
-- Show all needed info for this user: username, email, gender, age and job_title.
-- CALL udp_modify_user ('97 Valley Edge Parkway', 'Divinópolis');

DELIMITER $$
CREATE PROCEDURE udp_modify_user(p_address VARCHAR(30), p_town VARCHAR(30)) 
BEGIN
IF((SELECT COUNT(*) FROM `addresses` WHERE `address` = p_address) = 0) OR
	(SELECT COUNT(*) FROM `addresses` WHERE `town` = p_town) = 0
	THEN ROLLBACK;
ELSE 
	UPDATE `users`
    SET `age` = `age` + 10;

END IF;
END$$

CALL udp_modify_user ('97 Valley Edge Parkway', 'Divinópolis');
SELECT u.`username`, u.`email`, u.`gender`, u.`age`, u.`job_title` FROM `users` AS u
WHERE u.`username` = 'eblagden21';