
SELECT  SUM(AVG_SALARY) FROM (SELECT department_id , AVG(SALARY) AS  AVG_SALARY FROM employees GROUP BY department_id);

SELECT EMPLOYEE_ID , rownum FROM employees;


SELECT MAX(SALARY) FROM employees;


SELECT MIN(SALARY) FROM employees;


SELECT SUM(SALARY) FROM employees;


SELECT * FROM employees ;


SELECT DEPARTMENT_ID , AVG(SALARY) FROM employees GROUP BY DEPARTMENT_ID;


SELECT JOB_ID , COUNT(*) AS TOTAL_NUMBER FROM employees GROUP BY JOB_ID ;


SELECT DEPARTMENT_ID , SUM(salary) AS total_salary FROM employees GROUP BY DEPARTMENT_ID HAVING SUM(SALARY) > 50000;


SELECT AVG(COMMISSION_PCT)  FROM employees  ;


SELECT COUNT(*)FROM employees WHERE salary > 10000;


SELECT * FROM employees ;



SELECT JOB_ID , max(salary) , MIN(salary) FROM employees GROUP BY JOB_ID ;


SELECT  sum(salary) FROM employees WHERE MANAGER_ID IS NOT NULL;

SELECT * FROM employees ;


SELECT DEPARTMENT_ID , JOB_ID ,  COUNT(*) ,sum(salary) AS total_salary FROM employees GROUP BY DEPARTMENT_ID , JOB_ID;

SELECT JOB_ID , COUNT(*)  FROM employees GROUP BY JOB_ID HAVING COUNT(*) > 5;


SELECT DEPARTMENT_ID , COUNT(*) AS "Total employees" ,AVG(salary) AS "Average SALARY"  ,
max(salary) AS "Maximum salary" , min(salary) AS "Minimum salary"  FROM employees GROUP BY DEPARTMENT_ID;

SELECT 	DEPARTMENT_ID , count(*) AS "employee_count" , AVG(salary) AS "Average SALARY" FROM employees GROUP BY DEPARTMENT_ID  HAVING AVG(salary) > 8000 AND count(*) < 10;

SELECT DEPARTMENT_ID  , salary FROM employees ORDER BY salary DESC  FETCH FIRST 1 ROW ONLY;


SELECT 	DEPARTMENT_ID , SUM(SALARY) AS Total_Salary , AVG(salary) AS "Average SALARY" FROM employees GROUP BY DEPARTMENT_ID ;


SELECT * FROM employees ;
