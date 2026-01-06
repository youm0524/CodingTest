-- 코드를 입력하세요
-- 코드를 입력하세요
SELECT category, sum(bs.sales) as total_sales
from book b, book_sales bs
where bs.sales_date BETWEEN TO_DATE('2022-01-01', 'YYYY-MM-DD')
                        AND TO_DATE('2022-01-31', 'YYYY-MM-DD')
and b.book_id = bs.book_id
group by category
order by category asc;