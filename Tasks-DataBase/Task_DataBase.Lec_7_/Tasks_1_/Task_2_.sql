--_____________TASKS___________________
--_____________________________________

SELECT e.FIRST_NAME  ,d.DEPARTMENT_NAME 
FROM employees e JOIN departments d 
using(DEPARTMENT_ID);

SELECT  o.ORDERS  , c.CUSTOMER_NAME  
FROM orders o JOIN oricacustomer c 
using(CUSTOMER_ID);


SELECT  p.product_names , s.supplier names  
FROM products  p JOIN suppliers  s
using(supplier_id);


SELECT  s.student_name , c.course_name  
FROM student s JOIN course c
using(student_id);

SELECT  i.invoice_numbers , p.product_names 
FROM products p JOIN invoices i
using(product_id);

SELECT  e.employee_names , p.products_names  
FROM employee e JOIN products i
using(project_id);

SELECT  a.author_names ,b.book_name  
FROM authors a JOIN books b
using(author_id);


SELECT  o.sales_order ,e.employee_names  
FROM employee e JOIN orders o
using(employee_id);


SELECT  c.course_schedules ,i.instructor_names  
FROM instructors i  JOIN courses c
using(instructor_id);

SELECT  a.account_holder , t.transaction 
FROM accounts a  JOIN transactions t
using(account_id);






	