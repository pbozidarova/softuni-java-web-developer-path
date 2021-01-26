-- 2.	Data Insertion
-- You will have to INSERT records of data into the likes table, based on the users table.
-- For users with id between 16 and 20(inclusive), insert data in the likes table with the following values: 
-- •	For users with even id, the like will be on an article, else – comment.
-- •	Users’ username length will determine the article_id. 
-- •	Users’ email length will determine the comment_id.

INSERT INTO `likes` (`article_id`, `comment_id`, `user_id`)(
SELECT 
	CASE 
		WHEN u.`id` % 2 = 0 THEN CHAR_LENGTH(u.`username`)
		ELSE NULL
	END,
	CASE 
		WHEN u.`id` % 2 <> 0 THEN CHAR_LENGTH(u.`email`)
		ELSE NULL
	END,
	u.`id` FROM `users` AS u
WHERE u.`id` BETWEEN 16 AND 20);

INSERT INTO `likes` (`article_id`, `comment_id`, `user_id`)
SELECT IF(u.`id` % 2 = 0, CHAR_LENGTH(u.`username`), NULL),
	   IF(u.`id` % 2 = 1, CHAR_LENGTH(u.`email`), NULL),
	   u.`id`
FROM `users` as u
WHERE u.`id` BETWEEN 16 AND 20;

-- 3.	Data Update
-- UPDATE comments with id between 1 and 15(inclusive) and meet the following conditions:
-- •	If the comment’s id is dividable by 2 without remainder – ‘Very good article.’.
-- •	If the comment’s id is dividable by 3 without remainder – ‘This is interesting.’.
-- •	If the comment’s id is dividable by 5 without remainder – ‘I definitely will read the article again.’.
-- •	If the comment’s id is dividable by 7 without remainder – ‘The universe is such an amazing thing.’. 

UPDATE `comments` as c
SET c.`comment` = 
(CASE 
	WHEN id % 2 = 0 THEN "Very good article."
	WHEN id % 3 = 0 THEN "This is interesting."
	WHEN id % 5 = 0 THEN "I definitely will read the article again."
	WHEN id % 7 = 0 THEN "The universe is such an amazing thing."
    ELSE `comment`
END)
WHERE `id` BETWEEN 1 AND 15;

-- 4.	Data Deletion
-- The Council does not like articles without category. Delete all articles without category.
DELETE `articles` FROM `articles`
WHERE `category_id` IS NULL;

-- 5.	Extract 3 biggest articles
-- Extract from the database, the 3 biggest articles and summarize their content. 
-- The summary must be 20 symbols long plus "..." at the end. Order the results by article id.
-- Required Columns
-- •	title
-- •	summary
SELECT nt.`title`, nt.`summery` 
FROM (
		SELECT a.`id`, a.`title`, CONCAT(LEFT(a.`content`, 20), '...') as summery 
    	FROM `articles` AS a
		ORDER BY CHAR_LENGTH(a.`content`) DESC
		LIMIT 3
	) as nt
ORDER BY nt.`id`;

-- 6.	Golden Articles
-- When article has the same id as its author,
--  it is considered Golden Article. 
--  Extract from the database all golden articles. Order the results ascending by article id.
-- Required Columns
-- •	article_id
-- •	title
SELECT ua.`article_id`, ua.`title` FROM `users_articles` AS ua
JOIN `articles` AS a 
ON a.`id` = ua.`article_id`
WHERE ua.`user_id` = ua.`article_id`
ORDER BY ua.`article_id` ASC;

SELECT a.`title` FROM `articles` AS a
JOIN `users_articles` AS ua ON ua.`article_id` = a.`id`
WHERE ua.`user_id` = ua.`article_id`
ORDER BY ua.article_id asc;

-- 7.	Extract categories
-- Extract from the database, all categories with their articles, and likes. 
-- Order them by count of likes descending, then by article's count descending and lastly by category's id ascending.
-- Required Columns
-- •	category
-- •	articles (count of articles for the given category)
-- •	likes (total likes for the given category)
SELECT c.`category`, COUNT(DISTINCT a.`id`) AS `articles`, COUNT(DISTINCT l.`id`) AS `likes` FROM `categories` AS c
LEFT JOIN `articles` AS a ON a.`category_id` = c.`id`
LEFT JOIN `likes` AS l ON l.`article_id` = a.`id`
GROUP BY c.`category`
ORDER BY `likes` DESC, `articles` DESC, c.`id` ASC;


-- 8.	Extract the most commented Social article
-- Extract from the database, the most commented social article with the number of comments.
-- Required Columns
-- •	title
-- •	comments (total articles comments)
SELECT a.`title`, COUNT(c.`id`) AS cmt FROM `articles` AS a
RIGHT JOIN `comments` AS c ON c.`article_id` = a.`id`
JOIN `categories` AS ctg ON ctg.`id` = a.`category_id`
WHERE ctg.`category` = 'Social'
GROUP BY a.`title`
ORDER BY cmt DESC LIMIT 1;

SELECT a.`title`, COUNT(com.`id`) AS c_count FROM articles AS a
JOIN `categories` AS c ON  c.`id` = a.`category_id`
JOIN `comments` AS com on com.`article_id` = a.`id`
WHERE c.`category` = 'Social'
GROUP BY a.`id`
ORDER BY `c_count` DESC LIMIT 1;

-- 9.	Extract the less liked comments
-- Extract from the database those comments that are not liked by anyone and 
-- summarize them and order the results by comment id in descending order. 
-- The summary must be 20 symbols long plus "..." at the end.
-- Required Columns
-- •	summary
SELECT CONCAT(LEFT(`comment`, 20), '...') AS summary FROM `comments` AS c
LEFT JOIN `likes` AS l ON l.`comment_id` = c.`id`
WHERE l.`comment_id` IS NULL
ORDER BY c.id desc;

-- 10.	Get user’s articles count
-- Create a user defined function with the name udf_users_articles_count(username VARCHAR(30)) 
-- that receives a username and returns the number of articles this user has written.

DELIMITER $$
CREATE FUNCTION `udf_users_articles_count` (param VARCHAR(50))
RETURNS INTEGER
BEGIN

RETURN (SELECT COUNT(a.`id`) FROM `articles` AS a
JOIN `users_articles` AS ua ON ua.`article_id` = a.`id`
JOIN `users` AS u ON u.`id` = ua.`user_id`
WHERE u.`username` = param
);
END$$

DELIMITER $$
CREATE FUNCTION `udf_users_articles_count` (param VARCHAR(50))
RETURNS INTEGER
DETERMINISTIC
BEGIN
	DECLARE result INT;
    SET result := (
		SELECT COUNT(ua.`article_id`) 
        FROM `users_articles` AS ua
        RIGHT JOIN `users` AS u ON u.`id` = ua.`user_id`
        WHERE u.`username` = param
    );
    RETURN result;
END$$

SELECT u.`username`, udf_users_articles_count('UnderSinduxrein') AS count
FROM `articles` AS a
JOIN `users_articles` ua
ON a.`id` = ua.`article_id`
JOIN `users` u
ON ua.`user_id` = u.`id`
WHERE u.`username` = 'UnderSinduxrein'
GROUP BY u.`id`;

-- Create a user defined stored procedure with the name udp_like_article(username VARCHAR(30), title VARCHAR(30)) 
-- that receives a username and article title and likes the article only if the given username and title exist. If the 
-- modifying is not successful rollback any changes and 
-- throw an exception with error code ‘45000’ and message: "Non-existent user." or "Non-existent article.". 
-- 'Pesho123', 'Donnybrook, Victoria'

DELIMITER $$
CREATE PROCEDURE udp_like_article(p_username VARCHAR(30), p_title VARCHAR(30)) 
BEGIN
IF((SELECT COUNT(*) FROM `users` WHERE `username` = p_username) = 0)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Non-existent user.';
	ROLLBACK;
ELSEIF ((SELECT COUNT(*) FROM `articles` WHERE `title` = p_title) = 0)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Non-existent article.';
    ROLLBACK;
ELSE 
	INSERT INTO `likes` (`article_id`, `comment_id`, `user_id`)
	SELECT
		(SELECT `id` FROM `articles` WHERE `title` = p_title),
        NULL,
		(SELECT `id` FROM `users` WHERE `username` = p_username);
END IF;
END$$
CALL udp_like_article('Pesho123', 'Donnybrook, Victoria');