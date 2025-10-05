
--_____________________TASKS________________________________________
--__________________________________________________________________



SELECT  CONCAT( e.FIRST_NAME || ' ' , e.LAST_NAME ) AS full_name , salary  FROM  employees e
WHERE salary = (SELECT MAX(salary) FROM employees );


SELECT  CONCAT( e.FIRST_NAME || ' ' , e.LAST_NAME ) AS full_name , e.JOB_ID   FROM  employees e
WHERE e.JOB_ID = (SELECT  ee.JOB_ID FROM employees ee WHERE ee.FIRST_NAME = 'Alice')


SELECT * FROM products
WHERE price = (SELECT MIN(price) FROM products);



SELECT d.DEPARTMENT_NAME FROM DEPARTMENTS d 
WHERE d.DEPARTMENT_ID = (SELECT  e.DEPARTMENT_ID  FROM employees e 
WHERE e.SALARY =(SELECT MAX(ee.SALARY) FROM employees ee));


SELECT  e.MANAGER_ID  FROM employees e 
WHERE e.EMPLOYEE_ID = (SELECT ee.EMPLOYEE_ID   FROM employees ee 
WHERE HIRE_DATE = (SELECT MAX(eee.HIRE_DATE)  FROM employees eee));


SELECT  CONCAT(e.FIRST_NAME || ' ' , e.LAST_NAME )AS full_name FROM employees e
WHERE e.SALARY = (SELECT AVG(ee.SALARY)  FROM employees ee);


SELECT   o.order_name FROM orders o
WHERE o.hire_date = (SELECT MIN(hire_date) FROM orders );



SELECT  CONCAT(e.FIRST_NAME || ' ' , e.LAST_NAME )AS full_name ,e.SALARY  FROM employees e
WHERE e.SALARY > (SELECT ee.SALARY  FROM employees ee
WHERE ee.EMPLOYEE_ID  = 101);


SELECT s.student_name  FROM students s
WHERE GPA = (SELECT ss.GPA FROM students ss
WHERE ss.student_name = 'John Doe');


SELECT b.book_name FROM books b 
WHERE b.salary = (SELECT MAX(bb.salary) FROM books 
WHERE bb.category = 'Science');

















