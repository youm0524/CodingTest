-- 코드를 작성해주세요
select year, b.year_dev-ecoli_data.size_of_colony as year_dev,id
from ecoli_data
join(
    select YEAR(DIFFERENTIATION_DATE) as year, max(size_of_colony) as year_dev
    from ecoli_data 
    group by year
    ) b
ON  YEAR(ecoli_data.DIFFERENTIATION_DATE) = b.YEAR
order by year, year_dev;