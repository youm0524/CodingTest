# Write your MySQL query statement below
select p.project_id, round(sum(e.experience_years)/count(*),2) as average_years
from Project p, Employee e
where p.employee_id = e.employee_id
group by project_id;