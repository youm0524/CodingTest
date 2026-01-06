-- 코드를 입력하세요
SELECT ain.animal_id, ain.name
from animal_ins ain, animal_outs aout
where ain.animal_id = aout.animal_id
and ain.datetime > aout.datetime
order by ain.datetime asc;