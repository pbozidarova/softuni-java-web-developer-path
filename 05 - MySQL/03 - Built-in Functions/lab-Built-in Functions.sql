-- 1.	Find Book Titles
-- Write a SQL query to find books which titles start with “The”. Order the result by id.
SELECT 
    `title` AS `Book Title`
FROM
    `books`
WHERE
    SUBSTRING(`title`, 1, 3) = 'The'
ORDER BY `id`;

SELECT `id`, `title`, `cost`, SUBSTRING(`title` FROM 1 FOR 20) AS `Title Summery` 
FROM `books`;

-- 2.	Replace Titles
-- Write a SQL query to find books which titles start with “The” and replace the substring with 3 asterisks. Retrieve data about the updated titles. Order the result by id. 
SELECT REPLACE(`title`, 'The', '***') AS `Title` FROM `books`
WHERE SUBSTRING(`title`, 1, 3) = 'The'
ORDER BY `id`;

SELECT INSERT(`title`, LOCATE('The', `title`, 1), 3, '***') as `Title` FROM `books`
WHERE SUBSTRING(`title`, 1, 3) = 'The'
ORDER BY `id`;

SELECT `id`, `title`, LOCATE('The', `title` COLLATE utf8mb4_0900_as_cs) as `Index of 'The'` FROM `books`;

-- 3.	Sum Cost of All Books
-- Write a SQL query to sum prices of all books. Format the output to 2 digits after decimal point. 
SELECT ROUND(SUM(`cost`), 2) as `Total cost` FROM `books`;

-- 4.	Days Lived
-- Write a SQL query to calculate the days that the authors have lived. NULL values mean that the author is still alive. 
SELECT CONCAT_WS(' ', `first_name`, `last_name`) AS `Full Name`, 
TIMESTAMPDIFF(DAY, `born`, `died`) AS `Days Lived` 
FROM `authors`;

SELECT CONCAT_WS(' ', `first_name`, `last_name`) AS `Full Name`, 
DATE_FORMAT(`born`, '%b %D, %Y') as `Born`, 
DATE_FORMAT(`died`, '%b %D, %Y') as `Died`,
TIMESTAMPDIFF(YEAR, `born`, IFNULL(`died`, NOW())) AS `Years Lived` 
FROM `authors`;

-- 5.	Harry Potter Books
-- Write a SQL query to retrieve titles of all the Harry Potter books. Order the information by id. 
SELECT `title` FROM `books` WHERE SUBSTRING(`title`, 1, 5) = 'Harry' ORDER BY `id`;

SELECT `title` FROM `books` WHERE `title` LIKE '%Harry Potter%' ORDER BY `id`;

SELECT `title` FROM `books`
WHERE `title` REGEXP '[tT]he';

SELECT `title` FROM `books`
WHERE `title` RLIKE '[tT]he';

SELECT `title` FROM `books`
WHERE REGEXP_LIKE(`title`, '(?i)^.*\\sthe\\s.*$');

SELECT LTRIM(REGEXP_REPLACE(`title`, '(?i)\\s[tT]he|[tT]he\\s', ' *** ')) AS 'Title' 
FROM `books`
WHERE REGEXP_LIKE(`title`, '(?i)^.*the.*$');

SELECT CASE `id`
	WHEN 1 THEN 'one'
	WHEN 2 THEN 'two'
    WHEN 3 THEN 'three'
    WHEN 4 THEN 'four'
    WHEN 5 THEN 'five'
    ELSE 'more...'
END AS `Case Exmpression`,
CONCAT_WS('', `first_name`, `last_name`) as `Full Name`
FROM `authors`
ORDER BY `id`;