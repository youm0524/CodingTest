SELECT 
    o.product_id,
    p.product_name,
    SUM(p.price * o.amount) AS total_sales
FROM food_order o
JOIN food_product p ON o.product_id = p.product_id
WHERE o.produce_date LIKE '2022-05%'
GROUP BY o.product_id
ORDER BY total_sales DESC, o.product_id ASC;
