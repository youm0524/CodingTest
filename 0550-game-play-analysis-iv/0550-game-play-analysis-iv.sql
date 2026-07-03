SELECT ROUND(
    COUNT(DISTINCT A.player_id) / COUNT(DISTINCT B.player_id),
    2
) AS fraction
FROM Activity B
LEFT JOIN Activity A
    ON B.player_id = A.player_id
    AND DATEDIFF(A.event_date, B.event_date) = 1
WHERE B.event_date = (
    SELECT MIN(event_date)
    FROM Activity
    WHERE player_id = B.player_id
);