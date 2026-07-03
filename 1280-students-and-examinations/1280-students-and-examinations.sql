with attended_exam as (
    select student_id, subject_name, count(*) as attended_exams
    from Examinations
    group by student_id, subject_name
)

SELECT 
    st.student_id,
    st.student_name,
    su.subject_name,
    IFNULL(ae.attended_exams, 0) AS attended_exams
FROM Students st
CROSS JOIN Subjects su
LEFT JOIN attended_exam ae
    ON st.student_id = ae.student_id
    AND su.subject_name = ae.subject_name
ORDER BY 
    st.student_id, 
    su.subject_name;
