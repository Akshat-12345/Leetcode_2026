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

with maxSalary as(
    select
        departmentid,
        max(salary) as maxSal
    from employee 
    group by departmentid
)

select
 d.name as department,
 e.name as employee,
 e.salary as salary
FROM Employee e
JOIN maxSalary m
ON e.departmentid = m.departmentid
AND e.Salary = m.maxSal
JOIN Department d
ON e.DepartmentId = d.id;