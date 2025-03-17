-- 2022년 4월 13일 취소되지 않은 cs 진료 예약 내역 조회
SELECT TEMP.APNT_NO,
       P.PT_NAME,
       P.PT_NO,
       'CS' AS MCDP_CD,
       D.DR_NAME,
       TEMP.APNT_YMD
FROM (
    SELECT APNT_NO, -- 진료 예약 번호
       PT_NO, -- 환자 번호
       MDDR_ID, -- 의사 ID
       APNT_YMD -- 진료 예약 일시
    FROM APPOINTMENT
    WHERE DATE_FORMAT(APNT_YMD, '%Y%m%d') = '20220413'
      AND APNT_CNCL_YN = 'N'
      AND MCDP_CD = 'CS'
) TEMP
JOIN PATIENT P ON P.PT_NO = TEMP.PT_NO
JOIN DOCTOR D ON D.DR_ID = TEMP.MDDR_ID
ORDER BY TEMP.APNT_YMD ASC;
