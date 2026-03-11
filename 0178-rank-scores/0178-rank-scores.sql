# Write your MySQL query statement below
with ScoreRank as(
    select
       s1.score,
       (
            SELECT COUNT(DISTINCT s2.score)
            FROM Scores s2
            WHERE s2.score > s1.score
        ) + 1 AS `rank`
    FROM Scores s1
)

SELECT score, `rank`
FROM ScoreRank
ORDER BY score DESC;
