-- 2022년 05월 01일까지 출고완료 이 후 날짜는 출고 대기 미정이면 출고미정
SELECT ORDER_ID, 
       PRODUCT_ID, 
       DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
       CASE WHEN OUT_DATE IS NULL THEN '출고미정'
            WHEN DATE_FORMAT(OUT_DATE, '%Y-%m-%d') <= '2022-05-01' THEN '출고완료'
            ELSE '출고대기'
       END AS '출고여부'
FROM FOOD_ORDER
ORDER BY ORDER_ID ASC;