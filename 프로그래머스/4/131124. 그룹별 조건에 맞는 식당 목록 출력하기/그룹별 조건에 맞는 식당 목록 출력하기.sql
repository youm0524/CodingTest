-- 코드를 입력하세요
# select member_name, review_text, date_format(review_date,"%Y/%m/%d")
# from rest_review as re, member_profile as mem
# group by re.member_id;

with a as (select member_id, count(review_score)
from rest_review
group by member_id
order by count (review_id) desc
limit 1
)

select m.MEMBER_NAME, r.REVIEW_TEXT, date_format(r.REVIEW_DATE,'%Y-%m-%d') as REVIEW_DATE
from member_profile as m, a, rest_review as r
where m.member_id = a.member_id and m.member_id = r.member_id
order by REVIEW_DATE, REVIEW_TEXT;



