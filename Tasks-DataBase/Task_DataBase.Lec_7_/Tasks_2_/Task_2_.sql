--_____________TASKS___________________
--_____________________________________


SELECT  e.FIRST_NAME   , d.DEPARTMENT_NAME   
FROM employees e RIGHT OUTER JOIN departments d
using(DEPARTMENT_ID);


SELECT  p.product_name   , c.categorie_name  
FROM products p RIGHT OUTER JOIN categories c
using(product_Id);


SELECT  s.student_name   , c.course_name   
FROM students s RIGHT OUTER JOIN courses c
using(student_Id);

SELECT  o.order_name   , c.customer_name   
FROM orders o  RIGHT OUTER JOIN customers c
using(customer _Id);


SELECT  d.DEPARTMENT_NAME    , m.manager_name
FROM departments d  LEFT OUTER JOIN managers m
using(DEPARTMENT_ID);


SELECT  b.book_name , a.author_name
FROM books b RIGHT OUTER JOIN authors a
using(book_title);


SELECT  t.transactions , p.payment
FROM transactions t RIGHT OUTER JOIN payments p
using(payment_methods);

SELECT  e.FIRST_NAME  , p.project_name
FROM employees e RIGHT OUTER JOIN projects  p
using(employees_Id);





	