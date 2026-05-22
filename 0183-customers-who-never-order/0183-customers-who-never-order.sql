# Write your MySQL query statement below
SELECT
name as customers
from customers
where id not in (select customerid from orders)
