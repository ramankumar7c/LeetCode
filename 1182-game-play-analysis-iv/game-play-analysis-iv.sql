# Write your MySQL query statement below
WITH FirstLogins AS (
    SELECT player_id, MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
),
NextDayLogins AS (
    SELECT DISTINCT a.player_id
    FROM Activity a
    JOIN FirstLogins fl ON a.player_id = fl.player_id
    WHERE DATEDIFF(a.event_date, fl.first_login) = 1
)
SELECT 
    ROUND(
        (SELECT COUNT(*) FROM NextDayLogins) / 
        (SELECT COUNT(DISTINCT player_id) FROM Activity),
        2
    ) AS fraction;