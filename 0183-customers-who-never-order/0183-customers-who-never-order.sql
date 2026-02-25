# Write your MySQL query statement below
-- Select c.name as customers
-- from Customers c
-- left join Orders o
-- on c.id = o.customerId
-- where customerId is null;


SELECT Name AS Customers
FROM Customers
WHERE Id NOT IN (
    SELECT CustomerId
    FROM Orders
);