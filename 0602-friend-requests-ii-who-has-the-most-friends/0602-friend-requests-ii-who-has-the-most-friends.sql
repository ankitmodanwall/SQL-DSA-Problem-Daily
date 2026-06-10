# Write your MySQL query statement below
with all_ids  as (
select requester_id as id from RequestAccepted
UNION ALL
select accepter_id AS id FROM RequestAccepted

)
select id, count(id) as num
from all_ids
group by id
order by num desc
limit 1;