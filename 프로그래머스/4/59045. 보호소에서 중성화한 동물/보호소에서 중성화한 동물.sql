-- 코드를 입력하세요
SELECT ain.animal_id, ain.animal_type, ain.name
from animal_ins as ain, animal_outs as aout
where ain.animal_id = aout.animal_id
and ain.sex_upon_intake != aout.sex_upon_outcome;