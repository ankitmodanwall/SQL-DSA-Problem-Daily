# Write your MySQL query statement below
SELECT score ,
DENSE_Rank() over (Order  by score desc) as `rank`
from scores;
-- where scores >