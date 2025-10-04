--_____________TASKS___________________
--_____________________________________


SELECT  e.FIRST_NAME   , ee.LAST_NAME AS manager_name  
FROM employee e JOIN employees ee 
using(employee_id , manager_id);


SELECT  e.salesperson_names  ,  c.customer_names AS manager_name  
FROM employees e JOIN customers c
USING(name);


SELECT  o.order_ID  ,  d.product_ID 
FROM orders o JOIN order_details d
USING(order_id);


SELECT  s.student_names  ,   i.instructor_names 
FROM students s JOIN instructors i
USING(student_Id);


SELECT  e.employee_salaries  , d.department_budgets 
FROM employees e NATURAL JOIN departments d;

SELECT  p.project_name  , t.task_names 
FROM projects p JOIN tasks t
USING(name);


SELECT  c.course_name  , e.exam_time
FROM courses c JOIN exams e
ON(c.course_id = e.course_id)

SELECT  p.project_name  , c.category_name
FROM projects p JOIN categories c
USING(name);


SELECT  b.book_title  , publisher_name
FROM books b JOIN publishers p
USING(book_title);



SELECT  e.FIRST_NAME   , d.LOCATION_ID d
FROM employees e NATURAL JOIN departments d;





