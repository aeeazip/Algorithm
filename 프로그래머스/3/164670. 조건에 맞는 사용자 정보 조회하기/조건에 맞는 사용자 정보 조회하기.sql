-- 중고 거래 게시물을 3건 이상 등록한 사용자 정보 조회

SELECT U.USER_ID, 
       U.NICKNAME, 
       CONCAT(U.CITY, ' ', U.STREET_ADDRESS1, ' ', U.STREET_ADDRESS2) AS '전체주소',
       CONCAT(SUBSTRING(U.TLNO, 1, 3), '-', 
              SUBSTRING(U.TLNO, 4, 4), '-',
              SUBSTRING(U.TLNO, 8, 4)
       ) AS '전화번호'
FROM USED_GOODS_BOARD B JOIN USED_GOODS_USER U 
  ON B.WRITER_ID = U.USER_ID
GROUP BY U.USER_ID, U.NICKNAME, U.CITY, U.STREET_ADDRESS1, U.STREET_ADDRESS2, U.TLNO
HAVING COUNT(*) >= 3
ORDER BY U.USER_ID DESC;