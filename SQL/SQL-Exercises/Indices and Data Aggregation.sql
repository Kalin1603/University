/*
--12






--13
use SoftUni
Select d.DepartmentID, SUM(e.Salary) AS 'TotalSalary' From Employees AS e
JOIN Departments AS d ON d.DepartmentID = e.DepartmentID
Group By d.DepartmentID

--14
Select d.DepartmentID, MIN(e.Salary) AS 'MinimumSalary' From Employees AS e
JOIN Departments AS d ON d.DepartmentID = e.DepartmentID
Where e.HireDate > '2000-01-01' AND d.DepartmentID IN(2,5,7)
Group By d.DepartmentID
*/



