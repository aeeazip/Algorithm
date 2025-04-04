-- SKILL_CODE와 CODE를 &(AND) 했을 때 0이 아니면 CODE를 포함
SELECT DISTINCT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM (SELECT * FROM SKILLCODES WHERE NAME = 'Python' or NAME = 'C#') S
JOIN DEVELOPERS D
WHERE S.CODE & D.SKILL_CODE != 0
ORDER BY D.ID ASC;