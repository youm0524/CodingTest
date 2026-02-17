-- 코드를 입력하세요
with can_car as(
    SELECT *
    from CAR_RENTAL_COMPANY_CAR a
    where (a.car_type = "SUV" or a.car_type = "세단")
    and not exists(
        select 1 
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY b 
        where a.car_id = b.car_id
        and b.start_date<='2022-11-30' 
        AND b.end_date   >= '2022-11-01'
    )
),
price as(
    select c.car_id,c.car_type,
    floor(c.daily_fee * 30 * (100 - p.discount_rate) / 100) AS fee
    from can_car c, CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
    where c.car_type = p.car_type
    and p.duration_type ='30일 이상'
)
select car_id, car_type,fee
from price
WHERE fee BETWEEN 500000 AND 2000000
ORDER BY fee DESC, car_type ASC, car_id DESC;


