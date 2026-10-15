# Write your MySQL query statement below
SELECT unique_id , name     
FROM EmployeeUNI  t1
RIGHT JOIN Employees t2
ON t1.id = t2.id;