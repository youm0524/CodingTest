-- 코드를 입력하세요
SELECT floor(price/10000)* 10000 as PRICE_GROUP, count(*) as products
from product
group by floor(price/10000) * 10000
order by PRICE_GROUP;