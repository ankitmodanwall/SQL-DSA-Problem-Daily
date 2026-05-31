# Write your MySQL query statement below
select name
from employee
where id IN(
    SELECT managerId
    From employee
    group by managerId
    Having Count(*)>=5
);