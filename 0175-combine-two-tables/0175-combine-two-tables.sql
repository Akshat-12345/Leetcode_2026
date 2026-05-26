# Write your MySQL query statement below
SELECT p.firstName,p.lastName,a.city, a.state
FROM Person p                        #tablename.tribute
LEFT JOIN Address a
ON
p.personId = a.personId;
-- UNION
-- SELECT p.firstName,p.lastName,a.city, a.state
-- FROM Person p                        #tablename.tribute
-- RIGHT JOIN Address a
-- ON
-- p.personId = a.personId
