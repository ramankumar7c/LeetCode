# Write your MySQL query statement below
SELECT P.firstName, P.lastName, A.city, A.state FROM PERSON AS P LEFT JOIN ADDRESS AS A ON P.personId = A.personId;