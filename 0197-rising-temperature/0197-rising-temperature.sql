# Write your MySQL query statement below
select id
from weather w1
where temperature >
(
    select temperature 
    from weather w2
    where w2.recordDate = date_sub(w1.recordDate,INTERVAL 1 day)
);