-- TASKS 

--______________________________________________________________________________________

SELECT book_title , author_name FROM books NATURAL JOIN authors;

SELECT FIRST_NAME ,  DEPARTMENT_NAME  FROM employees  NATURAL JOIN  departments;

SELECT order_name ,  customer_name  FROM orderr  NATURAL JOIN  customers;

SELECT student_name ,  course_name  FROM student  NATURAL JOIN  course;

SELECT emp_name ,  project_name  FROM employeess  NATURAL JOIN  projectss;

SELECT product_name ,  quantity , total_amount FROM invoicess  NATURAL JOIN  productss;

SELECT class_name ,schedule_time , instructor_name FROM class_schedules NATURAL JOIN instructors;

SELECT supplier_name,product_name FROM suppliers NATURAL JOIN products;

SELECT  order_id ,customer_name , order_date ,shipping_address FROM customers NATURAL JOIN orders;

SELECT First_name , JOB_TITLE FROM employees NATURAL JOIN jobs;
 

--______________________________________________________________________________________