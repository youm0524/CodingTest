WITH a AS (
    SELECT employee_id, COUNT(*) AS cnt
    FROM Employee
    GROUP BY employee_id
)

SELECT e.employee_id, e.department_id
FROM Employee e
JOIN a 
  ON e.employee_id = a.employee_id
WHERE a.cnt = 1 
   OR e.primary_flag = 'Y';