# Write your MySQL query statement below
SELECT M.name FROM Employee E INNER JOIN Employee M ON E.managerId = M.id GROUP BY M.id HAVING COUNT(*) >= 5;