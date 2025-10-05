--_____________TASKS___________________
--_____________________________________



SELECT  o.order_name   , c.customer_name   
FROM orders o  FULL OUTER JOIN customers c
using(customer_Id); --

SELECT  e.FIRST_NAME  , p.project_name
FROM employees e FULL OUTER JOIN projects  p
using(employees_هd); --


SELECT  p.product_name   , s.supplier_name  
FROM products p RIGHT OUTER JOIN suppliers s
using(product_هd); --


SELECT  s.student_name   , c.course_name   
FROM students  s FULL OUTER JOIN courses c
using(student_d); --


SELECT  b.book_name , a.author_name
FROM books b FULL OUTER JOIN authors a
using(author_id); --


SELECT  e.FIRST_NAME   , d.DEPARTMENT_NAME   
FROM employees e FULL OUTER JOIN departments d
using(DEPARTMENT_ID); --


SELECT  t.transactions , p.payment
FROM transactions t FULL OUTER JOIN payments p
using(payment_method); --

SELECT a.customer_id , b.name
FROM RegionA_Customers a FULL OUTER JOIN RegionB_Customers b
ON a.customer_id = b.customer_id; --






	