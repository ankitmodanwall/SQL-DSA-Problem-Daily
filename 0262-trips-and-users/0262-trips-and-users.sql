select 
request_at as day,
round(
    sum(status != 'completed')/count(*),
    2

) as 'cancellation rate'
from trips
where client_id not in (
    select users_id
    from users
    where banned = 'yes'
)
And driver_id not in ( 
     select users_id
    from users
    where banned = 'yes'
)
and request_at between '2013-10-01' and '2013-10-03'
group by request_at;