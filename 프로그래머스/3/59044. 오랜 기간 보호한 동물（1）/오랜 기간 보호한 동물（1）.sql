-- 아직 입양 못 간 동물 중 가장 오래 보호소에 있었던 동물 세마리 이름과 보호 시작일
SELECT AI.NAME, DATETIME
FROM ANIMAL_INS AI
WHERE AI.ANIMAL_ID NOT IN (
    SELECT ANIMAL_ID
    FROM ANIMAL_OUTS
)
ORDER BY DATETIME ASC
LIMIT 3;