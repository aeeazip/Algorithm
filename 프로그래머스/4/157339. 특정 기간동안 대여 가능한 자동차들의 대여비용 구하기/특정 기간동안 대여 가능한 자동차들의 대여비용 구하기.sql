SELECT DISTINCT
    C.CAR_ID, 
    C.CAR_TYPE, 
    ROUND(C.DAILY_FEE * 30 * ((100 - DP.DISCOUNT_RATE) * 0.01), 1) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C 
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY RH ON C.CAR_ID = RH.CAR_ID
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN DP ON C.CAR_TYPE = DP.CAR_TYPE
WHERE (C.CAR_TYPE = '세단' OR C.CAR_TYPE = 'SUV')
  AND RH.CAR_ID NOT IN 
  (
      SELECT CAR_ID 
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
      WHERE END_DATE >= TO_DATE('2022-11-01', 'YYYY-MM-DD')
  )
  AND DP.DURATION_TYPE = '30일 이상'
  AND C.DAILY_FEE * 30 * ((100 - DP.DISCOUNT_RATE) * 0.01) >= 500000
  AND C.DAILY_FEE * 30 * ((100 - DP.DISCOUNT_RATE) * 0.01) < 2000000
 ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;


         