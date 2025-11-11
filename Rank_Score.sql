-- # Write your MySQL query statement below
-- select s.score,s.id from scores as s order by s.score desc;

SELECT
    score,
    DENSE_RANK() OVER (ORDER BY score DESC) AS 'rank'
FROM
    Scores;