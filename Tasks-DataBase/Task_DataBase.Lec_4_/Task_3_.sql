SELECT TO_CHAR(SYSDATE ,'DD-MON-YYYY') AS carrnt_date FROM dual;
SELECT TO_CHAR(SYSDATE ,'Month YYYY') AS carrnt_date FROM dual;
SELECT TO_CHAR(12345.67 ,'99,999.99') AS carrnt_date FROM dual;
SELECT CONCAT(salary , '$') FROM employees;