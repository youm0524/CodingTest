-- 코드를 입력하세
select flavor
from(
    select flavor, sum(total_order) as total
    from(
        select total_order, flavor
        from july
        union all
        select total_order, flavor
        from first_half
    ) t
    group by flavor
    ORDER BY total DESC
    limit 3
) p

