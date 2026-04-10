# Write your MySQL query statement below
delete p 
from Person p join Person p1
on p.email = p1.email and p.id>p1.id;