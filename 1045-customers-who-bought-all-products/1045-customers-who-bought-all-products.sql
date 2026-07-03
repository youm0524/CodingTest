with a as (
    select count(*) as c
    from Product
)
select customer_id
from Customer
cross join a
group by customer_id
having count(distinct product_key) = max(a.c);