--_____________TASKS___________________
--_____________________________________


SELECT  e.FIRST_NAME   , d.DEPARTMENT_NAME   
FROM employees e LEFT OUTER JOIN departments d
using(DEPARTMENT_ID);


SELECT  p.product_name   , c.categorie_name  
FROM products p LEFT OUTER JOIN categories c
using(product_Id);


SELECT  s.student_name   , c.course_name   
FROM students  p LEFT OUTER JOIN courses c
using(student_Id);


SELECT  o.order_name   , c.customer_name   
FROM orders o  LEFT OUTER JOIN customers c
using(customer _Id);


SELECT  d.DEPARTMENT_NAME    , m.manager_name
FROM departments d  LEFT OUTER JOIN managers m
using(DEPARTMENT_ID);


SELECT  b.book_name , a.author_name
FROM books b LEFT OUTER JOIN authors a
using(book_title);


SELECT  i.invoice , p.payment
FROM invoices i LEFT OUTER JOIN payments p
using(invoice_Id);

SELECT  e.FIRST_NAME  , p.project_name
FROM employees e LEFT OUTER JOIN projects  p
using(employees_Id);





	