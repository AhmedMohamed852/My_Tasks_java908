CREATE TABLE Employees_copy (
EmployeeID varchar(11) , FirstName varchar(10), LastName varchar(10), Department varchar(30), Salary number(7) );

SELECT * FROM employees_copy;


INSERT ALL
  INTO employees_copy (EMPLOYEEID, FIRSTNAME, LASTNAME, DEPARTMENT, SALARY)
    VALUES (101, 'John1', 'Doe1', 'HR', 20000)
  INTO employees_copy (EMPLOYEEID, FIRSTNAME, LASTNAME, DEPARTMENT, SALARY)
    VALUES (102, 'John2', 'Doe2', 'IT', 50000)
  INTO employees_copy (EMPLOYEEID, FIRSTNAME, LASTNAME, DEPARTMENT, SALARY)
    VALUES (103, 'John3', 'Doe3', 'CS', 40000)
  INTO employees_copy (EMPLOYEEID, FIRSTNAME, LASTNAME, DEPARTMENT, SALARY)
    VALUES (104, 'John4', 'Doe4', 'IT', 10000)
  INTO employees_copy (EMPLOYEEID, FIRSTNAME, LASTNAME, DEPARTMENT, SALARY)
    VALUES (105, 'John5', 'Doe5', 'ZX', 30000)
SELECT * FROM dual;

UPDATE employees_copy 

SET SALARY = 600000 WHERE EMPLOYEEID = 101;

SELECT * FROM employees_copy;

DELETE employees_copy WHERE EMPLOYEEID = 101;

SELECT * FROM employees_copy;

SELECT * FROM employees_copy WHERE DEPARTMENT = 'IT';

SELECT EMPLOYEEID , FIRSTNAME || ' ' || LASTNAME AS FULLNAME , DEPARTMENT , SALARY FROM employees_copy;