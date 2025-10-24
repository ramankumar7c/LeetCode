WITH daily AS (
  SELECT visited_on, SUM(amount) AS total_amount
  FROM Customer
  GROUP BY visited_on
),
dates AS (
  SELECT DISTINCT visited_on
  FROM Customer
  WHERE visited_on >= (
    SELECT DATE_ADD(MIN(visited_on), INTERVAL 6 DAY)
    FROM Customer
  )
)
SELECT
  d.visited_on,
  SUM(t.total_amount) AS amount,
  ROUND(SUM(t.total_amount) / 7, 2) AS average_amount
FROM dates d
JOIN daily t
  ON t.visited_on BETWEEN DATE_SUB(d.visited_on, INTERVAL 6 DAY) AND d.visited_on
GROUP BY d.visited_on
ORDER BY d.visited_on;