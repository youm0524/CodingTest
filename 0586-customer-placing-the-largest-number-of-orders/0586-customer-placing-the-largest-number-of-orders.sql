# Write your MySQL query statement below
select o1.customer_number
from Orders o1
group by o1.customer_number
order by count(*) desc
limit 1;