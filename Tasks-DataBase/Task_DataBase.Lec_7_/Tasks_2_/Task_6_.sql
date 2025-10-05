
--_____________________TASKS________________________________________
--__________________________________________________________________

SELECT  CONCAT( e.FIRST_NAME || ' ' , e.LAST_NAME ) AS full_name , salary  FROM  employees e
WHERE salary > ANY (SELECT ee.salary FROM employees ee 
WHERE ee.DEPARTMENT_ID = 10);


SELECT  CONCAT( e.FIRST_NAME || ' ' , e.LAST_NAME ) AS full_name , salary  FROM  employees e
WHERE salary < ALL (SELECT ee.salary FROM employees ee 
WHERE ee.DEPARTMENT_ID = 20);


SELECT p.product_name FROM products p 
WHERE p.price IN  (SELECT pp.price FROM products pp 
WHERE pp.category = 'Electronics');


SELECT c.customer_name FROM customars c 
WHERE c.customer_id IN (SELECT o.customer_id FROM orders o 
WHERE o.product_id IN (SELECT p.product_id FROM products p
WHERE p.price > 1000));


SELECT  d.DEPARTMENT_NAME  FROM DEPARTMENTS d 
WHERE  d.DEPARTMENT_ID  IN (SELECT e.DEPARTMENT_ID  FROM employees e
GROUP BY e.DEPARTMENT_ID HAVING  COUNT(e.DEPARTMENT_ID) > 1);

 -- ===== this 

SELECT  d.DEPARTMENT_NAME  FROM DEPARTMENTS d 
JOIN (SELECT e.DEPARTMENT_ID  FROM employees e
GROUP BY e.DEPARTMENT_ID HAVING  COUNT(e.DEPARTMENT_ID) > 1)  m 
ON (m.DEPARTMENT_ID = d.DEPARTMENT_ID);


SELECT o.order_name FROM orders o 
WHERE o.customer_id IN (SELECT c.customer_id  FROM customers c
WHERE c.city IN(SELECT c2.city  FROM customers c2
JOIN orders o2 ON o2.customer_id = c2.customer_id
GROUP BY(c2.customer_id) HAVING COUNT(c2.city) > 1));


SELECT b.book_name FROM books
WHERE b.book_id IN(SELECT a.book_id FROM authors a
GROUP BY a.book_id HAVING COUNT(a.book_id) > 1);


SELECT s.student_name FROM students 
WHERE s.student_id IN(SELECT c.student_id FROM courses c
WHERE c.professor_id = (SELECT p.professor_id FROM professors p 
WHERE p.professor_name = 'Dr. Smith'));


SELECT CONCAT(e.FIRST_NAME || ' ' , e.LAST_NAME ) AS full_name  , e.SALARY  , e.DEPARTMENT_ID  FROM employees e
WHERE  e.SALARY IN (SELECT e2.SALARY  FROM employees e2
WHERE e2.DEPARTMENT_ID = 30);



