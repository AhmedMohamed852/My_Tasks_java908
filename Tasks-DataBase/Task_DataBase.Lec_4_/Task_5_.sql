/*==============> 1 <=================*/
	
DROP TABLE customers;

CREATE TABLE  customers   ( full_name   varchar(100) );
INSERT INTO customers (full_name)
VALUES ('`addo                  ');


	SELECT full_name , TRIM(	BOTH ' ' FROM   full_name ) FROM customers;
	SELECT full_name , LTRIM(full_name  , ' ') FROM customers;
	SELECT full_name , RTRIM(full_name  , ' ') FROM customers;
	SELECT full_name , RTRIM(LTRIM( full_name , ' .ge $*#' ) , '.ge $*#') FROM customers;
	
/*==============> 2 <=================*/

SELECT REPLACE('promotion' , 'o' , 0) FROM dual;
SELECT REPLACE('This is a basic course' , 'basic' , 'advanced') FROM dual;

	
CREATE TABLE  departments_copy ( dept_name  varchar(50) );
INSERT INTO departments_copy (dept_name)
VALUES ('dept_3');

SELECT dept_name , LPAD(dept_name ,15 , '*') FROM departments_copy;
SELECT dept_name , RPAD(dept_name ,15 , '-') FROM departments_copy;

	
	/*==============> 3 <=================*/


SELECT TO_CHAR(SYSDATE ,'DD-MON-YYYY') FROM dual;
SELECT TO_CHAR(SYSDATE ,'Day-Month-YYYY') FROM dual;

SELECT TO_CHAR(12345.67, '99,999.99') AS formated_number FROM dual;

SELECT HIRE_DATE , TO_CHAR(HIRE_DATE,'YYYY-MM-DD-HH24-MI-SS') AS formated_HIRE_DATE FROM employees;


	/*==============> 4 <=================*/

CREATE TABLE  students    ( name  varchar(12) , score number(3) );
INSERT INTO students (name , score)
VALUES ('Moaaz' , 92 );

SELECT name , score , CASE 
	WHEN score >= 90 THEN 'A'
	WHEN score >= 80 THEN 'B'
	WHEN score >= 70 THEN 'C'
	ELSE 'F'
	END  AS grades FROM students ORDER BY score desc;

/* ============> After Update */

SELECT name , score , CASE 
	WHEN score >= 90 THEN 'A'
	WHEN score >= 80 THEN 'B'
	WHEN score >= 60 THEN 'C'
	ELSE 'F'
	END  AS grades FROM students ORDER BY score desc;

/* ============> After Update */

SELECT name , score , CASE 
	WHEN score >= 90 THEN '(A) Excellent'
	WHEN score >= 80 THEN '(B) Good'
	WHEN score >= 60 THEN '(C) Average'
	ELSE '(F) Needs Improvement'
	END  AS grades FROM students ORDER BY score desc;



SELECT TO_CHAR(SYSDATE , 'DAY'), CASE TO_CHAR(SYSDATE, 'DY')
WHEN 'SAT' THEN 'Today is SATURDAY'
WHEN 'SUN' THEN 'Today is SUNDAY'
WHEN 'MON' THEN 'Today is MONDAY'
WHEN 'TUE' THEN 'Today is TUESDAY'
WHEN 'WED' THEN 'Today is WEDNESDAY'
WHEN 'THU' THEN 'Today is THURSDAY'
WHEN 'FRI' THEN 'Today is FRIDAY'
END AS today_message FROM dual;

	/*==============> 5 <=================*/


SELECT name , DECODE(TRUNC(score/10),10, 'A', 9, 'A', 8, 'B', 7, 'C', 'D') AS grade FROM students;





CREATE TABLE  status_log   ( status_code    varchar(1) );
INSERT INTO status_log (status_code)
VALUES ('C');

SELECT status_code , DECODE(status_code ,'N', 'NEW', 'I', 'In Progress', 'C','Completed', 'Not_Found') FROM status_log;




CREATE TABLE  bonus   ( department   varchar(15) );
INSERT INTO bonus (department)
VALUES ('Sales');


SELECT department , DECODE(department ,'HR', 500, 'IT', 1000, 'Sales',1500, 300) AS BONUS FROM bonus;


	

	DROP TABLE bonus;