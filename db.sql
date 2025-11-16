# Write your MySQL query statement below
-- select p.email as Email from Person as p where id = 1 and 3;

select p.email as Email from Person as p group by email having count(email) > 1;