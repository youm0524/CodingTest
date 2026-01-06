-- 코드를 입력하세요
SELECT board_id,
       writer_id,
       title,
       price,
       CASE
           WHEN status = 'SALE' THEN '판매중'
           WHEN status = 'RESERVED' THEN '예약중'
           ELSE '거래완료'
       END AS status
FROM used_goods_board
WHERE TO_CHAR(created_date, 'YYYYMMDD') = '20221005'
ORDER BY board_id DESC