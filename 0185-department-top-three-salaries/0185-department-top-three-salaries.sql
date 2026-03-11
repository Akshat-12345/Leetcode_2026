-- # Write your MySQL query statement below
-- SELECT 
--     d.name AS Department,
--     e.name AS Employee,
--     e.salary AS Salary
-- FROM Employee e
-- JOIN Department d
-- ON e.departmentId = d.id
-- WHERE (
--     SELECT COUNT(DISTINCT e2.salary)
--     FROM Employee e2
--     WHERE e2.departmentId = e.departmentId
--       AND e2.salary > e.salary
-- ) < 3;


-- # Write your MySQL query statement below
-- SELECT d.Name AS Department,
--        e.Name AS Employee,
--        e.Salary
-- FROM Employee e
-- JOIN Department d
-- ON e.DepartmentId = d.Id
-- WHERE e.Salary = (
--     SELECT MAX(Salary)
--     FROM Employee
--     WHERE DepartmentId = e.DepartmentId
-- );

with highestSalary as(
    select
      e1.name as Employee,
      e1.salary as Salary,
      d.name as Department,
      (
        select count(distinct e2.salary)
        from Employee e2
        where e2.departmentid = e1.departmentid
        and e2.salary > e1.salary
      ) as higherSalaryCount

      from employee e1
      join department d
      on e1.departmentid = d.id
)

SELECT Department, Employee, Salary
FROM highestSalary
WHERE higherSalaryCount < 3;
