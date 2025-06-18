# Write your MySQL query statement below
select ei.unique_id,e.name
from EmployeeUNI as ei right join Employees as e
on ei.id=e.id;

