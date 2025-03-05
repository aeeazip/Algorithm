# (
#     SELECT PARENT.ID AS ID, COUNT(*) AS CHILD_COUNT
#     FROM ECOLI_DATA PARENT JOIN ECOLI_DATA CHILD
#     ON PARENT.ID = CHILD.PARENT_ID
#     GROUP BY PARENT.ID
# )
# UNION
# (
#     SELECT ID, COUNT(*) - 1 AS CHILD_COUNT
#     FROM ECOLI_DATA
#     WHERE ID NOT IN (SELECT PARENT_ID AS ID FROM ECOLI_DATA WHERE PARENT_ID IS NOT NULL)
#     GROUP BY ID
# )
# ORDER BY ID ASC;


select a.id, count(b.parent_id) as child_count
from ecoli_data as a
left join ecoli_data as b
on a.id = b.parent_id -- a가 부모 b가 자식
group by a.id;