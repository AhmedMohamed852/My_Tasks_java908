
CREATE TABLE customers (
    customer_id number(20) PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    orders VARCHAR(100)
);



DROP TABLE customers; 
DROP TABLE orders; 

CREATE TABLE orders (
    order_id number(20) PRIMARY KEY,
    order_count number(10) NOT NULL,
    customer_id NUMBER(10),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

SELECT CONCAT(CONCAT (first_name , ' ') , LAST_name) FROM EMPLOYEES 
WHERE salary > (SELECT AVG(salary) FROM EMPLOYEES);


SELECT customer_name  FROM customers  
WHERE orders IN( SELECT max(order_count) FROM orders);

SELECT products FROM products  
WHERE salary > ANY ( SELECT max(salary) FROM Accessories);


SELECT CONCAT(CONCAT (first_name , ' ') , LAST_name) AS FULL_NAME  , JOB_ID FROM EMPLOYEES 
WHERE JOB_ID IN (SELECT JOB_ID FROM EMPLOYEES WHERE FIRST_NAME = 'John' AND LAST_NAME ='Smith' );


SELECT order_name  ,customer_id FROM orders  
WHERE customer_id IN( SELECT  customer_id FROM customers WHERE city ='New York');

SELECT d.DEPARTMENT_NAME FROM departments d
WHERE NOT EXISTS (SELECT 1 FROM employees e WHERE e.DEPARTMENT_ID  = d.DEPARTMENT_ID );

SELECT student_name FROM students s
WHERE NOT EXISTS (SELECT 1 FROM courses c WHERE s.student_id = c.student_id); 


SELECT max(salary) FROM employees e
WHERE salary < (SELECT max(salary) FROM employees)


SELECT CONCAT( CONCAT(e.FIRST_NAME , ' ' ) , e.LAST_NAME ) AS FULL_Name, e.salary FROM employees e
WHERE e.salary = (SELECT MAX(salary) FROM employees WHERE salary <  (SELECT max(salary) FROM employees));


SELECT products FROM products  
WHERE salary > ANY ( SELECT AVG(salary) FROM products);




SELECT  c.customer_name FROM customers c
WHERE NOT EXISTS ( SELECT 1 FROM products P WHERE P.category = 'A'  );





--Please explain to me 
Find customers who have ordered all products in category 'A'.
Use a correlated subquery with NOT EXISTS.




