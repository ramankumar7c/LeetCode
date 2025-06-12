# Write your MySQL query statement below
SELECT M.employee_id, M.name, COUNT(E.employee_id) AS reports_count, ROUND(AVG(E.age)) AS average_age
FROM Employees E INNER JOIN Employees M on M.employee_id = E.reports_to
GROUP BY 1 ORDER BY 1;