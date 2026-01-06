-- 코드를 입력하세요
with a as(
select sum(f.total_order+j.total_order) as su, f.flavor
from first_half f, july j
where j.flavor = f.flavor
group by j.flavor
order by su desc
limit 3
)

select a.flavor from a;
# select * from a;

