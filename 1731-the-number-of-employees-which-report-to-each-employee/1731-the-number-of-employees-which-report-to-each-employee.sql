# Write your MySQL query statement below
select e2.employee_id, e2.name, count(e2.employee_id) as reports_count, round(sum(e1.age)/count(e2.employee_id),0) as average_age
from Employees e1, Employees e2
where e1.reports_to = e2.employee_id
group by e2.employee_id
order by employee_id;