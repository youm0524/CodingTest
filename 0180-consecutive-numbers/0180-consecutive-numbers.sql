# Write your MySQL query statement below
select distinct log1.num as ConsecutiveNums
from Logs log1, Logs l2, Logs log3
where log1.id = l2.id-1
and l2.id = log3.id-1
and log1.num = l2.num
and l2.num = log3.num;