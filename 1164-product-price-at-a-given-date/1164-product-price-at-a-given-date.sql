# Write your MySQL query statement below
with a as(select product_id, max(change_date) as ch_date
from Products
where change_date<="2019-08-16"
group by product_id),
b as(
    select distinct product_id, 10 as price
    from Products
    where product_id not in(
        select product_id
        from Products
        where change_date<="2019-08-16"
    )
)
,c as(
select p.product_id, p.new_price as price
from Products p join a on p.product_id=a.product_id
and p.change_date = a.ch_date
)

select * from b
union
select * from c;

