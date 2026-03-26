# Write your MySQL query statement below
with t as(
    select product_id, min(year) as first_year
    from Sales
    group by product_id
)
select s.product_id, t.first_year, s.quantity, s.price
from Sales s
join t
on s.product_id = t.product_id
and s.year = t.first_year;
