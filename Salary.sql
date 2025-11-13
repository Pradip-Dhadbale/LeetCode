-- # Write your MySQL query statement below
-- select e.name as Employee from Employee as e where managerID = 3 ;

SELECT
    e.name AS Employee
FROM
    Employee e
JOIN
    Employee m ON e.managerId = m.id
WHERE
    e.salary > m.salary;