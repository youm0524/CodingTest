-- 코드를 입력하세요
SELECT distinct cr.car_id
from CAR_RENTAL_COMPANY_CAR cr, CAR_RENTAL_COMPANY_RENTAL_HISTORY ch
where ch.start_date between '2022-10-01' and '2022-10-31'
and cr.car_type = '세단'
and cr.car_id= ch.car_id
order by cr.car_id desc;