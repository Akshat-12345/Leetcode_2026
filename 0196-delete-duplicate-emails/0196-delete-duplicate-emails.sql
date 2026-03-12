# Write your MySQL query statement below
With minId as (
    Select 
    min(id) as id
    from Person
    group by email
)
DELETE FROM Person
WHERE id NOT IN (SELECT id FROM minId);