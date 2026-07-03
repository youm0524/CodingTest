# Write your MySQL query statement below
select Department, Employee, Salary
from
(
    select d.name as Department, e.name as Employee, e.salary as Salary,
    dense_rank() over (partition by e.departmentId order by e.salary desc) as rnk
    from Department d, Employee e
    where e.departmentId = d.id
) t
where t.rnk = 1;